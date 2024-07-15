package kr.ac.ync.ex.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ac.ync.ex.dto.GuestBookDTO;
import kr.ac.ync.ex.entity.GuestBookEntity;
import kr.ac.ync.ex.entity.QGuestBookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static kr.ac.ync.ex.entity.QGuestBookEntity.guestBookEntity;

@SpringBootTest
public class QuerydslTest {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void testQuerydsl1() {
        String keyword = "11";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression expression1 = guestBookEntity.title.contains(keyword);
        BooleanExpression expression2 = guestBookEntity.writer.eq("user1");
        builder.and(expression1);
        builder.and(expression2);
        List<GuestBookEntity> result = jpaQueryFactory
                .select(guestBookEntity)
                .from(guestBookEntity)
                .where(builder)
                .fetch();

        result.forEach(System.out::println);
    }

    @Test
    void testQuerydsl2() {
        String keyword = "1";
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression exTitle = guestBookEntity.title.contains(keyword);
        BooleanExpression exContent = guestBookEntity.content.contains(keyword);
//        BooleanExpression exTitleAndContent = exTitle.and(exContent);
        booleanBuilder.and(exTitle);
        booleanBuilder.and(exContent);

        List<GuestBookEntity> result = jpaQueryFactory
//                .select(guestBookEntity)
//                .from(guestBookEntity)
                .selectFrom(guestBookEntity)
                .where(booleanBuilder)
//                .where(exTitleAndContent)
                .fetch();

        result.forEach(System.out::println);
    }

    @Test
    void testQuerydsl3() {
        List<Tuple> result = jpaQueryFactory
                .select(guestBookEntity.gno, guestBookEntity.title,
                        guestBookEntity.content, guestBookEntity.writer)
                .from(guestBookEntity)
                .fetch();
        result.forEach(tuple -> {
            System.out.println(tuple.get(guestBookEntity.gno));
            System.out.println(tuple.get(1, String.class));
        });
    }

    @Test
    void testQuerydsl4() {
        List<GuestBookDTO> result = jpaQueryFactory
                .select(
                        Projections.constructor(GuestBookDTO.class,
                                                guestBookEntity.gno,
                                                guestBookEntity.title,
                                                guestBookEntity.content,
                                                guestBookEntity.writer,
                                                guestBookEntity.createDate,
                                                guestBookEntity.modifiedDate)
                )
                .from(guestBookEntity)
                .offset(0)
                .limit(10)
                .orderBy(guestBookEntity.gno.desc())
                .fetch();
        result.forEach(System.out::println);
    }
}
