package vn.theson.jobhunter.entity.response;

import lombok.Getter;
import lombok.Setter;
import vn.theson.jobhunter.util.constant.GenderEnum;

import java.time.Instant;

@Getter
@Setter
public class ResUpdateUserDTO {
    private long id;
    private String name;
    private GenderEnum gender;
    private String address;
    private int age;
    private Instant updatedAt;
}
