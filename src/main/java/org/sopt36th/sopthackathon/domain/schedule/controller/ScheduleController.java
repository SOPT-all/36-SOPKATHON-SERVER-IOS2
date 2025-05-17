package org.sopt36th.sopthackathon.domain.schedule.controller;


import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.domain.schedule.dto.response.CourseDetailResponse;
import org.sopt36th.sopthackathon.domain.schedule.service.ScheduleService;
import org.sopt36th.sopthackathon.global.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 소연


    // 승준
    @GetMapping("/courses/{coursesId}")
    public ApiResponse<CourseDetailResponse> getCourseDetail(@RequestHeader String phoneNumber, @PathVariable Long coursesId) {
        return new ApiResponse<>(HttpStatus.OK, "성공적으로 수업 정보를 조회했습니다.", scheduleService.getCoursesDetail(phoneNumber, coursesId));
    }
}
