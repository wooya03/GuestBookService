package kr.ac.ync.ex.repository.querydsl;

import kr.ac.ync.ex.dto.GuestBookDTO;
import kr.ac.ync.ex.dto.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestBookQueryRepositoryImpl implements GuestBookQueryRepository {
    @Override
    public List<GuestBookDTO> findByConditions(PageRequestDTO pageRequestDTO) {
        return null;
    }
}
