package com.juvodu.lmg.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juvodu.lmg.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class MigrationServiceTest {
	
	@Autowired
	private MigrationService migrationService;
	
	@Test
	public void whenImportSpotsFromCsvThenSuccess(){
		
		//test csv import of spots
		int importSpotsFromCsv = migrationService.importSpotsFromCsv();
		assertTrue(importSpotsFromCsv > 0);
	}
}
