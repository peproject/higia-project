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
public class Urine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private Integer density;

	@Column(nullable = false)
	private Integer ph;

	@Column(nullable = false)
	private Integer glucose;

	@Column(nullable = false)
	private Integer proteins;

	@Column(nullable = false)
	private Integer redcells;

	@Column(nullable = false)
	private Integer leukocytes;

	@Column(nullable = false)
	private Integer ketones;

	@Column(nullable = false)
	private Integer urobilinogen;

	@Column(nullable = false)
	private Integer nitrite;

	@Column(nullable = false)
	private Integer crystals;

	@Column(nullable = false)
	private Integer epithelialcells;

	@ManyToOne
	private User user;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date updatedAt;
}
