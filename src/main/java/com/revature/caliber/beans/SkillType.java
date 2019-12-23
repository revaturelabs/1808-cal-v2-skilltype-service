package com.revature.caliber.beans;

import javax.persistence.*;

/**
 * 
 * @author Tad Perry, Loren Henderson
 *
 * SkillType bean
 *
 */

@Entity
@Table(name="skilltype")
public class SkillType {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SKILLTYPE_ID_SEQUENCE")
	@SequenceGenerator(name = "SKILLTYPE_ID_SEQUENCE", sequenceName = "SKILLTYPE_ID_SEQUENCE")
	private int id;
	
	@Column(name="type", nullable=false)
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public SkillType() {
		super();
	}
	
	public SkillType(int id, String type) {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillType other = (SkillType) obj;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
}
