package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public String tratarDados(Map<String, String> params) 
	{
		return params.get("UF");
	}
}
