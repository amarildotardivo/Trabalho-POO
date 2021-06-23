package apresentacao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_NomeProduto;
	private JLabel lbl_Quantidade;
	private JTextField textField_Quantidade;
	private JLabel lbl_TipoProduto;
	private JTextField textField_TipoProduto;
	private JLabel lbl_PrecoCompra;
	private JTextField textField_PrecoCompra;
	private JLabel lbl_PrecoVenda;
	private JTextField textField_PrecoVenda;
	private JLabel lbl_NomeFabricante;
	private JTextField textField_NomeFabricante;
	private JButton btn_Limpar;
	private JButton btn_Cancelar;
	private JLabel lbl_Titulo_Cad_Produto;

	
	public TelaProduto() {
		//FRAME E CONTENT PANE *****************************************************************************************************************
				setResizable(false);
				setTitle("Cadastro de Produto");
				setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCliente.class.getResource("/imagens/icon_cadastro.png")));
				setAlwaysOnTop(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setSize(554, 360);
				setLocationRelativeTo(null);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
				
				//PAINEL PRINCIPAL **********************************************************************************************************************
				JPanel painel_Principal = new JPanel();
				contentPane.add(painel_Principal, BorderLayout.CENTER);
				painel_Principal.setLayout(null);
					
					lbl_Titulo_Cad_Produto = new JLabel("Cadastro de Produto");
					lbl_Titulo_Cad_Produto.setHorizontalAlignment(SwingConstants.CENTER);
					lbl_Titulo_Cad_Produto.setFont(new Font("Tahoma", Font.PLAIN, 28));
					lbl_Titulo_Cad_Produto.setBounds(10, 11, 501, 39);
					painel_Principal.add(lbl_Titulo_Cad_Produto);
				
					JLabel lbl_NomeProduto = new JLabel("Nome do Produto:");
					lbl_NomeProduto.setBounds(10, 61, 130, 14);
					painel_Principal.add(lbl_NomeProduto);
					
					txtField_NomeProduto = new JTextField();
					txtField_NomeProduto.setToolTipText("");
					txtField_NomeProduto.setBounds(10, 80, 501, 29);
					painel_Principal.add(txtField_NomeProduto);
					txtField_NomeProduto.setColumns(10);
					
					lbl_Quantidade = new JLabel("Quantidade:");
					lbl_Quantidade.setBounds(10, 120, 87, 14);
					painel_Principal.add(lbl_Quantidade);
					
					textField_Quantidade = new JTextField();
					textField_Quantidade.setBounds(10, 138, 62, 29);
					painel_Principal.add(textField_Quantidade);
					textField_Quantidade.setColumns(10);
					
					lbl_TipoProduto = new JLabel("Tipo de Produto:");
					lbl_TipoProduto.setBounds(83, 120, 100, 14);
					painel_Principal.add(lbl_TipoProduto);
					
					textField_TipoProduto = new JTextField();
					textField_TipoProduto.setColumns(10);
					textField_TipoProduto.setBounds(82, 138, 130, 29);
					painel_Principal.add(textField_TipoProduto);
					
					lbl_PrecoCompra = new JLabel("Pre\u00E7o de Compra:");
					lbl_PrecoCompra.setBounds(10, 178, 130, 14);
					painel_Principal.add(lbl_PrecoCompra);
					
					textField_PrecoCompra = new JTextField();
					textField_PrecoCompra.setColumns(10);
					textField_PrecoCompra.setBounds(10, 195, 169, 29);
					painel_Principal.add(textField_PrecoCompra);
					
					lbl_PrecoVenda = new JLabel("Pre\u00E7o de Venda:");
					lbl_PrecoVenda.setBounds(189, 178, 124, 14);
					painel_Principal.add(lbl_PrecoVenda);
					
					textField_PrecoVenda = new JTextField();
					textField_PrecoVenda.setColumns(10);
					textField_PrecoVenda.setBounds(189, 195, 169, 29);
					painel_Principal.add(textField_PrecoVenda);
					
					lbl_NomeFabricante = new JLabel("Nome do Fabricante:");
					lbl_NomeFabricante.setBounds(222, 120, 169, 14);
					painel_Principal.add(lbl_NomeFabricante);
					
					textField_NomeFabricante = new JTextField();
					textField_NomeFabricante.setColumns(10);
					textField_NomeFabricante.setBounds(222, 137, 289, 29);
					painel_Principal.add(textField_NomeFabricante);
					
					JButton btn_Salvar = new JButton("SALVAR");
					btn_Salvar.setBounds(31, 252, 150, 45);
					painel_Principal.add(btn_Salvar);
					
					btn_Limpar = new JButton("LIMPAR");
					btn_Limpar.setBounds(191, 252, 150, 45);
					painel_Principal.add(btn_Limpar);
					
					btn_Cancelar = new JButton("CANCELAR");
					btn_Cancelar.setBounds(349, 252, 150, 45);
					painel_Principal.add(btn_Cancelar);
	}

}
