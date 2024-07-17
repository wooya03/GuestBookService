package kr.ac.ync.ex.domain.board.repository;

import kr.ac.ync.ex.domain.board.entity.BoardEntity;
import kr.ac.ync.ex.domain.guestbook.entity.GuestBookEntity;
import kr.ac.ync.ex.global.common.entity.BaseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    void testInsertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            BoardEntity boardEntity = BoardEntity.builder()
                    .title("title " + i)
                    .content("content " + i)
                    .build();
            boardRepository.save(boardEntity);
        });
    }

    @Test
    @Transactional
    @Commit
    void testUpdate() {
        Optional<BoardEntity> result = boardRepository.findById(301L);
        if(result.isPresent()){
            BoardEntity boardEntity = result.get();
            System.out.println(boardEntity);

            boardEntity.changeTitle("update title2");

            boardRepository.save(boardEntity);
        }
    }
}