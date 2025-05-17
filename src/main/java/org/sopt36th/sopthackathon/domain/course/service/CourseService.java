package org.sopt36th.sopthackathon.domain.course.service;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.domain.course.domain.Category;
import org.sopt36th.sopthackathon.domain.course.domain.Course;
import org.sopt36th.sopthackathon.domain.course.dto.response.GetCourseResponse;
import org.sopt36th.sopthackathon.domain.course.dto.response.GetCoursesResponse;
import org.sopt36th.sopthackathon.domain.course.repository.CategoryRepository;
import org.sopt36th.sopthackathon.domain.course.repository.CourseRepository;
import org.sopt36th.sopthackathon.domain.course.repository.ShopRepository;
import org.sopt36th.sopthackathon.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;

    // 소연
    public GetCoursesResponse getAllCourses(String phoneNumber) {
        List<Course> courses = courseRepository.findAll();

        List<GetCourseResponse> courseResponses = courses.stream()
                .map(course -> new GetCourseResponse(
                        course.getId(),
                        course.getImage(),
                        course.getTitle(),
                        course.getDescription(),
                        course.getIngredient()
                ))
                .collect(toList());

        return new GetCoursesResponse(courseResponses);
    }

    public GetCoursesResponse getFilteredCourses(String phoneNumber, String categoryName) {
        List<Category> categories = categoryRepository.findAllByName(categoryName);

        List<Course> courses = categories.stream()
                .map(Category::getCourse)
                .distinct()
                .toList();

        List<GetCourseResponse> courseResponses = courses.stream()
                .map(course -> new GetCourseResponse(
                        course.getId(),
                        course.getImage(),
                        course.getTitle(),
                        course.getDescription(),
                        course.getIngredient()
                ))
                .collect(toList());

        return new GetCoursesResponse(courseResponses);
    }

    // 승준

}
