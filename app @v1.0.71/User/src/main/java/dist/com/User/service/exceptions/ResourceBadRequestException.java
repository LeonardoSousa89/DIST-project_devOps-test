package dist.com.User.service.exceptions;

public class ResourceBadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceBadRequestException(String msg) {
		super("Was an error to create your resource, please check required fields" + "," + msg);
	}
	
}
