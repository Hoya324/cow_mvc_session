package cow.cow_mvc_session.member.controller.dto.response;

import cow.cow_mvc_session.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {
	private final Long id;
	private final String name;

	@Builder
	private MemberResponse(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public static MemberResponse of(final Member member) {
		return MemberResponse.builder()
			.id(member.getId())
			.name(member.getName())
			.build();
	}
}
