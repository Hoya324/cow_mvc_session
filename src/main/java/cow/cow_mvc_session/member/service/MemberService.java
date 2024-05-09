package cow.cow_mvc_session.member.service;

import java.util.ArrayList;
import java.util.List;

import cow.cow_mvc_session.member.controller.dto.request.MemberRequest;
import cow.cow_mvc_session.member.controller.dto.response.MemberResponse;

public interface MemberService {

	/* 기본 */
	// void join(MemberRequest memberRequest);
	// Member findOne(Long memberId);


	/* MemberResponse dto 적용 */
	MemberResponse findOne(Long memberId);
	MemberResponse join(MemberRequest memberRequest);
	List<MemberResponse> findAll();
}

