package cow.cow_mvc_session.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cow.cow_mvc_session.member.controller.dto.MemberRequest;
import cow.cow_mvc_session.member.controller.dto.MemberResponse;
import cow.cow_mvc_session.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/new")
	public void create(@RequestBody final MemberRequest memberRequest) {
		memberService.join(memberRequest);
	}

	@GetMapping("/{memberId}")
	public MemberResponse findMember(@PathVariable final Long memberId) {
		return memberService.findOne(memberId);
	}

	@GetMapping("/findAll")
	public List<MemberResponse> findAll() {
		return memberService.findAll();
	}

	@PutMapping("/update/{memberId}")
	public MemberResponse updateMember(@PathVariable final Long memberId, @RequestBody final MemberRequest memberRequest) {
		return memberService.updateMember(memberId, memberRequest);
	}

	@DeleteMapping("/delete/{memberId}")
	public void deleteMember(@PathVariable final Long memberId) {
		memberService.delete(memberId);
	}
}

