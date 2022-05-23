package kodlamaio.HRMS.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
@EqualsAndHashCode(callSuper=false)
public class Employee extends User {
	
	
	
	@Column(name="first_name")
	@NotNull
	public String firstName;
	
	@Column(name="last_name")
	@NotNull
	public String lastName;
	
	@Column(name="identification_number")
	@NotNull
	public String identificationNumber;
	
	@Column(name="birth_date")
	@NotNull
	public Date birthDate;

}
