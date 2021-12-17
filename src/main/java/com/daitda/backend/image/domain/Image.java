package com.daitda.backend.image.domain;

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
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String path;

    @OneToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    @Builder
    public Image(String path, Users users) {
        this.path = path;
        this.users = users;
    }
}
