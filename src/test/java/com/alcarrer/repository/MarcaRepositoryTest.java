package com.alcarrer.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.entity.MarcaEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MarcaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private MarcaRepository repository;

	@Test
	@DisplayName("Save Marca")
	public void saveMarca() {
		MarcaEntity obj = new MarcaEntity("Marca", "Descricao");
		MarcaEntity saved = entityManager.persist(obj);

		assertNotNull(saved);
		assertNotNull(saved.getCodigo());
		assertNotNull(saved.getNome());
		assertNotNull(saved.getDescricao());

		MarcaEntity found = repository.getOne(saved.getCodigo());

		assertEquals(saved.getCodigo(), found.getCodigo());
		assertEquals(saved.getNome(), found.getNome());
		assertEquals(saved.getDescricao(), found.getDescricao());
	}

	@Test
	@DisplayName("Update Marca")
	public void updateMarca() {
		List<MarcaEntity> listaDeMarcas = repository.findAll();
		assertNotNull(listaDeMarcas);

		// list nao e vazia
		assertFalse(listaDeMarcas.isEmpty());

		MarcaEntity marca = listaDeMarcas.get(0);
		MarcaEntity toUpdate = repository.getOne(marca.getCodigo());

		assertNotNull("codigo:" + toUpdate.getCodigo(), toUpdate.getCodigo());
		assertNotNull("nome:" + toUpdate.getNome(), toUpdate.getNome());
		assertNotNull("descricao:" + toUpdate.getDescricao(), toUpdate.getDescricao());

		toUpdate.setNome("New Nome");
		toUpdate.setDescricao("New Descricao");
		entityManager.persistAndFlush(toUpdate);

		MarcaEntity found = repository.getOne(marca.getCodigo());
		assertNotNull(found);
		assertNotNull("codigo:" + found.getCodigo(), found.getCodigo());
		assertNotNull("nome:" + found.getNome(), found.getNome());
		assertNotNull("descricao:" + found.getDescricao(), found.getDescricao());
	}

}
