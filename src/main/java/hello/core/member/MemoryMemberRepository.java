package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }
    //save 메서드 동작 분석: member 객체에서 getId 메서드를 호출에 id 추출 -> key로 사용
    //member 객체 전체를 value로 사용
    //store.put(key,value)메서드를 호출하여 이 key-value쌍을 store에 저장
    //store = HaspMap 객체 -> 키와 값을 한 쌍으로 데이터 가짐

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
    // public Member findById(Long memberId) {
    // return store.get(memberId);


}
