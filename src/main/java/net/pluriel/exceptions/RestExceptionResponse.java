package net.pluriel.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestExceptionResponse {
	 	private String title;
	    private int errorNumber;
	    private LocalDateTime date;
	    private String message;
}
