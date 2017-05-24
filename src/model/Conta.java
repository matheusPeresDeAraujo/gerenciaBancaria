package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
	protected float saldo;
	protected List<Cliente> clientes = new ArrayList();
	protected List<Operacao> operacoes = new ArrayList();
	
	public Conta(float saldo) {
		super();
		this.saldo = saldo;
	}

	public Conta() {
		super();
	}

	public float getSaldo(){
		return this.saldo;
	}
	
	public void Deposito(float deposito){
		this.saldo += deposito;
	}
	
	public boolean Saque(float saque){
		this.saldo -= saque;
		return false;
	}
	
	public boolean Pagamento(float valor){
		return false;
	}
	
	public boolean Investimento(float valor){
		return false;
	}
	
	public boolean Transferencia(float valor){
		return false;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(Operacao operacao) {
		this.operacoes.add(operacao);
	}

	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", clientes=" + clientes + ", operacoes=" + operacoes + "]";
	}
	
}
