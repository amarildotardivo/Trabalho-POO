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

import modelo.Representante;
import persistencia.RepresentanteBD;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class TelaRelatorioRepresentante extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	
	public TelaRelatorioRepresentante() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRelatorioCliente.class.getResource("/imagens/icon_cadastro.png")));
		setTitle("Relat\u00F3rio de Representantes");
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
		
		JLabel Label_Titulo = new JLabel("Relat\u00F3rio de Representantes");
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
					"ID", "Nome", "Logradouro", "Numero", "Bairro", "Cidade", "Telefone", "CPF", "Regi?o" 
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
		tModel.addColumn("CPF");
		tModel.addColumn("Regi?o");
		
		RepresentanteBD repDB = new RepresentanteBD();
		ArrayList<Representante> listaRepresentantes = repDB.listarRepresentantes();
		
		if(listaRepresentantes.isEmpty() == false) {
			for(Representante rep: listaRepresentantes) {
				tModel.addRow(new String[] {
						String.valueOf(rep.getId()), 
						rep.getNome(), 
						rep.getLogradouro(), 
						rep.getNumero(), 
						rep.getBairro(), 
						rep.getCidade(), 
						rep.getTelefone(), 
						rep.getCpf(), 
						rep.getRegiao() });
			}
			table.setModel(tModel);
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(40);//ID
		table.getColumnModel().getColumn(0).setMaxWidth(60);//ID
		table.getColumnModel().getColumn(1).setPreferredWidth(150);//NOME
		table.getColumnModel().getColumn(2).setPreferredWidth(100);//LOGRADOURO
		table.getColumnModel().getColumn(3).setPreferredWidth(55);//NUMERO
		table.getColumnModel().getColumn(4).setPreferredWidth(80);//BAIRRO
		table.getColumnModel().getColumn(5).setPreferredWidth(80);//CIDADE
		table.getColumnModel().getColumn(6).setPreferredWidth(80);//TEL
		table.getColumnModel().getColumn(7).setPreferredWidth(120);//CPF
		table.getColumnModel().getColumn(8).setPreferredWidth(150);//REGI?O
	}
}