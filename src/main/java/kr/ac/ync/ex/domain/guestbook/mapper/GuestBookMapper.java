package kr.ac.ync.ex.domain.guestbook.mapper;

import kr.ac.ync.ex.domain.guestbook.dto.GuestBookDTO;
import kr.ac.ync.ex.domain.guestbook.entity.GuestBookEntity;

public class GuestBookMapper {
    public static GuestBookDTO toDTO(GuestBookEntity entity){
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
