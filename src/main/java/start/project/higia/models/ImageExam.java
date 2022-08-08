package start.project.higia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

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
	private ImageExamType imageExamType;

	@Column(nullable = false)
	private String imageExamName;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date updatedAt;


}
