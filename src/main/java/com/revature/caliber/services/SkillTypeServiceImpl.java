package com.revature.caliber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.SkillType;
import com.revature.caliber.data.SkillTypeRepository;
import org.springframework.util.StringUtils;

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

	public SkillTypeServiceImpl(SkillTypeRepository repo) {
		this.skillRepo = repo;
	}

	@Autowired
	SkillTypeRepository skillRepo;

	/**
	 * 
	 * Adds skill to repository
	 * 
	 * @param skill The skill to be added to the repository
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
	 * Returns a list of all SkillTypes
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
	 * @param skill The skill to remove from the repository
	 */
	@Override
	public void deleteSkillType(SkillType skill) {
		SkillType type = null;
		if (skill != null && StringUtils.hasText(skill.getType())) {
			// Need the ID to delete
			type = skillRepo.findSkillTypeByType(skill.getType());
		}
		if (type != null && StringUtils.hasText(type.getType())) {
			skillRepo.delete(skill);
		}
	}

}
