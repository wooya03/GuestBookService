package kr.ac.ync.ex.domain.reply.repository;

import kr.ac.ync.ex.domain.reply.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
}
