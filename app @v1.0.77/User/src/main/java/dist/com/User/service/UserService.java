package dist.com.User.service;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dist.com.User.model.User;
import dist.com.User.projection.WorkersProjection;
import dist.com.User.repository.UserRepository;
import dist.com.User.repository.WorkersRepository;
import dist.com.User.service.exceptions.ResourceBadRequestException;
import dist.com.User.service.exceptions.ResourceNotFoundException;

@Service
public class UserService {
		
	// será usado em um futuro posterior
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private WorkersRepository workersRepository;
	
	
	public User createAccount(User account) {
		try {
			return repository.save(account);
		}catch (Exception e) {
			throw new ResourceBadRequestException(" Was an error, verify if some field is empty or perhaps your email already exists");
		}
	}
	
	public Page<WorkersProjection> findByUserData(String id,  PageRequest pageRequest) {
		
		Page<WorkersProjection> employee = workersRepository.findByUserData(id, pageRequest);

		if(employee.isEmpty()) {
			
			throw new ResourceNotFoundException("Resource not found.");
			
		}
		
		return employee;	
	}
	
	
	
}
