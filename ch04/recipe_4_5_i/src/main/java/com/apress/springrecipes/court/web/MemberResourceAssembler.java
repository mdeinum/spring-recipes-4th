package com.apress.springrecipes.court.web;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.apress.springrecipes.court.domain.Member;

public class MemberResourceAssembler extends ResourceAssemblerSupport<Member, MemberResource> {

    public MemberResourceAssembler() {
        super(RestMemberController.class, MemberResource.class);
    }

    @Override
    public MemberResource toResource(Member entity) {
        MemberResource resource = createResourceWithId(entity.getId(), entity);
        resource.setEmail(entity.getEmail());
        resource.setName(entity.getName());
        resource.setPhone(entity.getPhone());
        return resource;
    }
}
