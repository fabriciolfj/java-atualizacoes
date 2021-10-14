package br.com.alura.v1.dao;

import java.util.List;
import java.util.Map;

public class GalaxiaDAO {

	public void listar() {
		Map<String, List<String>> galaxias = Map.of("nome",
				List.of("A Pequena Nuvem de Magalh�es", "A Grande Nuvem de Magalh�es", "A gal�xia de Andr�meda"));
		System.out.println("[" + galaxias + "]");
	}
}
