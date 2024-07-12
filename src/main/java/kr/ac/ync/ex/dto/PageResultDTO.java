package kr.ac.ync.ex.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

@Getter
@Setter
@ToString
public class PageResultDTO<DTO, EN> {
    private List<DTO> dtoList; // DTO 리스트
    private int totalPage; // 총 페이지 번호
    private int page; // 현재 페이지 번호
    private int size; // 사이즈
    private int start, end; // 시작 페이지 번호, 끝 페이지 번호
    private boolean prev, next; // 이전 페이징 유무, 다음 페이지 버튼 유무
    private List<Integer> pageList; // 페이지 번호

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn){
//        entity -> entityToDTO(entity)
//        LIst<GuestBookEntity> result
        dtoList = result.stream().map(fn).toList();
        totalPage = result.getTotalPages();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable) {
        this.page = pageable.getPageNumber() + 1;
        this.size = pageable.getPageSize();

        int tempEnd = (int)(Math.ceil(page/10.0)) * 10;

        start = tempEnd - 9;
        prev = start > 1;
        end = totalPage > tempEnd ? tempEnd : totalPage;
        next = totalPage > tempEnd;
        pageList = IntStream.rangeClosed(start, end).boxed().toList();
    }


}
