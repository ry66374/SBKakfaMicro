package SBKafkaMicro.springboot_restful_webservices.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(
        description = "UserDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @Schema(description = "User's First name")
    @NotEmpty(message = "Firstname should not be empty")
    private String firstName;

    @Schema(description = "User's Last name")
    @NotEmpty(message = "Lastname should not be empty")
    private String lastName;

    @Schema(description = "User's Email address")
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

}
