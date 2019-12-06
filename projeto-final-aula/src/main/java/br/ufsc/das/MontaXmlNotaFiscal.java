package br.ufsc.das;


public class MontaXmlNotaFiscal {

	public String montaXmlNotaFiscal(Pedido pedido) {

		StringBuilder xml = new StringBuilder();

		xml.append("<notaFiscal>");
		xml.append("<nomeCliente>" + pedido.getCliente() + "</nomeCliente>");
		xml.append("<cpfCnpjCliente>" + pedido.getCPF() + "</cpfCnpjCliente>");
		xml.append("<enderecoCliente>" + pedido.getEndereco()
				+ "</enderecoCliente>");
		xml.append("<bairroCliente>" + pedido.getBairro() + "</bairroCliente>");
		xml.append("<cepCliente>" + pedido.getCep() + "</cepCliente>");
		xml.append("<municipioCliente>" + pedido.getCidade()
				+ "</municipioCliente>");
		xml.append("<telefoneCliente>" + pedido.getTelefone()
				+ "</telefoneCliente>");
		xml.append("<ufCliente>" + pedido.getEstado() + "</ufCliente>");
		xml.append("<valorFrete>" + pedido.getValorFrete() + "</valorFrete>");

		xml.append("<itens>");

		if (pedido.getqtdRoboDomestico() > 0)
			addItemNF(xml, "BR001", "Robo Domestico", 900,
					pedido.getqtdRoboDomestico());
		
		if (pedido.getqtdRoboDomestico() > 0)
			addItemNF(xml, "BR002", "Robo de Seguranca", 1800,
					pedido.getqtdRoboSeguranca());
		
		if (pedido.getqtdRoboDomestico() > 0)
			addItemNF(xml, "BR003", "Robo medico", 2500,
					pedido.getqtdRoboMedico());

		if (pedido.getqtdReatorArk() > 0)
			addItemNF(xml, "STK001", "Reator ARK", 2500,
					pedido.getqtdReatorArk());

		if (pedido.getqtdReatorSolar() > 0)
			addItemNF(xml, "STK002", "Reator Solar", 1500,
					pedido.getqtdReatorSolar());

		xml.append("</itens>");
		xml.append("<informacoesAdicionais>Produto comprado pelo site</informacoesAdicionais>");
		xml.append("</notaFiscal>");

		return xml.toString();
	}

	private void addItemNF(StringBuilder xml, String codigo, String nome,
			float valorUnitario, int quantidade) {

		float valorTotal = valorUnitario * quantidade;

		// String codigo = p.contains("Ark") ? "STK001" : p.contains("Solar") ?
		// "STK002" : p.contains("Domestico") ? "BR001" : "-";

		xml.append("<itemNotaFiscal>");
		xml.append("<codigo>" + codigo + "</codigo>");
		xml.append("<descricao>" + nome + "</descricao>");
		xml.append("<unidade>PC</unidade>");
		xml.append("<quantidade>" + quantidade + "</quantidade>");
		xml.append("<valorUnitario>" + valorUnitario + "</valorUnitario>");
		xml.append("<valorTotal>" + valorTotal + "</valorTotal>");
		xml.append("</itemNotaFiscal>");
	}
}
