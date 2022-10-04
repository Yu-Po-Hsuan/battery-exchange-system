package com.yupohsuan.batteryexchangesystem.service;

import com.yupohsuan.batteryexchangesystem.dto.MemberLoginRequest;
import com.yupohsuan.batteryexchangesystem.dto.MemberRegisterRequest;
import com.yupohsuan.batteryexchangesystem.model.Member;

public interface MemberService {
    Member getMemberById(Integer memberId);

    Integer register(MemberRegisterRequest memberRegisterRequest);

    Member login(MemberLoginRequest memberLoginRequest);
}
