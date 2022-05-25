package kodlamaio.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Position {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="position_id")
	public int positionId;
	
	@Column(name="position_name")
	public String positionName;
	
	
	@OneToMany(mappedBy = "position")
	private List<JobAdvert> jobAdverts;

}
