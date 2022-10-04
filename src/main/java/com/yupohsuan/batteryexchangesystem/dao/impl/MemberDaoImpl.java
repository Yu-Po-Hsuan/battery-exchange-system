package com.yupohsuan.batteryexchangesystem.dao.impl;

import com.yupohsuan.batteryexchangesystem.dao.MemberDao;
import com.yupohsuan.batteryexchangesystem.dto.MemberRegisterRequest;
import com.yupohsuan.batteryexchangesystem.model.Member;
import com.yupohsuan.batteryexchangesystem.rowmapper.MemberRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Member getMemberById(Integer memberId) {
        String sql = "SELECT member_id, email, password, created_date, last_modified_date FROM member " +
                "WHERE member_id = :memberId";

        Map<String, Object> map = new HashMap<>();
        map.put("memberId", memberId);

        List<Member> memberList = namedParameterJdbcTemplate.query(sql, map, new MemberRowMapper());

        if (memberList.size() > 0) {
            return memberList.get(0);
        } else {
            return null;
        }
    }


    @Override
    public Member getMemberByEmail(String email) {
        String sql = "SELECT member_id, email, password, created_date, last_modified_date FROM member " +
                "WHERE email = :email";

        Map<String, Object> map = new HashMap<>();
        map.put("email", email);

        List<Member> memberList = namedParameterJdbcTemplate.query(sql, map, new MemberRowMapper());

        if (memberList.size() > 0) {
            return memberList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createMember(MemberRegisterRequest memberRegisterRequest) {

        String sql = "INSERT INTO member (email, password, created_date, last_modified_date) " +
                "VALUES (:email, :password, :createdDate, :lastModifiedDate);";

        Map<String, Object> map = new HashMap<>();
        map.put("email", memberRegisterRequest.getEmail());
        map.put("password", memberRegisterRequest.getPassword());

        map.put("createdDate", new Date());
        map.put("lastModifiedDate", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        Integer memberId = keyHolder.getKey().intValue();

        return memberId;
    }
}
