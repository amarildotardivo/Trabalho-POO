package apresentacao;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import modelo.Produto;
import persistencia.ProdutoBD;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class TelaRelatorioProdutos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	
	public TelaRelatorioProdutos() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRelatorioCliente.class.getResource("/imagens/icon_cadastro.png")));
		setTitle("Relat\u00F3rio de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(890, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Label_Titulo = new JLabel("Relat\u00F3rio de Produtos");
		Label_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Titulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Label_Titulo.setBounds(0, 11, 854, 36);
		panel.add(Label_Titulo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 844, 359);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(20);
		table.setIntercellSpacing(new Dimension(5, 5));
		table.setToolTipText("");
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Nome do Produto", "Tipo do Produto", "Preço Compra", "Preço Venda", "Nome Fabricante", "Quantidade"
			}
		));
		table.setFont(table.getFont().deriveFont(Font.BOLD));
		
		DefaultTableModel tModel = new DefaultTableModel();
		
		tModel.addColumn("ID");
		tModel.addColumn("Nome do Produto");
		tModel.addColumn("Tipo do Produto");
		tModel.addColumn("Preço Compra");
		tModel.addColumn("Preço Venda");
		tModel.addColumn("Nome Fabricante");
		tModel.addColumn("Quantidade");
		
		ProdutoBD estBD = new ProdutoBD();
		ArrayList<Produto> listaEstoque = estBD.listarProdutos();
		
		if(listaEstoque.isEmpty() == false) {
			for(Produto est: listaEstoque) {
				tModel.addRow(new String[] {
						String.valueOf(est.getId()), 
						est.getNome_produto(), 
						est.getTipo_produto(), 
						Double.toString(est.getPreco_compra()), 
						Double.toString(est.getPreco_venda()), 
						est.getNome_fabricante(), 
						Integer.toString(est.getQuantidade())						
				});
			}
			table.setModel(tModel);
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(40);//ID
		table.getColumnModel().getColumn(0).setMaxWidth(60);//ID
		table.getColumnModel().getColumn(1).setPreferredWidth(150);//NOME PRODUTO
		table.getColumnModel().getColumn(2).setPreferredWidth(100);//TIPO PRODUTO
		table.getColumnModel().getColumn(3).setPreferredWidth(55);//PREÇO COMPRA
		table.getColumnModel().getColumn(4).setPreferredWidth(80);//PREÇO VENDA
		table.getColumnModel().getColumn(5).setPreferredWidth(80);//NOME FABRICANTE
		table.getColumnModel().getColumn(6).setPreferredWidth(80);//QUANTIDADE
		
	}
}