package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public String tratarFormulario(Map<String, String> params) {

		StringBuilder sb = new StringBuilder();

		String nome = params.get("nome");
		String sobrenome = params.get("sobrenome");

		sb.append("Nome: " + nome);
		sb.append("\n");
		sb.append("Sobrenome: " + sobrenome);

		return sb.toString();

	}

}