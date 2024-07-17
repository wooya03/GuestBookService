package kr.ac.ync.ex.domain.board.exception;

import kr.ac.ync.ex.global.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class  NotFoundBoardException extends CustomException{

    public static final CustomException EXCEPTION = new NotFoundBoardException();
    public NotFoundBoardException() {
        super(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다.");
    }
}
