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
	private long id;

	@Column(columnDefinition = "text")
	private String description;

	@ManyToOne
	private User user;

	@Column(nullable = false)
	private ImageExamType type;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date updatedAt;


}
