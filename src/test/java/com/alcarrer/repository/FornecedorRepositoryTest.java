package com.alcarrer.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.model.Fornecedor;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class FornecedorRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private FornecedorRepository repository; 

	@Test
	public void testSaveFornecedor() {
		
		Fornecedor obj = new Fornecedor("fornecedor","Descricao");	
		Fornecedor objDB = entityManager.persist(obj);
		Optional<Fornecedor> optional = repository.findById(objDB.getCodigo());
	 
	}

	 
	
}
