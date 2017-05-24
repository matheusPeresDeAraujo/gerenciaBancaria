package model;

public class ContaPremium extends Conta{
	private float chequeEspecial;

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
		saque += 4.0f;
		if(!Saque(saque)){
			return false;
		}
		return true;
	}
}
