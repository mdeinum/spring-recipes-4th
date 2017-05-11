package com.apress.springrecipes.court.service;

import java.util.List;

import com.apress.springrecipes.court.domain.Member;

public interface MemberService {

    void add(Member member);

    void remove(String memberName);

    List<Member> list();
}
