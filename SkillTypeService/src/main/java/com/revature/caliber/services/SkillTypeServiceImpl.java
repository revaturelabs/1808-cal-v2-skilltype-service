package com.revature.caliber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.SkillType;
import com.revature.caliber.data.SkillTypeRepository;

@Service
public class SkillTypeServiceImpl implements SkillTypeService {

	@Autowired
	SkillTypeRepository skillRepo;

	@Override
	public void createSkillType(SkillType skill) {
		skillRepo.save(skill);
	}

	@Override
	public SkillType getSkillType(Integer id) {
		return skillRepo.findOne(id);
	}

	@Override
	public List<SkillType> getSkillTypes() {
		return skillRepo.findAll();
	}

	@Override
	public void updateSkillType(SkillType skill) {
		skillRepo.save(skill);
	}

	@Override
	public void deleteSkillType(SkillType skill) {
		skillRepo.delete(skill);
	}

}
