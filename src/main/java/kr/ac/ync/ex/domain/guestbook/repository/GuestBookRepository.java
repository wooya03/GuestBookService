package kr.ac.ync.ex.domain.guestbook.repository;

import kr.ac.ync.ex.domain.guestbook.entity.GuestBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository extends JpaRepository<GuestBookEntity, Long> {
}
