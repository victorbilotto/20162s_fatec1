package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {

	static Empresa resultadoEsperado;
	static Empresa resultadoObtido;
	static EmpresaDAO empresaDAO;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		resultadoEsperado = new Empresa();
		resultadoEsperado.setCnpj("47753481000170");
		resultadoEsperado.setNomeDaEmpresa("Casas Bahia");
		resultadoEsperado.setEndereco("Rua Taquari");
		resultadoEsperado.setNomeFantasia("Casas Bahia");
		resultadoEsperado.setTelefone("11111111");
		empresaDAO = new EmpresaDAO();
		empresaDAO.adiciona(resultadoEsperado);
	}

	/**
	 * estabelece as condicoes após a execucao de cada teste
	 * 
	 * @throws Exception
	 */
	@After
	public void excluiEmpresa() throws Exception {
		empresaDAO.exclui("47753481000170");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void CT01UC02FBConsultarEmpresa_com_sucesso() {
		resultadoObtido = empresaDAO.consulta("47753481000170");
		assertTrue(resultadoEsperado.equals(resultadoObtido));
	}

}
