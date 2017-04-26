package com.apress.springrecipes.court.service;

import com.apress.springrecipes.court.domain.Member;

import java.util.Collection;

public interface MemberService {

    Collection<Member> findAll();
    Member find(long id);
}
