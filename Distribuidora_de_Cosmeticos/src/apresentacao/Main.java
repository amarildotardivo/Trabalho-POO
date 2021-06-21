package apresentacao;

import persistencia.CriarBD;

public class Main{
	
	public static void main(String[] args) {
		try {
			//INICIANDO A APLICAÇÃO - CHAMANDO A TELA PRINCIPAL
			TelaPrincipal frame = new TelaPrincipal();
			frame.setVisible(true);
			
			//ALTERAR A SENHA DO ROOT QUE ESTÁ NA CLASSE conexaoBD DO PACOTE persistencia PARA CRIAR O BD E AS TABELAS
			CriarBD criar = new CriarBD();
			criar.criarBD();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
