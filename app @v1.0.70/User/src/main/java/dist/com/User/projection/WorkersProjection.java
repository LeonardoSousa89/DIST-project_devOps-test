package dist.com.User.projection;

public interface WorkersProjection {

	//dados dos trabalhadores
	long getWorkerId();
	String getWorkerName();
	String getWorkerEmail();
	String getWorkerPost();
	String getWorkerAddress();
	String getWorkerPhoneNumber();
	String getWorkerAge();
		
	//dados do usuário
	long geUserId(); 
}
