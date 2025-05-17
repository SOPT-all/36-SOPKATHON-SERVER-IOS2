package org.sopt36th.sopthackathon.domain.schedule.controller;


import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.domain.schedule.dto.reqeust.ReservationRequest;
import org.sopt36th.sopthackathon.domain.schedule.service.ScheduleService;
import org.sopt36th.sopthackathon.global.response.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ScheduleController {

    private ScheduleService scheduleService;

    // 소연
    @PostMapping("/schedules/{scheduleId}")
    public ApiResponse<Void> makeReservation(
            @RequestHeader String phoneNumber,
            @PathVariable Long scheduleId,
            @RequestBody ReservationRequest reservationRequest
    ) {

    }

    // 승준

}
