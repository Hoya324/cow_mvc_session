package cow.cow_mvc_session.member.entity;

import java.util.ArrayList;
import java.util.List;

import cow.cow_mvc_session.post.entity.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	private String name;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private final List<Post> posts = new ArrayList<>();

	@Builder
	private Member(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public static Member of(String name) {
		return Member.builder()
			.name(name)
			.build();
	}

	public static Member from(Long id, String name) {
		return Member.builder()
			.id(id)
			.name(name)
			.build();
	}
}

