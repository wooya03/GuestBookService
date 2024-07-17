package kr.ac.ync.ex.domain.board.service;

import kr.ac.ync.ex.domain.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceImplTest {

    @Autowired
    private BoardService boardService;;

    @Test
    void test1() {
        boardService.findById(1L);
    }
}