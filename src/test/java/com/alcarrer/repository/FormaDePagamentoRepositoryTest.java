package com.alcarrer.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.model.FormasDePagamento;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class FormaDePagamentoRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private FormaDePagamentoRepository repository; 

	@Test
	public void testSaveFormaDePagamento() {
		
		FormasDePagamento obj = new FormasDePagamento("FormaDePagamento","Descricao", 1);	
		FormasDePagamento objDB = entityManager.persist(obj);
//		Optional<FormaDePagamento> optional = repository.findById(objDB.getCodigo());
	 
	}

	 
	
}
