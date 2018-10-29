package com.revature.caliber.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.SkillType;
import com.revature.caliber.data.SkillTypeRepository;

/**
 * 
 * @author Loren Henderson, Tad Perry 
 * 
 * 
 * Service class for communicating with repository.
 *
 */

@Service
public class SkillTypeServiceImpl implements SkillTypeService {

	public SkillTypeServiceImpl() {
		super();
	}

	@Autowired
	SkillTypeRepository skillRepo;

	/**
	 * 
	 * Adds skill to repository
	 * 
	 * @param skill the skill to be added to the repo
	 */
	@Override
	public void createSkillType(SkillType skill) {
		skillRepo.save(skill);
	}

	/**
	 * 
	 * Finds a SkillType by id.
	 * 
	 * @param id The id of the skill to retrieve.
	 * 
	 * @return SkillType matching id of parameter id.
	 * 
	 */
	@Override
	public SkillType getSkillType(Integer id) {
		return skillRepo.findOne(id);
	}

	/**
	 * Returns a list of all skilltypes
	 * 
	 * @return List of all SkillTypes
	 */
	@Override
	public List<SkillType> getSkillTypes() {
		return skillRepo.findAll();
	}

	/**
	 * 
	 * Updates the skill in the database.
	 * 
	 * @param skill The skill with updated information
	 */
	@Override
	public void updateSkillType(SkillType skill) {
		skillRepo.save(skill);
	}

	/**
	 * Deletes a skill
	 * 
	 * @param skill The skill to remove from the repo
	 */
	@Override
	public void deleteSkillType(SkillType skill) {
		skillRepo.delete(skill);
	}

}
