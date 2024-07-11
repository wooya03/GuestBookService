package kr.ac.ync.ex.exception.response;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Setter
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String message;
}
