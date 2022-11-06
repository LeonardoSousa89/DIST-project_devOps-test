package dist.com.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dist.com.User.model.Workers;
import dist.com.User.projection.WorkersNameProjection;
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
	
	/*
	 * org.postgresql.util.PSQLException: ERROR: operator does not exist: character varying ~~ bytea
  	Dica: No operator matches the given name and argument types. You might need to add explicit type casts.
  	Posição: 54
	 * 
	 * */
	
	/*public List<WorkersNameProjection> findByWorkerName(String workerName){
		Workers name = new Workers();
		workerName = name.getWorkerName();
		List<WorkersNameProjection> workers=repository.findByWorkerName(workerName);
		return workers;
	}
	
	public Workers saveWorker(Workers employee) {
		return repository.save(employee);
	}
	
	public Workers getWorkerById(Long id) {
		return repository.findById(id).get();
	}
	
	private void updateData(Workers updatedEmployee, Workers employee) {
		updatedEmployee.setWorkerName(employee.getWorkerName());
		updatedEmployee.setWorkerEmail(employee.getWorkerEmail());
		updatedEmployee.setWorkerPost(employee.getWorkerPost());
		updatedEmployee.setWorkerAddress(employee.getWorkerAddress());
		updatedEmployee.setWorkerPhoneNumber(employee.getWorkerPhoneNumber());
		updatedEmployee.setWorkerAge(employee.getWorkerAge());
	}
	
	public Workers updatetWorker(Long id, Workers employee) {
		Workers updatedEmployee=getWorkerById(id);
			updateData(updatedEmployee, employee);
			return repository.save(updatedEmployee);
	}*/
}
