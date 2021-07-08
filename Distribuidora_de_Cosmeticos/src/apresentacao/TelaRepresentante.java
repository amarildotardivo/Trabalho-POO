package apresentacao;

import modelo.Representante;
import persistencia.ConexaoBD;
import persistencia.RepresentanteBD;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class TelaRepresentante extends JFrame {

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
	private JLabel lbl_Regiao;
	private JTextField textField_Regiao;
	private JLabel lbl_Titulo_Representante;
	private JTextField textField_id;
	private JButton btn_ListarClientes;
	private JScrollPane scrollPane;

	public TelaRepresentante() {
		//FRAME E CONTENT PANE *****************************************************************************************************************
				setResizable(false);
				setTitle("Gerenciamento de Representante");
				setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRepresentante.class.getResource("/imagens/icon_cadastro.png")));
				setAlwaysOnTop(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setSize(880, 410);
				setLocationRelativeTo(null);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
				
				//PAINEL PRINCIPAL **********************************************************************************************************************
				JPanel painel_Principal = new JPanel();
				contentPane.add(painel_Principal, BorderLayout.CENTER);
				painel_Principal.setLayout(null);
					
					lbl_Titulo_Representante = new JLabel("Gerenciamento de Representante");
					lbl_Titulo_Representante.setHorizontalAlignment(SwingConstants.CENTER);
					lbl_Titulo_Representante.setFont(new Font("Tahoma", Font.PLAIN, 28));
					lbl_Titulo_Representante.setBounds(10, 11, 844, 39);
					painel_Principal.add(lbl_Titulo_Representante);
					
					JLabel lbl_id = new JLabel("ID:");
					lbl_id.setBounds(10, 56, 54, 14);
					painel_Principal.add(lbl_id);
					
					textField_id = new JTextField();
					textField_id.setEditable(false);
					textField_id.setName("");
					textField_id.setColumns(10);
					textField_id.setBounds(10, 75, 46, 29);
					painel_Principal.add(textField_id);
				
					JLabel lbl_NomeRepresentante = new JLabel("Nome:");
					lbl_NomeRepresentante.setBounds(66, 56, 100, 14);
					painel_Principal.add(lbl_NomeRepresentante);
					
					textField_Nome = new JTextField();
					textField_Nome.setToolTipText("");
					textField_Nome.setBounds(66, 75, 292, 29);
					painel_Principal.add(textField_Nome);
					textField_Nome.setColumns(10);
					
					lbl_Logradouro = new JLabel("Logradouro:");
					lbl_Logradouro.setBounds(10, 115, 87, 14);
					painel_Principal.add(lbl_Logradouro);
					
					textField_Logradouro = new JTextField();
					textField_Logradouro.setBounds(10, 133, 275, 29);
					painel_Principal.add(textField_Logradouro);
					textField_Logradouro.setColumns(10);
					
					lbl_Numero = new JLabel("N\u00FAmero:");
					lbl_Numero.setBounds(296, 115, 62, 14);
					painel_Principal.add(lbl_Numero);
					
					textField_Numero = new JTextField();
					textField_Numero.setColumns(10);
					textField_Numero.setBounds(295, 133, 63, 29);
					painel_Principal.add(textField_Numero);
					
					lbl_Bairro = new JLabel("Bairro:");
					lbl_Bairro.setBounds(10, 173, 46, 14);
					painel_Principal.add(lbl_Bairro);
					
					textField_Bairro = new JTextField();
					textField_Bairro.setColumns(10);
					textField_Bairro.setBounds(10, 190, 169, 29);
					painel_Principal.add(textField_Bairro);
					
					lbl_Cidade = new JLabel("Cidade:");
					lbl_Cidade.setBounds(189, 173, 46, 14);
					painel_Principal.add(lbl_Cidade);
					
					textField_Cidade = new JTextField();
					textField_Cidade.setColumns(10);
					textField_Cidade.setBounds(189, 190, 169, 29);
					painel_Principal.add(textField_Cidade);
					
					lbl_Telefone = new JLabel("Telefone:");
					lbl_Telefone.setBounds(11, 230, 62, 14);
					painel_Principal.add(lbl_Telefone);
					
					textField_Telefone = new JTextField();
					textField_Telefone.setColumns(10);
					textField_Telefone.setBounds(10, 247, 138, 29);
					painel_Principal.add(textField_Telefone);
					
					lbl_Cpf = new JLabel("CPF:");
					lbl_Cpf.setBounds(158, 230, 46, 14);
					painel_Principal.add(lbl_Cpf);
					
					textField_cpf = new JTextField();
					textField_cpf.setColumns(10);
					textField_cpf.setBounds(158, 247, 136, 29);
					painel_Principal.add(textField_cpf);
					
					lbl_Regiao = new JLabel("Regi\u00E3o:");
					lbl_Regiao.setBounds(304, 230, 54, 14);
					painel_Principal.add(lbl_Regiao);
					
					textField_Regiao = new JTextField();
					textField_Regiao.setColumns(10);
					textField_Regiao.setBounds(304, 247, 54, 29);
					painel_Principal.add(textField_Regiao);
					
					//FUNÇÃO DE INCLUIR NO BANCO DE DADOS
					JButton btn_Salvar = new JButton("SALVAR");
					btn_Salvar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								
								//REALIZA A CONEXÃO COM O BD
								ConexaoBD conectar = new ConexaoBD();	
								System.out.println("Conexão Realizada Com Sucesso!!!");
								
								//CRIA A STRING SQL
								String querySQL = "INSERT INTO distribuidora_cosmeticos.representante (nome, logradouro, numero, bairro, cidade, telefone, cpf, regiao) "
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
								stmt.setString(8, textField_Regiao.getText());
								
								
								//EXECUTA A QUERY NO BANCO DE DADOS
								stmt.executeUpdate();
								System.out.println("Representante Cadastrado com Sucesso!!!");
								//Popup de Informação
								TelaInformacao tInformacao = new TelaInformacao("Representante: " + textField_Nome.getText(), "Salvo com Sucesso!");
								tInformacao.setVisible(true);
								
								//FECHA O COMANDO STMT E A CONEXÃO
								stmt.close();
								conectar.fecharConexaoBD();
								System.out.println("Conexão Encerrada Com Sucesso!!!");
							}
							catch (SQLException ex) {
								System.err.println("Erro na conexão do BD: "+ex.getMessage());
								//Popup de Erro
								TelaErro tErro = new TelaErro("Error de Banco de Dados: " + ex);
								tErro.setVisible(true);
							}
							catch (Exception ex) {
								System.err.println("Erro geral: "+ex.getMessage());
								//Popup de Erro
								TelaErro tErro = new TelaErro("Error: " + ex);
								tErro.setVisible(true);
							}
						}
					});
					btn_Salvar.setBounds(54, 307, 100, 35);
					painel_Principal.add(btn_Salvar);
					
					//FUNÇÃO DE ALTERAR NO BANCO DE DADOS
					JButton btn_Editar = new JButton("EDITAR");
					btn_Editar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								
								//REALIZA A CONEXÃO COM O BD
								ConexaoBD conectar = new ConexaoBD();	
								System.out.println("Conexão Realizada Com Sucesso!!!");														
									
									//CRIA A STRING SQL
									String querySQL = "UPDATE distribuidora_cosmeticos.representante SET `nome` = ?, `logradouro` = ?, "
											+ "`numero` = ?, `bairro` = ?, `cidade` = ?, `telefone` = ?, `cpf` = ?, `regiao` = ? "
											+ " WHERE id = ?";
									
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
									stmt.setString(8, textField_Regiao.getText());
									stmt.setInt(9, Integer.parseInt(textField_id.getText()));
									
									//EXECUTA A QUERY NO BANCO DE DADOS
									int rowsAffected = stmt.executeUpdate();
									System.out.println("Atualizado: "+ rowsAffected+" linha(s)");
									System.out.println("Representante Cadastrado com Sucesso!!!");
									//Popup de Informação
									TelaInformacao tInformacao = new TelaInformacao("Representante: " + textField_Nome.getText(), "Editado com Sucesso!");
									tInformacao.setVisible(true);
									
									//FECHA O COMANDO STMT E A CONEXÃO
									stmt.close();
									conectar.fecharConexaoBD();
									System.out.println("Conexão Encerrada Com Sucesso!!!");

							}
							catch (SQLException ex) {
								System.err.println("Erro na conexão do BD: "+ex.getMessage());
								//Popup de Erro
								TelaErro tErro = new TelaErro("Error de Banco de Dados: " + ex);
								tErro.setVisible(true);
							}
							catch (Exception ex) {
								System.err.println("Erro geral: "+ex.getMessage());
								//Popup de Erro
								TelaErro tErro = new TelaErro("Error: " + ex);
								tErro.setVisible(true);
							}
						}
					});
					btn_Editar.setBounds(179, 307, 100, 35);
					painel_Principal.add(btn_Editar);
					
					//FUNÇÃO DE CONSULTAR NO BANCO DE DADOS
					JButton btn_Buscar = new JButton("BUSCAR");
					btn_Buscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								//REALIZA A CONEXÃO COM O BD
								ConexaoBD conectar = new ConexaoBD();
								System.out.println("Conexão Realizada Com Sucesso!!!");
								
								RepresentanteBD repBd = new RepresentanteBD();
														
								//TRÁS DO BANCO DE DADOS TODOS OS CLIENTES CADASTRADOS
								ArrayList<Representante> listaRepresentantes = repBd.BuscarRepresentante(textField_Nome.getText());
								
								if(listaRepresentantes != null) {
									for(Representante r: listaRepresentantes) {
										textField_id.setText("" + r.getId());
										textField_Nome.setText("" + r.getNome());
										textField_Logradouro.setText("" + r.getLogradouro());
										textField_Numero.setText("" + r.getNumero());
										textField_Bairro.setText("" + r.getBairro());
										textField_Cidade.setText("" + r.getCidade());
										textField_Telefone.setText("" + r.getTelefone());
										textField_cpf.setText("" + r.getCpf());
										textField_Regiao.setText("" + r.getRegiao());
										
									}
									System.out.println("Busca do Representante Realizada Com Sucesso!!!");
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
					btn_Buscar.setBounds(305, 307, 100, 35);
					painel_Principal.add(btn_Buscar);
					
					//FUNÇÃO DE DELETAR DO BANCO DE DADOS
					JButton btn_Deletar = new JButton("DELETAR");
					btn_Deletar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								Representante rep = new Representante(Integer.parseInt(textField_id.getText()),textField_Nome.getText(), textField_Logradouro.getText(),
										textField_Numero.getText(), textField_Bairro.getText(), textField_Cidade.getText(), 
										textField_Telefone.getText(), textField_cpf.getText(), textField_Regiao.getText());
								
								RepresentanteBD repBd = new RepresentanteBD();
								repBd.DeletarRepresentante(rep);
								
								System.out.println("Representante Deletado com sucesso!");
								//Popup de Informação
								TelaInformacao tInformacao = new TelaInformacao("Representante: " + textField_Nome.getText(), "Deletado com Sucesso!");
								tInformacao.setVisible(true);
							} 
							catch (Exception ex) {
								System.err.println("Erro geral: "+ex.getMessage());
								//Popup de Erro
								TelaErro tErro = new TelaErro("Error: " + ex);
								tErro.setVisible(true);
							}
						}
					});
					btn_Deletar.setBounds(429, 307, 100, 35);
					painel_Principal.add(btn_Deletar);
					
					JButton btn_Limpar = new JButton("LIMPAR");
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
							textField_Regiao.setText("");
						}
					});
					btn_Limpar.setBounds(552, 307, 100, 35);
					painel_Principal.add(btn_Limpar);
					
					JLabel lbl_ListaClientes = new JLabel("Lista de Clientes:");
					lbl_ListaClientes.setBounds(368, 56, 100, 14);
					painel_Principal.add(lbl_ListaClientes);
					
					scrollPane = new JScrollPane();
					scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
					scrollPane.setBounds(368, 77, 475, 199);
					painel_Principal.add(scrollPane);
					
					JTextArea textArea_ListaRepresentantes = new JTextArea();
					textArea_ListaRepresentantes.setBorder(UIManager.getBorder("TextField.border"));
					scrollPane.setViewportView(textArea_ListaRepresentantes);
					
					textArea_ListaRepresentantes.setText("");
					
					//LISTA OS REPRESENTANTES EM UMA TEXTAREA
					try {
						//REALIZA A CONEXÃO COM O BD
						ConexaoBD conectar = new ConexaoBD();
						System.out.println("Conexão da TextArea com  BD Realizada Com Sucesso!!!");
						
						RepresentanteBD repBd = new RepresentanteBD();
						
						
						//TRÁS DO BANCO DE DADOS TODOS OS REPRESENTANTES CADASTRADOS
						ArrayList<Representante> listaRepresentantes = repBd.listarRepresentantes();
						if(listaRepresentantes != null) {
							for(Representante r: listaRepresentantes) {
								
								textArea_ListaRepresentantes.setText(textArea_ListaRepresentantes.getText() + 
										r.getId() + ": " +
										r.getNome() + " - " +
										r.getLogradouro() + " Nº: " +
										r.getNumero() + " - " +
										r.getBairro() + " / " +
										r.getCidade() + " Tel.: " +
										r.getTelefone() + " CPF: " +
										r.getCpf() + " Reg.: " +
										r.getRegiao()+"\n");
								
							}
						}
						
						conectar.fecharConexaoBD();
						System.out.println("Conexão da TextArea com  BD Encerrada Com Sucesso!!!");
						
					}
					catch (SQLException ex) {
						System.err.println("Erro na conexão do BD: "+ex.getMessage());
					}
					catch (Exception ex) {
						System.err.println("Erro geral: "+ex.getMessage());
					}
					
					//BOTÃO QUE LISTA TODOS OS REPRESENTANTES NA TEXTAREA
					btn_ListarClientes = new JButton("LISTAR CLIENTES");
					btn_ListarClientes.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//LISTA OS REPRESENTANTES EM UMA TEXTAREA
							try {
								//REALIZA A CONEXÃO COM O BD
								ConexaoBD conectar = new ConexaoBD();
								System.out.println("Conexão da TextArea com  BD Realizada Com Sucesso!!!");
								
								RepresentanteBD repBd = new RepresentanteBD();
								
								
								//TRÁS DO BANCO DE DADOS TODOS OS REPRESENTANTES CADASTRADOS
								ArrayList<Representante> listaRepresentantes = repBd.listarRepresentantes();
								
								textArea_ListaRepresentantes.setText("");
								if(listaRepresentantes != null) {
									for(Representante r: listaRepresentantes) {
										
										textArea_ListaRepresentantes.setText(textArea_ListaRepresentantes.getText() + 
												r.getId() + ": " +
												r.getNome() + " - " +
												r.getLogradouro() + " Nº: " +
												r.getNumero() + " - " +
												r.getBairro() + " / " +
												r.getCidade() + " Tel.: " +
												r.getTelefone() + " CPF: " +
												r.getCpf() + " Reg.: " +
												r.getRegiao()+ "\n");
										
									}
								}
								
								conectar.fecharConexaoBD();
								System.out.println("Conexão da TextArea com  BD Encerrada Com Sucesso!!!");
								
							}
							catch (SQLException ex) {
								System.err.println("Erro na conexão do BD: "+ex.getMessage());
							}
							catch (Exception ex) {
								System.err.println("Erro geral: "+ex.getMessage());
							}
						}
					});
					btn_ListarClientes.setBounds(675, 307, 138, 35);
					painel_Principal.add(btn_ListarClientes);
	}
}
