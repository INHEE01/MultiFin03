package com.multi.multifin.member.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multi.multifin.member.model.vo.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> { 
	Member findByMemberId(String memberId);
}