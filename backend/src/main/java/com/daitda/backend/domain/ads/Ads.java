package com.daitda.backend.domain.ads;

import com.daitda.backend.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table
public class Ads extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 40, nullable = false)
    private String agency;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int view;

    @Builder
    public Ads(String title, String agency, int view) {
        this.title = title;
        this.agency = agency;
        this.view = view;
    }

    public void updateViews() {
        this.view ++;
    }
}
