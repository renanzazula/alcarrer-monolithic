package com.alcarrer.repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.dto.CategoriaDTO;
import com.alcarrer.dto.ItensTipoMedidaDTO;
import com.alcarrer.dto.MarcaDTO;
import com.alcarrer.dto.MedidaDTO;
import com.alcarrer.dto.SubCategoriaDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MedidaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private MedidaRepository repository;

	@Test
	public void testSaveMedida() {

		MedidaDTO medida = new MedidaDTO("medida", "Descricao");
		CategoriaDTO categoria = new CategoriaDTO("categoria", "Descricao");
		MarcaDTO marca = new MarcaDTO("nome", "Descricao");
		SubCategoriaDTO subCategoria = new SubCategoriaDTO("nome", "Descricao");

		ItensTipoMedidaDTO itensTipoMedida = new ItensTipoMedidaDTO();
		itensTipoMedida.setMedida(medida);
		itensTipoMedida.setMarca(marca);
		itensTipoMedida.setCategoria(categoria);
		itensTipoMedida.setSubCategoria(subCategoria);

		Set<ItensTipoMedidaDTO> itensTipoMedidaSet = new HashSet<ItensTipoMedidaDTO>();
		itensTipoMedidaSet.add(itensTipoMedida);
		medida.setItensTipoMedida(itensTipoMedidaSet);

		MedidaDTO objDB = entityManager.persist(medida);
//		Optional<Medida> optional = repository.findById(objDB.getCodigo());

	}

}
