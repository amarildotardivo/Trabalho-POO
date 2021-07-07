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

import modelo.Venda;
import persistencia.VendaBD;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class TelaRelatorioVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	
	public TelaRelatorioVendas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRelatorioCliente.class.getResource("/imagens/icon_cadastro.png")));
		setTitle("Relat\u00F3rio de Vendas");
		setAlwaysOnTop(true);
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
					"ID", "Nome do Cliente", "Nome do Produto", "Quantidade"
			}
		));
		table.setFont(table.getFont().deriveFont(Font.BOLD));
		
		DefaultTableModel tModel = new DefaultTableModel();
		
		tModel.addColumn("ID");
		tModel.addColumn("Nome do Cliente");
		tModel.addColumn("Nome do Produto");
		tModel.addColumn("Quantidade");
		
		VendaBD vendaBD = new VendaBD();
		ArrayList<Venda> listaVendas = vendaBD.listarVendas();
		
		if(listaVendas.isEmpty() == false) {
			for(Venda venda: listaVendas) {
				tModel.addRow(new String[] {
						String.valueOf(venda.getId()), 
						venda.getNome_cliente(),
						venda.getNome_produto(),
						Integer.toString(venda.getQuantidade())						
				});
			}
			table.setModel(tModel);
		}
		
		
		JLabel Label_Titulo = new JLabel("Relat\u00F3rio de Vendas");
		Label_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Titulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Label_Titulo.setBounds(0, 11, 854, 36);
		panel.add(Label_Titulo);
		
	}
}
