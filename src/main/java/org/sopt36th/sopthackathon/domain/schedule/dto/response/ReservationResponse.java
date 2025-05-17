package org.sopt36th.sopthackathon.domain.schedule.dto.response;

import java.time.LocalDateTime;
import org.sopt36th.sopthackathon.domain.course.dto.response.ShopResponse;

public record ReservationResponse(Long id, String image, String title, ShopResponse shopResponse, LocalDateTime time) {
}
