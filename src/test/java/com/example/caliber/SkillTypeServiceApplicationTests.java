package com.example.caliber;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.SkillTypeServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SkillTypeServiceApplication.class)
public class SkillTypeServiceApplicationTests {

	/**
	 * This test is to make sure the context of the main application
	 * is properly loaded.
	 */
	@Test
	public void contextLoads() {
		assertTrue(true);
	}

}
