package com.example.caliber;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.caliber.SkillTypeServiceApplication;
import com.revature.caliber.beans.SkillType;
import com.revature.caliber.controllers.SkillTypeController;
import com.revature.caliber.services.SkillTypeService;

import io.restassured.RestAssured;


/**
 * 
 * @author Tad Perry & Loren Henderson
 *
 *This class tests the skill type controller methods individually. It uses
 *RESTassured to mock Http requests to test the end points.
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillTypeControllerTest {

	@Mock
	static SkillTypeService service;
	
	@InjectMocks
	static SkillTypeController controller;

	static SkillType skill;
	static List<SkillType> skills;
	
	@BeforeClass
	public static void classSetup() {
		skills = new ArrayList<SkillType>();
	}

	@Before
	public void setup() {
		RestAssured.port = 8080;
		skills.clear();
		this.skill = new SkillType(1, "java");
		this.skills = new ArrayList<SkillType>();
		skills.add(this.skill);
		skills.add(new SkillType(2, "PEGA"));
		org.mockito.Mockito.when(service.getSkillType(1)).thenReturn(skill);
		org.mockito.Mockito.when(service.getSkillTypes()).thenReturn(skills);			
	}
	
	
	@Test
	public void testGetSkill() {
		List<String> allSkills = controller.allSkillTypes();
		System.out.println(allSkills);
		
		assertEquals( "Expected first skill in list to be " + skills.get(0).getType() , skills.get(0).getType(), allSkills.get(0));
		assertEquals( "Expected second skill in list to be " + skills.get(1).getType() , skills.get(1).getType(), allSkills.get(1));

	}
	
	@Test
	public void testEndpoints() {
		get("types/skill/all").then().statusCode(200);
	}
	
	@Test
	public void testAddSkillType() {
		controller.addSkillType(skill);
		verify(service).createSkillType(skill);	
	}
	
	@Test
	public void testGetSkillType() {
		String sType = controller.getType(1);
		assertEquals( "Expected skill to be " + skill.getType() , skill.getType(), sType);
	}
	
	@Test
	public void testDeleteType() {
		controller.deleteType("java");
		verify(service).deleteSkillType(skill);
	}
}
