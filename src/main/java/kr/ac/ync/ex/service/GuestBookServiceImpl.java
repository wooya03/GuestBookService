package kr.ac.ync.ex.service;

import kr.ac.ync.ex.dto.GuestBookDTO;
import kr.ac.ync.ex.entity.GuestBookEntity;
import kr.ac.ync.ex.exception.CustomException;
import kr.ac.ync.ex.exception.NotFoundGuestBookException;
import kr.ac.ync.ex.mapper.GuestBookMapper;
import kr.ac.ync.ex.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
