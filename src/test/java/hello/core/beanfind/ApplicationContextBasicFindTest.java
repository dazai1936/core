package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    /**
     * 스프링 컨테이너 생성
     * AppConfig 클래스를 구성 정보로 사용하여 스프링 컨테이너를 초기화함
     * 이 과정에서 AppConfig에 정의된 모든 빈들이 스프링 컨테이너에 등록됨
     */

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    /**
     * 빈 이름으로 조회하는 테스트 메서드
     * 특정 이름("memberService")을 가진 빈을 조회하고 타입을 확인함
     */


    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        /*
         * 조회된 빈이 MemberServiceImpl 클래스의 인스턴스인지 검증
         * memberService는 인터페이스이며, 실제 구현체는 MemberServiceImpl이어야 함
         * isInstanceOf: 객체가 특정 클래스나 인터페이스의 인스턴스인지 확인하는 메서드
         */

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

}
