package kr.ac.ync.ex.repository;

import kr.ac.ync.ex.entity.GuestBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository extends JpaRepository<GuestBookEntity, Long> {
}
