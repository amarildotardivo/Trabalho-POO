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

import java.awt.Color;

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
	private JButton btn_Deletar;
	private JLabel lbl_Titulo_Cad_Cliente;
	private JButton btn_Atualizar;
	private JLabel lbl_id;
	private JTextField textField_id;

	@SuppressWarnings("unchecked")
	public CadastroCliente() {
		//FRAME E CONTENT PANE *****************************************************************************************************************
		setResizable(false);
		setTitle("Gerenciamento de Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroCliente.class.getResource("/imagens/icon_cadastro.png")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1061, 410);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//PAINEL PRINCIPAL **********************************************************************************************************************
		JPanel painel_Principal = new JPanel();
		contentPane.add(painel_Principal, BorderLayout.CENTER);
			painel_Principal.setLayout(null);
			
			lbl_Titulo_Cad_Cliente = new JLabel("Gerenciamento do Cliente");
			lbl_Titulo_Cad_Cliente.setBounds(10, 11, 428, 39);
			lbl_Titulo_Cad_Cliente.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_Titulo_Cad_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
			painel_Principal.add(lbl_Titulo_Cad_Cliente);
			
			lbl_id = new JLabel("ID:");
			lbl_id.setBounds(10, 61, 54, 14);
			painel_Principal.add(lbl_id);
			
			textField_id = new JTextField();
			textField_id.setBounds(10, 80, 62, 29);
			painel_Principal.add(textField_id);
			textField_id.setColumns(10);
		
			JLabel lbl_NomeCliente = new JLabel("Nome:");
			lbl_NomeCliente.setBounds(84, 61, 427, 14);
			painel_Principal.add(lbl_NomeCliente);
			
			textField_Nome = new JTextField();
			textField_Nome.setBounds(84, 80, 427, 29);
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
			
			JLabel lbl_ListaClientes = new JLabel("Lista de Clientes:");
			lbl_ListaClientes.setBounds(548, 61, 109, 14);
			painel_Principal.add(lbl_ListaClientes);
			
			//DEFINE O MODELO DO JLIST
			@SuppressWarnings("rawtypes")
			DefaultListModel model = new DefaultListModel();
			
			//LISTA OS CLIENTE EM UMA JLIST
			try {
				//REALIZA A CONEXÃO COM O BD
				ConexaoBD conectar = new ConexaoBD();
				System.out.println("Conexão do JList com  BD Realizada Com Sucesso!!!");
				
				ClienteDB clienteBD = new ClienteDB();
				
				
				//TRÁS DO BANCO DE DADOS TODOS OS CLIENTES CADASTRADOS
				ArrayList<Cliente> listaClientes = clienteBD.listarClientes();
				
				if(listaClientes != null) {
					for(Cliente c: listaClientes) {
						
						model.addElement(c.getId()+": "+ c.getNome() + " - " + c.getLogradouro() + " - " + c.getNumero() + " - " + 
						c.getBairro() + " - " + c.getCidade() + " - " + c.getTelefone() + " - " + c.getCpf() + " - " + c.getNome_representante());
						
					}
				}
				
				conectar.fecharConexaoBD();
				System.out.println("Conexão do JList com  BD Encerrada Com Sucesso!!!");
				
			}
			catch (SQLException ex) {
				System.err.println("Erro na conexão do BD: "+ex.getMessage());
			}
			catch (Exception ex) {
				System.err.println("Erro geral: "+ex.getMessage());
			}
			
			@SuppressWarnings("rawtypes")
			JList list_ListarClientes = new JList(model);
			list_ListarClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
			list_ListarClientes.setBounds(548, 80, 468, 201);
			painel_Principal.add(list_ListarClientes);
			
			//FUNÇÃO DE INCLUIR NO BANCO DE DADOS
			JButton btn_Salvar = new JButton("SALVAR");			
			btn_Salvar.setBounds(10, 305, 100, 35);
			btn_Salvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
						//REALIZA A CONEXÃO COM O BD
						ConexaoBD conectar = new ConexaoBD();	
						System.out.println("Conexão Realizada Com Sucesso!!!");
						
						//CRIA A STRING SQL
						String querySQL = "INSERT INTO distribuidora_cosmeticos.cliente (id, nome, logradouro, numero, bairro, cidade, telefone, cpf, nome_representante) "
								+ "VALUES(?,?,?,?,?,?,?,?,?)";
						
						//CRIA O COMANDO SQL
						PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
						
						//SETA OS VALORES NA STRING querySQL
						stmt.setInt(1, Integer.parseInt(textField_id.getText()) );
						stmt.setString(2, textField_Nome.getText());
						stmt.setString(3, textField_Logradouro.getText());
						stmt.setString(4, textField_Numero.getText());
						stmt.setString(5, textField_Bairro.getText());
						stmt.setString(6, textField_Cidade.getText());
						stmt.setString(7, textField_Telefone.getText());
						stmt.setString(8, textField_cpf.getText());
						stmt.setString(9, textField_NomeRepresentante.getText());
						
						
						//EXECUTA A QUERY NO BANCO DE DADOS
						stmt.executeUpdate();
						System.out.println("Cliente Cadastrado com Sucesso!!!");
						
						//FECHA O COMANDO STMT E A CONEXÃO
						stmt.close();
						conectar.fecharConexaoBD();
						System.out.println("Conexão Encerrada Com Sucesso!!!");
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
			
			//FUNÇÃO DE ALTERAR NO BANCO DE DADOS
			btn_Atualizar = new JButton("ATUALIZAR");
			btn_Atualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
						//REALIZA A CONEXÃO COM O BD
						ConexaoBD conectar = new ConexaoBD();	
						System.out.println("Conexão Realizada Com Sucesso!!!");
						
							//if(textField_Nome.getText().equals("")) {
							int id = Integer.parseInt(textField_id.getText());
							String nome = textField_Nome.getText();
							String logradouro = textField_Logradouro.getText();
							String numero = textField_Numero.getText();
							String bairro = textField_Bairro.getText();
							String cidade = textField_Cidade.getText();
							String telefone = textField_Telefone.getText();
							String cpf = textField_cpf.getText();
							String nome_representante = textField_NomeRepresentante.getText();
												
//							String querySQL = "UPDATE `distribuidora_cosmeticos`.`cliente` SET `nome` = 'teste', `logradouro` = 'rua 888' WHERE nome = 'teste' ";
							
//							//CRIA A STRING SQL
							String querySQL = "UPDATE distribuidora_cosmeticos.cliente SET `nome` = ?, `logradouro` = ?, "
									+ "`numero` = ?, `bairro` = ?, `cidade` = ?, `telefone` = ?, `cpf` = ?, `nome_representante` = ? "
									+ " WHERE id = ?";
							
							//CRIA O COMANDO SQL
							PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
							
							//SETA OS VALORES NA STRING querySQL
							stmt.setString(1, nome);
							stmt.setString(2, logradouro);
							stmt.setString(3, numero);
							stmt.setString(4, bairro);
							stmt.setString(5, cidade);
							stmt.setString(6, telefone);
							stmt.setString(7, cpf);
							stmt.setString(8, nome_representante);
							stmt.setInt(9, id);
							
							//EXECUTA A QUERY NO BANCO DE DADOS
							

							int rowsAffected = stmt.executeUpdate();
							System.out.println("Atualizado :"+ rowsAffected+" linha(s)");
							
							System.out.println("Cliente Cadastrado com Sucesso!!!");
							
							//FECHA O COMANDO STMT E A CONEXÃO
							stmt.close();
							conectar.fecharConexaoBD();
							System.out.println("Conexão Encerrada Com Sucesso!!!");
							
					//	}

					}
					catch (SQLException ex) {
						System.err.println("Erro na conexão do BD: "+ex.getMessage());
					}
					catch (Exception ex) {
						System.err.println("Erro geral: "+ex.getMessage());
					}
					finally {
						
					}
				}
			});
			btn_Atualizar.setBounds(135, 305, 100, 35);
			painel_Principal.add(btn_Atualizar);
			
			btn_Limpar = new JButton("LIMPAR");
			btn_Limpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField_id.setText("");
					textField_Nome.setText("");
					textField_Logradouro.setText("");
					textField_Numero.setText("");
					textField_Bairro.setText("");
					textField_Cidade.setText("");
					textField_Telefone.setText("");
					textField_cpf.setText("");
					textField_NomeRepresentante.setText("");
				}
			});
			btn_Limpar.setBounds(508, 305, 100, 35);
			painel_Principal.add(btn_Limpar);
			
			//FUNÇÃO DE CONSULTAR NO BANCO DE DADOS
			JButton btn_Buscar = new JButton("BUSCAR");
			btn_Buscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//REALIZA A CONEXÃO COM O BD
						ConexaoBD conectar = new ConexaoBD();
						System.out.println("Conexão Realizada Com Sucesso!!!");
						
						ClienteDB clienteBD = new ClienteDB();
												
						//TRÁS DO BANCO DE DADOS TODOS OS CLIENTES CADASTRADOS
						ArrayList<Cliente> listaClientes = clienteBD.BuscarCliente(textField_Nome.getText());
						
						if(listaClientes != null) {
							for(Cliente c: listaClientes) {
								textField_id.setText("" + c.getId());
								textField_Nome.setText("" + c.getNome());
								textField_Logradouro.setText("" + c.getLogradouro());
								textField_Numero.setText("" + c.getNumero());
								textField_Bairro.setText("" + c.getBairro());
								textField_Cidade.setText("" + c.getCidade());
								textField_Telefone.setText("" + c.getTelefone());
								textField_cpf.setText("" + c.getCpf());
								textField_NomeRepresentante.setText("" + c.getNome_representante());
								
							}
							System.out.println("Busca do Cliente Realizada Com Sucesso!!!");
						}
						
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
			btn_Buscar.setBounds(261, 305, 100, 35);
			painel_Principal.add(btn_Buscar);
			
			//FUNÇÃO DE DELETAR DO BANCO DE DADOS
			btn_Deletar = new JButton("DELETAR");
			btn_Deletar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
					Cliente c = new Cliente(Integer.parseInt(textField_id.getText()),textField_Nome.getText(), textField_Logradouro.getText(),
							textField_Numero.getText(), textField_Bairro.getText(), textField_Cidade.getText(), 
							textField_Telefone.getText(), textField_cpf.getText(), textField_NomeRepresentante.getText());
					
					ClienteDB cbd = new ClienteDB();
					cbd.DeletarCliente(c);
					
				}
			});
			btn_Deletar.setBounds(385, 305, 100, 35);
			painel_Principal.add(btn_Deletar);
	}
}
