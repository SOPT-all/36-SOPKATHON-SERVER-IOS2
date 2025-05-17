package org.sopt36th.sopthackathon.domain.course.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sopt36th.sopthackathon.global.entity.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
@Entity
public class Course extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private final Shop shop;

    private final String title;

    private final String description;

    private final String ingredient;

    private final String image;
}
