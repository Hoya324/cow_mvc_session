package cow.cow_mvc_session.member.controller.dto.request;

import cow.cow_mvc_session.member.entity.Member;
import lombok.Getter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class MemberRequest {
	Long id;
	final String name;

	@Builder
	private MemberRequest(final String name) {
		this.name = name;
	}

	public static Member toEntity(String name) {
		return Member.of(name);
	}
}

