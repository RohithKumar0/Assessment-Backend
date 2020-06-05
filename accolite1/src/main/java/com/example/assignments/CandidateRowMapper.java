package com.example.assignments;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CandidateRowMapper implements RowMapper<CandidateStructure>{

	@Override
	public CandidateStructure mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		CandidateStructure c = new CandidateStructure();
		c.setEmail(rs.getString("email"));
		c.setMarks(rs.getInt("marks"));
		c.setName(rs.getString("name"));
		c.setUser_id(rs.getInt("user_id"));
		return c;
	}

}
