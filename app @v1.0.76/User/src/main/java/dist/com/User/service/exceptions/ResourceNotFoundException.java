package dist.com.User.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	//aulas de tratamento de erro do curso de java completo, 317 a 319
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
}
