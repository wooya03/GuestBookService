package kr.ac.ync.ex.config;

import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuerydslConfig {
    @PersistenceContext
//    EntityManager를 빈으로 주입할 때 사용하는 어노테이션
//    동시성 문제 해결Thread-Safe  보장
    public EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){
        // JPA의 엔터티를 이용하여 JPQLQuery를 보다 쉽고 편리하게 작성할 수 있는 QueryDsl의 도구
        return new JPAQueryFactory(JPQLTemplates.DEFAULT,entityManager);
    }
}
