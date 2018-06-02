package com.alcarrer.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CategoriaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

//	@Autowired
//	private CategoriaRepository categoriaRepository;

	@Test
	public void testSaveCategoria() {

//		Categoria categoria = new Categoria("categoria", "Descricao");
//		SubCategoria  subCategoria  = new SubCategoria("nome", "descricao");  
//		
//		CategoriaHasSubCategoria categoriaHasSubCategoria = new CategoriaHasSubCategoria();
//		categoriaHasSubCategoria.setCategoria(categoria);
//		categoriaHasSubCategoria.setSubCategoria(subCategoria);
//		
//		Set<CategoriaHasSubCategoria> categoriaHasSubCategoriaSet = new HashSet<>();
//		categoriaHasSubCategoriaSet.add(categoriaHasSubCategoria);
//	
//		categoria.setSubCategorias(categoriaHasSubCategoriaSet);
		
////		Categoria categoriaDB = 
//				entityManager.persist(categoria);
//		Categoria optional = categoriaRepository.findOne(categoriaDB.getCodigo());

	}

}
