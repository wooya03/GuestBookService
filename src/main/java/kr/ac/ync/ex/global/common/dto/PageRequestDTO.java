package kr.ac.ync.ex.global.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Setter //파라미터 값 자동 수집
@Getter
@ToString
public class PageRequestDTO {
    private String keyword;
    private String type; // t(title), c(content), w(writer), tc, tw, tcw
    private  int page;
    private  int size;


    public PageRequestDTO() {  //혹시나 안들어 올 것을 대비해 생성자로 초기화
        page = 1;
        size = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page-1, size, sort);
    }
}
