package start.project.higia.models.exams;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
}
