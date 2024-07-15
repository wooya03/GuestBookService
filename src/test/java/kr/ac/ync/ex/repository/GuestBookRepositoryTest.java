package kr.ac.ync.ex.repository;

import kr.ac.ync.ex.entity.GuestBookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestBookRepositoryTest {
    @Autowired
    private GuestBookRepository guestBookRepository;

    @Test
    void testInsertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            GuestBookEntity bookEntity = GuestBookEntity.builder().title("title ......" + i)
                    .content("content ......" + i)
                    .writer("writer ......" + (i%10))
                    .build();
            guestBookRepository.save(bookEntity);
        });
    }

    @Test
    void testUpdate() {
        Optional<GuestBookEntity> result = guestBookRepository.findById(1L);
        if(result.isPresent()){
            GuestBookEntity guestBookEntity = result.get();
            guestBookEntity.updateTitle("update title ......");
            guestBookEntity.updateContent("update content ......");

            guestBookRepository.save(guestBookEntity);
        }
    }
}