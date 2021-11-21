package repository;

import models.Member;
import models.MemberId;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryMemberRepository implements MemberRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<MemberId, Member> data = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        data.put(member.getMemberId(), member);
    }

    @Override
    public Member byId(MemberId memberId) {
        final Member member = data.get(memberId);
        if (member == null) {
            throw new RuntimeException("No member for " + memberId.getValue());
        }
        return member;
    }

    @Override
    public MemberId nextId() {
        return MemberId.of(counter.incrementAndGet());
    }

    @Override
    public List<Member> findAll() {
        return data.values().stream().collect(Collectors.toList());
    }
}
