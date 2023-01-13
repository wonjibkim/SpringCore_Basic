package hello.hellospring.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 서비스 비즈니스의존적으로 설계
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
         * 회원가입
         */
        public long join(Member member){
            vailidateDuplicateMember(member); //중복회원 검증
            memberRepository.save(member);
        return member.getId();

    }

    private void vailidateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m  -> { // 멤버에 값이 있으면 exception 처리
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    /**
     *
     * 전체회원조회
     */

    public List<Member> findMembers(){
            return memberRepository.findAll();
    }

    public Optional<Member> findOne (Long memberId){
        return memberRepository.findById(memberId);
    }

}
