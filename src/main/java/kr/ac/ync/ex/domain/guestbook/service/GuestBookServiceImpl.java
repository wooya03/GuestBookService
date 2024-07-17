package kr.ac.ync.ex.domain.guestbook.service;

import kr.ac.ync.ex.domain.guestbook.dto.GuestBookDTO;
import kr.ac.ync.ex.global.common.dto.PageRequestDTO;
import kr.ac.ync.ex.global.common.dto.PageResultDTO;
import kr.ac.ync.ex.domain.guestbook.entity.GuestBookEntity;
import kr.ac.ync.ex.global.exception.CustomException;
import kr.ac.ync.ex.domain.guestbook.exception.NotFoundGuestBookException;
import kr.ac.ync.ex.domain.guestbook.mapper.GuestBookMapper;
import kr.ac.ync.ex.domain.guestbook.repository.GuestBookRepository;
import kr.ac.ync.ex.domain.guestbook.repository.querydsl.GuestBookQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GuestBookServiceImpl implements GuestBookService{


    private final GuestBookRepository guestBookRepository;
    private final GuestBookQueryRepository guestBookQueryRepository;

    @Override
    public Long register(GuestBookDTO guestBookDTO) {
        GuestBookEntity guestBookEntity = dtoToEntity(guestBookDTO);
        guestBookRepository.save(guestBookEntity);
        return guestBookEntity.getGno();

    }

    @Override
    public PageResultDTO<GuestBookDTO, GuestBookEntity> getList(PageRequestDTO resultDTO) {
        Pageable pageable = resultDTO.getPageable(Sort.by("gno").descending());
        Page<GuestBookEntity> result = guestBookRepository.findAll(pageable);

        Function<GuestBookEntity, GuestBookDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public List<GuestBookDTO> getSearchList(PageRequestDTO pageRequestDTO) {
        // querydsl
        return guestBookQueryRepository.findByConditions(pageRequestDTO);
    }

    @Override
    public GuestBookDTO read(Long gno) throws CustomException {
        GuestBookDTO guestBookDTO = guestBookRepository.findById(gno)
                .map(GuestBookMapper::toDTO)
                .orElseThrow(() -> NotFoundGuestBookException.EXCEPTION);
        return guestBookDTO;
    }

    @Override
    public void modify(GuestBookDTO guestBookDTO) throws CustomException {
        GuestBookEntity guestBookEntity = guestBookRepository.findById(guestBookDTO.getGno()).orElseThrow(() -> NotFoundGuestBookException.EXCEPTION);
        guestBookEntity.updateTitle(guestBookDTO.getTitle());
        guestBookEntity.updateContent(guestBookDTO.getContent());
        guestBookRepository.save(guestBookEntity);
    }

    @Override
    public void remove(Long gno) throws CustomException {
        guestBookRepository.deleteById(gno);
    }


}
