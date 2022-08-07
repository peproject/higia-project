package start.project.higia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageExam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long imageExamId;

	@ManyToOne
	private Exam exam;

	@Column(nullable = false)
	private String imageExamName;

}
