package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public InformacaoCEP tratarDados(Map<String, String> params) {

		InformacaoCEP info = new InformacaoCEP();

		info.setCep(params.get("cep"));

		return info;
	}
}
