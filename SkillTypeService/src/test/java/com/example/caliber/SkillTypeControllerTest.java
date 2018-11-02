package com.example.caliber;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.caliber.SkillTypeServiceApplication;
import com.revature.caliber.beans.SkillType;
import com.revature.caliber.controllers.SkillTypeController;
import com.revature.caliber.services.SkillTypeService;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;


/**
 * 
 * @author Tad Perry & Loren Henderson
 *
 *This class tests the skill type controller methods individually. It uses
 *RESTassured to mock Http requests to test the end points.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SkillTypeServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SkillTypeControllerTest {

	@Mock
	static SkillTypeService service;
	
	@InjectMocks
	static SkillTypeController controller;

	@LocalServerPort
	private int port;
	
	static SkillType skill;
	static List<SkillType> skills;
	
	@BeforeClass
	public static void classSetup() {
		skills = new ArrayList<SkillType>();
	}

	@Before
	public void setup() {
		RestAssured.port = port;
        MockitoAnnotations.initMocks(this);
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
