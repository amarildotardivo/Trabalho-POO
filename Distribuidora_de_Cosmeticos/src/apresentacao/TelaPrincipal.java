package apresentacao;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import scripts_bd.ConexaoBD;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
		//FRAME *****************************************************************************************************
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		
		//PAINEL DO MENUBAR ******************************************************************************************
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(900,30));
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		//MENUBAR PRINCIPAL *******************************************************************************************
		JMenuBar menuBar_Principal = new JMenuBar();
		menuBar_Principal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel.add(menuBar_Principal);
		
		//MENU CLIENTE ************************************************************************************************
		JMenu Menu_Cliente = new JMenu("Clientes");
		Menu_Cliente.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar_Principal.add(Menu_Cliente);
		
			JMenuItem Menu_Cadastro_Clientes = new JMenuItem("Cadastrar Cliente");
			
			Menu_Cadastro_Clientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadastroCliente cad_cliente = new CadastroCliente();
					cad_cliente.setVisible(true);
					//JOptionPane.showMessageDialog(null,"Teste");
				}
			});
			Menu_Cliente.add(Menu_Cadastro_Clientes);
			
			JMenuItem Menu_Deletar_Cliente = new JMenuItem("Deletar Cliente");
			Menu_Cliente.add(Menu_Deletar_Cliente);
			
			JMenuItem Menu_Listar_Clientes = new JMenuItem("Listar Clientes");
			Menu_Cliente.add(Menu_Listar_Clientes);
		
		//MENU REPRESENTANTE ******************************************************************************************
		JMenu Menu_Representante = new JMenu("Representante");
		menuBar_Principal.add(Menu_Representante);
		
			JMenuItem Menu_Cadastrar_Representante = new JMenuItem("Cadastrar Representante");
			Menu_Representante.add(Menu_Cadastrar_Representante);
			
			JMenuItem Menu_Deletar_Representante = new JMenuItem("Deletar Representante");
			Menu_Representante.add(Menu_Deletar_Representante);
			
			JMenuItem Menu_Listar_Representantes = new JMenuItem("Listar Representantes");
			Menu_Representante.add(Menu_Listar_Representantes);
		
		//MENU REPRESENTANTE *******************************************************************************************
		JMenu Menu_Fabricante = new JMenu("Fabricante");
		menuBar_Principal.add(Menu_Fabricante);
		
			JMenuItem Menu_Cadastrar_Fabricante = new JMenuItem("Cadastrar Fabricante");
			Menu_Fabricante.add(Menu_Cadastrar_Fabricante);
			
			JMenuItem Menu_Deletar_Fabricante = new JMenuItem("Deletar Fabricante");
			Menu_Fabricante.add(Menu_Deletar_Fabricante);
			
			JMenuItem Menu_Listar_Fabricantes = new JMenuItem("Listar Fabricantes");
			Menu_Fabricante.add(Menu_Listar_Fabricantes);
		
		//MENU ESTOQUE ***************************************************************************************************
		JMenu Menu_Estoque = new JMenu("Estoque");
		menuBar_Principal.add(Menu_Estoque);
		
			JMenuItem Menu_Cadastrar_Produto = new JMenuItem("Cadastrar Produto");
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
	}

}
