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
public class Category extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "course_id")
    private final Course course;

    private final String name;
}
