package org.sopt36th.sopthackathon.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.domain.course.domain.Course;
import org.sopt36th.sopthackathon.domain.course.domain.Shop;
import org.sopt36th.sopthackathon.domain.course.repository.CourseRepository;
import org.sopt36th.sopthackathon.domain.course.repository.ShopRepository;
import org.sopt36th.sopthackathon.domain.schedule.domain.Schedule;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.CourseDetailResponse;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.ScheduledCourse;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.ScheduledCourseList;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.ShopDetailInfo;
import org.sopt36th.sopthackathon.domain.schedule.repository.ScheduleRepository;
import org.sopt36th.sopthackathon.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    // 소연


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
