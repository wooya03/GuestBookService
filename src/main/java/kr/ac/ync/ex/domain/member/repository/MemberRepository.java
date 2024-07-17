package kr.ac.ync.ex.domain.member.repository;

import kr.ac.ync.ex.domain.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

}
