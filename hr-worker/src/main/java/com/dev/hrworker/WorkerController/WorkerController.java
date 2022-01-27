package com.dev.hrworker.WorkerController;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.hrworker.entities.Worker;
import com.dev.hrworker.repositories.WorkerRepostiory;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

	private WorkerRepostiory repository;
	
	private WorkerController(WorkerRepostiory repostiory) {
		this.repository = repostiory;
	}
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workers = this.repository.findAll();
		return new ResponseEntity<>(workers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	public ResponseEntity<Worker> findById(@PathVariable("id") Long id){
		Optional<Worker> worker = this.repository.findById(id);
		return new ResponseEntity<>(worker.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Worker worker){
		this.repository.save(worker);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
