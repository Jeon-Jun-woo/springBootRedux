package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * CNO int 
POSTER text 
PUB text 
TITLE text 
NAME text 
TYPE text 
SELLDATE text 
PRICE text 
hit int
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cdlp {
	@Id
	private int cno;
	@Column(insertable = true,updatable = false)
	private String poster;
	@Column(insertable = true,updatable = false)
	private String pub;
	@Column(insertable = true,updatable = false)
	private String title;
	@Column(insertable = true,updatable = false)
	private String name;
	@Column(insertable = true,updatable = false)
	private String type;
	@Column(insertable = true,updatable = false)
	private String selldate;
	@Column(insertable = true,updatable = false)
	private String price;
	@Column(insertable = true,updatable = true)
	private int hit;
}
