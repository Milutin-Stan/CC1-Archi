package repository;

import models.Member;
import models.MemberId;

import java.util.List;

public interface MemberRepository {
    void save(Member member);

    Member byId(MemberId memberId);

    MemberId nextId();

    List<Member> findAll();
}
