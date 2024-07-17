package kr.ac.ync.ex.domain.guestbook.repository.querydsl;

import kr.ac.ync.ex.domain.guestbook.dto.GuestBookDTO;
import kr.ac.ync.ex.global.common.dto.PageRequestDTO;
import java.util.List;

public interface GuestBookQueryRepository {
    List<GuestBookDTO> findByConditions(PageRequestDTO pageRequestDTO);
}
