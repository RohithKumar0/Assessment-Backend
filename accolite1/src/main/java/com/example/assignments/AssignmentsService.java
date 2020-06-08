package com.example.assignments;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.model.AuthResonse;

@Service
public class AssignmentsService {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public List<AssignmentStructure> getAllAssignments() {
		LOGGER.log(Level.INFO, "Get all asignment	"); 
//		String query = "select a.id, a.name,u.name as author,a.expire_time,a.duration from assignments as a join users as u on a.user_id=u.id;";
		String query = "select * from assignments";
		System.out.println("get all assigments");
		List<AssignmentStructure> a = jdbc.query(query, new AssignmentRowMapper());
		System.out.println(a);
		
		return a;
	}
	
	public AuthResonse addAssignment(AssignmentStructure as, int userId) {
		LOGGER.log(Level.INFO, "Add assignment	");
		String query= "insert into assignments (name, user_id, expire_time, duration)\r\n" + 
				"values('"+as.getName()+"',"+userId+",'"+as.getExpire_time()+"', '"+as.getDuration()+"')";
		jdbc.execute(query);
		return new AuthResonse("successfully added");
	}

	public AssignmentStructure getAssignbyId(int id) {
		LOGGER.log(Level.INFO, "Get assign by ID	");
		// TODO Auto-generated method stub
		String query = "select * from assignments where id ="+id+" limit 1";
		AssignmentStructure a = jdbc.queryForObject(query, new AssignmentRowMapper());
		System.out.println(a);
		return a;
	}

	public AuthResonse deleteAssignment(int id) {
		LOGGER.log(Level.INFO, "delete assignment	");
		String query= "delete from assignments where id ="+id;
		jdbc.execute(query);
		return new AuthResonse("successfully deleted");
	}

	public List<CandidateStructure> getCandiadtesbyAssignId(int id) {
		LOGGER.log(Level.INFO, "get candiadates by assign id");
		// TODO Auto-generated method stub
		String query = "select * from  results as r join users as u on r.user_id=u.id where r.assignment_id="+id;
		List<CandidateStructure> c = jdbc.query(query, new CandidateRowMapper());
		return c;
	}

	public AuthResonse updateAssign(AssignmentStructure as, int id) {
		// TODO Auto-generated method stub
		LOGGER.log(Level.INFO, "update assignment	");
		String query= "update assignments\r\n" + 
				"set name = '"+as.getName()+"', expire_time='"+as.getExpire_time()+"',duration='"+as.getDuration()+"' where id ="+id;
		jdbc.execute(query);
		return new AuthResonse("successfully updated");
	}
	
	
}
