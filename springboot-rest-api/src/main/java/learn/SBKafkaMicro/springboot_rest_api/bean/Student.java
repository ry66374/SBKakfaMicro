package learn.SBKafkaMicro.springboot_rest_api.bean;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    private int id;
    private String firstName;
    private String lastName;

}
