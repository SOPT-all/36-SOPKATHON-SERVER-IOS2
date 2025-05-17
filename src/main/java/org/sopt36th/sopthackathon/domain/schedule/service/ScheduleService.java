package org.sopt36th.sopthackathon.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.domain.course.domain.Course;
import org.sopt36th.sopthackathon.domain.course.domain.Shop;
import org.sopt36th.sopthackathon.domain.course.dto.response.ShopResponse;
import org.sopt36th.sopthackathon.domain.course.repository.CourseRepository;
import org.sopt36th.sopthackathon.domain.course.repository.ShopRepository;
import org.sopt36th.sopthackathon.domain.schedule.domain.Schedule;
import org.sopt36th.sopthackathon.domain.schedule.dto.reqeust.ReservationRequest;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.CourseDetailResponse;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.ReservationResponse;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.ReservationsResponse;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.ScheduledCourse;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.ScheduledCourseList;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.ShopDetailInfo;
import org.sopt36th.sopthackathon.domain.schedule.repository.ScheduleRepository;
import org.sopt36th.sopthackathon.domain.user.domain.User;
import org.sopt36th.sopthackathon.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    // 소연
    @Transactional
    public void makeReservation(Long scheduleId, ReservationRequest reservationRequest) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new RuntimeException("해당 강의를 "
                + "찾을 수 없습니다."));
        schedule.updateNumberOfPeople(reservationRequest.numberOfPeople());
    }

    public ReservationsResponse getReservations(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);

        List<Schedule> schedules = scheduleRepository.findAllByUserId(user.getId());

        List<ReservationResponse> reservations = schedules.stream()
                .map(schedule -> {
                    Course course = courseRepository.findById(schedule.getCourseId())
                            .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + schedule.getCourseId()));
                    ShopResponse shopResponse = new ShopResponse(
                            course.getShop().getId(),
                            course.getShop().getName()
                    );

                    return new ReservationResponse(
                            schedule.getId(),
                            course.getImage(),
                            course.getTitle(),
                            shopResponse,
                            schedule.getTime()
                    );
                })
                .toList();

        return new ReservationsResponse(reservations);
    }



    // 승준
    public CourseDetailResponse getCoursesDetail(String phoneNumber, Long coursesId){
        Course course = courseRepository.findById(coursesId).orElseThrow(() -> new RuntimeException("해당 강좌를 찾을 수 없습니다."));
        Shop shop = shopRepository.findById(course.getShop().getId()).orElseThrow(() -> new RuntimeException("해당 강좌를 찾을 수 없습니다."));
        ShopDetailInfo shopDetailInfo = new ShopDetailInfo(shop.getId(), shop.getLocation(), shop.getBusinessHour(), shop.getPhoneNumber());
        List <Schedule> schedules = scheduleRepository.findAllByCourseId(coursesId);
        List<ScheduledCourse> scheduledCourseList= new ArrayList<>();

        for (Schedule schedule : schedules){
            scheduledCourseList.add(new ScheduledCourse(schedule.getId(), schedule.getTime()));
        }
        return new CourseDetailResponse(coursesId, shopDetailInfo, new ScheduledCourseList(scheduledCourseList));
    }

}
