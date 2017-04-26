package com.apress.springrecipes.court.web;

import com.apress.springrecipes.court.domain.Member;
import com.apress.springrecipes.court.service.MemberService;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
public class RestMemberController {

    private final MemberService memberService;

    public RestMemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Resource<Member>>> getRestMembers() {

        List<Resource<Member>> members = memberService.findAll().stream().map(m -> new Resource<>(m)).collect(Collectors.toList());

        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{memberid}")
    public ResponseEntity<Resource<Member>> getMember(@PathVariable("memberid") long memberID) {
        Member member = memberService.find(memberID);
        if (member != null) {
            return new ResponseEntity<>(new Resource<>(member), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
