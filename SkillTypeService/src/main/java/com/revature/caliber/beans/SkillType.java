package com.revature.caliber.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Tad Perry, Loren Henderson
 *
 * SkillType bean
 *
 */

@Entity
@Table(name="skiltype")
public class SkillType {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Column(name="type", nullable=false)
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public SkillType() {
		super();
	}
	
	public SkillType(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SkillType [id=" + id + ", type=" + type + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof SkillType)) {
			return false;
		} else {
			return ((SkillType)o).type.equals(this.type);
		}
	}
}
