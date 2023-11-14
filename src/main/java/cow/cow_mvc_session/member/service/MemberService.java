package cow.cow_mvc_session.member.service;

import java.util.List;

import cow.cow_mvc_session.member.controller.dto.MemberRequest;
import cow.cow_mvc_session.member.controller.dto.MemberResponse;

public interface MemberService {

	void join(MemberRequest memberRequest);

	MemberResponse findOne(Long memberId);

	List<MemberResponse> findAll();

	MemberResponse updateMember(Long memberId, MemberRequest memberRequest);

	void delete(Long memberId);
}

