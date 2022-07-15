package start.project.higia.models.exams;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = true, length = 400)
	private String aspect;
	@Column(nullable = true, length = 400)
	private String protozoa;
	@Column(nullable = true, length = 400)
	private String helminths;
	@Column(nullable = true, length = 400)
	private String comments;

}
