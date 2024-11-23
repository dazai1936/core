package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; //추상에만 의존, 구체적인 것은 외부(Appconfig에서 생성해 넣어줌)

    public  MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
