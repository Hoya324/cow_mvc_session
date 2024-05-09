package cow.cow_mvc_session.member.repository;

import java.util.List;
import java.util.Optional;

import cow.cow_mvc_session.member.entity.Member;

public interface MemberRepository {

	void save(Member member);

	Optional<Member> findById(Long memberId);

	Optional<List<Member>> findAll();
}
