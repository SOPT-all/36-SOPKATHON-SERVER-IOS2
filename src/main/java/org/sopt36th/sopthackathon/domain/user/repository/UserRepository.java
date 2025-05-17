package org.sopt36th.sopthackathon.domain.user.repository;

import org.sopt36th.sopthackathon.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneNumber(String phoneNumber);

    // 소연


    // 승준


}
