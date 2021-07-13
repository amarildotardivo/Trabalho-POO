package apresentacao;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	@SuppressWarnings("deprecation")
	public TelaPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imagens/icon_distribuidora.png")));
		setTitle("Sistema de Distribuidora de Cosm\u00E9ticos");
		
		//FRAME *****************************************************************************************************
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		
		//PAINEL DO MENUBAR PRINCIPAL ******************************************************************************************
		JPanel painel_Menu_Principal = new JPanel();
		getContentPane().add(painel_Menu_Principal, BorderLayout.NORTH);
		painel_Menu_Principal.setPreferredSize(new Dimension(900,30));
		painel_Menu_Principal.setLayout(new GridLayout(0, 1, 0, 0));
		
		//MENUBAR PRINCIPAL *******************************************************************************************
		JMenuBar menuBar_Principal = new JMenuBar();
		menuBar_Principal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		painel_Menu_Principal.add(menuBar_Principal);
			
			JMenu mnArquivo = new JMenu("Arquivo");
			menuBar_Principal.add(mnArquivo);
			
			JMenuItem Menu_Sobre = new JMenuItem("Sobre");
			Menu_Sobre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"Instituto Federal Fluminense - IFF Campos (Campus Centro)"
							+ "\nDisciplina de Programaçao Orientada a Objetos"
							+ "\nAplicação em Java usando Banco de Dados - versão 3.0"
							+ "\nDesenvolvido por: @amarildotardivo","Sobre a Aplicação",JOptionPane.INFORMATION_MESSAGE);
				}
			});
			Menu_Sobre.setPreferredSize(new Dimension(200, 30));
			mnArquivo.add(Menu_Sobre);
			
			JSeparator separator = new JSeparator();
			mnArquivo.add(separator);
			
			JMenuItem Menu_Sair = new JMenuItem("Sair");
			Menu_Sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_END, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
			Menu_Sair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizarSistema();
				}
			});
			Menu_Sair.setPreferredSize(new Dimension(71, 30));
			mnArquivo.add(Menu_Sair);
		
			//MENU CLIENTE ************************************************************************************************
			JMenu Menu_Cliente = new JMenu("Cliente");
			Menu_Cliente.setFont(new Font("Segoe UI", Font.BOLD, 12));
			menuBar_Principal.add(Menu_Cliente);
			
				JMenuItem Menu_Cadastro_Clientes = new JMenuItem("Gerenciar Cliente");
				Menu_Cadastro_Clientes.setPreferredSize(new Dimension(300, 30));
				Menu_Cadastro_Clientes.setHorizontalTextPosition(SwingConstants.LEFT);
				Menu_Cadastro_Clientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
				Menu_Cadastro_Clientes.setHorizontalAlignment(SwingConstants.LEFT);
				
				Menu_Cadastro_Clientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						TelaCliente cad_cliente = new TelaCliente();
						cad_cliente.setVisible(true);
					}
				});
				Menu_Cliente.add(Menu_Cadastro_Clientes);
				
				JMenuItem Menu_Listar_Clientes = new JMenuItem("Relat\u00F3rio de Clientes");
				Menu_Listar_Clientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaRelatorioCliente relatCli = new TelaRelatorioCliente();
						relatCli.setVisible(true);
					}
				});
				Menu_Listar_Clientes.setPreferredSize(new Dimension(125, 30));
				Menu_Cliente.add(Menu_Listar_Clientes);
			
			//MENU REPRESENTANTE ******************************************************************************************
			JMenu Menu_Representante = new JMenu("Representante");
			menuBar_Principal.add(Menu_Representante);
			
				JMenuItem Menu_Gerenciar_Representante = new JMenuItem("Gerenciar Representante");
				Menu_Gerenciar_Representante.setPreferredSize(new Dimension(300, 30));
				Menu_Gerenciar_Representante.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
				Menu_Gerenciar_Representante.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaRepresentante cad_Representante = new TelaRepresentante();
						cad_Representante.setVisible(true);
					}
				});
				Menu_Representante.add(Menu_Gerenciar_Representante);
				
				JMenuItem Menu_Listar_Representantes = new JMenuItem("Relat\u00F3rio de Representantes");
				Menu_Listar_Representantes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaRelatorioRepresentante relatRep = new TelaRelatorioRepresentante();
						relatRep.setVisible(true);
					}
				});
				Menu_Listar_Representantes.setPreferredSize(new Dimension(163, 30));
				Menu_Representante.add(Menu_Listar_Representantes);
			
			//MENU FABRICANTE *******************************************************************************************
			JMenu Menu_Fabricante = new JMenu("Fabricante");
			menuBar_Principal.add(Menu_Fabricante);
			
				JMenuItem Menu_Gerenciar_Fabricante = new JMenuItem("Gerenciar Fabricante");
				Menu_Gerenciar_Fabricante.setPreferredSize(new Dimension(300, 30));
				Menu_Gerenciar_Fabricante.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
				Menu_Gerenciar_Fabricante.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaFabricante cad_Fabricante = new TelaFabricante();
						cad_Fabricante.setVisible(true);
					}
				});
				Menu_Fabricante.add(Menu_Gerenciar_Fabricante);
				
				JMenuItem Menu_Listar_Fabricantes = new JMenuItem("Relat\u00F3rio de Fabricantes");
				Menu_Listar_Fabricantes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaRelatorioFabricante relatFab = new TelaRelatorioFabricante();
						relatFab.setVisible(true);
					}
				});
				Menu_Listar_Fabricantes.setPreferredSize(new Dimension(143, 30));
				Menu_Fabricante.add(Menu_Listar_Fabricantes);
			
			//MENU ESTOQUE ***************************************************************************************************
			JMenu Menu_Estoque = new JMenu("Estoque");
			menuBar_Principal.add(Menu_Estoque);
			
				JMenuItem Menu_Gerenciar_Produto = new JMenuItem("Gerenciar Produto");
				Menu_Gerenciar_Produto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
				Menu_Gerenciar_Produto.setPreferredSize(new Dimension(200, 30));
				Menu_Gerenciar_Produto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaProduto cad_Produto = new TelaProduto();
						cad_Produto.setVisible(true);
					}
				});
				Menu_Estoque.add(Menu_Gerenciar_Produto);
				
				JMenuItem Menu_Listar_Produtos = new JMenuItem("Relat\u00F3rio de Produtos");
				Menu_Listar_Produtos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaRelatorioProdutos relatEst = new TelaRelatorioProdutos();
						relatEst.setVisible(true);
					}
				});
				Menu_Listar_Produtos.setPreferredSize(new Dimension(131, 30));
				Menu_Estoque.add(Menu_Listar_Produtos);
			
			//MENU VENDA ********************************************************************************************************
			JMenu Menu_Venda = new JMenu("Venda");
			menuBar_Principal.add(Menu_Venda);
			
				JMenuItem Menu_Realizar_Venda = new JMenuItem("Realizar Venda");
				Menu_Realizar_Venda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.CTRL_MASK));
				Menu_Realizar_Venda.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaVenda venda = new TelaVenda();
						venda.setVisible(true);
					}
				});
				Menu_Realizar_Venda.setPreferredSize(new Dimension(200, 30));
				Menu_Venda.add(Menu_Realizar_Venda);
				
				JMenuItem Menu_Listar_Vendas = new JMenuItem("Relat\u00F3rio de Vendas");
				Menu_Listar_Vendas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaRelatorioVendas relatVenda = new TelaRelatorioVendas();
						relatVenda.setVisible(true);
					}
				});
				Menu_Listar_Vendas.setPreferredSize(new Dimension(200, 30));
				Menu_Venda.add(Menu_Listar_Vendas);
		
		//PANEL WALLPAPER *******************************************************************************************************
		JPanel painel_Wallpaper = new JPanel();
		getContentPane().add(painel_Wallpaper, BorderLayout.CENTER);
		painel_Wallpaper.setLayout(null);
		
			//LABEL QUE CONTÊM A IMAGEM DE WALLPAPER *******************************************************************************
			JLabel Label_Wallpaper = new JLabel("");
			Label_Wallpaper.setBounds(0, 0, 894, 541);
			Label_Wallpaper.setIconTextGap(0);
			Label_Wallpaper.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/wallpaper_O.jpg")));
			painel_Wallpaper.add(Label_Wallpaper);
			
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					finalizarSistema();
				}
			});
	}
	
	public void finalizarSistema() {
		Object[] options = { "Sim, Absoluta!", "Não, Cliquei sem querer!" };
		int sair = JOptionPane.showOptionDialog(null, 
				"Tem certeza que deseja encerrar o Sistema?", "Atenção!!!", 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(sair == JOptionPane.YES_OPTION){
			System.out.println("Sistema Finalizado com Sucesso!");
			System.exit(0);
		}else {
			System.out.println("Foi cancelada a ação de encerrar o sistema!");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}
	
}
