package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정 정보 - 애플리케이션이 어떻게 구성되는지
public class AppConfig {
//스프링 컨테이너 생성 -> 스프링 빈 저장소에 저장 -> 구성 정보 활용 (지워도 되는 내용)
    @Bean //Bean 어노테이션을 붙이면 각각의 생성된 객체가 스프링 컨테이너에 등록됨(빈 이름 - 빈 객체)
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }//생성자 주입
    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}