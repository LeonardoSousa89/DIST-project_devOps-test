package dist.com.User.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dist.com.User.model.Workers;
import dist.com.User.projection.WorkersAddressProjection;
import dist.com.User.projection.WorkersAddressProjectionMore;
import dist.com.User.projection.WorkersNameProjection;
import dist.com.User.projection.WorkersProjection;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long>{
	
	@Query(nativeQuery = true, value = "SELECT workerAddress FROM dist_workers WHERE workerAddress LIKE (:workerAddress)")
	List<WorkersAddressProjection> findByWorkerAddress(String workerAddress);
	
	@Query(nativeQuery = true, value = "SELECT workerName, "
			+ "workerEmail, "
			+ "workerPost, "
			+ "workerAddress "
			+ "FROM dist_workers WHERE workerAddress LIKE (:workerAddress)")
	List<WorkersAddressProjectionMore> findByWorkerAddressMore(String workerAddress);
	
	@Query(nativeQuery = true, value = "SELECT workerName FROM dist_workers WHERE workerName LIKE (:workerName)")
	List<WorkersNameProjection> findByWorkerName(String workerName);
	
	/* essa junção será a projeção do próximo projeto */
}
