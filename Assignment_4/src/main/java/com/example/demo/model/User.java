package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity(name= "users")
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToMany(targetEntity = Sale.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Sale> sale;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Sale> getSale() {
		return sale;
	}
	public void setSale(List<Sale> sale) {
		this.sale = sale;
	}
}
