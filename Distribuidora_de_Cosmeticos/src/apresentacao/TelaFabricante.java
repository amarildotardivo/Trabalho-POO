package apresentacao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaFabricante extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nome;
	private JLabel lbl_Logradouro;
	private JTextField textField_Logradouro;
	private JLabel lbl_Numero;
	private JTextField textField_Numero;
	private JLabel lbl_Bairro;
	private JTextField textField_Bairro;
	private JLabel lbl_Cidade;
	private JTextField textField_Cidade;
	private JLabel lbl_Telefone;
	private JTextField textField_Telefone;
	private JLabel lbl_Cnpj;
	private JTextField textField_cnpj;
	private JLabel lbl_Titulo_Fabricante;
	private JButton btn_Salvar;
	private JButton btn_Editar;
	private JButton btn_Buscar;
	private JButton btn_Deletar;
	private JButton btn_Limpar;
	private JButton btn_ListarClientes;
	private JLabel lbl_ListaFabricantes;
	private JTextField textField_id;
	private JLabel lbl_id;

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaFabricante() {
		//FRAME E CONTENT PANE *****************************************************************************************************************
				setResizable(false);
				setTitle("Cadastro de Fabricante");
				setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCliente.class.getResource("/imagens/icon_cadastro.png")));
				setAlwaysOnTop(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setSize(890, 360);
				setLocationRelativeTo(null);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
				
				//PAINEL PRINCIPAL **********************************************************************************************************************
				JPanel painel_Principal = new JPanel();
				contentPane.add(painel_Principal, BorderLayout.CENTER);
				painel_Principal.setLayout(null);
					
					lbl_Titulo_Fabricante = new JLabel("Gerenciamento do Fabricante");
					lbl_Titulo_Fabricante.setHorizontalAlignment(SwingConstants.CENTER);
					lbl_Titulo_Fabricante.setFont(new Font("Tahoma", Font.PLAIN, 28));
					lbl_Titulo_Fabricante.setBounds(10, 11, 854, 39);
					painel_Principal.add(lbl_Titulo_Fabricante);
				
					JLabel lbl_NomeFabricante = new JLabel("Nome:");
					lbl_NomeFabricante.setBounds(66, 61, 322, 14);
					painel_Principal.add(lbl_NomeFabricante);
					
					textField_Nome = new JTextField();
					textField_Nome.setToolTipText("");
					textField_Nome.setBounds(66, 80, 322, 29);
					painel_Principal.add(textField_Nome);
					textField_Nome.setColumns(10);
					
					lbl_Logradouro = new JLabel("Logradouro:");
					lbl_Logradouro.setBounds(10, 120, 87, 14);
					painel_Principal.add(lbl_Logradouro);
					
					textField_Logradouro = new JTextField();
					textField_Logradouro.setBounds(10, 138, 196, 29);
					painel_Principal.add(textField_Logradouro);
					textField_Logradouro.setColumns(10);
					
					lbl_Numero = new JLabel("N\u00FAmero:");
					lbl_Numero.setBounds(217, 120, 62, 14);
					painel_Principal.add(lbl_Numero);
					
					textField_Numero = new JTextField();
					textField_Numero.setColumns(10);
					textField_Numero.setBounds(216, 138, 46, 29);
					painel_Principal.add(textField_Numero);
					
					lbl_Bairro = new JLabel("Bairro:");
					lbl_Bairro.setBounds(272, 120, 46, 14);
					painel_Principal.add(lbl_Bairro);
					
					textField_Bairro = new JTextField();
					textField_Bairro.setColumns(10);
					textField_Bairro.setBounds(272, 137, 116, 29);
					painel_Principal.add(textField_Bairro);
					
					lbl_Cidade = new JLabel("Cidade:");
					lbl_Cidade.setBounds(10, 178, 46, 14);
					painel_Principal.add(lbl_Cidade);
					
					textField_Cidade = new JTextField();
					textField_Cidade.setColumns(10);
					textField_Cidade.setBounds(10, 195, 135, 29);
					painel_Principal.add(textField_Cidade);
					
					lbl_Telefone = new JLabel("Telefone:");
					lbl_Telefone.setBounds(156, 178, 87, 14);
					painel_Principal.add(lbl_Telefone);
					
					textField_Telefone = new JTextField();
					textField_Telefone.setColumns(10);
					textField_Telefone.setBounds(155, 195, 107, 29);
					painel_Principal.add(textField_Telefone);
					
					lbl_Cnpj = new JLabel("CNPJ:");
					lbl_Cnpj.setBounds(272, 177, 46, 14);
					painel_Principal.add(lbl_Cnpj);
					
					textField_cnpj = new JTextField();
					textField_cnpj.setColumns(10);
					textField_cnpj.setBounds(272, 194, 116, 29);
					painel_Principal.add(textField_cnpj);
					
					btn_Salvar = new JButton("SALVAR");
					btn_Salvar.setBounds(61, 263, 100, 35);
					painel_Principal.add(btn_Salvar);
					
					btn_Editar = new JButton("EDITAR");
					btn_Editar.setBounds(186, 263, 100, 35);
					painel_Principal.add(btn_Editar);
					
					btn_Buscar = new JButton("BUSCAR");
					btn_Buscar.setBounds(312, 263, 100, 35);
					painel_Principal.add(btn_Buscar);
					
					btn_Deletar = new JButton("DELETAR");
					btn_Deletar.setBounds(436, 263, 100, 35);
					painel_Principal.add(btn_Deletar);
					
					btn_Limpar = new JButton("LIMPAR");
					btn_Limpar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textField_id.setText("");
							textField_Nome.setText("");
							textField_Logradouro.setText("");
							textField_Numero.setText("");
							textField_Bairro.setText("");
							textField_Cidade.setText("");
							textField_Telefone.setText("");
							textField_cnpj.setText("");
						}
					});
					btn_Limpar.setBounds(559, 263, 100, 35);
					painel_Principal.add(btn_Limpar);
					
					btn_ListarClientes = new JButton("LISTAR CLIENTES");
					btn_ListarClientes.setBounds(682, 263, 138, 35);
					painel_Principal.add(btn_ListarClientes);
					
					lbl_ListaFabricantes = new JLabel("Lista de Fabricantes:");
					lbl_ListaFabricantes.setBounds(398, 61, 158, 14);
					painel_Principal.add(lbl_ListaFabricantes);
					
					//DEFINE O MODELO DO JLIST
					DefaultListModel model = new DefaultListModel();
					
					JList list_ListarFabricantes = new JList(model);
					list_ListarFabricantes.setBorder(new EmptyBorder(5, 5, 5, 5));
					list_ListarFabricantes.setBounds(398, 81, 455, 142);
					painel_Principal.add(list_ListarFabricantes);
					
					textField_id = new JTextField();
					textField_id.setName("");
					textField_id.setColumns(10);
					textField_id.setBounds(10, 80, 46, 29);
					painel_Principal.add(textField_id);
					
					lbl_id = new JLabel("ID:");
					lbl_id.setBounds(10, 61, 54, 14);
					painel_Principal.add(lbl_id);
	}
}
