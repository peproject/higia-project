package start.project.higia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorPasswordTokens {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String tokens;
	@Column(nullable = false, length = 2)
	private Integer used;
	
	@ManyToOne
	@NotNull
	private Doctor doctor;
	
	
}
