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
				cl1.setNome("CLiente 01");
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
				cl2.setNome("CLiente 02");
				cl2.setCadastro(new Date());
				cl2.setNascimento(new Date());
				cl2.setCelular("55032999998819");
				cl2.setRenda(2000.00);
				cl2.setTelefone("5503234212121");
				cl2.setCpf("10388767618");
				Endereco ed2 = new Endereco("rua", 666, "bairro", "cidade", "estado", "cep");
				cl2.setEndereco(ed1);
		
		/*
		 * CADASTRO DE CONTA : RN1.1
		 * 
		 */
		Map <Long, Conta> contas = new HashMap<>();
		ContaPremium c1 = new ContaPremium();
				c1.setId(100);
				c1.setMovimentacao(c1.getMovimentacao());
				c1.setChequeEspecial(100000.00f);
				c1.setClientes(cl1);
					cl1.setContas(c1);
				c1.setClientes(cl2);
					cl2.setContas(c1);
			contas.put(c1.getId(), c1);
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
				
		ContaSalario cs1 = new ContaSalario();
				cs1.setId(200);
				cs1.setMovimentacao(cs1.getMovimentacao());
				cs1.setClientes(cl1);
					cl1.setContas(cs1);
			contas.put(cs1.getId(), cs1);
					
				ClienteConta cc3 = new ClienteConta(cs1,cl1);
				cc3.setCredencialAlfabetica("DEF");
				cc3.setCredencialNumerica(1234);
				clientes.put(cc3.getCredencialAlfabetica()+cc3.getCredencialNumerica(), cc3);	
					
		ContaSalario cs2 = new ContaSalario();
				cs2.setId(300);
				cs2.setMovimentacao(cs2.getMovimentacao());
				cs2.setClientes(cl2);
					cl2.setContas(cs2);
			contas.put(cs2.getId(), cs2);
					
				ClienteConta cc4 = new ClienteConta(cs2,cl2);
				cc4.setCredencialAlfabetica("FED");
				cc4.setCredencialNumerica(4321);
				clientes.put(cc4.getCredencialAlfabetica()+cc4.getCredencialNumerica(), cc4);	
		
		ContaExecutiva ce1 = new ContaExecutiva();
				ce1.setId(400);
				ce1.setMovimentacao(ce1.getMovimentacao());
				ce1.setChequeEspecial(5000);
				ce1.setClientes(cl1);
					cl1.setContas(ce1);
			contas.put(ce1.getId(), ce1);
					
				ClienteConta cc5 = new ClienteConta(ce1,cl1);
				cc5.setCredencialAlfabetica("GHI");
				cc5.setCredencialNumerica(1234);
				clientes.put(cc5.getCredencialAlfabetica()+cc5.getCredencialNumerica(), cc5);	
				
		FundoInvestimento fi = new FundoInvestimento();
			fi.setAgencia(1012);
			fi.setConta(332456);
			fi.setDescricao("Fundo de Investimento");
		
		
		
		//______________________________________________________________________________________________________
		
		int op = -1;
		while(op != 0){
		
				Scanner scan = new Scanner(System.in);
				ClienteConta ccscan = new ClienteConta();
				System.out.println("Informe senha numerica de acesso:");
				ccscan.setCredencialNumerica(scan.nextInt());
				scan.nextLine();
				System.out.println("Informe senha alfabetica de acesso:");
				ccscan.setCredencialAlfabetica(scan.nextLine());
				
				if(clientes.containsKey(ccscan.getCredencialAlfabetica()+ccscan.getCredencialNumerica())){
					ccscan = clientes.get(ccscan.getCredencialAlfabetica()+ccscan.getCredencialNumerica());
					System.out.println("Bem Vindo " + ccscan.getCliente().getNome());
				}else{
					System.out.println("Credenciais Inválidas");
					continue;
				}
				
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
								scan.nextLine();
							break;
						case 5: System.out.println("Informe valor de saque: ");
								Operacao op5 = new Operacao(ccscan.getConta(),ccscan.getCliente());
								op5.saque(scan.nextFloat(), op5);
								scan.nextLine();
							break;
						case 6: if (ccscan.getConta().getTipo() == "Conta Salario"){
									System.out.println("Essa conta não pode realizar este tipo de operação");
									break;
								}
								System.out.println("Informe identificador da conta");
								Conta cDestino = contas.get(scan.nextLong());
								scan.nextLine();
								System.out.println("Informe valor da transferencia: ");
								Operacao op6 = new Operacao(ccscan.getConta(),ccscan.getCliente());
								op6.transferencia(scan.nextFloat(), cDestino, ccscan.getConta(), op6);
								scan.nextLine();
								
							break;
						case 7: if (ccscan.getConta().getTipo() == "Conta Salario"){
									System.out.println("Essa conta não pode realizar este tipo de operação");
									break;
								}
								System.out.println("Informe codigo de barras do boleto: ");
								Boleto b1 = new Boleto();
								b1.setCodBarra(scan.nextLine());
								System.out.println("Informe valor do boleto: ");
								b1.setValor(scan.nextFloat());
								Operacao op7 = new Operacao(ccscan.getConta(),ccscan.getCliente());
								op7.pagamento(b1, op7);	
								scan.nextLine();
							break;
						case 8: if (ccscan.getConta().getTipo() == "Conta Salario"){
									System.out.println("Essa conta não pode realizar este tipo de operação");
									break;
								}
								System.out.println("Informe valor a ser investido: ");
								Operacao op8 = new Operacao(ccscan.getConta(),ccscan.getCliente());
								op8.investimento(scan.nextFloat(), op8);
								scan.nextLine();
							break;
						default:
							continue;
						}
				System.out.println("Pressione qualquer tecla para realizar nova operação");
				scan.nextLine();
		}
		     
	}
}
