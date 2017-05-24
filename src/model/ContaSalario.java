package model;

public class ContaSalario extends Conta{
	
	public boolean Saque(float saque){
		if(saque > getSaldo()){
			System.out.println("Saldo da conta insuficiente");
			return false;
		}
		this.saldo -= saque;
		return true;
	}
}
