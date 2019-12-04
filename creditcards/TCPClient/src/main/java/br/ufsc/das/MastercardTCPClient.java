package br.ufsc.das;

import java.io.*;
import java.net.*;

public class MastercardTCPClient {
	
	private final String okCommand = "OK";
	private final String proceedCommand = "PROCEED";
	private final String paymentCommand = "PAYMENT";
	private final String commitCommand = "COMMIT";

	public String Process(CartaoCredito cartao) throws Exception {
		String receivedMessage = null;
		
		receivedMessage = SendMessage(paymentCommand);
		if (!receivedMessage.equals(okCommand))
			lancarExcecao(receivedMessage);
		
		receivedMessage = SendMessage(cartao.CardNumber.substring(0, 4));
		if (!receivedMessage.equals(proceedCommand))
			lancarExcecao(receivedMessage);
		receivedMessage = SendMessage(cartao.CardNumber.substring(4, 8));
		if (!receivedMessage.equals(proceedCommand))
			lancarExcecao(receivedMessage);
		receivedMessage = SendMessage(cartao.CardNumber.substring(8, 12));
		if (!receivedMessage.equals(proceedCommand))
			lancarExcecao(receivedMessage);
		receivedMessage = SendMessage(cartao.CardNumber.substring(12, 16));
		if (!receivedMessage.equals(proceedCommand))
			lancarExcecao(receivedMessage);
		
		receivedMessage = SendMessage(cartao.CardName);
		if (!receivedMessage.equals(proceedCommand))
			lancarExcecao(receivedMessage);
		
		receivedMessage = SendMessage(cartao.ExpirationDate);
		if (!receivedMessage.equals(proceedCommand))
			lancarExcecao(receivedMessage);
		
		receivedMessage = SendMessage(cartao.TransactionValue);
		if (!receivedMessage.equals(proceedCommand))
			lancarExcecao(receivedMessage);
		
		receivedMessage = SendMessage(commitCommand);
		
		String[] str = receivedMessage.split(System.getProperty("line.separator"));
		if (!str[0].equals(okCommand))
			lancarExcecao(receivedMessage);
		
		return str[1];
	}
	
	private String SendMessage(String message) throws Exception {
		Socket clientSocket = new Socket("localhost", 5011);
		DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader dIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		byte[] data = (message + System.getProperty("line.separator")).getBytes("UTF-8");
		dOut.write(data);
		
		StringBuilder receivedMessage = new StringBuilder();
		String line = null;
		while ((line = dIn.readLine()) != null) {
			receivedMessage.append(line);
			receivedMessage.append(System.getProperty("line.separator"));
		}
		
		clientSocket.close();
		
		return receivedMessage.toString().trim();
	}
	
	private void lancarExcecao(String errorCode) {
		switch(errorCode) {
			case "ERROR 4000":
				throw new IllegalArgumentException("Comando inválido");
			case "ERROR 4001":
				throw new IllegalArgumentException("Número de cartão de crédito inválido");
			case "ERROR 4002":
				throw new IllegalArgumentException("Cartão de crédito não é da bandeira Mastercard");
			case "ERROR 4003":
				throw new IllegalArgumentException("Nome da pessoa inválido");
			case "ERROR 4004":
				throw new IllegalArgumentException("Data de expiração do cartão de crédito inválida");
			case "ERROR 4005":
				throw new IllegalArgumentException("Valor da transação inválido");
			case "ERROR 4006":
				throw new IllegalArgumentException("Sistema indisponível");
			default:
				throw new IllegalArgumentException("Resposta da API da Mastercard desconhecida");
		}
	}
}
