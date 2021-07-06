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

import modelo.Fabricante;
import persistencia.FabricanteBD;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class TelaRelatorioFabricante extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	
	public TelaRelatorioFabricante() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRelatorioCliente.class.getResource("/imagens/icon_cadastro.png")));
		setTitle("Relat\u00F3rio de Clientes");
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
					"ID", "Nome", "Logradouro", "Numero", "Bairro", "Cidade", "Telefone", "CPF", "Região" 
			}
		));
		table.setFont(table.getFont().deriveFont(Font.BOLD));
		
		DefaultTableModel tModel = new DefaultTableModel();
		
		tModel.addColumn("ID");
		tModel.addColumn("Nome");
		tModel.addColumn("Logradouro");
		tModel.addColumn("Numero");
		tModel.addColumn("Bairro");
		tModel.addColumn("Cidade");
		tModel.addColumn("Telefone");
		tModel.addColumn("CNPJ");
		
		FabricanteBD fabBD = new FabricanteBD();
		ArrayList<Fabricante> listaFabricantes = fabBD.listarFabricantes();
		
		if(listaFabricantes.isEmpty() == false) {
			for(Fabricante fab: listaFabricantes) {
				tModel.addRow(new String[] {
						String.valueOf(fab.getId()), 
						fab.getNome(), 
						fab.getLogradouro(), 
						fab.getNumero(), 
						fab.getBairro(), 
						fab.getCidade(), 
						fab.getTelefone(), 
						fab.getCnpj()						
				});
			}
			table.setModel(tModel);
		}
		
		
		JLabel Label_Titulo = new JLabel("Relat\u00F3rio de Fabricantes");
		Label_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Titulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Label_Titulo.setBounds(0, 11, 854, 36);
		panel.add(Label_Titulo);
		
	}
}