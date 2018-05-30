package com.alcarrer.repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.model.Categoria;
import com.alcarrer.model.ItensTipoMedida;
import com.alcarrer.model.Marca;
import com.alcarrer.model.Medida;
import com.alcarrer.model.SubCategoria;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MedidaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private MedidaRepository repository;

	@Test
	public void testSaveMedida() {

		Medida medida = new Medida("medida", "Descricao");
		Categoria categoria = new Categoria("categoria", "Descricao");
		Marca marca = new Marca("nome", "Descricao");
		SubCategoria subCategoria = new SubCategoria("nome", "Descricao");

		ItensTipoMedida itensTipoMedida = new ItensTipoMedida();
		itensTipoMedida.setMedida(medida);
		itensTipoMedida.setMarca(marca);
		itensTipoMedida.setCategoria(categoria);
		itensTipoMedida.setSubCategoria(subCategoria);

		Set<ItensTipoMedida> itensTipoMedidaSet = new HashSet<ItensTipoMedida>();
		itensTipoMedidaSet.add(itensTipoMedida);

		medida.setItensTipoMedida(itensTipoMedidaSet);

		Medida objDB = entityManager.persist(medida);
//		Optional<Medida> optional = repository.findById(objDB.getCodigo());

	}

}
