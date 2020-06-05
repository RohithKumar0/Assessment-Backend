package com.example.assignments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.model.AuthResonse;

@Service
public class McqService {

	@Autowired
	private JdbcTemplate jdbc;

	public List<McqStructure> getAllMcqs(int id) {
		// TODO Auto-generated method stub
		String query = "select * from mcqs where assignment_id ="+id;
		List<McqStructure> m = jdbc.query(query, new McqRowMapper());
		return m;
	}

	public AuthResonse addMcq(McqStructure as, int assignment_id) {
		// TODO Auto-generated method stub
		System.out.println(as);
		String query = "insert into mcqs (assignment_id,question,a,b,c,d,answer)\r\n" + 
				"values ("+assignment_id+",'"+as.getQuestion()+"','"+as.getA()+"','"+as.getB()+"','"+as.getC()+"','"+as.getD()+"','"+as.getAnswer()+"')";
		jdbc.execute(query);
		return new AuthResonse("successfully added");
	}

	public McqStructure getMcqbyId(int id) {
		// TODO Auto-generated method stub
		String Query = "select * from mcqs where id="+id;
		McqStructure m = jdbc.queryForObject(Query, new McqRowMapper());
		return m;
	}

	public AuthResonse deleteMcq(int id) {
		// TODO Auto-generated method stub
		String query = "delete from mcqs where id="+id;
		return new AuthResonse("Mcq deleted successfully");
	}
	


}
