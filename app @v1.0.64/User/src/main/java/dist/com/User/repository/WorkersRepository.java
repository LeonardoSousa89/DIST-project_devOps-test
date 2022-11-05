package dist.com.User.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dist.com.User.model.Workers;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long>{
	
	//em teste
	//Workers findByWorkers(Workers workername);
	
}
