package com.example.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AssignmentRowMapper implements RowMapper<MyAssignments> {

	@Override
	public MyAssignments mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MyAssignments m = new MyAssignments();
		m.setAssignment_id(rs.getInt("assignment_id"));
		m.setAuthor_id(rs.getString("author_id"));
		m.setDuration(rs.getTime("duration"));
		m.setExpire_time(rs.getTime("expire_time"));
		m.setMarks(rs.getInt("marks"));
		m.setName(rs.getString("name"));
		return m;
	}

}
