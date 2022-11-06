package dist.com.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dist.com.User.projection.WorkersAddressProjection;
import dist.com.User.projection.WorkersAddressProjectionMore;
import dist.com.User.projection.WorkersNameProjection;
import dist.com.User.projection.WorkersProjection;
import dist.com.User.repository.UserRepository;
import dist.com.User.repository.WorkersRepository;

@SpringBootApplication
public class UserApplication implements CommandLineRunner{

	@Autowired
	private WorkersRepository repository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("exercicios de query.");
		
		//projection 1
		List<WorkersAddressProjection> findByWorkerAddress=repository.findByWorkerAddress("Gotham city");
		
		System.out.println();
		System.out.println("Projection #1");
		
		for (WorkersAddressProjection apelido : findByWorkerAddress) {
			System.out.println(apelido.getWorkerAddress());
		}
		
		//projection 2
		List<WorkersNameProjection> findByWorkerName=repository.findByWorkerName("Alfred Penworth");
			
		System.out.println();
		System.out.println("Projection #2");
		
		for (WorkersNameProjection apelido : findByWorkerName) {
			System.out.println(apelido.getWorkerName());
		}
		
		//projection 3
		List<WorkersAddressProjectionMore> findByWorkerAddressMore=repository.findByWorkerAddressMore("Gotham city");
		
		System.out.println();
		System.out.println("Projection #3");
		
		for (WorkersAddressProjectionMore apelido : findByWorkerAddressMore) {
			System.out.println(apelido.getWorkerName() + "," + apelido.getWorkerEmail() + "," +  apelido.getWorkerPost() + "," +  apelido.getWorkerAddress());
		}
		
		//projection 4
		List<WorkersProjection> findByWorkerId=repository.findByWorkerId((long) 2);
						
		System.out.println();
		System.out.println("Projection #4");
						
		for (WorkersProjection apelido : findByWorkerId) {
							
			System.out.println(apelido.getWorkerId() + "," + 
										       apelido.getWorkerName() + "," + 
										       apelido.getWorkerEmail() + "," +  
										       apelido.getWorkerPost() + "," +  
										       apelido.getWorkerAddress() + "," +  
										       apelido.getWorkerPhoneNumber() + "," +  
										       apelido.getWorkerAge());
						}
		
		
		//projection 5
		List<WorkersProjection> findByUserData=repository.findByUserData((long) 1);
		
		System.out.println();
		System.out.println("Projection #5");
		System.out.println("user 1");
		System.out.println("User data:");
		
		for (WorkersProjection apelido : findByUserData) {
			System.out.println(apelido.getWorkerId() + "," + 
						       apelido.getWorkerName() + "," + 
						       apelido.getWorkerEmail() + "," +  
						       apelido.getWorkerPost() + "," +  
						       apelido.getWorkerAddress() + "," +  
						       apelido.getWorkerPhoneNumber() + "," +  
						       apelido.getWorkerAge());
		}
		
		//projection 6
		List<WorkersProjection> findByUserData2=repository.findByUserData((long) 2);
		
		System.out.println();
		System.out.println("Projection #6");
		System.out.println("user 2");
		System.out.println("User data:");
		
		
		for (WorkersProjection apelido : findByUserData2) {
			System.out.println(apelido.getWorkerId() + "," + 
						       apelido.getWorkerName() + "," + 
						       apelido.getWorkerEmail() + "," +  
						       apelido.getWorkerPost() + "," +  
						       apelido.getWorkerAddress() + "," +  
						       apelido.getWorkerPhoneNumber() + "," +  
						       apelido.getWorkerAge());
		}
		
		//projection 7
		List<WorkersProjection> findByUserData3=repository.findByUserData((long) 3);
				
		System.out.println();
		System.out.println("Projection #7");
		System.out.println("user 3");
		System.out.println("User data:");
				
				
		for (WorkersProjection apelido : findByUserData3) {
				System.out.println(apelido.getWorkerId() + "," + 
								       apelido.getWorkerName() + "," + 
								       apelido.getWorkerEmail() + "," +  
								       apelido.getWorkerPost() + "," +  
								       apelido.getWorkerAddress() + "," +  
								       apelido.getWorkerPhoneNumber() + "," +  
								       apelido.getWorkerAge());
				}
		
		/*
		 * um factory method pode ser uma solução para dados, produzidos por demanda. (um excelente recurso de melhoria.)
		 * */
				
	}

}
