# COW MVC PRACTICE 초기 코드

## 📮 미션 제출 방법
- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - 해당 리포지토리를 fork/clone
    - 미션 구현
    - 미션 구현 과정에서 학습한 내용, 고민했던 점 등을 기록한 본인 깃헙 아이디 이름 md파일 작성(ex. Hoya324.md)
    - 구현 완료 한 코드는 해당 리포지토리에 pr 작성
        - pr 타이틀: [#주차] cow mvc practice(깃헙 아이디)
            - ex. [1주차] cow mvc practice(Hoya324)
    - 미션 구현에서 기록한 md파일은 [COW-Spring-3](https://github.com/COW-edu/COW-Spring-3/tree/main/week08) 리포지토리에 pr 작성
    - 미션 구현 pr 링크 첨부

## 환경
### [spring initializr link](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.2.5&packaging=jar&jvmVersion=17&groupId=com.cow&artifactId=cow_mvc_session&name=cow_mvc_session&description=cow_mvc_session&packageName=com.cow.cow_mvc_session&dependencies=web,data-jpa,lombok)

## h2 실행 방법
- https://www.h2database.com/html/download.html
- 해당 링크에서 운영체제에 맞는 h2 DB를 다운 받습니다.
- 아래의 블로그를 참조해서 작성해주세요
  - 단 url은 `jdbc:h2:tcp://localhost/~/cow_mvc_session` 또는 본인의 url를 사용하여 application.yml을 수정해서 사용해주세요
  - 현재 설정된 username: sa
  - password은 설정하지 않았습니다.
- https://velog.io/@piaocanyi/m1-mac-h2-database-%EC%84%A4%EC%B9%98-%EC%8B%A4%ED%96%89
- https://atoz-develop.tistory.com/entry/H2-Database-%EC%84%A4%EC%B9%98-%EC%84%9C%EB%B2%84-%EC%8B%A4%ED%96%89-%EC%A0%91%EC%86%8D-%EB%B0%A9%EB%B2%95

## 구현 미션

- 이번주 미션은 저번 세션에서 했던 Spring MVC 실습 + JPA를 활용해 추가적인 CRUD를 하는 미션으로 하겠습니다.
- 엔티티를 반환하는 것이 아닌, DTO를 사용해서 필요한 값들만 반환해주도록 합니다.
    - builder 패턴을 적용해보시면 좋습니다!
    - [Builder 패턴 참고자료](https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%EB%B9%8C%EB%8D%94Builder-%ED%8C%A8%ED%84%B4-%EB%81%9D%ED%8C%90%EC%99%95-%EC%A0%95%EB%A6%AC)

> 필요한 api를 직접 작성하는 능력을 키우고자, 큰 가이드 라인을 드리지 않았습니다.

### 요구사항
1. 사용자는 사용자의 정보를 수정할 수 있습니다. (keyword: 변경감지) 
2. 실제 Member의 id값은 로그인을 통해 토큰의 값을 해석해 가져오거나, 세션 id를 통해 가져오나, 이번 미션에서는 members/1 과 같이 Path Variable을 사용해주세요.
3. Comment Entity를 생성해주세요. Comment Entity는 게시글과 1 : N, Member와 1 : N의 관계를 가지고 있습니다. (기존 코드를 참고해주세요)
3. 사용자는 특정 게시글을 조회할 수 있습니다. 이때 posts/1 와 같이 Path Variable을 통해 조회해주세요.

   이때 게시글 제목, 게시글 내용, 게시글 작성자, 작성일시, 댓글 내용을 반환합니다.

4. 사용자는 게시글을 작성할 수 있습니다. Post를 생성하기 위한 정보는 body를 사용해주세요.
   - 사용자는 제목과 내용을 입력해 게시글을 생성합니다. members/1와 같이 Path Variable을 사용해주세요.

5. 사용자는 댓글을 작성할 수 있습니다. 이때 members/2/posts/1 와 같은 Path Variable를 사용하고, comment의 내용은 body를 통해 전달하는 것으로 합니다. 이때 게시글에 댓글이 작성된다면 해당 게시글의 댓글 개수를 추가하는 메서드를 작성해주세요.
6. 사용자는 모든 게시글들을 조회할 수 있습니다. 게시글의 id, 게시글의 제목, 작성자의 이름, 게시글의 댓글 개수를 리스트로 반환합니다.
7. 사용자는 게시글을 삭제할 수 있습니다. 이때 cascade 옵션을 사용해 해당 게시글의 댓글도 같이 삭제합니다. cascade 옵션에 대해 학습하기 위해서 다음과 같은 링크를 참고해주세요. 또한 cascade 옵션이 있을 경우와 cascade 있을 경우 쿼리를 비교해서 캡쳐해주세요.
   [https://velog.io/@max9106/JPA엔티티-상태-Cascade](https://velog.io/@max9106/JPA%EC%97%94%ED%8B%B0%ED%8B%B0-%EC%83%81%ED%83%9C-Cascade)

---

분명 척척해내시는 분들도 계실거고, 조금은 버거우신 분들도 존재하리라 생각이 듭니다! 
모든 것을 처음부터 잘하는 사람은 없으니 저희 멘토들에게 많은 질문해주시고 욕심이 있으신분들은 추가적인 공부를 통해 더욱더 성장하시길 바랍니다!!

모든 요구사항을 충족시키시기 어렵다는 생각이 드신다면 member, post만이라고 확실하게 구현해보시고 이해하시길 추천드려요! 
또한 해당 과제에서는 간단한 mvc 구현이 목적이기에 JPA에 대한 설명이 많이 부족합니다. 너무 JPA에 대해 많은 시간을 쏟지 않으셔도 된다는 말씀드립니다.