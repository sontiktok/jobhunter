package vn.theson.jobhunter.entity.dto;


import lombok.Getter;
import lombok.Setter;
import vn.theson.jobhunter.util.constant.GenderEnum;

import java.time.Instant;

@Getter
@Setter

public class ResCreateUserDTO {
    private long id;
    private String name;
    private String email;
    private GenderEnum gender;
    private String address;
    private int age;
    private Instant createdAt;
}

