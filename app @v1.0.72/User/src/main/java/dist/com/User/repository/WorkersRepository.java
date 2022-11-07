package dist.com.User.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dist.com.User.model.Workers;
import dist.com.User.projection.WorkersProjection;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long>{
	
	@Query(nativeQuery = true, value = "SELECT" + 
			"   w.workerId," + 
			" 	w.workerName ," + 
			"	w.workerEmail," + 
			"	w.workerPost, " + 
			"	w.workerAddress," + 
			"	w.workerPhoneNumber," + 
			"	w.workerAge" + 
			" FROM dist_users u INNER JOIN dist_workers w ON u.userId = w.user_id WHERE u.userId = (:id)")
	List<WorkersProjection> findByUserData(Long  id); 
	
}
