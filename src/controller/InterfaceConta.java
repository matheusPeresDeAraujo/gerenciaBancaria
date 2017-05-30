package controller;

public interface InterfaceConta {

	public void Deposito(float deposito);	
	public boolean Saque(float saque);
	public boolean Pagamento(float valor);	
	public boolean Investimento(float valor);	
	public boolean Transferencia(float valor);
}
