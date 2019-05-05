package demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserProfile {
    private String name;
    private String email;
    private Integer age;
    private String gender;
}
