import controller.MemberController;
import models.MemberId;
import repository.InMemoryMemberRepository;
import repository.MemberRepository;
import service.MemberService;

public class Main {

    public static void main(String[] args) {

        MemberRepository memberRepository = new InMemoryMemberRepository();
        MemberService memberService = new MemberService(memberRepository);
        MemberController memberController = new MemberController(memberService);

        final MemberId myMemberId = memberRepository.nextId();

        memberController.createMember( myMemberId);
        memberController.changePassword( myMemberId);
        memberController.printAllMembers();
    }
}
