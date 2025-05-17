package org.sopt36th.sopthackathon.domain.course.domain;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.global.entity.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
@Entity
public class Shop extends BaseEntity {
    private final String name;
    private final String product;
    private final String location;
    private final String businessHour;
    private final String phoneNumber;
}
