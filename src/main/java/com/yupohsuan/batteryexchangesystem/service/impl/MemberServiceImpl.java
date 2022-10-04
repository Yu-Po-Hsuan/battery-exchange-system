package com.yupohsuan.batteryexchangesystem.service.impl;

import com.yupohsuan.batteryexchangesystem.dao.MemberDao;
import com.yupohsuan.batteryexchangesystem.dto.MemberRegisterRequest;
import com.yupohsuan.batteryexchangesystem.model.Member;
import com.yupohsuan.batteryexchangesystem.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    private final static Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Override
    public Member getMemberById(Integer memberId) {

        Member member = memberDao.getMemberById(memberId);

        return member;
    }

    @Override
    public Integer register(MemberRegisterRequest memberRegisterRequest) {

        Member member = memberDao.getMemberByEmail(memberRegisterRequest.getEmail());

        if (member != null) {
            log.warn("該 email {} 已經被註冊", memberRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return memberDao.createMember(memberRegisterRequest);
    }
}
