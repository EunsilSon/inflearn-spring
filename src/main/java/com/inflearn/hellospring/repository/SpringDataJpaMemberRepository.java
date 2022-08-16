package com.inflearn.hellospring.repository;
import com.inflearn.hellospring.repository.MemberRepository;

import com.inflearn.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPL : select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}