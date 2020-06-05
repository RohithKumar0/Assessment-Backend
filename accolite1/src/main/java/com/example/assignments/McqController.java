package com.example.assignments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AuthResonse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("{assignment_id}/mcq")
public class McqController {
	
	@Autowired
	private McqService mcqService;
	
	
	@GetMapping("")
	public List<McqStructure> getAllMcqs(@PathVariable("assignment_id") int id) {
		return mcqService.getAllMcqs(id);
	}
	
	@PostMapping("/add")
	public AuthResonse addMcqs(@RequestBody McqStructure as, @PathVariable("assignment_id") int assignment_id) {
		System.out.println(as);
		return mcqService.addMcq(as, assignment_id);
	}

	@GetMapping("/{id}")
	public McqStructure getMcqbyId(@PathVariable("id") int id) {
		return mcqService.getMcqbyId(id);
		
	}
	
	@DeleteMapping("/{id}")
	public AuthResonse deleteMcq(@PathVariable("id") int id) {
		return mcqService.deleteMcq(id);
	}
	

}
