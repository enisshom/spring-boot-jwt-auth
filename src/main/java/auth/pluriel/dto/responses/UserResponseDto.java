package auth.pluriel.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
	 private Integer id;
	private String firstname;
	private String lastname;
	private String email;

}
