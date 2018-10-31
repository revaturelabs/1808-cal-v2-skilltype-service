package com.revature.caliber.services;
import java.util.List;

import com.revature.caliber.beans.SkillType;

public interface SkillTypeService {
	public void createSkillType(SkillType skill);

	public SkillType getSkillType(Integer id);

	public List<SkillType> getSkillTypes();

	public void updateSkillType(SkillType skill);

	public void deleteSkillType(SkillType skill);

}
