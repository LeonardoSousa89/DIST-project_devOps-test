package dist.com.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dist.com.User.model.Workers;
import dist.com.User.repository.WorkersRepository;

@Service
public class WorkersService {
	
	@Autowired
	private WorkersRepository repository;
	
	public Workers insertWorker(Workers worker) {
		return repository.save(worker);
	}
	
}
