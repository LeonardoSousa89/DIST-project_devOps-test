package dist.com.User.controller;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dist.com.User.config.URL;
import dist.com.User.model.User;
import dist.com.User.model.Workers;
import dist.com.User.projection.WorkersProjection;
import dist.com.User.service.UserService;

@RestController
@RequestMapping(value = "/dist/worker")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/user-account/{id}/administration")
	private ResponseEntity<Optional<User>> getAccountCredentials(@PathVariable String id){
		Optional<User> user = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping(value = "/user-account/employee/{id}/administration")
	private ResponseEntity<Optional<WorkersProjection>> findByWorkerName(@PathVariable String id, 
															   @RequestParam(value = "workerName", required = true) String workerName) 
															   throws UnsupportedEncodingException{
		workerName = URL.decodeParam(workerName);
		Optional<WorkersProjection> employee = service.findByWorkerName(id, workerName);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@PostMapping(value = "/user-account/administration")
	private ResponseEntity<Object> createAccount(@RequestBody User account){
				
				/*
				 * há um bug de verificação de duplicidade do email,
				 * o endpoint não verifica e está retornando status 201,
				 * só está tratando os campos userId e email inválidos ou vazios,
				 * entretanto como estes dados virão do firebase, não necessito me preocupar em tratá-los no momento.
				*/
				service.createAccount(account);
				return ResponseEntity.status(HttpStatus.CREATED).body("Account successfully created");
	
	}
	
	@GetMapping(value = "/{id}/administration")
	private ResponseEntity<Page<WorkersProjection>> findByUserData(@PathVariable String id,  
																   @RequestParam(value = "page",  required = false,  defaultValue = "0") int page,
																   @RequestParam(value = "size",  required = false, defaultValue = "5") int size){
		/*URL para paginação:
		 * 
		 * o parametro page diz em qual página determina situa o volume de dados,
		 *  ao alterá-lo você vai para a próxima página ou regride.
		 *  	
		 *  	A URL padrão já está com a páginação inicial com 5 volumes,
		 *  	para alterar se faz necessário alterar o valor do parametro page, para a página que se deseja navegar.
		 *  	
		 *  		http://localhost:8762/dist/worker/1/administration
		 * 		
		 *      inserir na documentação:
		 * 			EX: http://localhost:8762/dist/worker/1/administration?page=0
		 * 			EX: http://localhost:8762/dist/worker/1/administration?page=1
		 * 
		 * O parametro size diz qual o volume de recursos por página.
		 * 
		 * 			EX: http://localhost:8762/dist/worker/1/administration?size3=1
		 * 
		 * Os parametros podem ser combinados:
		 * 			
		 * 			EX: http://localhost:8762/dist/worker/1/administration?size=3&page=2
		 *          EX: http://localhost:8762/dist/worker/1/administration?size=3&page=3
		 *          
		 * REF: https://cursos.alura.com.br/forum/topico-cannot-convert-from-pagerequest-to-springdatawebproperties-pageable-239796
		 * 
		*/
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<WorkersProjection> employee = service.findByUserData(id, pageRequest);
		return ResponseEntity.status(org.springframework.http.HttpStatus.OK).body(employee);
	
	}
	
}
