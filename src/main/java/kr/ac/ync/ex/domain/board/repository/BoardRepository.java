package kr.ac.ync.ex.domain.board.repository;

import kr.ac.ync.ex.domain.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
