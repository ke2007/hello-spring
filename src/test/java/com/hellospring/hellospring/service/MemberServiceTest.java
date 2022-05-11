package com.hellospring.hellospring.service;

import com.hellospring.hellospring.domain.Member;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void join() { //테스트 코드는 한글로 적어도 OK
        //given - given 부분의 데이터를 기반으로 돌리는구나~  Given when then 패턴으로 테스트 코드 작성, 상황에 따라 다름
        Member member = new Member();
        member.setName("hello");

        //when - 검증내용
        Long saveId = memberService.join(member);

        //then - 검증부
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}