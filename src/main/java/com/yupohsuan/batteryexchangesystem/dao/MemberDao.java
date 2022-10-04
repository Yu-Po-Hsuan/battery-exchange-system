package com.yupohsuan.batteryexchangesystem.dao;

import com.yupohsuan.batteryexchangesystem.dto.MemberRegisterRequest;
import com.yupohsuan.batteryexchangesystem.model.Member;

public interface MemberDao {

    Member getMemberById(Integer memberId);

    Member getMemberByEmail(String email);

    Integer createMember(MemberRegisterRequest memberRegisterRequest);
}
