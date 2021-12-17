package com.daitda.backend.print.domain;

import com.daitda.backend.BaseTimeEntity;
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
public class Print extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @Column(nullable = false)
    private String path;

    @Builder
    public Print(Users users, String path) {
        this.users = users;
        this.path = path;
    }


}
