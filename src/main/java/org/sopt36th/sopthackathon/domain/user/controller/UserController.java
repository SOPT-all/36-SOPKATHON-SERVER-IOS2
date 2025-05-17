package org.sopt36th.sopthackathon.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.domain.user.dto.request.LoginRequest;
import org.sopt36th.sopthackathon.domain.user.service.UserService;
import org.sopt36th.sopthackathon.global.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    // 소연


    // 승준
    @PostMapping("/login")
    public ApiResponse<Void> login(@RequestBody LoginRequest loginRequest) {
        userService.login(loginRequest);
        return new ApiResponse<>(HttpStatus.CREATED, "로그인 완료!");
    }
}
