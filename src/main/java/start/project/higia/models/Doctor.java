package start.project.higia.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, unique = true)
	private String crm;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String lastname;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@Enumerated(EnumType.STRING)
	private Roles role;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

}
