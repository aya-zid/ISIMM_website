package org.isimm.entities;




import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "account")
public class Account implements Serializable{
    @Id
    private Long CIN;

    @Column(unique = true)
    private String username;

    private String password;

	public Long getCIN() {
		return CIN;
	}

	public void setCIN(Long id) {
		CIN= id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account(Long id, String username, String password) {
		
		CIN = id;
		this.username = username;
		this.password = password;
	}
public Account() {}
public void setStudent(Student student) {
    this.student = student;
    student.setAccount(this);
}

public void setRole(Role role) {
    this.role = role;
    role.setAccount(this);
}


@OneToOne
	 @JoinColumn(name = "CIN", referencedColumnName = "CIN")
	 private Student student;

	 @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	 private Role role;

}