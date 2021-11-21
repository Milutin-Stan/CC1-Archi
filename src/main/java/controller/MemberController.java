package controller;

import models.Member;
import models.MemberId;
import service.MemberService;

import java.util.List;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void createMember(MemberId myMemberId) {
        Member member = Member.of(myMemberId, "Stanojevic", "Milutin", "Initial");
        this.memberService.create(member);
    }

    public void changePassword(MemberId myMemberId) {
        memberService.changePassword(myMemberId, "After_Change");
    }

    public void printAllMembers() {
        System.out.println("List all members");

        final List<Member> members = memberService.all();
        members.forEach(currentMember -> System.out.println(currentMember));
    }
}
