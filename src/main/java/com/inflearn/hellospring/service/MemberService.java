package com.inflearn.hellospring.service;

import com.inflearn.hellospring.domain.Member;
import com.inflearn.hellospring.repository.MemberRepository;
import com.inflearn.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memoryMemberRepository;

    public MemberService(MemoryMemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }

    /*
     * 회원 가입
     */
    public Long join(Member member) {
        // ctrl + alt + m : 메소드 자동 생성
        validateDuplicateMember(member); // 중복 체크
        memoryMemberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memoryMemberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memoryMemberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memoryMemberRepository.findById(memberId);
    }
}
