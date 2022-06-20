package start.project.higia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import start.project.higia.utils.Util;

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

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String birthday;

    @Column(nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    private Roles role;

    public Roles getRole() {
		return role;
	}

	public void setRole() {
		this.role = Roles.USER;
	}

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Util.md5(password);
	}
	
}
