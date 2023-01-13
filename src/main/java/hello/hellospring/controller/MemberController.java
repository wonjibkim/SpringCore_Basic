package hello.hellospring.controller;

import hello.hellospring.Service.MemberService;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller// 스프링 컨테이너가 컨트룰러라는 어노테이션이 있으면 스프링 시작할 떄 객체를 생성하여 메모리에 들고 있음 => 빈이 관리되고 있다
public class MemberController {

//    private  final MemberService memberService = new MemberService();
//    // 이런식으로 선언하면 memberservice가 다른곳에서도 사용할수 있는데 다른곳도 메모리에 올려서 써서 비효율적

    private final MemberService memberService;

    @Autowired // 스프링 컨테이너에서 memberservice를 가져옴
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
