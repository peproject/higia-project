package start.project.higia.models.exams;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import start.project.higia.models.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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

	@ManyToOne
	private User user;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date updatedAt;

}
