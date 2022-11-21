package com.yupohsuan.batteryexchangesystem.rowmapper;

import com.yupohsuan.batteryexchangesystem.model.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet resultSet, int i) throws SQLException {
        Member member = new Member();
        member.setMemberId(resultSet.getInt("member_id"));
        member.setEmail(resultSet.getString("email"));
        member.setPassword(resultSet.getString("password"));
        member.setPhoneNumber(resultSet.getString("phone_number"));
        member.setCreatedDate(resultSet.getTimestamp("created_date"));
        member.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return member;
    }
}
