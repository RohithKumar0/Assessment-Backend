package com.example.assignments;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.RowMapper;

public class AssignmentRowMapper implements RowMapper<AssignmentStructure>{

	@Override
	public AssignmentStructure mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		AssignmentStructure a = new AssignmentStructure();
		a.setId(rs.getInt("id"));
		a.setName(rs.getString("name"));
		a.setUser_id(rs.getInt("User_id"));
		a.setExpire_time(rs.getTime("expire_time"));
		a.setDuration(rs.getTime("duration"));
		return a;
	}
	

}
