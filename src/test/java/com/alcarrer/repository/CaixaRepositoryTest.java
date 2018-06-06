package com.alcarrer.repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.entity.CaixaEntity;
import com.alcarrer.model.Caixa;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CaixaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CaixaRepository repository;

	@Test
	public void testSaveCaixa() throws Exception {
		
		Date dataHoraAbertura = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-11-15 15:30:14.332");
		Date dataHoraFechamento = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-11-15 15:30:14.332");
		CaixaEntity obj = new CaixaEntity(dataHoraAbertura, dataHoraFechamento, new Double(10), new Double(5), new Double(15), "open");
		CaixaEntity objDB = entityManager.persist(obj);
		CaixaEntity optional = repository.findOne(objDB.getCodigo());
		
	}

}
