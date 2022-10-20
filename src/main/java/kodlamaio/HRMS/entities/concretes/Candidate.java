package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@EqualsAndHashCode(callSuper = true)
@Table(name="candidates")

public class Candidate extends User {
	
	@Column(name="first_name")
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	@NotBlank
	private String lastName;
	
	
	@Column(name="identity_number")
	@NotNull
	@NotBlank
	private String identityNumber;
	
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;

	
	
	@JsonIgnore
	@OneToOne
	private UserActivation userActivation;

}
