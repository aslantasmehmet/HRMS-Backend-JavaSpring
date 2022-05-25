package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jobadverts")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","favorites"})
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advert_id")
	public int jobAdvertId;
	
	@Column(name="min_salary")
	public float minSalary;
	
	@Column(name="max_salary")
	public float maxSalary;
	
	@Column(name="quantity")
	@NotNull
	public int quantity;
	
	@Column(name="advert_date")
	public LocalDate advertDate;
	
	@Column(name="due_date")
	@NotNull
	public LocalDate dueDate;
	
	@Column(name="description")
	@NotNull
	@NotBlank
	public String description;
	
	@Column(name="activity_status")
	public boolean activityStatus;
	
	@Column(name="ad_status_description")
	public String adStatusDescription;
	
	@Column(name="posiiton_id")
	@NotNull
	public int positionId;
	
	@Column(name="city_id")
	@NotNull
	public int cityId;
	
	@Column(name="user_id")
	@NotNull
	public int userId;
	
	@Column(name="place_type_id")
	@NotNull
	public int placeTypeId;
	
	@Column(name="time_type_id")
	@NotNull
	public int timeTypeId;
	
	

}
