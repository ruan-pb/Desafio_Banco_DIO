package banco;

public interface ContaMetodos {

	public Transacao criarTransacao(double valor);
	
	
	public Transacao depositar(double valor,String msg);
	
	public Transacao sacar(double valor);
	
	public double saldo();
	
	public String extrato();
	
}
