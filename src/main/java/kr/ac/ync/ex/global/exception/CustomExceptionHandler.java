package kr.ac.ync.ex.global.exception;

import kr.ac.ync.ex.global.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 예외의 전역적으로 처리
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity handlerCustomException(CustomException e){
        return ResponseEntity.status(e.getHttpStatus())
                .body(new ErrorResponse(e.getHttpStatus(), e.getMessage())
                );
    }

    @ExceptionHandler(Exception.class)
    protected  ResponseEntity  handlerException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
