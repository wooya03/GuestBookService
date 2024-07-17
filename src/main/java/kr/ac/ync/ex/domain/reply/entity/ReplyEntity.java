package kr.ac.ync.ex.domain.reply.entity;

import jakarta.persistence.*;
import kr.ac.ync.ex.domain.board.entity.BoardEntity;
import kr.ac.ync.ex.global.common.entity.BaseEntity;
import lombok.*;

@Entity
@Table(name = "tbl_reply")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
public class ReplyEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String replyer;

    @ManyToOne
    private BoardEntity board;
}
