package dist.com.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dist.com.User.projection.WorkersAddressProjection;
import dist.com.User.projection.WorkersAddressProjectionMore;
import dist.com.User.projection.WorkersNameProjection;
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
	}

}
