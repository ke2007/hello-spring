package com.hellospring.hellospring.service;

import com.hellospring.hellospring.domain.Member;
import com.hellospring.hellospring.repository.MemberRepository;
import com.hellospring.hellospring.repository.MemoryMemberRepository;
import org.apache.el.lang.ELArithmetic;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {
        //중복회원 X
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //findByName을 해 그 결과는 optionalmember니까 중복확인을해
//            result.orElseGet(기본값); 있으면 내놓고 없으면 기본값을 줘
                .ifPresent(m -> {//result.ifPresent
                    throw new IllegalStateException("이미있음요");
                });
    }

    //    전체 회원 조회
    public List<Member> findMembers() { //서비스클래스의 이름들은 기능에 알맞게~ 한번에 알아보게~  서버쪽 클래스는 로직에 맞게~
        return memberRepository.findAll();
    }

    // 회원 한명 조회
    public Optional<Member> findOne(Long memberID) {

        return memberRepository.findById(memberID);
    }
}
