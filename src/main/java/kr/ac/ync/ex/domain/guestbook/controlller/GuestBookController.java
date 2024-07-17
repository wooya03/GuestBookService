package kr.ac.ync.ex.domain.guestbook.controlller;

import kr.ac.ync.ex.domain.guestbook.dto.GuestBookDTO;
import kr.ac.ync.ex.global.common.dto.PageDataResponse;
import kr.ac.ync.ex.global.common.dto.PageRequestDTO;
import kr.ac.ync.ex.domain.guestbook.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestbook")
@RequiredArgsConstructor
@Slf4j
public class GuestBookController {
    private final GuestBookService guestBookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody GuestBookDTO dto){
        log.info(" ... register = {}", dto);
        guestBookService.register(dto);
    }

    @GetMapping("/{gno}")
    public ResponseEntity<GuestBookDTO> read(@PathVariable("gno") long gno){
        return ResponseEntity.ok().body(guestBookService.read(gno));
    }

    @PutMapping
    public void modify(@RequestBody GuestBookDTO dto){
        guestBookService.modify(dto);
    }

    @DeleteMapping("/{gno}")
    public void remove(@PathVariable("gno") long gno){
        guestBookService.remove(gno);
    }

    @GetMapping("/list")
    public ResponseEntity getlist(PageRequestDTO pageRequestDTO){
        log.info(" .... pageRequest : {}",  pageRequestDTO);
        PageDataResponse<List<GuestBookDTO>> dataResponse =
                PageDataResponse.create(
                        guestBookService.getSearchList(pageRequestDTO)
                );
        return ResponseEntity.ok().body(guestBookService.getSearchList(pageRequestDTO));
    }

}
