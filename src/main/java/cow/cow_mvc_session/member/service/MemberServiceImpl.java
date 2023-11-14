package cow.cow_mvc_session.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cow.cow_mvc_session.member.controller.dto.MemberRequest;
import cow.cow_mvc_session.member.controller.dto.MemberResponse;
import cow.cow_mvc_session.member.entity.Member;
import cow.cow_mvc_session.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	private final MemberRepository memberRepository;

	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(MemberRequest memberRequest) {
		Member member = new Member(memberRequest.getId(), memberRequest.getName());
		memberRepository.save(member);
	}

	@Override
	public MemberResponse findOne(Long memberId) {
		Member member = memberRepository.findById(memberId);
		return MemberResponse.of(member);
	}

	@Override
	public MemberResponse updateMember(Long memberId, MemberRequest memberRequest) {
		Member member = memberRepository.findById(memberId);
		member.setName(memberRequest.getName());
		memberRepository.save(member);
		return MemberResponse.of(member);
	}

	@Override
	public void delete(Long memberId) {
		Member member = memberRepository.findById(memberId);
		memberRepository.delete(member);
	}

	@Override
	public List<MemberResponse> findAll() {
		List<Member> member = memberRepository.findAll();

		return member.stream()
			.map(MemberResponse::of)
			.collect(Collectors.toList());
	}


}
