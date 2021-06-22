package apresentacao;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import persistencia.ClienteDB;
import persistencia.ConexaoBD;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

@SuppressWarnings("serial")
public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nome;
	private JLabel lbl_Logradouro;
	private JTextField textField_Logradouro;
	private JLabel lbl_Numero;
	private JTextField textField_Numero;
	private JLabel lbl_Bairro;
	private JTextField textField_Bairro;
	private JLabel lbl_Cidade;
	private JTextField textField_Cidade;
	private JLabel lbl_Telefone;
	private JTextField textField_Telefone;
	private JLabel lbl_Cpf;
	private JTextField textField_cpf;
	private JLabel lbl_NomeRepresentante;
	private JTextField textField_NomeRepresentante;
	private JButton btn_Limpar;
	private JButton btn_Cancelar;
	private JLabel lbl_Titulo_Cad_Cliente;


	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public CadastroCliente() {
		//FRAME E CONTENT PANE *****************************************************************************************************************
		setResizable(false);
		setTitle("Cadastro de Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroCliente.class.getResource("/imagens/icon_cadastro.png")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1061, 410);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//PAINEL PRINCIPAL **********************************************************************************************************************
		JPanel painel_Principal = new JPanel();
		contentPane.add(painel_Principal, BorderLayout.CENTER);
			painel_Principal.setLayout(null);
			
			lbl_Titulo_Cad_Cliente = new JLabel("Cadastro de Cliente");
			lbl_Titulo_Cad_Cliente.setBounds(10, 11, 501, 39);
			lbl_Titulo_Cad_Cliente.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Titulo_Cad_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
			painel_Principal.add(lbl_Titulo_Cad_Cliente);
		
			JLabel lbl_NomeCliente = new JLabel("Nome:");
			lbl_NomeCliente.setBounds(10, 61, 46, 14);
			painel_Principal.add(lbl_NomeCliente);
			
			textField_Nome = new JTextField();
			textField_Nome.setBounds(10, 80, 501, 29);
			textField_Nome.setToolTipText("");
			painel_Principal.add(textField_Nome);
			textField_Nome.setColumns(10);
			
			lbl_Logradouro = new JLabel("Logradouro:");
			lbl_Logradouro.setBounds(10, 120, 87, 14);
			painel_Principal.add(lbl_Logradouro);
			
			textField_Logradouro = new JTextField();
			textField_Logradouro.setBounds(10, 138, 428, 29);
			painel_Principal.add(textField_Logradouro);
			textField_Logradouro.setColumns(10);
			
			lbl_Numero = new JLabel("N\u00FAmero:");
			lbl_Numero.setBounds(449, 120, 62, 14);
			painel_Principal.add(lbl_Numero);
			
			textField_Numero = new JTextField();
			textField_Numero.setBounds(448, 138, 63, 29);
			textField_Numero.setColumns(10);
			painel_Principal.add(textField_Numero);
			
			lbl_Bairro = new JLabel("Bairro:");
			lbl_Bairro.setBounds(10, 178, 46, 14);
			painel_Principal.add(lbl_Bairro);
			
			textField_Bairro = new JTextField();
			textField_Bairro.setBounds(10, 195, 169, 29);
			textField_Bairro.setColumns(10);
			painel_Principal.add(textField_Bairro);
			
			lbl_Cidade = new JLabel("Cidade:");
			lbl_Cidade.setBounds(189, 178, 46, 14);
			painel_Principal.add(lbl_Cidade);
			
			textField_Cidade = new JTextField();
			textField_Cidade.setBounds(189, 195, 169, 29);
			textField_Cidade.setColumns(10);
			painel_Principal.add(textField_Cidade);
			
			lbl_Telefone = new JLabel("Telefone:");
			lbl_Telefone.setBounds(369, 178, 87, 14);
			painel_Principal.add(lbl_Telefone);
			
			textField_Telefone = new JTextField();
			textField_Telefone.setBounds(368, 195, 143, 29);
			textField_Telefone.setColumns(10);
			painel_Principal.add(textField_Telefone);
			
			lbl_Cpf = new JLabel("CPF:");
			lbl_Cpf.setBounds(10, 235, 46, 14);
			painel_Principal.add(lbl_Cpf);
			
			textField_cpf = new JTextField();
			textField_cpf.setBounds(10, 252, 169, 29);
			textField_cpf.setColumns(10);
			painel_Principal.add(textField_cpf);
			
			lbl_NomeRepresentante = new JLabel("Nome do Representante:");
			lbl_NomeRepresentante.setBounds(189, 235, 169, 14);
			painel_Principal.add(lbl_NomeRepresentante);
			
			textField_NomeRepresentante = new JTextField();
			textField_NomeRepresentante.setBounds(189, 252, 322, 29);
			textField_NomeRepresentante.setColumns(10);
			painel_Principal.add(textField_NomeRepresentante);
			
			JLabel lbl_ListaClientes = new JLabel("Listar de Clientes:");
			lbl_ListaClientes.setBounds(548, 61, 109, 14);
			painel_Principal.add(lbl_ListaClientes);
			
			
			//DEFINE O MODELO DO JLIST
			DefaultListModel model = new DefaultListModel();
			
			//LISTA OS CLIENTE EM UMA JLIST
			try {
				//REALIZA A CONEXÃO COM O BD
				ConexaoBD conectar = new ConexaoBD();
				
				ClienteDB clienteBD = new ClienteDB();
				
				
				//ArrayList<Cliente> listaClientes = clienteBD.listarClientes();
				ArrayList<Cliente> listaClientes = clienteBD.listarClientes();
				
				if(listaClientes != null) {
					for(Cliente c: listaClientes) {
						
						model.addElement(c.getNome() + " - " + c.getLogradouro());
						
					}
				}
				
				conectar.fecharConexaoBD();
				
			}
			catch (SQLException ex) {
				System.err.println("Erro na conexão do BD: "+ex.getMessage());
			}
			catch (Exception ex) {
				System.err.println("Erro geral: "+ex.getMessage());
			}
			
			JList list_ListarClientes = new JList(model);
			list_ListarClientes.setBounds(548, 80, 468, 260);
			painel_Principal.add(list_ListarClientes);
			
			JButton btn_Salvar = new JButton("SALVAR");			
			btn_Salvar.setBounds(31, 305, 100, 35);
			btn_Salvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
						//REALIZA A CONEXÃO COM O BD
						ConexaoBD conectar = new ConexaoBD();	
						
						//CRIA A STRING SQL
						String querySQL = "INSERT INTO distribuidora_cosmeticos.cliente (nome, logradouro, numero, bairro, cidade, telefone, cpf, nome_representante) "
								+ "VALUES(?,?,?,?,?,?,?,?)";
						
						//CRIA O COMANDO SQL
						PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
						
						//SETA OS VALORES NA STRING querySQL
						stmt.setString(1, textField_Nome.getText());
						stmt.setString(2, textField_Logradouro.getText());
						stmt.setString(3, textField_Numero.getText());
						stmt.setString(4, textField_Bairro.getText());
						stmt.setString(5, textField_Cidade.getText());
						stmt.setString(6, textField_Telefone.getText());
						stmt.setString(7, textField_cpf.getText());
						stmt.setString(8, textField_NomeRepresentante.getText());
						
						
						//EXECUTA A QUERY NO BANCO DE DADOS
						stmt.executeUpdate();
						System.out.println("Informações Inseridas com Sucesso!!!");
						
						//FECHA O COMANDO STMT E A CONEXÃO
						stmt.close();
						conectar.fecharConexaoBD();
					}
					catch (SQLException ex) {
						System.err.println("Erro na conexão do BD: "+ex.getMessage());
					}
					catch (Exception ex) {
						System.err.println("Erro geral: "+ex.getMessage());
					}					
				}
			});
			painel_Principal.add(btn_Salvar);
			
			btn_Limpar = new JButton("LIMPAR");
			btn_Limpar.setBounds(153, 305, 100, 35);
			painel_Principal.add(btn_Limpar);
			
			JButton btn_Listar = new JButton("BUSCAR");
			btn_Listar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
							
				}
			});
			btn_Listar.setBounds(278, 305, 100, 35);
			painel_Principal.add(btn_Listar);
			
			btn_Cancelar = new JButton("CANCELAR");
			btn_Cancelar.setBounds(399, 305, 100, 35);
			painel_Principal.add(btn_Cancelar);			
	}
}
