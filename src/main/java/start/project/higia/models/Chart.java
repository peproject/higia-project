package start.project.higia.models;

import java.util.Date;

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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private String name;
	
	//ver depois
	//@OneToOne
	//@Column(nullable = false)
	//private User cpf;
	
	@Column(nullable = false, length = 400)
	private String occupation;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Limitation limitation;
	
	@Column(length = 400)
	private String allergy;
}
