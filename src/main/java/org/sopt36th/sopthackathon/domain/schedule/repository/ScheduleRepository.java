package org.sopt36th.sopthackathon.domain.schedule.repository;

import org.sopt36th.sopthackathon.domain.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByCourseId(Long coursesId);
    // 소연


    // 승준
}
