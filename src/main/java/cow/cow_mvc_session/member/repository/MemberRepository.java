package cow.cow_mvc_session.member.repository;

import java.util.List;

import cow.cow_mvc_session.member.entity.Member;

public interface MemberRepository {

	void save(Member member);

	Member findById(Long memberId);

	List<Member> findAll();

	void delete(Member member);
}
