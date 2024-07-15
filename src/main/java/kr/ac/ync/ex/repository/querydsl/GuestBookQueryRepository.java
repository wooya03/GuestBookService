package kr.ac.ync.ex.repository.querydsl;

import kr.ac.ync.ex.dto.GuestBookDTO;
import kr.ac.ync.ex.dto.PageRequestDTO;
import java.util.List;

public interface GuestBookQueryRepository {
    List<GuestBookDTO> findByConditions(PageRequestDTO pageRequestDTO);
}
