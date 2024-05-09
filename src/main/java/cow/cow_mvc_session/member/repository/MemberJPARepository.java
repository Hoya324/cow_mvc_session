package cow.cow_mvc_session.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cow.cow_mvc_session.member.entity.Member;

public interface MemberJPARepository extends JpaRepository<Member, Long> {}
