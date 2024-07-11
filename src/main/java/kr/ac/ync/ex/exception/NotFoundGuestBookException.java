package kr.ac.ync.ex.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;

public class NotFoundGuestBookException extends CustomException {

    // 업캐스팅
    public static final CustomException EXCEPTION = new NotFoundGuestBookException();
    public NotFoundGuestBookException(){
        super(HttpStatus.NOT_FOUND, "방명록을 찾을 수 없습니다.");
    }
}
