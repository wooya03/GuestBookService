package kr.ac.ync.ex.domain.guestbook.exception;

import kr.ac.ync.ex.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundGuestBookException extends CustomException {

    // 업캐스팅
    public static final CustomException EXCEPTION = new NotFoundGuestBookException();
    public NotFoundGuestBookException(){
        super(HttpStatus.NOT_FOUND, "방명록을 찾을 수 없습니다.");
    }
}
