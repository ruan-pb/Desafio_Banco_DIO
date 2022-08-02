package banco;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Conta implements ContaMetodos{
	private int TransID;
	private Correntista correntista;
	private int numero;
	
	private BigDecimal saldo;
	private List<Transacao> transacoes ;
	
	public Conta(Correntista correntista, int numero) {
		super();
		this.correntista = correntista;
		this.numero = numero;
		this.saldo = new BigDecimal(0.0);
		transacoes = new LinkedList<>();
	}
	public Conta(int id,Correntista correntista, int numero) {
		super();
		this.TransID = id;
		this.correntista = correntista;
		this.numero = numero;
	}
	

	public Transacao criarTransacao(double valor) {
		BigDecimal valorBig = new BigDecimal(valor);
		Transacao transacao =  new Transacao(this.TransID++, valorBig);
		transacoes.add(transacao);
		this.saldo.add(valorBig);
		return transacao;	
	}
	
	public Transacao depositar(double valor,String msg) {
		if(this.saldo() < valor) throw new SaldoInsuficienteException("Erro - Depositar - Valor negativo: "+valor);
		return criarTransacao(valor);
		
	}

	public Transacao sacar(double valor) {
		if(this.saldo() < valor) throw new SaldoInsuficienteException("Erro - Depositar - Valor negativo: "+valor);
		return criarTransacao(-valor);
	
	}
	public double saldo() {
		return saldo.doubleValue();
	}
	
	public String extrato() {
		StringBuilder extrato = new StringBuilder();
		extrato.append("Nome: "+this.correntista.getNome());
		extrato.append("CPF "+this.correntista.getCpf());
		extrato.append("Numero da Conta: "+ this.correntista.getConta().numero);
		extrato.append("Saldo da conta: "+this.saldo());
		extrato.append(transacoes.toString());
		return extrato.toString();
	}

	public int getTransID() {
		return this.TransID;
	}


}
