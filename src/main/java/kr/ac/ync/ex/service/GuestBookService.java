package kr.ac.ync.ex.service;

import kr.ac.ync.ex.dto.GuestBookDTO;
import kr.ac.ync.ex.dto.PageRequestDTO;
import kr.ac.ync.ex.dto.PageResultDTO;
import kr.ac.ync.ex.entity.GuestBookEntity;
import kr.ac.ync.ex.exception.CustomException;

import java.util.List;

public interface GuestBookService {
    // GuestBook CRUD

    Long register(GuestBookDTO guestBookDTO);

    PageResultDTO<GuestBookDTO, GuestBookEntity> getList(PageRequestDTO resultDTO);

    default GuestBookEntity dtoToEntity(GuestBookDTO dto){
        return GuestBookEntity.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

    }

    List<GuestBookDTO> getSearchList(PageRequestDTO pageRequestDTO);

    public GuestBookDTO read(Long gno) throws CustomException;

    void modify(GuestBookDTO guestBookDTO) throws CustomException;

    void remove(Long gno) throws CustomException;

    default GuestBookDTO entityToDTO(GuestBookEntity entity){
        return GuestBookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .createDate(entity.getCreateDate())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }
}
