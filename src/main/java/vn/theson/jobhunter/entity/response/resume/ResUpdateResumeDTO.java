package vn.theson.jobhunter.entity.response.resume;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ResUpdateResumeDTO {
    private Instant updatedAt;
    private String updatedBy;
}
