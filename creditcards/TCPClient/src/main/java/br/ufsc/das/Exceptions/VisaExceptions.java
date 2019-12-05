package br.ufsc.das.Exceptions;

public class VisaExceptions {
	public void lancarExcecao(String errorCode) {
		switch(errorCode) {
			case "ERROR 3000":
				throw new IllegalArgumentException("Comando inválido");
			case "ERROR 3001":
				throw new IllegalArgumentException("Número de cartão de crédito inválido");
			case "ERROR 3002":
				throw new IllegalArgumentException("Cartão de crédito não é da bandeira Visa");
			case "ERROR 3003":
				throw new IllegalArgumentException("Nome da pessoa inválido");
			case "ERROR 3004":
				throw new IllegalArgumentException("Data de expiração do cartão de crédito inválida");
			case "ERROR 3005":
				throw new IllegalArgumentException("Valor da transação inválido");
			case "ERROR 3006":
				throw new IllegalArgumentException("Sistema indisponível");
			default:
				throw new IllegalArgumentException("Resposta da API da Visa desconhecida");
		}
	}
}
