package com.example.caliber;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.caliber.beans.SkillType;
import com.revature.caliber.controllers.SkillTypeController;
import com.revature.caliber.services.SkillTypeService;

import io.restassured.RestAssured;

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
		//controller.setSkillService(service);
	}
	
	@Before
	public void setup() {
		RestAssured.port = 9090;
		
		this.skill = new SkillType(1, "java");
		this.skills = new ArrayList<SkillType>();
		skills.add(this.skill);
		skills.add(new SkillType(2, "PEGA"));
		
		org.mockito.Mockito.when(service.getSkillType(1)).thenReturn(skill);
		org.mockito.Mockito.when(service.getSkillTypes()).thenReturn(skills);		
	}
	
	@Test
	public void test() {
		System.out.println(service.getSkillTypes());
		get("types/skill/all").then().statusCode(200).assertThat()
	      .body("", equalTo(this.skill.getType()));		
	}
	
	
}
