package kr.ac.ync.ex.service;

import kr.ac.ync.ex.dto.GuestBookDTO;
import kr.ac.ync.ex.exception.CustomException;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuestBookServiceTest {
    @Autowired
    private GuestBookService guestBookService;

    @Test
    void testRegister() {
        GuestBookDTO dto = GuestBookDTO.builder()
                .title("title ....")
                .content("content ....")
                .writer("user1")
                .build();
        Long gno = guestBookService.register(dto);
        System.out.println(gno);
    }

    @Test
    void testRead() throws CustomException {
        long gno = 1000L;
        GuestBookDTO guestBookDTO = guestBookService.read(gno);
        System.out.println(guestBookDTO);
    }

    @Test
    void testModify() throws CustomException {
        GuestBookDTO guestBookDTO = GuestBookDTO.builder().gno(1L).title("업데이트 제목")
                .content("업데이트 내용")
                .build();
        guestBookService.modify(guestBookDTO);
    }
}