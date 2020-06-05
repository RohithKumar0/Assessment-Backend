package com.example.assignments;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class McqRowMapper implements RowMapper<McqStructure> {

	@Override
	public McqStructure mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		McqStructure m = new McqStructure();
		m.setId(rs.getInt("id"));
		m.setAssignment_id(rs.getInt("assignment_id"));
		m.setQuestion(rs.getString("question"));
		m.setA(rs.getString("a"));
		m.setB(rs.getString("b"));
		m.setC(rs.getString("c"));
		m.setD(rs.getString("d"));
		m.setAnswer(rs.getString("answer"));
		return m;
	}

}
