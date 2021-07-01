package apresentacao;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Estoque;
import modelo.Fabricante;
import modelo.Venda;
import persistencia.ClienteDB;
import persistencia.ConexaoBD;
import persistencia.EstoqueBD;
import persistencia.FabricanteBD;
import persistencia.VendaBD;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;


	@SuppressWarnings({ "unchecked", "deprecation" })
	public TelaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(890, 360);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCliente.class.getResource("/imagens/icon_cadastro.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbl_id = new JLabel("ID:");
		lbl_id.setBounds(10, 61, 46, 14);
		panel.add(lbl_id);
		
		textField_id = new JTextField();
		textField_id.setName("");
		textField_id.setColumns(10);
		textField_id.setBounds(10, 80, 46, 29);
		panel.add(textField_id);		
		
		JLabel lbl_Titulo_Venda = new JLabel("Vendas");
		lbl_Titulo_Venda.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titulo_Venda.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lbl_Titulo_Venda.setBounds(10, 11, 854, 39);
		panel.add(lbl_Titulo_Venda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 80, 453, 142);
		panel.add(scrollPane);
		
		JLabel lbl_NomeCliente = new JLabel("Cliente:");
		lbl_NomeCliente.setBounds(66, 61, 197, 14);
		panel.add(lbl_NomeCliente);
		
		JComboBox<Object> comboBox_NomeCliente = new JComboBox<Object>();
		comboBox_NomeCliente.setBounds(66, 80, 321, 29);
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
		
		JLabel lbl_NomeProduto = new JLabel("Produto:");
		lbl_NomeProduto.setBounds(10, 132, 197, 14);
		panel.add(lbl_NomeProduto);
		
		JComboBox<Object> comboBox_NomeProduto = new JComboBox<Object>();
		comboBox_NomeProduto.setBounds(10, 151, 321, 29);
		panel.add(comboBox_NomeProduto);
		
		try {
			//Preenchendo o JComboBox de Clientes
			ConexaoBD conectarBD = new ConexaoBD();
			EstoqueBD estBD = new EstoqueBD();
			
			ArrayList<Estoque> listaEst = estBD.listarProdutos();
			
			comboBox_NomeProduto.addItem("Selecione um Produto");
			
			for(Estoque est: listaEst) {
				comboBox_NomeProduto.addItem(est.getNome_produto());
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
		
		JButton btn_Vender = new JButton("VENDER");
		btn_Vender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					//REALIZA A CONEXÃO COM O BD
					ConexaoBD conectar = new ConexaoBD();	
					System.out.println("Conexão Realizada Com Sucesso!!!");
					
					//CRIA A STRING SQL
					String querySQL = "INSERT INTO distribuidora_cosmeticos.venda (id, nome_cliente, nome_produto, quantidade) "
							+ "VALUES(?,?,?,?)";
					
					//CRIA O COMANDO SQL
					PreparedStatement stmt = conectar.conectarBD().prepareStatement(querySQL);
					
					String nomeCli = (String) comboBox_NomeCliente.getSelectedItem();
					String nomeProd = (String) comboBox_NomeProduto.getSelectedItem();
					
					//SETA OS VALORES NA STRING querySQL
					stmt.setInt(1, Integer.parseInt(textField_id.getText()) );
					stmt.setString(2, nomeCli);
					stmt.setString(3, nomeProd);
					stmt.setInt(4, (Integer) spinner_Quantidade.getValue());
					
					
					//EXECUTA A QUERY NO BANCO DE DADOS
					stmt.executeUpdate();
					System.out.println("Produto Comprado com Sucesso!!!");
					//Popup de Informação
					TelaInformacao tInformacao = new TelaInformacao("Venda: " + comboBox_NomeCliente.getSelectedItem(), "Realizada com Sucesso!");
					tInformacao.setVisible(true);
					
					//SQL PARA DIMINUIR A QUANTIDADE DO PRODUTO
					//CRIA A STRING SQL
					String quantidadeSQL = "UPDATE distribuidora_cosmeticos.estoque SET `quantidade` = ? WHERE `nome_produto` = ?";
					
					//CRIA O COMANDO SQL
					PreparedStatement pst = conectar.conectarBD().prepareStatement(quantidadeSQL);
					
					//BUSCA A QUANTIDADE DO PRODUTO EM ESTOQUE E DIMINUI COM A QUANTIDADE VENDIDA
					String nome_produto = (String) comboBox_NomeProduto.getSelectedItem();
					EstoqueBD estBD = new EstoqueBD();
					ArrayList<Estoque> listaEstoque = estBD.BuscarProduto(nome_produto);
					int quantProdEst = 0;
						for(Estoque est: listaEstoque) {
							quantProdEst = est.getQuantidade();
						}
							
					int quantProdVenda = quantProdEst - (int)spinner_Quantidade.getValue();
					
					//SETA OS VALORES NA STRING querySQL
					pst.setInt(1, quantProdVenda);
					pst.setString(2, nome_produto);
					
					//EXECUTA A QUERY NO BANCO DE DADOS
					pst.executeUpdate();
					
					
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
		btn_Vender.setBounds(50, 259, 100, 35);
		panel.add(btn_Vender);
		
		JButton btn_Editar = new JButton("EDITAR");
		btn_Editar.setBounds(175, 259, 100, 35);
		panel.add(btn_Editar);
		
		JButton btn_Buscar = new JButton("BUSCAR");
		btn_Buscar.setBounds(301, 259, 100, 35);
		panel.add(btn_Buscar);
		
		JButton btn_Deletar = new JButton("DELETAR");
		btn_Deletar.setBounds(425, 259, 100, 35);
		panel.add(btn_Deletar);
		
		JButton btn_Limpar = new JButton("LIMPAR");
		btn_Limpar.setBounds(548, 259, 100, 35);
		panel.add(btn_Limpar);
		
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
					
					model.addElement(venda.getId()+": "+ venda.getNome_cliente() + " - " + venda.getNome_produto() + " - " + venda.getQuantidade() );
					
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
							
							model.addElement(venda.getId()+": "+ venda.getNome_cliente() + " - " + venda.getNome_produto() + " - " + venda.getQuantidade() );
							
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
		btn_ListarVendas.setBounds(671, 259, 148, 35);
		panel.add(btn_ListarVendas);
		
	}
}
