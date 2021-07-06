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

import modelo.Cliente;
import persistencia.ClienteDB;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TelaRelatorioCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	
	public TelaRelatorioCliente() {
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
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Nome", "Logradouro", "Numero", "Bairro", "Cidade", "Telefone", "CPF", "Representante" 
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
		tModel.addColumn("Representante");
		
		ClienteDB cliDB = new ClienteDB();
		ArrayList<Cliente> listaClientes = cliDB.listarClientes();
		
		if(listaClientes.isEmpty() == false) {
			for(Cliente cli: listaClientes) {
				tModel.addRow(new String[] {String.valueOf(cli.getId()), cli.getNome(), cli.getLogradouro(), cli.getNumero(), cli.getBairro(), cli.getCidade(), cli.getTelefone(), cli.getCpf(), cli.getNome_representante() });
			}
			table.setModel(tModel);
			table.setEnabled(false);
		}
		
		
		JLabel lblNewLabel = new JLabel("Relat\u00F3rio de Clientes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(0, 11, 854, 36);
		panel.add(lblNewLabel);
		
	}
}
