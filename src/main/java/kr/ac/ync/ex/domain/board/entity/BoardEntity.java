package kr.ac.ync.ex.domain.board.entity;

import jakarta.persistence.*;
import kr.ac.ync.ex.global.common.entity.BaseEntity;
import lombok.*;

@Entity
@Table(name = "tbl_board")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String title;
    @Column(nullable = false, length = 2000)
    private String content;

    public void changeTitle(String title){
        this.title = title;
    }

}
