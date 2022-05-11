package com.hellospring.hellospring.Repository;

import com.hellospring.hellospring.domain.Member;
import com.hellospring.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 테스트는 의존관계없이 실행되어야한다. 공용데이터 저장소들을 비워줘야함! 추가) 테스트를 먼저 만들고 구현클래스를 만들어서 돌려보는것 - TDD 테스트 주도개발
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get(); // optional일때 get으로 바로 꺼내도됨 테스트에서는 ㅇㅇ,new에서 저장한 멤버랑 db에서 불러온 멤버가 같으면 OK
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member(); // shift + F6 은 변수이름 한번에 바꾸기 ㅇㅇ
        member2.setName("spring2");
        repository.save(member2);
        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member(); // shift + F6 은 변수이름 한번에 바꾸기 ㅇㅇ
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
        //테스트가 끝나면 데이터를 초기화 해줘야한다!!!!
    }
}
