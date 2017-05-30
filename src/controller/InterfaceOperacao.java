package controller;

import model.*;

public interface InterfaceOperacao {
	
	public void deposito(float deposito, Operacao operacao);
	public void saque(float saque, Operacao operacao);
	public void pagamento(Boleto boleto, Operacao operacao);
	public void transferencia(float valor, Conta contaDestino, Conta contaSaida, Operacao operacao);
	public void investimento(float valor, Operacao operacao);
	
}
