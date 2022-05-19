package start.project.higia.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
	@Column(nullable = false) 
	private String name;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private Date birthday;
    
    @Column(nullable = false)
    private String number;
    
    private Role role;
	
    public Role getRole() {
		return role;
	}
	
    public void setRole(Role role) {
		this.role = role;
	}
    	
}
