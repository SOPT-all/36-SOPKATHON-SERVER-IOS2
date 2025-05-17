package org.sopt36th.sopthackathon.domain.schedule.dto.response;

import java.time.LocalDateTime;

public record ScheduledCourse(Long id, LocalDateTime time) {
}
