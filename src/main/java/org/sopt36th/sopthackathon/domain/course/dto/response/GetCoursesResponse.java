package org.sopt36th.sopthackathon.domain.course.dto.response;

import java.util.List;

public record GetCoursesResponse(List<GetCourseResponse> courses) {
}
