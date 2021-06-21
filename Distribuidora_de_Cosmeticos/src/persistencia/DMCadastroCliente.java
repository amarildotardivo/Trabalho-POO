package persistencia;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import modelo.Cliente;

public class DMCadastroCliente {

	//METODO DE CADASTRAR CLIENTE
	public void incluir(Object obj){
		
		Cliente objCliente = (Cliente) obj;
        
		try
        {   Statement statement = getConnection().createStatement();
            
            String incluirSQL = "INSERT INTO pfisicas (" + "nome, logradouro, numero, bairro, cidade, telefone, cpf, nome_representante" +
                                ") VALUES ('" +
                                objCliente.getNome() + "', '" +
                                objCliente.getLogradouro() + "', '" +
                                objCliente.getNumero() + "', '" +
                                objCliente.getBairro() + "', '" +
                                objCliente.getCidade() + "', '" +
                                objCliente.getTelefone() + "', '" +
                                objCliente.getCpf() + "', '" +
                                objCliente.getNome_representante() + "')";
            
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            
            statement.executeUpdate(incluirSQL);
            
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclusão de pessoa física!"); }
    }

}
