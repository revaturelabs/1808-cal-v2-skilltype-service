package com.example.caliber;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.revature.caliber.beans.SkillType;
import com.revature.caliber.data.SkillTypeRepository;
import com.revature.caliber.services.SkillTypeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SkillServiceTest {

	@Mock
	SkillTypeRepository repo;

	@InjectMocks
	SkillTypeServiceImpl ss;


	private static SkillType skill;
	
	private static List<SkillType> skillList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		skillList = new ArrayList<SkillType>();
	}
	
	@Before
	public void setUp() throws Exception {
		this.skill = new SkillType(1, "PEGA");
		this.skillList.addAll(Arrays.asList(new SkillType[] {this.skill,
				new SkillType(2, "Java Full Stack")}));
		when(repo.findAll()).thenReturn(this.skillList);
		when(repo.findOne(1)).thenReturn(this.skill);

		
	}


	@Test
	public void testGetAllSkill() {
		assertEquals(
				"Should get whole list of skills", 
				this.skillList,
				this.ss.getSkillTypes());
	}

	@Test
	public void testGetASkill() {
		assertEquals(
				"Should get single skill", 
				this.skill, 
				this.ss.getSkillType(1));
	}
	
	@Test
	public void testMakeSkill() {
		ss.createSkillType(this.skill);
		verify(repo).save(this.skill);
	}
	
	@Test
	public void testUpdateSkill() {
		ss.updateSkillType(this.skill);
		verify(repo).save(this.skill);
	}
	
	@Test
	public void testDeleteSkill() {
		ss.deleteSkillType(this.skill);
		verify(repo).delete(this.skill);
	}

}
