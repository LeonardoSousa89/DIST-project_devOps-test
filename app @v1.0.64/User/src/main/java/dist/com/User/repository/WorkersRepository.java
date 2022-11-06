package dist.com.User.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dist.com.User.model.Workers;
import dist.com.User.projection.WorkersProjection;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long>{
	
	/*
	 * org.postgresql.util.PSQLException: ERROR: operator does not exist: character varying ~~ bytea
  	Dica: No operator matches the given name and argument types. You might need to add explicit type casts.
  	Posição: 54
	 * 
	 * */
	@Query(nativeQuery = true, value = "SELECT workerName FROM dist_workers WHERE workerName LIKE (:workerName)")
	List<WorkersProjection> findByWorkerName(String workerName);
	
}
