package dist.com.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dist.com.User.model.Workers;
import dist.com.User.service.WorkersService;

@RestController
@RequestMapping(value = "/dist/worker/test")
public class WorkersController {

	@Autowired
	private WorkersService service;
	
	/*@PostMapping(value = "/{id}/administration")
	public ResponseEntity<Workers> saveWorker(@RequestBody Workers employee){
		service.saveWorker(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}*/
	
	@GetMapping
	public ResponseEntity<List<Workers>> findAll(){
		List<Workers> workers=service.findAll() ;
		return ResponseEntity.status(HttpStatus.OK).body(workers);
	}

	/*
	 * org.postgresql.util.PSQLException: ERROR: operator does not exist: character varying ~~ bytea
  	Dica: No operator matches the given name and argument types. You might need to add explicit type casts.
  	Posição: 54
	 * 
	 * */
	/*
	 * @GetMapping(value = "/requestControlled")
	public ResponseEntity<List<WorkersProjection>> findByWorkerName(@RequestParam(value = "workerName", defaultValue = "") String workerName) throws UnsupportedEncodingException{
		workerName = URL.decodeParam(workerName);
		List<WorkersProjection> workers=service.findByWorkerName(workerName);
		return ResponseEntity.status(HttpStatus.OK).body(workers);
	}*/
	
}
