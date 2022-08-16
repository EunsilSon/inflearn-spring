package com.inflearn.hellospring;

import com.inflearn.hellospring.repository.JdbcTemplateMemberRepository;
import com.inflearn.hellospring.repository.JpaMemberRepository;
import com.inflearn.hellospring.repository.MemoryMemberRepository;
import com.inflearn.hellospring.repository.MemberRepository;
import com.inflearn.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    /*
    private EntityManager em;
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    private DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    }
     */
}
