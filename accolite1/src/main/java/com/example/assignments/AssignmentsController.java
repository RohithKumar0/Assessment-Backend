package com.example.assignments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AuthResonse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("{userId}/assignments")
public class AssignmentsController {
	
	@Autowired
	private AssignmentsService assignService;
	
	
	@GetMapping("")
	public List<AssignmentStructure> getAllAssignments() {
		return assignService.getAllAssignments();
	}
	
	@PostMapping("/add")
	public AuthResonse addAssignments(@RequestBody AssignmentStructure as, @PathVariable("userId") int userId) {
		return assignService.addAssignment(as, userId);
	}

	@GetMapping("/{id}")
	public AssignmentStructure getAssignmentbyId(@PathVariable("id") int id) {
		return assignService.getAssignbyId(id);
		
	}
	
	@GetMapping("/{id}/candidate")
	public List<CandidateStructure> getCandiadtesbyAssignId(@PathVariable("id") int id) {
		return assignService.getCandiadtesbyAssignId(id);
		
	}
	
	@DeleteMapping("/{id}")
	public AuthResonse deleteAssignment(@PathVariable("id") int id) {
		return assignService.deleteAssignment(id);
	}
	
	@PutMapping("/{id}")
	public AuthResonse updateAssign(@RequestBody AssignmentStructure as,@PathVariable("id") int id) {
		return assignService.updateAssign(as, id);
	}
	
}
