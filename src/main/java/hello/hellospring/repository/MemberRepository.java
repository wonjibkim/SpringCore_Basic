package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id); // optional : key값인 findByid로 값을 가져오는데 null일 수도 있으니 한번더 감싸서 가져오는 구조
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
