package com.alcarrer.repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.entity.CategoriaEntity;
import com.alcarrer.entity.ItensTipoMedidaEntity;
import com.alcarrer.entity.MarcaEntity;
import com.alcarrer.entity.MedidaEntity;
import com.alcarrer.entity.SubCategoriaEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MedidaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private MedidaRepository repository;

	@Test
	public void testSaveMedida() {

		MedidaEntity medida = new MedidaEntity("medida", "Descricao");
		CategoriaEntity categoria = new CategoriaEntity("categoria", "Descricao");
		MarcaEntity marca = new MarcaEntity("nome", "Descricao");
		SubCategoriaEntity subCategoria = new SubCategoriaEntity("nome", "Descricao");

		ItensTipoMedidaEntity itensTipoMedida = new ItensTipoMedidaEntity();
		itensTipoMedida.setMedida(medida);
		itensTipoMedida.setMarca(marca);
		itensTipoMedida.setCategoria(categoria);
		itensTipoMedida.setSubCategoria(subCategoria);

		Set<ItensTipoMedidaEntity> itensTipoMedidaSet = new HashSet<ItensTipoMedidaEntity>();
		itensTipoMedidaSet.add(itensTipoMedida);
		medida.setItensTipoMedida(itensTipoMedidaSet);

		MedidaEntity objDB = entityManager.persist(medida);
//		Optional<Medida> optional = repository.findById(objDB.getCodigo());

	}

}
