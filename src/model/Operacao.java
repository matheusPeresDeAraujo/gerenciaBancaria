package model;

import java.util.Date;

public class Operacao {
	private Conta conta;
	private Cliente cliente;
	private Date data;
	private String tipo;
	private float valor;

	
	public Operacao(Conta conta, Cliente cliente) {
		super();
		this.conta = conta;
		this.cliente = cliente;
	}

	public void saque(float saque, Operacao operacao){
		operacao.tipo = "saque";
		operacao.data = new Date();
		operacao.valor = saque;
		
		if(!conta.Saque(saque)){
			return;
		}
		
		conta.setOperacoes(operacao);
		
	}
	
	public void deposito(float deposito, Operacao operacao){
		operacao.tipo = "deposito";
		operacao.data = new Date();
		operacao.valor = deposito;
		
		conta.Deposito(deposito);
		conta.setOperacoes(operacao);
		
	}
	
	public void pagamento(Boleto boleto, Operacao operacao){
		operacao.tipo = "pagamento";
		operacao.data = new Date();
		operacao.valor = boleto.getValor();

		if(!conta.Pagamento(boleto.getValor())){
			return;
		}
		conta.setOperacoes(operacao);
	}

	public void transferencia(float valor, Conta contaDestino, Conta contaSaida, Operacao operacao){
		operacao.tipo = "transferencia-saida";
		operacao.data = new Date();
		operacao.valor = valor;
		
		if(!contaSaida.Transferencia(valor)){
			return;
		}
		contaSaida.setOperacoes(operacao);
		operacao.tipo = "transferencia-entrada";
		contaDestino.setOperacoes(operacao);
		
	}
	@Override
	public String toString() {
		return "Operacao \n Nome= "+cliente.getNome()+"\n data= " + data + "\n tipo= " + tipo + "\n valor= " + valor + "]\n\n";
	}
	
	
	
}
