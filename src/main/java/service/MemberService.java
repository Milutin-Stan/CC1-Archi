package service;

import models.Member;
import models.MemberId;
import repository.MemberRepository;

import java.util.List;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void create(Member member) {
        this.memberRepository.save(member);
    }

    public void changePassword(MemberId memberId, String newPassword) {
        var member = this.memberRepository.byId(memberId);
        member.changePassword(newPassword);
        this.memberRepository.save(member);
    }

    public List<Member> all() {
        return this.memberRepository.findAll();
    }
}
