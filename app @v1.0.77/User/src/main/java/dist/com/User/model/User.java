package dist.com.User.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dist_users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="userid")
	private String userId;
	
	private String username;
	
	@Column(unique = true)
	private String email;
	
	//essa é a forma correta ensinada pelo mestre Nélio, como fazer associação um para muitos.
	@JsonIgnore	
	@OneToMany(mappedBy = "admin")
	Set <Workers> workers=new HashSet<>();
	
	public User() {}

	public User(String userId, String username, String email) {
		this.userId = userId;
		this.username = username;
		this.email = email;
	}

	public String geUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserame() {
		return username;
	}

	public void setUserame(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Workers> getWorkers() {
		return workers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
