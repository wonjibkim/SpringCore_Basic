package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

   private static Map<Long,Member> store = new HashMap<>();
   private  static long sequence = 0L;


    @Override //id를 저장하기
    public Member save(Member member) {
        member.setId(++sequence); // id에 값을 넣기
        store.put(member.getId(), member); // map 형태로 id값 : name값 넣기
        return member;
    }

    @Override //store에서 id값을 키값으로 꺼내온다 단 null값이 발생할 수 있으므로 optional을 사용
    public Optional<Member> findById(Long id) {
        return Optional.of(store.get(id));
    }

    @Override //store에서 루프를 돌려서 필터 name값이 값으면 하나라도 찾는다
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
