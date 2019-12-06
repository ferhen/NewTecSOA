package br.ufsc.das;

import java.util.HashMap;

public class SomarValorTotalComFrete {

	public Float parse(HashMap<String,String> input)
	{
		Float valorFrete = Float.parseFloat(input.get("valorFrete"));
		Float valorTotal = Float.parseFloat(input.get("valorTotal").toString());
		return valorFrete + valorTotal;
	}
}
