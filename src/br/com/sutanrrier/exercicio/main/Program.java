package br.com.sutanrrier.exercicio.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.sutanrrier.exercicio.entities.Pessoa;
import br.com.sutanrrier.exercicio.entities.PessoaFisica;
import br.com.sutanrrier.exercicio.entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		List<Pessoa> lista_pessoas = new ArrayList<>(); 
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o número de pessoas a pagar imposto: ");
		int quantidade_pessoas = sc.nextInt();
		
		//Registrando as pessoas a pagar impostos na lista
		for(int i=1; i<=quantidade_pessoas; i++) {
			System.out.println("\nPessoa #" + i);
			System.out.print("Pessoa Física (F) ou Jurídica (J): ");
			char tipo_pessoa = sc.next().toUpperCase().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Renda Anual: ");
			double renda_anual = sc.nextDouble();
			if (tipo_pessoa == 'F') {
				System.out.print("Gastos Médicos: ");
				double gastos_saude = sc.nextDouble();
				lista_pessoas.add(new PessoaFisica(nome, renda_anual, gastos_saude));
			}
			if (tipo_pessoa == 'J') {
				System.out.print("Número de Funcionários:  ");
				int num_funcionarios = sc.nextInt();
				lista_pessoas.add(new PessoaJuridica(nome, renda_anual, num_funcionarios));
			}
		}
		
		//Buscando o valores de impostos na lista
		System.out.println("\nImpostos Pagos:");
		double total_impostos = 0.0;
		for (Pessoa pessoa : lista_pessoas) {
			System.out.printf("%s: $%.2f\n", pessoa.getNome(), pessoa.impostoPago());
			total_impostos += pessoa.impostoPago();
		}
		
		//Exibindo total de impostos dos membros da lista
		System.out.printf("\nTotal de Impostos: $ %.2f", total_impostos);
		
		sc.close();
	}

}
