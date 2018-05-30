package com.alcarrer.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class SubCategoriaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private SubCategoriaRepository repository; 

	@Test
	public void testSaveSubCategoria() {
		
		
	
	}

	 
	
}
