package com.daitda.backend.result.domain;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.user.domain.Users;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    @OneToOne
    @JoinColumn(name = "images_id", nullable = false)
    private Image image;

    @Builder
    public Result(Users users, Image image) {
        this.users = users;
        this.image = image;
    }
}
