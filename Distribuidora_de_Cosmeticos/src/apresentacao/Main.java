package apresentacao;

import persistencia.CriarBD;

public class Main{
	
	public static void main(String[] args) {
		try {
			//INICIANDO A APLICA��O - CHAMANDO A TELA PRINCIPAL
			TelaPrincipal frame = new TelaPrincipal();
			frame.setVisible(true);
			
			//ALTERAR A SENHA DO ROOT QUE EST� NA CLASSE conexaoBD DO PACOTE persistencia PARA CRIAR O BD E AS TABELAS
			CriarBD criar = new CriarBD();
			criar.criarBD();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
