package apresentacao;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CadastroRepresentante extends JFrame {

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
	private JLabel lbl_Regiao;
	private JTextField textField_NomeRepresentante;
	private JButton btn_Limpar;
	private JButton btn_Cancelar;
	private JLabel lbl_Titulo_Cad_Representante;

	public CadastroRepresentante() {
		//FRAME E CONTENT PANE *****************************************************************************************************************
				setResizable(false);
				setTitle("Cadastro de Representante");
				setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroRepresentante.class.getResource("/imagens/icon_cadastro.png")));
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
					
					lbl_Titulo_Cad_Representante = new JLabel("Cadastro de Representante");
					lbl_Titulo_Cad_Representante.setHorizontalAlignment(SwingConstants.CENTER);
					lbl_Titulo_Cad_Representante.setFont(new Font("Tahoma", Font.PLAIN, 28));
					lbl_Titulo_Cad_Representante.setBounds(10, 11, 501, 39);
					painel_Principal.add(lbl_Titulo_Cad_Representante);
				
					JLabel lbl_NomeRepresentante = new JLabel("Nome:");
					lbl_NomeRepresentante.setBounds(10, 56, 46, 14);
					painel_Principal.add(lbl_NomeRepresentante);
					
					txtField_Nome = new JTextField();
					txtField_Nome.setToolTipText("");
					txtField_Nome.setBounds(10, 75, 501, 29);
					painel_Principal.add(txtField_Nome);
					txtField_Nome.setColumns(10);
					
					lbl_Logradouro = new JLabel("Logradouro:");
					lbl_Logradouro.setBounds(10, 115, 87, 14);
					painel_Principal.add(lbl_Logradouro);
					
					textField_Logradouro = new JTextField();
					textField_Logradouro.setBounds(10, 133, 428, 29);
					painel_Principal.add(textField_Logradouro);
					textField_Logradouro.setColumns(10);
					
					lbl_Numero = new JLabel("N\u00FAmero:");
					lbl_Numero.setBounds(449, 115, 62, 14);
					painel_Principal.add(lbl_Numero);
					
					textField_Numero = new JTextField();
					textField_Numero.setColumns(10);
					textField_Numero.setBounds(448, 133, 63, 29);
					painel_Principal.add(textField_Numero);
					
					lbl_Bairro = new JLabel("Bairro:");
					lbl_Bairro.setBounds(10, 173, 46, 14);
					painel_Principal.add(lbl_Bairro);
					
					textField_Bairro = new JTextField();
					textField_Bairro.setColumns(10);
					textField_Bairro.setBounds(10, 190, 169, 29);
					painel_Principal.add(textField_Bairro);
					
					lbl_Cidade = new JLabel("Cidade:");
					lbl_Cidade.setBounds(189, 173, 46, 14);
					painel_Principal.add(lbl_Cidade);
					
					textField_Cidade = new JTextField();
					textField_Cidade.setColumns(10);
					textField_Cidade.setBounds(189, 190, 169, 29);
					painel_Principal.add(textField_Cidade);
					
					lbl_Telefone = new JLabel("Telefone:");
					lbl_Telefone.setBounds(369, 173, 87, 14);
					painel_Principal.add(lbl_Telefone);
					
					textField = new JTextField();
					textField.setColumns(10);
					textField.setBounds(368, 190, 143, 29);
					painel_Principal.add(textField);
					
					lbl_Cpf = new JLabel("CPF:");
					lbl_Cpf.setBounds(10, 230, 46, 14);
					painel_Principal.add(lbl_Cpf);
					
					textField_cpf = new JTextField();
					textField_cpf.setColumns(10);
					textField_cpf.setBounds(10, 247, 169, 29);
					painel_Principal.add(textField_cpf);
					
					lbl_Regiao = new JLabel("Regi\u00E3o:");
					lbl_Regiao.setBounds(189, 230, 169, 14);
					painel_Principal.add(lbl_Regiao);
					
					textField_NomeRepresentante = new JTextField();
					textField_NomeRepresentante.setColumns(10);
					textField_NomeRepresentante.setBounds(189, 247, 322, 29);
					painel_Principal.add(textField_NomeRepresentante);
					
					JButton btn_Salvar = new JButton("SALVAR");
					btn_Salvar.setBounds(28, 305, 150, 45);
					painel_Principal.add(btn_Salvar);
					
					btn_Limpar = new JButton("LIMPAR");
					btn_Limpar.setBounds(188, 305, 150, 45);
					painel_Principal.add(btn_Limpar);
					
					btn_Cancelar = new JButton("CANCELAR");
					btn_Cancelar.setBounds(346, 305, 150, 45);
					painel_Principal.add(btn_Cancelar);
		
	}

}
