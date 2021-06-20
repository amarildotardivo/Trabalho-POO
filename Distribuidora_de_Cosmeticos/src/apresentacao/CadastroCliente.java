package apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_Nome;
	private JLabel lbl_Logradouro;
	private JTextField textField_Logradouro;
	private JLabel lbl_Numero;
	private JTextField textField_Numero;
	private JLabel lbl_Bairro;
	private JTextField textField_Bairro;
	private JLabel lbl_Cidade;
	private JTextField textField_Cidade;
	private JLabel lbl_Telefone;
	private JTextField textField;
	private JLabel lbl_Cpf;
	private JTextField textField_cpf;
	private JLabel lbl_NomeRepresentante;
	private JTextField textField_NomeRepresentante;
	private JButton btn_Limpar;
	private JButton btn_Cancelar;
	private JLabel lbl_Titulo_Cad_Cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroCliente() {
		//FRAME E CONTENT PANE *****************************************************************************************************************
		setResizable(false);
		setTitle("Cadastro de Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroCliente.class.getResource("/imagens/icon_cadastro.png")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(554, 415);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//PAINEL PRINCIPAL **********************************************************************************************************************
		JPanel painel_Principal = new JPanel();
		contentPane.add(painel_Principal, BorderLayout.CENTER);
		painel_Principal.setLayout(null);
			
			lbl_Titulo_Cad_Cliente = new JLabel("Cadastro de Cliente");
			lbl_Titulo_Cad_Cliente.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Titulo_Cad_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
			lbl_Titulo_Cad_Cliente.setBounds(10, 11, 501, 39);
			painel_Principal.add(lbl_Titulo_Cad_Cliente);
		
			JLabel lbl_NomeCliente = new JLabel("Nome:");
			lbl_NomeCliente.setBounds(10, 61, 46, 14);
			painel_Principal.add(lbl_NomeCliente);
			
			txtField_Nome = new JTextField();
			txtField_Nome.setToolTipText("");
			txtField_Nome.setBounds(10, 80, 501, 29);
			painel_Principal.add(txtField_Nome);
			txtField_Nome.setColumns(10);
			
			lbl_Logradouro = new JLabel("Logradouro:");
			lbl_Logradouro.setBounds(10, 120, 87, 14);
			painel_Principal.add(lbl_Logradouro);
			
			textField_Logradouro = new JTextField();
			textField_Logradouro.setBounds(10, 138, 428, 29);
			painel_Principal.add(textField_Logradouro);
			textField_Logradouro.setColumns(10);
			
			lbl_Numero = new JLabel("N\u00FAmero:");
			lbl_Numero.setBounds(449, 120, 62, 14);
			painel_Principal.add(lbl_Numero);
			
			textField_Numero = new JTextField();
			textField_Numero.setColumns(10);
			textField_Numero.setBounds(448, 138, 63, 29);
			painel_Principal.add(textField_Numero);
			
			lbl_Bairro = new JLabel("Bairro:");
			lbl_Bairro.setBounds(10, 178, 46, 14);
			painel_Principal.add(lbl_Bairro);
			
			textField_Bairro = new JTextField();
			textField_Bairro.setColumns(10);
			textField_Bairro.setBounds(10, 195, 169, 29);
			painel_Principal.add(textField_Bairro);
			
			lbl_Cidade = new JLabel("Cidade:");
			lbl_Cidade.setBounds(189, 178, 46, 14);
			painel_Principal.add(lbl_Cidade);
			
			textField_Cidade = new JTextField();
			textField_Cidade.setColumns(10);
			textField_Cidade.setBounds(189, 195, 169, 29);
			painel_Principal.add(textField_Cidade);
			
			lbl_Telefone = new JLabel("Telefone:");
			lbl_Telefone.setBounds(369, 178, 87, 14);
			painel_Principal.add(lbl_Telefone);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(368, 195, 143, 29);
			painel_Principal.add(textField);
			
			lbl_Cpf = new JLabel("CPF:");
			lbl_Cpf.setBounds(10, 235, 46, 14);
			painel_Principal.add(lbl_Cpf);
			
			textField_cpf = new JTextField();
			textField_cpf.setColumns(10);
			textField_cpf.setBounds(10, 252, 169, 29);
			painel_Principal.add(textField_cpf);
			
			lbl_NomeRepresentante = new JLabel("Nome do Representante:");
			lbl_NomeRepresentante.setBounds(189, 235, 169, 14);
			painel_Principal.add(lbl_NomeRepresentante);
			
			textField_NomeRepresentante = new JTextField();
			textField_NomeRepresentante.setColumns(10);
			textField_NomeRepresentante.setBounds(189, 252, 322, 29);
			painel_Principal.add(textField_NomeRepresentante);
			
			JButton btn_Salvar = new JButton("SALVAR");
			btn_Salvar.setBounds(31, 305, 150, 45);
			painel_Principal.add(btn_Salvar);
			
			btn_Limpar = new JButton("LIMPAR");
			btn_Limpar.setBounds(191, 305, 150, 45);
			painel_Principal.add(btn_Limpar);
			
			btn_Cancelar = new JButton("CANCELAR");
			btn_Cancelar.setBounds(349, 305, 150, 45);
			painel_Principal.add(btn_Cancelar);
	}
}
