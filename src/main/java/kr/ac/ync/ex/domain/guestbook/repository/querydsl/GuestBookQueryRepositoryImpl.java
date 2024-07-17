package kr.ac.ync.ex.domain.guestbook.repository.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ac.ync.ex.domain.guestbook.dto.GuestBookDTO;
import kr.ac.ync.ex.global.common.dto.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.ac.ync.ex.domain.guestbook.entity.QGuestBookEntity.guestBookEntity;

@Repository
@RequiredArgsConstructor
public class GuestBookQueryRepositoryImpl implements GuestBookQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<GuestBookDTO> findByConditions(PageRequestDTO pageRequestDTO) {
        List<GuestBookDTO> result = jpaQueryFactory
                .select(guestBookProjection())
                .from(guestBookEntity)
                .where(
                        guestBookEntity.gno.gt(0), // > 0
                        searchConditions(pageRequestDTO.getType(), pageRequestDTO.getKeyword()))
                .offset((pageRequestDTO.getPage()-1) * pageRequestDTO.getSize())
                .limit(pageRequestDTO.getSize())
                .orderBy(guestBookEntity.gno.desc())
                .fetch();
        return result;
    }

    private BooleanBuilder searchConditions(String type, String keyword) {
        if(type == null || type.trim().length() == 0){
            return null;
        }
        BooleanBuilder builder = new BooleanBuilder();
        if(type.contains("t")){
             builder.or(guestBookEntity.title.contains(keyword));
        }
        else if (type.contains("c")){
            builder.or(guestBookEntity.content.contains(keyword));
        }
        else if(type.contains("w")){
            builder.or(containWriter(keyword));
        }
        return builder;
    }

    private BooleanExpression containWriter(String keyword){
        return guestBookEntity.writer.contains(keyword);
    }

    private ConstructorExpression<GuestBookDTO> guestBookProjection() {
        return Projections.constructor(
                GuestBookDTO.class,
                guestBookEntity.gno,
                guestBookEntity.title,
                guestBookEntity.content,
                guestBookEntity.writer,
                guestBookEntity.createDate,
                guestBookEntity.modifiedDate );

    };

}
