package kr.ac.ync.ex.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.ac.ync.ex.global.common.entity.BaseEntity;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Builder
@Table(name = "tbl_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
public class MemberEntity extends BaseEntity {
    @Id
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

}
