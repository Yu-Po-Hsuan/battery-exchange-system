package com.yupohsuan.batteryexchangesystem.service.impl;

import com.yupohsuan.batteryexchangesystem.dao.MemberDao;
import com.yupohsuan.batteryexchangesystem.dto.MemberLoginRequest;
import com.yupohsuan.batteryexchangesystem.dto.MemberRegisterRequest;
import com.yupohsuan.batteryexchangesystem.model.Member;
import com.yupohsuan.batteryexchangesystem.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
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
        //檢查註冊 email
        Member member = memberDao.getMemberByEmail(memberRegisterRequest.getEmail());

        if (member != null) {
            log.warn("該 email {} 已經被註冊", memberRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //使用 md5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(memberRegisterRequest.getPassword().getBytes());
        memberRegisterRequest.setPassword(hashedPassword);

        //創建帳號
        return memberDao.createMember(memberRegisterRequest);
    }

    @Override
    public Member login(MemberLoginRequest memberLoginRequest) {
        Member member = memberDao.getMemberByEmail(memberLoginRequest.getEmail());

        //檢查 member 是否存在
        if (member == null) {
            log.warn("該 email {} 尚未註冊", memberLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //使用 md5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(memberLoginRequest.getPassword().getBytes());

        //比較密碼
        if (member.getPassword().equals(hashedPassword)) {
            return member;
        } else {
            log.warn("該 email {} 密碼輸入不正確", memberLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
