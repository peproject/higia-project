package start.project.higia.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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

	@OneToOne
	@NotNull
	private User user;

	@Column(nullable = false, length = 400)
	private String occupation;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Limitation limitation;

	@Column(length = 400, nullable = true)
	private String allergy;

	@Column(nullable = false)
	private String medication;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date updatedAt;
}
