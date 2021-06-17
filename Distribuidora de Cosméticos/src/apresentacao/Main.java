package apresentacao;

import java.sql.SQLException;

import scripts_bd.ConexaoBD;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		//ALTERAR A SENHA DO ROOT QUE ESTÁ NA CLASSE conexaoBD DO PACOTE persistencia PARA CRIAR O BD E AS TABELAS
		ConexaoBD.criarBD();
		
	}

}
