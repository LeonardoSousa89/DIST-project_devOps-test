package dist.com.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dist.com.User.model.User;
import dist.com.User.projection.WorkersProjection;
import dist.com.User.repository.UserRepository;
import dist.com.User.repository.WorkersRepository;

@Service
public class UserService {
		
	// será usado em um futuro posterior
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private WorkersRepository workersRepository;
	
	public List <WorkersProjection> findByUserData(Long userId) {
		List <WorkersProjection> employee = workersRepository.findByUserData(userId);
		return employee;
	}
	
}
