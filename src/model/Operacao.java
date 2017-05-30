package model;

import java.util.Date;
import controller.*;

public class Operacao implements InterfaceOperacao{
	private Conta conta;
	private Cliente cliente;
	private Date data;
	private String tipo;
	private float valor;

	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Operacao(Conta conta, Cliente cliente) {
		super();
		this.conta = conta;
		this.cliente = cliente;
	}

	public void saque(float saque, Operacao operacao){
		
		float movimentacao = 0;
		
		for(int i = 0; i< conta.getOperacoes().size(); i++){
			if(conta.operacoes.get(i).getData().getDate() == new Date().getDate() && conta.operacoes.get(i).getData().getMonth() == new Date().getMonth() && conta.operacoes.get(i).getData().getYear() == new Date().getYear()){
				movimentacao += conta.operacoes.get(i).getValor();
			}	
		}
		
		if(movimentacao+saque > conta.getMovimentacao()){
			//System.out.println("Movimentação:"+movimentacao+saque);
			//System.out.println("Limite:"+conta.getMovimentacao());
			System.out.println("Limite da movimentacao atingido");
			return;
		}
		
		operacao.tipo = "saque";
		operacao.data = new Date();//new Date(2000,10,10);
		operacao.valor = saque;
		
		if(!conta.Saque(saque)){
			return;
		}
		
		conta.setOperacoes(operacao);
		
	}
	
	public void deposito(float deposito, Operacao operacao){
		float movimentacao = 0;
		
		for(int i = 0; i< conta.getOperacoes().size(); i++){
			if(conta.operacoes.get(i).getData().getDate() == new Date().getDate() && conta.operacoes.get(i).getData().getMonth() == new Date().getMonth() && conta.operacoes.get(i).getData().getYear() == new Date().getYear()){
				movimentacao += conta.operacoes.get(i).getValor();
			}	
		}
		
		if(movimentacao+deposito > conta.getMovimentacao()){
			System.out.println("Limite da movimentacao atingido");
			return;
		}
		
		operacao.tipo = "deposito";
		operacao.data = new Date();
		operacao.valor = deposito;
		
		conta.Deposito(deposito);
		conta.setOperacoes(operacao);
		
	}
	
	public void pagamento(Boleto boleto, Operacao operacao){

		float movimentacao = 0;
		
		for(int i = 0; i< conta.getOperacoes().size(); i++){
			if(conta.operacoes.get(i).getData().getDate() == new Date().getDate() && conta.operacoes.get(i).getData().getMonth() == new Date().getMonth() && conta.operacoes.get(i).getData().getYear() == new Date().getYear()){
				movimentacao += conta.operacoes.get(i).getValor();
			}	
		}
		
		if(movimentacao+boleto.getValor() > conta.getMovimentacao()){
			System.out.println("Limite da movimentacao atingido");
			return;
		}
		
		operacao.tipo = "pagamento";
		operacao.data = new Date();
		operacao.valor = boleto.getValor();

		if(!conta.Pagamento(boleto.getValor())){
			return;
		}
		conta.setOperacoes(operacao);
	}

	public void transferencia(float valor, Conta contaDestino, Conta contaSaida, Operacao operacao){
		
		float movimentacao = 0;
		
		for(int i = 0; i< conta.getOperacoes().size(); i++){
			if(conta.operacoes.get(i).getData().getDate() == new Date().getDate() && conta.operacoes.get(i).getData().getMonth() == new Date().getMonth() && conta.operacoes.get(i).getData().getYear() == new Date().getYear()){
				movimentacao += conta.operacoes.get(i).getValor();
			}	
		}
		
		if(movimentacao+valor > conta.getMovimentacao()){
			System.out.println("Limite da movimentacao atingido");
			return;
		}
		
		operacao.tipo = "transferencia-saida";
		operacao.data = new Date();
		
		if(!conta.getTipo().equals("Conta Premium") || conta.getSaldo()<50000){
			valor +=4;
		}
		
		operacao.valor = valor;
		
		if(!contaSaida.Transferencia(valor)){
			return;
		}
		contaSaida.setOperacoes(operacao);

		contaDestino.Deposito(valor);
		Operacao operacao2 = new Operacao(contaDestino,cliente);
		operacao2.tipo = "transferencia-entrada";
		operacao2.data = new Date();
		operacao2.valor = valor;
		contaDestino.setOperacoes(operacao2);
		
	}
	
	public void investimento(float valor, Operacao operacao){
		
		float movimentacao = 0;
		
		for(int i = 0; i< conta.getOperacoes().size(); i++){
			if(conta.operacoes.get(i).getData().getDate() == new Date().getDate() && conta.operacoes.get(i).getData().getMonth() == new Date().getMonth() && conta.operacoes.get(i).getData().getYear() == new Date().getYear()){
				movimentacao += conta.operacoes.get(i).getValor();
			}	
		}
		
		if(movimentacao+valor > conta.getMovimentacao()){
			System.out.println("Limite da movimentacao atingido");
			return;
		}
		
		operacao.tipo = "investimento";
		operacao.data = new Date();
		
		if(!conta.getTipo().equals("Conta Premium") || conta.getSaldo()<50000){
			valor +=valor/100;
		}
				
		operacao.valor = valor;
		
		if(!conta.Investimento(valor)){
			return;
		}
		
		conta.setOperacoes(operacao);
	}
	
	@Override
	public String toString() {
		return "Operacao \n Nome= "+cliente.getNome()+"\n data= " + data + "\n tipo= " + tipo + "\n valor= " + valor + "]\n\n";
	}
	
	
	
}
