package com.sprotyshoes.model;

import java.sql.Date;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="userorder")
public class Userorder {
	
	@Id
	@GeneratedValue
	@Column(name="oid")
	private int oid;
	
	@Column(name="prodcat")
	private String prodcat;
	
	@Column(name="puser")
	private String puser;
	
	@Column(name="prodname")
	private String prodname;
	
	public String getProdname() {
		return prodname;
	}


	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	
	public String getProdcat() {
		return prodcat;
	}



	public void setProdcat(String prodcat) {
		this.prodcat = prodcat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private java.util.Date date;
	
	@PrePersist
	private void onCreate() {
		date=new java.util.Date();
	}
	

	
	public java.util.Date getDate() {
		return date;
	}



	public void setDate(java.util.Date date) {
		this.date = date;
	}



	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

		public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}
	
	
	

}
