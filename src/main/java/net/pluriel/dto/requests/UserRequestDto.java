package net.pluriel.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
}
