package banco;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Transacao {
	
	private int id;
	private Calendar data;
	private BigDecimal valor;
	
	
	public Transacao(int id, BigDecimal valor) {
		super();
		this.id = id;
		this.valor = valor;
		this.data = Calendar.getInstance();
	}
	
	
	public int getId() {
		return id;
	}


	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", data=" + data + ", valor=" + valor + "]";
	}
	
	

}
