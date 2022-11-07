package dist.com.User.service;

import org.hibernate.dialect.PostgreSQL10Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import dist.com.User.model.Workers;
import dist.com.User.repository.WorkersRepository;
import dist.com.User.service.exceptions.ResourceBadRequestException;

@Service
public class WorkersService {
	
	@Autowired
	private WorkersRepository repository;
	
	public Workers insertWorker(Workers worker) {
		try {
		return repository.save(worker);
		}catch (Exception e) {
			throw new ResourceBadRequestException("verify if your email is insert on field or perhaps already exists.");
		}

		/*try {
		return repository.save(worker);
		}catch (Exception e) {
			
		}*/
	}
	
}
