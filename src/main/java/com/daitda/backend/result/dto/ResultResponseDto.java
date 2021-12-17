package com.daitda.backend.result.dto;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.result.domain.Result;
import com.daitda.backend.user.domain.Users;
import lombok.Getter;

@Getter
public class ResultResponseDto {
    private final Long userId;
    private final String name;
    private final String phone;
    private final String category;
    private final String path;

    public ResultResponseDto(Result entity) {

        switch (entity.getUsers().getCategory()) {
            case 0:
                this.category = "한부모 가정 ∙ 조손 가정";
                break;
            case 1:
                this.category = "소년소녀 가정";
                break;
            case 2:
                this.category = "장애인";
                break;
            case 3:
                this.category = "상이 군경";
                break;
            case 4:
                this.category = "독거노인";
                break;
            case 5:
                this.category = "기아 난민";
                break;
            case 6:
                this.category = "유기 동물";
                break;
            case 7:
                this.category = "지구온난화";
                break;
            default:
                this.category = "";
                break;
        }

        this.userId = entity.getId();
        this.name = entity.getUsers().getName();
        this.phone = entity.getUsers().getPhone();
        this.path = entity.getImage().getPath();
    }
}
