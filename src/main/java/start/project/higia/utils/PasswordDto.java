package start.project.higia.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDto {

	private String repeatPassword;

	private String token;

	private String newPassword;

}
