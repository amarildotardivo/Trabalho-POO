package apresentacao;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;
import persistencia.ClienteDB;
import persistencia.ConexaoBD;
import persistencia.ProdutoBD;
import persistencia.VendaBD;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

@SuppressWarnings("serial")
public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField text_Preco_Unitario;

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public TelaVenda() {
		setTitle("Vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(890, 360);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCliente.class.getResource("/imagens/icon_cadastro.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbl_Titulo_Venda = new JLabel("Vendas");
		lbl_Titulo_Venda.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titulo_Venda.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lbl_Titulo_Venda.setBounds(10, 11, 854, 39);
		panel.add(lbl_Titulo_Venda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 80, 453, 168);
		panel.add(scrollPane);
		
		JLabel lbl_NomeCliente = new JLabel("Cliente:");
		lbl_NomeCliente.setBounds(10, 61, 197, 14);
		panel.add(lbl_NomeCliente);
		
		JComboBox<Object> comboBox_NomeCliente = new JComboBox<Object>();
		comboBox_NomeCliente.setBounds(10, 80, 377, 29);
		panel.add(comboBox_NomeCliente);
		
		try {
			//Preenchendo o JComboBox de Clientes
			ConexaoBD conectarBD = new ConexaoBD();
			ClienteDB cliBD = new ClienteDB();
			
			ArrayList<Cliente> listaCli = cliBD.listarClientes();
			
			comboBox_NomeCliente.addItem("Selecione um Cliente");
			
			for(Cliente cli: listaCli) {
				comboBox_NomeCliente.addItem(cli.getNome());
			}
			
			conectarBD.fecharConexaoBD();
		} catch (SQLException ex) {
			System.err.println("Erro na conexão do BD: "+ex.getMessage());
			//Popup de Erro
			TelaErro tErro = new TelaErro("Error de Banco de Dados: " + ex);
			tErro.setVisible(true);
		}
		
		JLabel lbl_Quantidade = new JLabel("Quant.:");
		lbl_Quantidade.setBounds(341, 132, 60, 14);
		panel.add(lbl_Quantidade);
		
		JSpinner spinner_Quantidade = new JSpinner();
		spinner_Quantidade.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_Quantidade.setBounds(341, 151, 46, 29);
		panel.add(spinner_Quantidade);
		
		JLabel lbl_NomeProduto = new JLabel("Produto:");
		lbl_NomeProduto.setBounds(10, 132, 197, 14);
		panel.add(lbl_NomeProduto);
		
		JComboBox<Object> comboBox_NomeProduto = new JComboBox<Object>();
		comboBox_NomeProduto.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				
				String querySQL = "SELECT * FROM distribuidora_cosmeticos.estoque WHERE nome_produto = ?";
				
				try {
					ConexaoBD con = new ConexaoBD();
					PreparedStatement ps = con.conectarBD().prepareStatement(querySQL);
					ps.setString(1,(String) comboBox_NomeProduto.getSelectedItem());
					
					ResultSet rs = ps.executeQuery();
					
					if(comboBox_NomeProduto.getSelectedItem().equals("Selecione um Produto") == true) {
						text_Preco_Unitario.setText("");
					}
					
					if(rs.next()) {						
						String preco_uni = Double.toString(rs.getDouble("preco_venda"));
						text_Preco_Unitario.setText(preco_uni);
					}
				} catch (Exception e2) {
					System.err.println("Erro ao tentar mostrar o Preço unitário! "+ e2);
				}
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		comboBox_NomeProduto.setBounds(10, 151, 321, 29);
		panel.add(comboBox_NomeProduto);
		
		try {
			//Preenchendo o JComboBox de Clientes
			ConexaoBD conectarBD = new ConexaoBD();
			ProdutoBD estBD = new ProdutoBD();
			
			ArrayList<Produto> listaEst = estBD.listarProdutos();
			
			comboBox_NomeProduto.addItem("Selecione um Produto");
			
			for(Produto est: listaEst) {
				comboBox_NomeProduto.addItem(est.getNome_produto());
			}
			
			conectarBD.fecharConexaoBD();
		} catch (SQLException ex) {
			System.err.println("Erro na conexão do BD: "+ex.getMessage());
			//Popup de Erro
			TelaErro tErro = new TelaErro("Error de Banco de Dados: " + ex);
			tErro.setVisible(true);
		}
		
		JButton btn_Vender = new JButton("VENDER");
		btn_Vender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					//REALIZA A CONEXÃO COM O BD
					ConexaoBD conectar = new ConexaoBD();	
					System.out.println("Conexão Realizada Com Sucesso!!!");
					
					//CRIA A STRING SQL
					String querySQL = "INSERT INTO distribuidora_cosmeticos.venda (nome_cliente, nome_produto, quantidade, preco_unitario, total) "
							+ "VALUES(?,?,?, ?, ?)";
					
					//CRIA O COMANDO SQL
					PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
					
					String nomeCli = (String) comboBox_NomeCliente.getSelectedItem();
					String nomeProd = (String) comboBox_NomeProduto.getSelectedItem();
					
					//SETA OS VALORES NA STRING querySQL
					stmt.setString(1, nomeCli);
					stmt.setString(2, nomeProd);
					stmt.setInt(3, (Integer) spinner_Quantidade.getValue());
					stmt.setDouble(4, Double.parseDouble(text_Preco_Unitario.getText()));
					
					
					//SQL PARA DIMINUIR A QUANTIDADE DO PRODUTO
					//CRIA A STRING SQL
					String quantidadeSQL = "UPDATE distribuidora_cosmeticos.estoque SET `quantidade` = ? WHERE `nome_produto` = ?";
					
					//CRIA O COMANDO SQL
					PreparedStatement pst = conectar.conectarBD().prepareStatement(quantidadeSQL);
					
					//BUSCA A QUANTIDADE DO PRODUTO EM ESTOQUE E DIMINUI COM A QUANTIDADE VENDIDA
					String nome_produto = (String) comboBox_NomeProduto.getSelectedItem();
					
					ProdutoBD estBD = new ProdutoBD();
					
					ArrayList<Produto> listaEstoque = estBD.BuscarProduto(nome_produto);
					int quantProdEst = 0;
						for(Produto est: listaEstoque) {
							quantProdEst = est.getQuantidade();
						}
					
					int quantProdSolicitada = (int)spinner_Quantidade.getValue();
																
					int quantProdVenda = quantProdEst - quantProdSolicitada;
										
					//SETA OS VALORES NA STRING querySQL
					pst.setInt(1, quantProdVenda);
					pst.setString(2, nome_produto);
					
					//VERIFICA SE A VENDA PODE SER REALIZADA
					if( (comboBox_NomeCliente.getSelectedItem().toString() != "Selecione um Cliente") && (comboBox_NomeProduto.getSelectedItem().toString() != "Selecione um Produto") ) {
						if( (quantProdEst >= quantProdSolicitada) && (quantProdEst > 0) ) {

							//CALCULA O TOTAL DA COMPRA DESEJADA 
							double preco_uni = Double.parseDouble(text_Preco_Unitario.getText());
							int quant = (Integer)spinner_Quantidade.getValue();
							double total = preco_uni * quant;
							
							String nome_prod = comboBox_NomeProduto.getSelectedItem().toString();
							
							Object[] options = { "Sim, posso pagar!", "Não, não tenho Dinheiro!" };
							int pagamento = JOptionPane.showOptionDialog(panel, 
									
									"Sua compra do produto: "+ nome_prod +" tatoliza: R$"+ total + "\nDeseja realizar a compra?", "Total", 
									
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
							
							//VERIFICA SE O USUÁRIO DESEJA PROSSEGUIR COM A COMPRA
							if(pagamento == JOptionPane.YES_OPTION){
								stmt.setDouble(5, total);
								//EXECUTA A QUERY NO BANCO DE DADOS PARA REALIZAR A VENDA
								stmt.executeUpdate();
								//EXECUTA A QUERY NO BANCO DE DADOS PARA ATUALIZAR O ESTOQUE
								pst.executeUpdate();
								
								System.out.println("Venda Realizada com Sucesso!!!");
								//Popup de Informação
								TelaInformacao tInformacao = new TelaInformacao("Venda: " + comboBox_NomeCliente.getSelectedItem(), "Realizada com Sucesso!");
								tInformacao.setVisible(true);
								
							}else {
								System.out.println("O cliente desistiu de comprar o produto: "+ nome_prod);
								JOptionPane.showMessageDialog(panel,"Compra Cancelada!", "Cancelamento", JOptionPane.INFORMATION_MESSAGE);								
							}
							
						}else {
							System.out.println("Venda Não pode ser Realizada!");
							//Popup de Informação
							TelaInformacao tInformacao = new TelaInformacao("O Item: " + comboBox_NomeProduto.getSelectedItem(), "Não possui quantidade suficiente!");
							tInformacao.setVisible(true);
						}
						
					}else {
						System.out.println("Venda Não pode ser Realizada!");
						//Popup de Informação
						TelaInformacao tInformacao = new TelaInformacao("O Produto e/ou Cliente: ", "Não Foi Selecionado!");
						tInformacao.setVisible(true);
					}
					
					//FECHA O COMANDO STMT E A CONEXÃO
					stmt.close();
					pst.close();
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
		btn_Vender.setBounds(10, 259, 100, 35);
		panel.add(btn_Vender);
		
		//DEFINE O MODELO DO JLIST
		@SuppressWarnings("rawtypes")
		DefaultListModel model = new DefaultListModel();	
		
		//LISTA OS FABRICANTES EM UMA JLIST
		try {
			//REALIZA A CONEXÃO COM O BD
			ConexaoBD conectar = new ConexaoBD();
			System.out.println("Conexão do JList com  BD Realizada Com Sucesso!!!");
			
			VendaBD vendaBD = new VendaBD();					
			
			//TRÁS DO BANCO DE DADOS TODOS OS CLIENTES CADASTRADOS
			ArrayList<Venda> listaVendas = vendaBD.listarVendas();
			
			
			if(listaVendas != null) {
				for(Venda venda: listaVendas) {
					
					model.addElement(venda.getId()+": "+ venda.getNome_cliente() + " - " + venda.getNome_produto() + " - " + venda.getQuantidade() + " - " + venda.getPreco_unitario() + " - " + venda.getTotal() );
					
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

		JLabel lbl_ListaVendas = new JLabel("Lista de Vendas Realizadas:");
		lbl_ListaVendas.setBounds(410, 61, 211, 14);
		panel.add(lbl_ListaVendas);
		
		@SuppressWarnings("rawtypes")
		JList list_ListarVendas = new JList(model);
		scrollPane.setViewportView(list_ListarVendas);
		list_ListarVendas.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btn_ListarVendas = new JButton("LISTAR VENDAS");
		btn_ListarVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LISTA OS FABRICANTES EM UMA JLIST
				try {
					//REALIZA A CONEXÃO COM O BD
					ConexaoBD conectar = new ConexaoBD();
					System.out.println("Conexão do JList com  BD Realizada Com Sucesso!!!");
					
					VendaBD vendaBD = new VendaBD();					
					
					//TRÁS DO BANCO DE DADOS TODOS OS CLIENTES CADASTRADOS
					ArrayList<Venda> listaVendas = vendaBD.listarVendas();
					
					model.clear();
					if(listaVendas != null) {
						for(Venda venda: listaVendas) {
							
							model.addElement(venda.getId()+": "+ venda.getNome_cliente() + " - " + venda.getNome_produto() + " - " + venda.getQuantidade() + " - " + venda.getPreco_unitario() + " - " + venda.getTotal() );
							
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
		btn_ListarVendas.setBounds(411, 259, 148, 35);
		panel.add(btn_ListarVendas);
		
		JLabel lbl_Preco_Unitario = new JLabel("Pre\u00E7o unit\u00E1rio:");
		lbl_Preco_Unitario.setBounds(10, 191, 100, 14);
		panel.add(lbl_Preco_Unitario);
		
		text_Preco_Unitario = new JTextField();
		text_Preco_Unitario.setEditable(false);
		text_Preco_Unitario.setBounds(10, 210, 86, 29);
		panel.add(text_Preco_Unitario);
		text_Preco_Unitario.setColumns(10);
		
	}
}

