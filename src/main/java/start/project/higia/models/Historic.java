package start.project.higia.models;


import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Historic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "historic")
	private List<Evolution> evolutions;
	
	@ManyToOne
	private Doctor doctor;
	
	@OneToOne
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public List<Evolution> getEvolutions() {
		return evolutions;
	}

	public void setEvolutions(List<Evolution> evolutions) {
		this.evolutions = evolutions;
	}


}
