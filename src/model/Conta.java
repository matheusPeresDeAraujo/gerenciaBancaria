package model;

import java.util.ArrayList;
import java.util.List;

import controller.InterfaceConta;

public abstract class Conta implements InterfaceConta{
	
	protected long id;
	protected String tipo;
	protected float saldo;
	protected float movimentacao;
	
	protected List<Cliente> clientes = new ArrayList();
	protected List<Operacao> operacoes = new ArrayList();
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(float movimentacao) {
		this.movimentacao = movimentacao;
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

}
