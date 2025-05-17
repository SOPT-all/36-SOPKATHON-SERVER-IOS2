package org.sopt36th.sopthackathon.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.domain.user.domain.User;
import org.sopt36th.sopthackathon.domain.user.dto.request.LoginRequest;
import org.sopt36th.sopthackathon.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 소연


    // 승준
    public void login(LoginRequest loginRequest){
        User user = new User(loginRequest.phoneNumber());
        userRepository.save(user);
    }
}
