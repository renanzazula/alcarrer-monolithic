package com.alcarrer.repository;

import java.util.HashSet;
import java.util.List;
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
	public void testSaveMedidaWithCategoriaAndSubCategoria() {

		MedidaEntity medida = new MedidaEntity("medida", "Descricao");
		CategoriaEntity categoria = new CategoriaEntity("categoria", "Descricao");
		MarcaEntity marca = new MarcaEntity("nome", "Descricao");
		SubCategoriaEntity subCategoria = new SubCategoriaEntity("nome", "Descricao");

		Set<ItensTipoMedidaEntity> itensTipoMedidaSet = new HashSet<ItensTipoMedidaEntity>();

		for (int i = 0; i < 3; i++) {
			ItensTipoMedidaEntity itensTipoMedida = new ItensTipoMedidaEntity();
			itensTipoMedida.setMedida(medida);
			itensTipoMedida.setMarca(marca);
			itensTipoMedida.setCategoria(categoria);
			itensTipoMedida.setSubCategoria(subCategoria);
			itensTipoMedida.setValor("");
			itensTipoMedidaSet.add(itensTipoMedida);
		}
		medida.setItensTipoMedida(itensTipoMedidaSet);

		MedidaEntity objDB = entityManager.persist(medida);
		
		List<MedidaEntity> foundAll = repository.findAll();

		for (MedidaEntity medidaEntity : foundAll) {
			System.out.println(""+medidaEntity.getNome());
		}
		
	}

	@Test
	public void testFindAll() {

		List<MedidaEntity> found = repository.findAll();

		for (MedidaEntity medidaEntity : found) {
			System.out.println(""+medidaEntity.getNome());
		}
		
	}

}
