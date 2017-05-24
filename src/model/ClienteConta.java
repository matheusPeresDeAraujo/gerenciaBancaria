package model;

public class ClienteConta {
	private Conta conta;
	private Cliente cliente;
	
	private int credencialNumerica;
	private String credencialAlfabetica;
	
	public ClienteConta(Conta conta, Cliente cliente, int credencialNumerica, String credencialAlfabetica) {
		super();
		this.conta = conta;
		this.cliente = cliente;
		this.credencialNumerica = credencialNumerica;
		this.credencialAlfabetica = credencialAlfabetica;
	}

	public ClienteConta(Conta conta, Cliente cliente) {
		super();
		this.conta = conta;
		this.cliente = cliente;
	}

	public ClienteConta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCredencialNumerica() {
		return credencialNumerica;
	}

	public void setCredencialNumerica(int credencialNumerica) {
		if((credencialNumerica / 10000 > 0) || (credencialNumerica % 10000 <1000)){
			System.out.println("Numeros invalidos");
			return;
		}
		
		this.credencialNumerica = credencialNumerica;
	}

	public String getCredencialAlfabetica() {
		return credencialAlfabetica;
	}

	public void setCredencialAlfabetica(String credencialAlfabetica) {
		if(credencialAlfabetica.length() != 3){
			System.out.println("Caracteres invalidos");
			return;
		}
		this.credencialAlfabetica = credencialAlfabetica;
	}

	@Override
	public String toString() {
		return "ClienteConta [conta=" + conta + ", cliente=" + cliente + ", credencialNumerica=" + credencialNumerica
				+ ", credencialAlfabetica=" + credencialAlfabetica + "]";
	}

}
