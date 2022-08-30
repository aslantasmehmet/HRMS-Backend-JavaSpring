package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
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
@Inheritance(strategy=InheritanceType.JOINED)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	public int userId;
	
	@Column(name="email", unique = true)
	@Email(message="Lütfen email formatında giriniz")
	@NotBlank(message = "E-posta alanı boş geçilemez.")
	@NotNull(message = "E-posta alanı boş geçilemez.")
	public String email;
	
	@Column(name="password")
	@NotBlank(message = "Parola alanı boş geçilemez.")
	@NotNull(message = "Parola alanı boş geçilemez.")
	public String password;
	

}
