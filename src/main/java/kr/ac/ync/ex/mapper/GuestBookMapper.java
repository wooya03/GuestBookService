package kr.ac.ync.ex.mapper;

import kr.ac.ync.ex.dto.GuestBookDTO;
import kr.ac.ync.ex.entity.GuestBookEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
