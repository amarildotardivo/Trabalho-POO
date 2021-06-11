package modelo;

public class Pedido {
	private String forma_pagamento;
	private boolean status_entrega;
	
	public String getForma_pagamento() {
		return forma_pagamento;
	}
	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
	public boolean isStatus_entrega() {
		return status_entrega;
	}
	public void setStatus_entrega(boolean status_entrega) {
		this.status_entrega = status_entrega;
	}
	
	
}
