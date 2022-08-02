package banco;

import java.util.Map;

public class Banco {
	
	private Map<Integer,Conta> contas;
	private int numeroContaLivre = 0;
	private Map<String,Correntista> correntista;
	
	
	
	public Conta criarConta(Correntista correntista) {
		Conta cadastro = new Conta(gerarNumeroConta(),correntista,gerarNumeroConta());
		return contas.put(gerarNumeroConta(), cadastro);
	}
	
	
	public Conta getConta(int conta) {
		return contas.get(conta);
	}

	
	public Conta getConta(Correntista titular) { //1 duvidas
		return contas.get(titular.getConta().getTransID());
	}
	
	
	public void addCorrentista(Correntista correntista) {
		this.correntista.put(correntista.getCpf(), correntista);
	}
	
	
	public Correntista getCorrentista(Correntista cpf) {
		return this.correntista.get(cpf.getCpf());
	}
	

	public int gerarNumeroConta() {
		numeroContaLivre = contas.size();
		return numeroContaLivre+=1;
	}
	

}
