package com.valuequo.buckswise.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "income")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Income implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "userid")
    private Long userid;
    
    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private String amount;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid2) {
		this.userid = userid2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Income() {
		
	}
	
	public Income(String uName, String uValue, Long userid) {
		super();
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", userid=" + userid + ", name=" + name + "]";
	}
    
}
