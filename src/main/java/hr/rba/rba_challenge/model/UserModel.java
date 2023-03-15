package hr.rba.rba_challenge.model;

import java.time.Instant;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name="Users")
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "deleted=false")
public class UserModel {
   
	@Id
	private String oib;
	
	private String name;
	private String surname;

	private Integer status;
	
	private boolean deleted = Boolean.FALSE;
	
	@CreatedDate
	@Column(updatable=false)
	private Instant createdDate;
	
	@LastModifiedDate
	private Instant lastModifiedDate;


	
}
