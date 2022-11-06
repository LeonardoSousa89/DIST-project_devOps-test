package dist.com.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dist.com.User.projection.WorkersProjection;
import dist.com.User.service.UserService;

@RestController
@RequestMapping(value = "/dist/worker")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}/administration")
	private ResponseEntity<List<WorkersProjection>> findByUserData(@PathVariable Long id){
		List<WorkersProjection> employee = service.findByUserData(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
}
