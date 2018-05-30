package com.alcarrer.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.model.Medida;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MarcaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private MedidaRepository repository; 

	@Test
	public void testSaveSubCategoria() {
		
		Medida obj = new Medida("medida","Descricao");	
		Medida objDB = entityManager.persist(obj);
//		Optional<Medida> optional = repository.findById(objDB.getCodigo());
	 
	}

	 
	
}
