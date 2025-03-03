package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        순수 자바 코드로 DI를 직접 구현한 방식(AppConfig 클래스에서 직접 서비스 객체들을 생성하고 의존성을 주입)
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();


        //스프링 컨테이너 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 스프링 컨테이너에서 빈 객체 가져오기
        // getBean 메서드를 통해 스프링 컨테이너에 등록된 빈을 조회
        // 첫 번째 인자: 빈 이름, 두 번째 인자: 빈의 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        // 회원 생성 및 등록
        // 새로운 회원 객체 생성: ID는 1L, 이름은 "memberA", 등급은 VIP
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 주문 생성
        // orderService를 통해 주문 생성: 회원 ID, 상품명("itemA"), 가격(20000)
        // VIP 회원이므로 할인 정책에 따라 할인이 적용됨
        Order order = orderService.createOrder(memberId,"itemA",20000);

        // 생성된 주문 정보 출력
        // Order 클래스의 toString() 메서드가 오버라이드되어 있어 주문 정보가 포맷팅되어 출력됨
        System.out.println("order = " + order);
    }
}
