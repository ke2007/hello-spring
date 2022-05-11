package com.hellospring.hellospring.repository;

import com.hellospring.hellospring.domain.Member;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); // save 하면 회원저장

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();


}
