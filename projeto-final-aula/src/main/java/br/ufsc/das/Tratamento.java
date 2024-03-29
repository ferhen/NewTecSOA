package br.ufsc.das;

import java.util.Map;

public class Tratamento {

	public Pedido tratarDados(Map<String, String> params) {

		String qtdDomesticoArk = params.get("QRDRA");
		String qtdDomesticoSolar = params.get("QRDRS");
		String qtdSegurancaArk = params.get("QRSRA");
		String qtdSegurancaSolar = params.get("QRSRS");
		String qtdMedicoArk = params.get("QRMRA");
		String qtdMedicoSolar = params.get("QRMRS");

		// String codigoCompra = params.get("codigo");
		String nome = params.get("nome");
		String cpf = params.get("cpf");
		String cep = params.get("cep").replace("-", "");
		String endereco = params.get("endereco");
		String estado = params.get("estado");
		String telefone = params.get("telefone");
		String email = params.get("email");

		// cria o bean para ser enviado para o proximo estagio
		Pedido bean = new Pedido();

		bean.setCliente(nome);
		bean.setCPF(cpf);
		bean.setCep(cep);
		bean.setEndereco(endereco);
		bean.setEstado(estado);
		bean.setTelefone(telefone);
		bean.setEmail(email);

		// tratar itens do pedido ... para passar ao bean
		int qtdRoboDomestico = Integer.parseInt(qtdDomesticoArk)
				+ Integer.parseInt(qtdDomesticoSolar);

		int qtdRoboSeguranca = Integer.parseInt(qtdSegurancaArk)
				+ Integer.parseInt(qtdSegurancaSolar);

		int qtdRoboMedico = Integer.parseInt(qtdMedicoArk)
				+ Integer.parseInt(qtdMedicoSolar);

		int qtdReatorArk = Integer.parseInt(qtdDomesticoArk)
				+ Integer.parseInt(qtdSegurancaArk)
				+ Integer.parseInt(qtdMedicoArk);

		int qtdReatorSolar = Integer.parseInt(qtdDomesticoSolar)
				+ Integer.parseInt(qtdSegurancaSolar)
				+ Integer.parseInt(qtdMedicoSolar);

		bean.setqtdRoboDomestico(qtdRoboDomestico);
		bean.setqtdRoboSeguranca(qtdRoboSeguranca);
		bean.setqtdRoboMedico(qtdRoboMedico);
		bean.setqtdReatorArk(qtdReatorArk);
		bean.setqtdReatorSolar(qtdReatorSolar);
		
		CartaoCredito cartao = new CartaoCredito();
		cartao.CardNumber = params.get("CardNumber");
		cartao.CardName = params.get("CardName");
		cartao.ExpirationDate = params.get("ExpirationDate");
		
		bean.cartao = cartao;
		
		System.out.println("pedido=" + bean);

		return bean;

	}

}
