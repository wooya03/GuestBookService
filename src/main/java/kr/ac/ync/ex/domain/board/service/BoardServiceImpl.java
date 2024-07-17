package kr.ac.ync.ex.domain.board.service;

import kr.ac.ync.ex.domain.board.entity.BoardEntity;
import kr.ac.ync.ex.domain.board.exception.NotFoundBoardException;
import kr.ac.ync.ex.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public void findById(Long id) {
        Optional<BoardEntity> result = boardRepository.findById(id);
        if(result.isPresent()){
            result.orElseThrow();
        } else {
            new NotFoundBoardException();
        }
            BoardEntity boardEntity = result.orElseThrow(
                    () -> NotFoundBoardException.EXCEPTION
            );

    }
}
