package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public Pedido tratarDados(Map<String, String> params) {

		String qDomesticoArk = params.get("QRDRA");
		String qDomesticoSolar = params.get("QRDRS");
		String qSegurancaArk = params.get("QRSRA");
		String qSegurancaSolar = params.get("QRSRS");
		String qMedicoArk = params.get("QRMRA");
		String qMedicoSolar = params.get("QRMRS");

		// String codigoCompra = params.get("codigo");
		String nome = params.get("nome");

		String cep = params.get("cep");
		String endereco = params.get("endereco");
		String estado = params.get("estado");

		// cria o bean para ser enviado para o proximo estagio
		Pedido bean = new Pedido();

		bean.setCliente(nome);
		bean.setCep(cep);
		bean.setEndereco(endereco);
		bean.setEstado(estado);

		// tratar itens do pedido ... para passar ao bean
		int qRoboDomestico = Integer.parseInt(qDomesticoArk)
				+ Integer.parseInt(qDomesticoSolar);

		int qRoboSeguranca = Integer.parseInt(qSegurancaArk)
				+ Integer.parseInt(qSegurancaSolar);

		int qRoboMedico = Integer.parseInt(qMedicoArk)
				+ Integer.parseInt(qMedicoSolar);

		int qReatorArk = Integer.parseInt(qDomesticoArk)
				+ Integer.parseInt(qSegurancaArk)
				+ Integer.parseInt(qMedicoArk);

		int qReatorSolar = Integer.parseInt(qDomesticoSolar)
				+ Integer.parseInt(qSegurancaSolar)
				+ Integer.parseInt(qMedicoSolar);

		bean.setqRoboDomestico(qRoboDomestico);
		bean.setqRoboSeguranca(qRoboSeguranca);
		bean.setqRoboMedico(qRoboMedico);
		bean.setqReatorArk(qReatorArk);
		bean.setqReatorSolar(qReatorSolar);

		System.out.println("pedido=" + bean);

		return bean;

	}

}
