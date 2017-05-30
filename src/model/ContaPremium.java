package model;

import controller.InterfaceConta;

public class ContaPremium extends Conta{
	
	private float chequeEspecial;
	private String tipo = "Conta Premium";
	private float movimentacao = 100000;

	
	public ContaPremium(float saldo, float chequeEspecial) {
		super();
		if (chequeEspecial > 100000){
			System.out.println("Valor máximo ultrapassado para cheque especial: Valor máximo de 100.000,00");
			return;
		}
		this.saldo = saldo;
		this.chequeEspecial = chequeEspecial;
	}

	public ContaPremium() {
		super();
	}
	
	public float getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(float movimentacao) {
		this.movimentacao = movimentacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(float chequeEspecial) {
		if (chequeEspecial > 100000){
			System.out.println("Valor máximo ultrapassado para cheque especial: Valor máximo de 100.000,00");
			return;
		}
		this.chequeEspecial = chequeEspecial;
	}
	
	public boolean Saque(float saque){
		if(saque > saldo + chequeEspecial){
			System.out.println("Valor da operacao acima do limite da conta");
			return false;
		}
		this.saldo -= saque;
		return true;
	}
	
	public boolean Pagamento(float saque){
		if(!Saque(saque)){
			return false;
		}
		return true;
	}
	
	public boolean Transferencia(float saque){
		
		if(!Saque(saque)){
			return false;
		}
		return true;
	}
	
	public boolean Investimento(float investimento){
		if(!Saque(investimento)){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Conta Premium [saldo= " + saldo + "]\n";
	}
}
