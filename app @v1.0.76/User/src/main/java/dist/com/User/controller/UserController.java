package dist.com.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dist.com.User.projection.WorkersProjection;
import dist.com.User.service.UserService;

@RestController
@RequestMapping(value = "/dist/worker")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}/administration")
	private ResponseEntity<Page<WorkersProjection>> findByUserData(@PathVariable Long id,  
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
	
	@GetMapping(value = "/{id}/administration/pagination")
	private ResponseEntity<Page<WorkersProjection>> findByUserDataControlledPagination(@PathVariable Long id,  
																   @RequestParam(value = "page",  required = false,  defaultValue = "0") int page,
																   @RequestParam(value = "size",  required = false, defaultValue = "5") int size){
		
		/** O frontend encontrou problemas ao
		 * fazer requisições pagonadas com a mesma url.
		 * */
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<WorkersProjection> employee = service.findByUserData(id, pageRequest);
		return ResponseEntity.status(org.springframework.http.HttpStatus.OK).body(employee);
	
	}
	
}
