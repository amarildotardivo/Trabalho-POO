package apresentacao;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Dimension;
import javax.swing.JMenuItem;
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

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	@SuppressWarnings("deprecation")
	public TelaPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imagens/icon_distribuidora.png")));
		setTitle("Sistema de Distribuidora de Cosm\u00E9ticos");
		
		//FRAME *****************************************************************************************************
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
			//MENU CLIENTE ************************************************************************************************
			JMenu mnCliente = new JMenu("Cliente");
			mnCliente.setFont(new Font("Segoe UI", Font.BOLD, 12));
			menuBar_Principal.add(mnCliente);
			
				JMenuItem Menu_Cadastro_Clientes = new JMenuItem("Cadastrar Cliente ...");
				Menu_Cadastro_Clientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
				Menu_Cadastro_Clientes.setHorizontalAlignment(SwingConstants.LEFT);
				
				Menu_Cadastro_Clientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						CadastroCliente cad_cliente = new CadastroCliente();
						cad_cliente.setVisible(true);
					}
				});
				mnCliente.add(Menu_Cadastro_Clientes);
				
				JMenuItem Menu_Deletar_Cliente = new JMenuItem("Deletar Cliente");
				mnCliente.add(Menu_Deletar_Cliente);
				
				JMenuItem Menu_Listar_Clientes = new JMenuItem("Listar Clientes");
				mnCliente.add(Menu_Listar_Clientes);
			
			//MENU REPRESENTANTE ******************************************************************************************
			JMenu Menu_Representante = new JMenu("Representante");
			menuBar_Principal.add(Menu_Representante);
			
				JMenuItem Menu_Cadastrar_Representante = new JMenuItem("Cadastrar Representante");
				Menu_Cadastrar_Representante.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CadastroRepresentante cad_Representante = new CadastroRepresentante();
						cad_Representante.setVisible(true);
					}
				});
				Menu_Representante.add(Menu_Cadastrar_Representante);
				
				JMenuItem Menu_Deletar_Representante = new JMenuItem("Deletar Representante");
				Menu_Representante.add(Menu_Deletar_Representante);
				
				JMenuItem Menu_Listar_Representantes = new JMenuItem("Listar Representantes");
				Menu_Representante.add(Menu_Listar_Representantes);
			
			//MENU FABRICANTE *******************************************************************************************
			JMenu Menu_Fabricante = new JMenu("Fabricante");
			menuBar_Principal.add(Menu_Fabricante);
			
				JMenuItem Menu_Cadastrar_Fabricante = new JMenuItem("Cadastrar Fabricante");
				Menu_Cadastrar_Fabricante.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CadastroFabricante cad_Fabricante = new CadastroFabricante();
						cad_Fabricante.setVisible(true);
					}
				});
				Menu_Fabricante.add(Menu_Cadastrar_Fabricante);
				
				JMenuItem Menu_Deletar_Fabricante = new JMenuItem("Deletar Fabricante");
				Menu_Fabricante.add(Menu_Deletar_Fabricante);
				
				JMenuItem Menu_Listar_Fabricantes = new JMenuItem("Listar Fabricantes");
				Menu_Fabricante.add(Menu_Listar_Fabricantes);
			
			//MENU ESTOQUE ***************************************************************************************************
			JMenu Menu_Estoque = new JMenu("Estoque");
			menuBar_Principal.add(Menu_Estoque);
			
				JMenuItem Menu_Cadastrar_Produto = new JMenuItem("Cadastrar Produto");
				Menu_Cadastrar_Produto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CadastroProduto cad_Produto = new CadastroProduto();
						cad_Produto.setVisible(true);
					}
				});
				Menu_Estoque.add(Menu_Cadastrar_Produto);
				
				JMenuItem Menu_Comprar_Produto = new JMenuItem("Comprar Produto");
				Menu_Estoque.add(Menu_Comprar_Produto);
				
				JMenuItem Menu_Listar_Produtos = new JMenuItem("Listar Produtos");
				Menu_Estoque.add(Menu_Listar_Produtos);
			
			//MENU VENDA ********************************************************************************************************
			JMenu Menu_Venda = new JMenu("Venda");
			menuBar_Principal.add(Menu_Venda);
			
				JMenuItem Menu_Realizar_Venda = new JMenuItem("Realizar Venda");
				Menu_Venda.add(Menu_Realizar_Venda);
		
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
			
			
	}

}
