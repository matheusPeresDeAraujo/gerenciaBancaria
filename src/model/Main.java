package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * CADASTRO DE CLIENTES: RN3
		 * 
		 */
		Map <String, ClienteConta> clientes = new HashMap<>();
		// Cliente 1
		Cliente cl1 = new Cliente();
		cl1.setNome("Matheus");
		cl1.setCadastro(new Date());
		cl1.setNascimento(new Date());
		cl1.setCelular("55032999998819");
		cl1.setRenda(2000.00);
		cl1.setTelefone("5503234212121");
		cl1.setCpf("10388767618");
		Endereco ed1 = new Endereco("rua", 666, "bairro", "cidade", "estado", "cep");
		cl1.setEndereco(ed1);
		
		
		// Cliente 2
		Cliente cl2 = new Cliente();
		cl2.setNome("Araujo");
		cl2.setCadastro(new Date());
		cl2.setNascimento(new Date());
		cl2.setCelular("55032999998819");
		cl2.setRenda(2000.00);
		cl2.setTelefone("5503234212121");
		cl2.setCpf("10388767618");
		Endereco ed2 = new Endereco("rua", 666, "bairro", "cidade", "estado", "cep");
		cl2.setEndereco(ed1);
		
		/*
		 * CADASTRO DE CONTA SALÁRIO : RN1.1
		 */
		ContaPremium c1 = new ContaPremium();
		c1.setChequeEspecial(300.00f);
		c1.setClientes(cl1);
		c1.setClientes(cl2);
		/*
		 * As credenciais informadas em cadastro devem respeitar as regras impostas pelo modelo:
		 * - credencialNumerica com 4 dígitos.
		 * - credenciaAlfabetica com 3 caracteres
		 */
		ClienteConta cc1 = new ClienteConta(c1,cl1);
		//cc1.setCredencialAlfabetica("AC");// resultado: caracteres inválidos
		cc1.setCredencialAlfabetica("ABC");
		//cl1.setCredencialNumerica(123);// resultado: numeros inválidos
		cc1.setCredencialNumerica(1234);
		clientes.put(cc1.getCredencialAlfabetica()+cc1.getCredencialNumerica(), cc1);
		ClienteConta cc2 = new ClienteConta(c1,cl2);
		cc2.setCredencialAlfabetica("CBA");
		cc2.setCredencialNumerica(4321);
		clientes.put(cc2.getCredencialAlfabetica()+cc2.getCredencialNumerica(), cc2);
		
		//Deposito
		Operacao op1 = new Operacao(c1, cl1);
		op1.deposito(100.00f, op1);
		Operacao op2 = new Operacao(c1, cl1);
		//op2.setSaque(300.00f);// resultado : saldo da conta insuficiente
		op2.saque(100.00f, op2);
		Operacao op3 = new Operacao(c1, cl1);
		op3.pagamento(new Boleto("123wer",0.0f),op3);
		
		//System.out.println(c1.getSaldo());
		//System.out.println(c1.getOperacoes());
		
		//______________________________________________________________________________________________________
		

		
		Scanner scan = new Scanner(System.in);
		ClienteConta ccscan = new ClienteConta();
		System.out.println("Informe senha numerica de acesso:");
		ccscan.setCredencialNumerica(scan.nextInt());
		scan.nextLine();
		System.out.println("Informe senha alfabetica de acesso:");
		ccscan.setCredencialAlfabetica(scan.nextLine());
		
		ccscan = clientes.get(ccscan.getCredencialAlfabetica()+ccscan.getCredencialNumerica());
		System.out.println("Bem Vindo " + ccscan.getCliente().getNome());
		int op = -1;
		while(op != 0){
			
				System.out.println("0 - sair");
				System.out.println("1 - Visualizar saldo atual.");
				System.out.println("2 - Visualizar operacoes na conta.");
				System.out.println("3 - Visualizar informações do cliente");
				System.out.println("4 - Realizar deposito");
				System.out.println("5 - Realizar saque");
				System.out.println("6 - Realizar transferencia");
				System.out.println("7 - Realizar pagamento");
				System.out.println("8 - Realizar investimento");
				
				System.out.println("Informe a operação desejada: ");
				op = scan.nextInt();
				scan.nextLine();
				
				switch(op){
				case 1: System.out.println("Seu saldo atual é de : " + ccscan.getConta().getSaldo());
					break;
				case 2: System.out.println("Operações realizadas na conta: \n" + ccscan.getConta().getOperacoes());
					break;
				case 3: System.out.println(ccscan.getCliente());
					break;
				case 4: System.out.println("Informe valor de deposito: ");
						Operacao op4 = new Operacao(ccscan.getConta(),ccscan.getCliente());
						op4.deposito(scan.nextFloat(), op4);
					break;
				case 5: System.out.println("Informe valor de saque: ");
						Operacao op5 = new Operacao(ccscan.getConta(),ccscan.getCliente());
						op5.saque(scan.nextFloat(), op5);
					break;
				case 6: System.out.println("Informe valor da transferencia: ");
						Operacao op6 = new Operacao(ccscan.getConta(),ccscan.getCliente());
						op6.transferencia(scan.nextFloat(), ccscan.getConta(), ccscan.getConta(), op6);
						
					break;
				case 7: System.out.println("Informe codigo de barras do boleto: ");
						Boleto b1 = new Boleto();
						b1.setCodBarra(scan.nextLine());
						System.out.println("Informe valor do boleto: ");
						b1.setValor(scan.nextFloat());
						Operacao op7 = new Operacao(ccscan.getConta(),ccscan.getCliente());
						op7.pagamento(b1, op7);		
				}
		}
		     
	}
}
