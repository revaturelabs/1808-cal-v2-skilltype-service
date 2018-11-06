package com.revature.caliber.controllers;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.SkillType;
import com.revature.caliber.services.SkillTypeService;

/**
 * 
 * @author Loren Henderson, Tad Perry
 * 
 *
 * Controller for performing CRUD methods on skills. Used to populate UI lists.
 */
@RestController
@RequestMapping(value = "types", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class SkillTypeController {

	Logger log = Logger.getLogger(SkillTypeController.class);
	
	@Autowired
	private SkillTypeService skillService;

	/**
	 * Get Skill types to select appropriate skill on UI
	 *
	 * @return the response entity
	 */
	@GetMapping(value = "skill/all")
	public List<String> allSkillTypes() {

		log.debug("Fetching skill types");
		List<String> result = new ArrayList<>();

		List<SkillType> skills = skillService.getSkillTypes();

		for (SkillType skill : skills) {
			result.add(skill.getType());
		}

		return result;
	}

	/**
	 * This is the mapping to add a skill.
	 * 
	 * NOT in v1.
	 * 
	 * @param skill is the skill to add
	 * @return a success message
	 */
	@RequestMapping(value = "skill", method = RequestMethod.POST)
	public void addSkillType(@RequestBody SkillType skill) {
		log.debug("adding skill: " + skill);
		skillService.createSkillType(skill);
	}

	/**
	 * Get a single skill by the id
	 * 
	 * 
	 * @param id the id of the skill
	 * @return The string representation of the type of skill
	 */
	@GetMapping(value = "skill/{id}")
	public String getType(@PathVariable("id")Integer id) {
		log.debug("Retrieving skill with id: " + id);
		return skillService.getSkillType(id).getType();
	}
	
	/**
	 * Removes the skill from the database.
	 * 
	 * @param type the string representing the type of skill to be removed.
	 */
	@DeleteMapping(value = "skill/{type}")
	public void deleteType(@PathVariable("type")String type) {
		log.debug("Deleting SkillType: " + type);
		skillService.deleteSkillType(new SkillType(0, type));
	}

	public SkillTypeController() {
		super();
	}


	public SkillTypeService getSkillService() {
		return skillService;
	}

	public void setSkillService(SkillTypeService skillService) {
		this.skillService = skillService;
	}
}