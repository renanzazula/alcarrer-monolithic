package com.alcarrer.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.model.Caixa;
import com.alcarrer.model.Retirada;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class RecebimentoRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RetiradaRepository repository;

	@Test
	public void testSaveRetirada() throws ParseException {

		Caixa caixa = new Caixa();

		Date dataHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-11-15 15:30:14.332");
		Retirada obj = new Retirada("descricao", dataHora, 0d, caixa);

		Retirada objDB = entityManager.persist(obj);
//		Optional<Retirada> optional = repository.findById(objDB.getCodigo());

	}

}
