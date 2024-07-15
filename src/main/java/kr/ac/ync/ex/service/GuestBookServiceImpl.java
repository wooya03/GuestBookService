package kr.ac.ync.ex.service;

import kr.ac.ync.ex.dto.GuestBookDTO;
import kr.ac.ync.ex.dto.PageRequestDTO;
import kr.ac.ync.ex.dto.PageResultDTO;
import kr.ac.ync.ex.entity.GuestBookEntity;
import kr.ac.ync.ex.exception.CustomException;
import kr.ac.ync.ex.exception.NotFoundGuestBookException;
import kr.ac.ync.ex.mapper.GuestBookMapper;
import kr.ac.ync.ex.repository.GuestBookRepository;
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
        return null;
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
