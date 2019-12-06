package br.ufsc.das;

public class CheckIfValidShipping {

	public Float checkIfValid(Float input) throws Exception
	{
		if (input < 0)
			throw new Exception("Estado de destino inválido!");
		return input;
	}
}
