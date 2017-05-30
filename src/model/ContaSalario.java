package model;

import controller.InterfaceConta;

public class ContaSalario extends Conta{

	private static String tipo = "Conta Salario";
	private float movimentacao = 999999;
	
	
	public boolean Saque(float saque){
		if(saque > getSaldo()){
			System.out.println("Saldo da conta insuficiente");
			return false;
		}
		this.saldo -= saque;
		return true;
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


	@Override
	public String toString() {
		return "Conta Salario [saldo= " + saldo + "]\n";
	}
}
