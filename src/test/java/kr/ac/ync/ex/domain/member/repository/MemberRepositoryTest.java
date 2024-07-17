package kr.ac.ync.ex.domain.member.repository;

import kr.ac.ync.ex.domain.member.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void insertMembers() {
        IntStream.rangeClosed(1, 100).forEach(i->{
            MemberEntity member = MemberEntity.builder()
                    .email("user"+i+"@ync.ac.kr")
                    .password("user123")
                    .name("user"+i)
                    .build();
            memberRepository.save(member);
        });
    }
}