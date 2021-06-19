package apresentacao;

import java.awt.EventQueue;

import scripts_bd.ConexaoBD;

/**
 * Launch the application.
 */
public class Main{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					
					//ALTERAR A SENHA DO ROOT QUE ESTÁ NA CLASSE conexaoBD DO PACOTE persistencia PARA CRIAR O BD E AS TABELAS
					ConexaoBD.criarBD();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
