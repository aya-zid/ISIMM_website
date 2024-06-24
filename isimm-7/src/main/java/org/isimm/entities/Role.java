package org.isimm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Role {
	@Id
    @Column(name = "cin") // This should match the column name in the database
    private Long CIN;
    @Column(name = "username")
    private String username;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    // Constructors, Getters, and Setters

    @OneToOne
    @JoinColumn(name = "cin", referencedColumnName = "cin")
    private Account account;
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

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Role(Long CIN,String username, UserRole userRole) {
		super();
		this.CIN=CIN;
		this.username = username;
		this.userRole = userRole;
	}
	public Role() {}

	public void setAccount(Account account) {
this.account=account;		
	}
}