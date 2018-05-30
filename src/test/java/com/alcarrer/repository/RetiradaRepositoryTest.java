package com.alcarrer.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.model.Caixa;
import com.alcarrer.model.Cliente;
import com.alcarrer.model.Recebimento;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class RetiradaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private RecebimentoRepository repository; 

	@Test
	public void testSaveRecebimento() throws ParseException {
		
		Caixa caixa = new Caixa();
		Cliente cliente = new Cliente();
		
		Date dataHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-11-15 15:30:14.332");
		Recebimento obj = new Recebimento("nome", "descricao", dataHora, 0d, caixa, cliente);
		 
		Recebimento objDB = entityManager.persist(obj);
		Optional<Recebimento> optional = repository.findById(objDB.getCodigo());
		
	}

	 
	
}
