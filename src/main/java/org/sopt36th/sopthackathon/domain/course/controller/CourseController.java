package org.sopt36th.sopthackathon.domain.course.controller;

import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.domain.course.dto.response.GetCoursesResponse;
import org.sopt36th.sopthackathon.domain.course.service.CourseService;
import org.sopt36th.sopthackathon.global.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CourseController {

    private final CourseService courseService;

    // 소연
    @GetMapping("/courses")
    public ApiResponse<GetCoursesResponse> getCourses(
            @RequestHeader String phoneNumber,
            @RequestParam(required = false) String categoryName) {

        if (categoryName == null || categoryName.isBlank()) {
            GetCoursesResponse response = courseService.getAllCourses(phoneNumber);

            return new ApiResponse<>(HttpStatus.OK, "성공적으로 수업 목록을 조회했습니다.", response);
        }

        GetCoursesResponse response = courseService.getFilteredCourses(phoneNumber, categoryName);

        return new ApiResponse<>(HttpStatus.OK, "성공적으로 수업 목록을 조회했습니다.", response);
    }

    // 승준

}
