package cow.cow_mvc_session.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cow.cow_mvc_session.member.controller.dto.request.MemberRequest;
import cow.cow_mvc_session.member.controller.dto.response.MemberResponse;
import cow.cow_mvc_session.member.entity.Member;
import cow.cow_mvc_session.member.repository.MemberJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

	private final MemberJPARepository memberRepository;
	// private final MemberRepository memberRepository;

	/* 기본 */
	// @Override
	// public void join(MemberRequest memberRequest) {
	// 	Member member = Member.from(memberRequest.getId(), memberRequest.getName());
	// 	memberRepository.save(member);
	// }
	//
	// @Transactional(readOnly = true)
	// @Override
	// public Member findOne(Long memberId) {
	// 	return memberRepository.findById(memberId)
	// 		.orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
	// }

	/* MemberResponse dto 적용 */
	@Override
	public MemberResponse join(MemberRequest memberRequest) {
		Member member = Member.of(memberRequest.getName());
		memberRepository.save(member);
		return MemberResponse.of(member);
	}

	@Transactional(readOnly = true)
	@Override
	public MemberResponse findOne(Long memberId) {
		Member member = memberRepository.findById(memberId)
			.orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
		return MemberResponse.of(member);
	}

	@Override
	public List<MemberResponse> findAll() {
		List<Member> members = memberRepository.findAll();
		return members.stream()
			.map(MemberResponse::of)
			.collect(Collectors.toList());
	}
}