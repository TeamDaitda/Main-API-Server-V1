package com.daitda.backend.domain.adLogs;

import com.daitda.backend.domain.ads.Ads;
import com.daitda.backend.domain.users.Users;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class AdLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "ads_id")
    private Ads ads;

    @Builder
    public AdLogs(Users users, Ads ads) {
        this.users = users;
        this.ads = ads;
    }
}
