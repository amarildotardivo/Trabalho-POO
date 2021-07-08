package apresentacao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Estoque;
import modelo.Fabricante;
import persistencia.ConexaoBD;
import persistencia.EstoqueBD;
import persistencia.FabricanteBD;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings({ "serial", "unused" })
public class TelaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField_NomeProduto;
	private JLabel lbl_Quantidade;
	private JTextField textField_Quantidade;
	private JLabel lbl_TipoProduto;
	private JTextField textField_TipoProduto;
	private JLabel lbl_PrecoCompra;
	private JTextField textField_PrecoCompra;
	private JLabel lbl_PrecoVenda;
	private JTextField textField_PrecoVenda;
	private JLabel lbl_NomeFabricante;
	private JLabel lbl_Titulo_Ger_Produto;
	private JComboBox<Object> comboBox_NomeFabricante;
	private JTextField textField_id;
	private JScrollPane scrollPane;

	
	@SuppressWarnings("unchecked")
	public TelaProduto() {
	
		//FRAME E CONTENT PANE *****************************************************************************************************************
				setResizable(false);
				setTitle("Gerenciamento de Produto");
				setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCliente.class.getResource("/imagens/icon_cadastro.png")));
				setAlwaysOnTop(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setSize(890, 360);
				setLocationRelativeTo(null);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
				
				//PAINEL PRINCIPAL **********************************************************************************************************************
				JPanel painel_Principal = new JPanel();
				contentPane.add(painel_Principal, BorderLayout.CENTER);
				painel_Principal.setLayout(null);
					
					lbl_Titulo_Ger_Produto = new JLabel("Gerenciamento de Produto");
					lbl_Titulo_Ger_Produto.setHorizontalAlignment(SwingConstants.CENTER);
					lbl_Titulo_Ger_Produto.setFont(new Font("Tahoma", Font.PLAIN, 28));
					lbl_Titulo_Ger_Produto.setBounds(10, 11, 854, 39);
					painel_Principal.add(lbl_Titulo_Ger_Produto);

					JLabel lbl_id = new JLabel("ID:");
					lbl_id.setBounds(10, 61, 54, 14);
					painel_Principal.add(lbl_id);
					
					textField_id = new JTextField();
					textField_id.setEditable(false);
					textField_id.setName("");
					textField_id.setColumns(10);
					textField_id.setBounds(10, 80, 46, 29);
					painel_Principal.add(textField_id);
				
					JLabel lbl_NomeProduto = new JLabel("Nome do Produto:");
					lbl_NomeProduto.setBounds(66, 61, 130, 14);
					painel_Principal.add(lbl_NomeProduto);
					
					textField_NomeProduto = new JTextField();
					textField_NomeProduto.setToolTipText("");
					textField_NomeProduto.setBounds(66, 80, 248, 29);
					painel_Principal.add(textField_NomeProduto);
					textField_NomeProduto.setColumns(10);
					
					lbl_Quantidade = new JLabel("Quantidade:");
					lbl_Quantidade.setBounds(324, 61, 87, 14);
					painel_Principal.add(lbl_Quantidade);
					
					textField_Quantidade = new JTextField();
					textField_Quantidade.setBounds(324, 79, 62, 29);
					painel_Principal.add(textField_Quantidade);
					textField_Quantidade.setColumns(10);
					
					lbl_TipoProduto = new JLabel("Tipo de Produto:");
					lbl_TipoProduto.setBounds(11, 120, 105, 14);
					painel_Principal.add(lbl_TipoProduto);
					
					textField_TipoProduto = new JTextField();
					textField_TipoProduto.setColumns(10);
					textField_TipoProduto.setBounds(10, 138, 169, 29);
					painel_Principal.add(textField_TipoProduto);
					
					lbl_PrecoCompra = new JLabel("Pre\u00E7o de Compra:");
					lbl_PrecoCompra.setBounds(10, 178, 130, 14);
					painel_Principal.add(lbl_PrecoCompra);
					
					textField_PrecoCompra = new JTextField();
					textField_PrecoCompra.setColumns(10);
					textField_PrecoCompra.setBounds(10, 195, 186, 29);
					painel_Principal.add(textField_PrecoCompra);
					
					lbl_PrecoVenda = new JLabel("Pre\u00E7o de Venda:");
					lbl_PrecoVenda.setBounds(206, 178, 124, 14);
					painel_Principal.add(lbl_PrecoVenda);
					
					textField_PrecoVenda = new JTextField();
					textField_PrecoVenda.setColumns(10);
					textField_PrecoVenda.setBounds(206, 195, 180, 29);
					painel_Principal.add(textField_PrecoVenda);
					
					lbl_NomeFabricante = new JLabel("Nome do Fabricante:");
					lbl_NomeFabricante.setBounds(189, 120, 197, 14);
					painel_Principal.add(lbl_NomeFabricante);
					
					comboBox_NomeFabricante = new JComboBox<Object>();
					comboBox_NomeFabricante.setBounds(189, 138, 197, 29);
					painel_Principal.add(comboBox_NomeFabricante);
					
					try {
						//Preenchendo o JComboBox de Fabricante
						ConexaoBD conectarBD = new ConexaoBD();
						FabricanteBD fabBD = new FabricanteBD();
						
						ArrayList<Fabricante> listaFab = fabBD.listarFabricantes();
						
						comboBox_NomeFabricante.addItem("Selecione um Fabricante");
						
						for(Fabricante fab: listaFab) {
							comboBox_NomeFabricante.addItem(fab.getNome());
						}
						
					} catch (SQLException ex) {
						System.err.println("Erro na conexão do BD: "+ex.getMessage());
						//Popup de Erro
						TelaErro tErro = new TelaErro("Error de Banco de Dados: " + ex);
						tErro.setVisible(true);
					}
						
					
					JButton btn_Comprar = new JButton("COMPRAR");
					btn_Comprar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								
								//REALIZA A CONEXÃO COM O BD
								ConexaoBD conectar = new ConexaoBD();	
								System.out.println("Conexão Realizada Com Sucesso!!!");
								
								//CRIA A STRING SQL
								String querySQL = "INSERT INTO distribuidora_cosmeticos.estoque (nome_produto, quantidade, preco_compra, preco_venda, tipo_produto, nome_fabricante) "
										+ "VALUES(?,?,?,?,?,?)";
								
								//CRIA O COMANDO SQL
								PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
								
								String nomeFab = (String) comboBox_NomeFabricante.getSelectedItem();
								
								//SETA OS VALORES NA STRING querySQL
								stmt.setString(1, textField_NomeProduto.getText());
								stmt.setInt(2, Integer.parseInt(textField_Quantidade.getText()));
								stmt.setDouble(3, Double.parseDouble(textField_PrecoCompra.getText()));
								stmt.setDouble(4, Double.parseDouble(textField_PrecoVenda.getText()));
								stmt.setString(5, textField_TipoProduto.getText());
								stmt.setString(6, nomeFab);
								
								
								//EXECUTA A QUERY NO BANCO DE DADOS
								stmt.executeUpdate();
								System.out.println("Produto Comprado com Sucesso!!!");
								//Popup de Informação
								TelaInformacao tInformacao = new TelaInformacao("Produto: " + textField_NomeProduto.getText(), "Comprado com Sucesso!");
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
					btn_Comprar.setBounds(55, 260, 100, 35);
					painel_Principal.add(btn_Comprar);
					
					JButton btn_Editar = new JButton("EDITAR");
					btn_Editar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								
								//REALIZA A CONEXÃO COM O BD
								ConexaoBD conectar = new ConexaoBD();	
								System.out.println("Conexão Realizada Com Sucesso!!!");												
									
									//CRIA A STRING SQL
									String querySQL = "UPDATE distribuidora_cosmeticos.estoque SET `nome_produto` = ?, `quantidade` = ?, "
											+ "`preco_compra` = ?, `preco_venda` = ?, `tipo_produto` = ?, `nome_fabricante` = ? "
											+ " WHERE id = ?";
									
									//CRIA O COMANDO SQL
									PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
									
									String nomeFab = (String) comboBox_NomeFabricante.getSelectedItem();
									
									//SETA OS VALORES NA STRING querySQL
									stmt.setString(1, textField_NomeProduto.getText());
									stmt.setInt(2, Integer.parseInt(textField_Quantidade.getText()));
									stmt.setDouble(3, Double.parseDouble(textField_PrecoCompra.getText()));
									stmt.setDouble(4, Double.parseDouble(textField_PrecoVenda.getText()));
									stmt.setString(5, textField_TipoProduto.getText());
									stmt.setString(6, nomeFab);
									stmt.setInt(7, Integer.parseInt(textField_id.getText()));
									
									//EXECUTA A QUERY NO BANCO DE DADOS
									int rowsAffected = stmt.executeUpdate();
									System.out.println("Atualizado: "+ rowsAffected+" linha(s)");
									System.out.println("Fabricante Editado com Sucesso!!!");
									//Popup de Informação
									TelaInformacao tInformacao = new TelaInformacao("Produto: " + textField_NomeProduto.getText(), "Editado com Sucesso!");
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
					btn_Editar.setBounds(180, 260, 100, 35);
					painel_Principal.add(btn_Editar);
					
					JButton btn_Buscar = new JButton("BUSCAR");
					btn_Buscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								//REALIZA A CONEXÃO COM O BD
								ConexaoBD conectar = new ConexaoBD();
								System.out.println("Conexão Realizada Com Sucesso!!!");
								
								EstoqueBD estBd = new EstoqueBD();
														
								//TRÁS DO BANCO DE DADOS TODOS OS CLIENTES CADASTRADOS
								ArrayList<Estoque> listaProdutos = estBd.BuscarProduto(textField_NomeProduto.getText());
								
								if(listaProdutos != null) {
									for(Estoque est: listaProdutos) {
										textField_id.setText("" + est.getId());
										textField_NomeProduto.setText("" + est.getNome_produto());
										textField_Quantidade.setText("" + est.getQuantidade());
										textField_PrecoCompra.setText("" + est.getPreco_compra());
										textField_PrecoVenda.setText("" + est.getPreco_venda());
										textField_TipoProduto.setText("" + est.getTipo_produto());
										comboBox_NomeFabricante.setSelectedItem((Object) est.getNome_fabricante());
										
									}
									System.out.println("Busca do Produto Realizada Com Sucesso!!!");
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
					btn_Buscar.setBounds(306, 260, 100, 35);
					painel_Principal.add(btn_Buscar);
					
					JButton btn_Deletar = new JButton("DELETAR");
					btn_Deletar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								Estoque est = new Estoque(Integer.parseInt(textField_id.getText()),textField_NomeProduto.getText(), textField_TipoProduto.getText(),
										Integer.parseInt(textField_Quantidade.getText()), Double.parseDouble(textField_PrecoCompra.getText()) , Double.parseDouble(textField_PrecoVenda.getText()), 
										 String.valueOf(comboBox_NomeFabricante.getSelectedItem()) );
								
								EstoqueBD estBd = new EstoqueBD();
								estBd.DeletarProduto(est);
								//Popup de Informação
								TelaInformacao tInformacao = new TelaInformacao("Produto: " + textField_NomeProduto.getText(), "Deletado com Sucesso!");
								tInformacao.setVisible(true);
								
							} catch (Exception ex) {
								//Popup de Erro
								TelaErro tErro = new TelaErro("Error: " + ex);
								tErro.setVisible(true);
							}
						}
					});
					btn_Deletar.setBounds(430, 260, 100, 35);
					painel_Principal.add(btn_Deletar);
					
					JButton btn_Limpar = new JButton("LIMPAR");
					btn_Limpar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textField_id.setText("");
							textField_NomeProduto.setText("");
							textField_TipoProduto.setText("");
							textField_Quantidade.setText("");
							textField_PrecoCompra.setText("");
							textField_PrecoVenda.setText("");
						}
					});
					btn_Limpar.setBounds(553, 260, 100, 35);
					painel_Principal.add(btn_Limpar);
					
					//DEFINE O MODELO DO JLIST
					@SuppressWarnings("rawtypes")
					DefaultListModel model = new DefaultListModel();	
					
					//LISTA OS FABRICANTES EM UMA JLIST
					try {
						//REALIZA A CONEXÃO COM O BD
						ConexaoBD conectar = new ConexaoBD();
						System.out.println("Conexão do JList com  BD Realizada Com Sucesso!!!");
						
						EstoqueBD estBd = new EstoqueBD();					
						
						//TRÁS DO BANCO DE DADOS TODOS OS CLIENTES CADASTRADOS
						ArrayList<Estoque> listaProdutos = estBd.listarProdutos();
						
						
						if(listaProdutos != null) {
							for(Estoque est: listaProdutos) {
								
								model.addElement(est.getId()+": "+ est.getNome_produto() + " - " + est.getTipo_produto() + " - " + est.getQuantidade() + " - " + 
								est.getPreco_compra() + " - " + est.getPreco_venda() + " - " + est.getNome_fabricante() );
								
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
					
					JLabel lbl_ListaFabricantes = new JLabel("Lista de Fabricantes:");
					lbl_ListaFabricantes.setBounds(396, 61, 158, 14);
					painel_Principal.add(lbl_ListaFabricantes);					
					
					scrollPane = new JScrollPane();
					scrollPane.setBounds(397, 82, 467, 142);
					painel_Principal.add(scrollPane);
					
					
					@SuppressWarnings("rawtypes")
					JList list_ListarProdutos = new JList(model);
					scrollPane.setViewportView(list_ListarProdutos);
					list_ListarProdutos.setBorder(new EmptyBorder(5, 5, 5, 5));
					
					JButton btn_ListarProdutos = new JButton("LISTAR PRODUTOS");
					btn_ListarProdutos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//LISTA OS FABRICANTES EM UMA JLIST
							try {
								//REALIZA A CONEXÃO COM O BD
								ConexaoBD conectar = new ConexaoBD();
								System.out.println("Conexão do JList com  BD Realizada Com Sucesso!!!");
								
								EstoqueBD estBd = new EstoqueBD();					
								
								//TRÁS DO BANCO DE DADOS TODOS OS CLIENTES CADASTRADOS
								ArrayList<Estoque> listaProdutos = estBd.listarProdutos();
								
								model.clear();
								if(listaProdutos != null) {
									for(Estoque est: listaProdutos) {
										
										model.addElement(est.getId()+": "+ est.getNome_produto() + " - " + est.getTipo_produto() + " - " + est.getQuantidade() + " - " + 
										est.getPreco_compra() + " - " + est.getPreco_venda() + " - " + est.getNome_fabricante() );
										
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
						}
					});
					btn_ListarProdutos.setBounds(676, 260, 148, 35);
					painel_Principal.add(btn_ListarProdutos);
					
					
					
	}
}
