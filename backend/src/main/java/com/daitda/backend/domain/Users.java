package com.daitda.backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String affiliation;

    @Column(length = 20, nullable = false)
    private String phone;

    private int category;

    @Builder
    public Users(String name, String affiliation, String phone, int category) {
        this.name = name;
        this.affiliation = affiliation;
        this.phone = phone;
        this.category = category;
    }

    public void updateCategory(int category) {
        this.category = category;
    }
}
