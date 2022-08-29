package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="educations")
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name_of_educational_institutio")
	private String nameOfEducationalInstitution;
	
	@Column(name="department")
	private String department;
	
	@Column(name="degree")
	private String degree;
	
	@Column(name="string_date")
	private LocalDate stringDate;
	
	@Column(name="graduation_date")
	private LocalDate graduationDate;
	
	public String graduationDate() {
		if(graduationDate==null) {
			return "Devam Ediyor.";
		}
		return graduationDate.toString();
	}
	
	

}
