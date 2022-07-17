package com.health.bo;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.springframework.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String pName;
	private String lastName;
	private String address;
	private Long mobile;
	private LocalDate dt;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "pid",referencedColumnName ="pid")
	private List<Report> list;
	
	
	public Patient(String pName2, String lastName2, String address2, Long mobile2, LocalDate now,
			List<Report> reportList) {
		// TODO Auto-generated constructor stub
		super();
		this.pName=pName2;
		this.lastName=lastName2;
		this.address=address2;
		this.mobile=mobile2;
		this.dt=now;
		this.list=reportList;
	}
	
}
