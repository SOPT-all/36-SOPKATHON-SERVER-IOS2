package org.sopt36th.sopthackathon.domain.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.global.entity.BaseEntity;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class User extends BaseEntity {

    private final String phoneNumber;
}
