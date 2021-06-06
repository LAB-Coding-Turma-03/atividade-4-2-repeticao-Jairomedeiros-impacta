package br.com.impacta.lab.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simular")
public class SimularValoresController {

	@GetMapping("/valorFuturo")
	public ResponseEntity<String> simularValores(@RequestParam(name="codigoProduto") int codigoProduto,
			@RequestParam(name="ano") int ano) {
		/*
		 * Elabore um algoritmo para calcular o valor futuro de um produto com base em seu valor REAL
		 *  e o ano que desejado.
		 *  
		 *  A escolha do produto da-se através de seus códigos, como no exercicio anterior.
		 *  
		 *  considerando o ano atual 2021, para cada ano subsequente acrescente 5% ao valor do produto 
		 *  (não esqueça que o valor a ser considerado é sempre o do ano atual).
		 *  
		 *  Usar as estruturas de repetição.
		 *  
		 *  Tabela de produto
		 *  
		 *  CodigoProduto	descrição do Produto		Valor do Produto
		 * 	1				Camisa						70.00
		 * 	2				Shorts						57.50
		 * 	3				Meia						9.99
		 * 	4				Toca						35.00
		 * 	5				Luvas						19.50
		 * 
		 * -----------------------------------------------------------------
		 * 
		 * 
		 * 
		 * <descrição do produto> custará <valor final do produto> reais em <ano-recebido-como-parametro>
		 * 
		 * Ex.: Camisa custará 73.50 reais em 2022
		 * 
		 */
		
		String descProduto = "";
		double valorProduto = 0;
		if (codigoProduto == 1) {
			descProduto = "Camisa";
			valorProduto = 70;
		} else if (codigoProduto == 2) {
			descProduto = "Shorts";
			valorProduto = 57.50;
		} else if (codigoProduto == 3) {
			descProduto = "Meia";
			valorProduto = 9.99;
		} else if (codigoProduto == 4) {
			descProduto = "Toca";
			valorProduto = 35;
		} else if (codigoProduto == 5) {
			descProduto = "Luvas";
			valorProduto = 19.50;
		}
		int anoAtual = 2021;
		while (anoAtual < ano) {
			valorProduto = valorProduto + (valorProduto * 0.05);

			anoAtual++;
		}


		DecimalFormat df = new DecimalFormat("####0.00");
		df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
		return ResponseEntity.ok(descProduto + " custará " + df.format(valorProduto) + " reais em " + ano);
	}
	
