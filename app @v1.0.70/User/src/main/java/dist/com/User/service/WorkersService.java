package dist.com.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dist.com.User.model.Workers;
import dist.com.User.repository.WorkersRepository;

@Service
public class WorkersService {
	
	@Autowired
	private WorkersRepository repository;
	
	//teste
	public List<Workers> findAll(){
		List<Workers> employees = repository.findAll();
		return employees;
	}
	
}
