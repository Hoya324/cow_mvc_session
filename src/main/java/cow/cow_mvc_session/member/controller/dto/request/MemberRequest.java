package cow.cow_mvc_session.member.controller.dto.request;

import cow.cow_mvc_session.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberRequest {
	private String name;

	public static Member toEntity(String name) {
		return Member.builder()
			.name(name)
			.build();
	}
}

