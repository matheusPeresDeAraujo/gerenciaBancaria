package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
	
	private String nome;
	private Date nascimento;
	private String cpf;
	private Date cadastro;
	private double renda;
	private Endereco endereco;
	private String telefone;
	private String celular;
	
	public Cliente(String nome, Date nascimento, String cpf, Date cadastro, double renda, Endereco endereco, String telefone,
			String celular) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.cadastro = cadastro;
		this.renda = renda;
		this.endereco = endereco;
		this.telefone = telefone;
		this.celular = celular;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double d) {
		this.renda = d;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", nascimento=" + nascimento + ", cpf=" + cpf + ", cadastro=" + cadastro
				+ ", renda=" + renda + ", endereco=" + endereco + ", telefone=" + telefone + ", celular=" + celular
				+ "]";
	}

	
}
