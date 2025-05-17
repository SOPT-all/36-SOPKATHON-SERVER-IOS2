package org.sopt36th.sopthackathon.domain.schedule.service;

import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.domain.course.repository.CourseRepository;
import org.sopt36th.sopthackathon.domain.schedule.repository.ScheduleRepository;
import org.sopt36th.sopthackathon.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Service
@RequestMapping("/api/v1")
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    // 소연


    // 승준


}
