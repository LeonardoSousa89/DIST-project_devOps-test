package dist.com.User.controller;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping(value = "/{id}/administration")
	public ResponseEntity<Workers> saveWorker(@RequestBody Workers employee){
		service.saveWorker(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
