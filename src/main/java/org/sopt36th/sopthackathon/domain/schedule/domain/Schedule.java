package org.sopt36th.sopthackathon.domain.schedule.domain;

import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.global.entity.BaseEntity;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
@Entity
public class Schedule extends BaseEntity {
    private final Long courseId;
    private final Long userId;
    private final LocalDateTime time;
    private int numberOfPeople;

    public void updateNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
