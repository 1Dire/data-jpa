package study.dataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.dataJpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
