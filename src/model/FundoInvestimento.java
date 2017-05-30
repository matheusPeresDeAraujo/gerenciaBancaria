package model;

public class FundoInvestimento {
	private int agencia;
	private int conta;
	private String descricao;
	private float saldo;
	
	public FundoInvestimento(int agencia, int conta, String descricao) {
		super();
		this.agencia = agencia;
		this.conta = conta;
		this.descricao = descricao;
	}
	
	public FundoInvestimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo += saldo;
	}

	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + conta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FundoInvestimento other = (FundoInvestimento) obj;
		if (agencia != other.agencia)
			return false;
		if (conta != other.conta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FundoInvestimento [agencia=" + agencia + ", conta=" + conta + ", descricao=" + descricao + "]";
	}
	
	
	
}
