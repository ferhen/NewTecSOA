package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public float tratarDados(Map<String, String> params) 
	{
		return Float.parseFloat(params.get("valor"));
	}
}
