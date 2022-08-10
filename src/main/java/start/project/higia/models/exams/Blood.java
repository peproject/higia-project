package start.project.higia.models.exams;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import start.project.higia.models.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blood {
	//Blood-test
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private Integer hemoglobin;

	@Column(nullable = false)
	private Integer neutrophils;

	@Column(nullable = false)
	private Integer eosinophils;

	@Column(nullable = false)
	private Integer basophiles;

	@Column(nullable = false)
	private Integer lymphocytes;

	@Column(nullable = false)
	private Integer monocytes;

	@Column(nullable = false)
	private Integer platelets;

	@ManyToOne
	private User user;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date updatedAt;


}
