package apresentacao;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.Representante;
import persistencia.ClienteDB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

//	serialVersionUID:
//	Para mais informações sobre a serialização acesse:
//	https://blog.algaworks.com/serialversionuid/
@SuppressWarnings("serial")
public class TelaCliente extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField_NomeCliente;
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
	private JLabel lbl_Cpf;
	private JTextField textField_cpf;
	private JLabel lbl_NomeRepresentante;
	private JButton btn_Limpar;
	private JButton btn_Deletar;
	private JLabel lbl_Titulo_Cliente;
	private JButton btn_Editar;
	private JLabel lbl_id;
	private JTextField textField_id;
	private JScrollPane scrollPane;

	private Cliente cli = new Cliente();
	
	//DEFINE O MODELO DO JLIST
	private DefaultListModel<String> model = new DefaultListModel<>();
	
	public String getNomeCliente() {
		return textField_NomeCliente.getText();
	}
	
//	@SuppressWarnings("unchecked")
	public TelaCliente() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Gerenciamento de Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCliente.class.getResource("/imagens/icon_cadastro.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(890, 410);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		//PAINEL PRINCIPAL **********************************************************************************************************************
		JPanel painel_Principal = new JPanel();
		contentPane.add(painel_Principal, BorderLayout.CENTER);
			painel_Principal.setLayout(null);
			
			lbl_Titulo_Cliente = new JLabel("Gerenciamento do Cliente");
			lbl_Titulo_Cliente.setBounds(10, 11, 864, 39);
			lbl_Titulo_Cliente.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Titulo_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
			painel_Principal.add(lbl_Titulo_Cliente);
			
			lbl_id = new JLabel("ID:");
			lbl_id.setBounds(10, 61, 54, 14);
			painel_Principal.add(lbl_id);
			
			textField_id = new JTextField();
			textField_id.setEditable(false);
			textField_id.setName("");
			textField_id.setBounds(10, 80, 46, 29);
			painel_Principal.add(textField_id);
			textField_id.setColumns(10);
		
			JLabel lbl_NomeCliente = new JLabel("Nome* :");
			lbl_NomeCliente.setBounds(66, 61, 127, 14);
			painel_Principal.add(lbl_NomeCliente);
			
			textField_NomeCliente = new JTextField();
			textField_NomeCliente.setBounds(66, 80, 292, 29);
			textField_NomeCliente.setToolTipText("");
			painel_Principal.add(textField_NomeCliente);
			textField_NomeCliente.setColumns(10);
			
			lbl_Logradouro = new JLabel("Logradouro:");
			lbl_Logradouro.setBounds(10, 120, 87, 14);
			painel_Principal.add(lbl_Logradouro);
			
			textField_Logradouro = new JTextField();
			textField_Logradouro.setBounds(10, 138, 275, 29);
			painel_Principal.add(textField_Logradouro);
			textField_Logradouro.setColumns(10);
			
			lbl_Numero = new JLabel("N\u00FAmero:");
			lbl_Numero.setBounds(296, 120, 62, 14);
			painel_Principal.add(lbl_Numero);
			
			textField_Numero = new JTextField();
			textField_Numero.setBounds(295, 138, 63, 29);
			textField_Numero.setColumns(10);
			painel_Principal.add(textField_Numero);
			
			lbl_Bairro = new JLabel("Bairro:");
			lbl_Bairro.setBounds(10, 178, 46, 14);
			painel_Principal.add(lbl_Bairro);
			
			textField_Bairro = new JTextField();
			textField_Bairro.setBounds(10, 195, 109, 29);
			textField_Bairro.setColumns(10);
			painel_Principal.add(textField_Bairro);
			
			lbl_Cidade = new JLabel("Cidade:");
			lbl_Cidade.setBounds(129, 178, 46, 14);
			painel_Principal.add(lbl_Cidade);
			
			textField_Cidade = new JTextField();
			textField_Cidade.setBounds(129, 195, 109, 29);
			textField_Cidade.setColumns(10);
			painel_Principal.add(textField_Cidade);
			
			lbl_Telefone = new JLabel("Telefone:");
			lbl_Telefone.setBounds(249, 178, 87, 14);
			painel_Principal.add(lbl_Telefone);
			
			textField_Telefone = new JTextField();
			textField_Telefone.setBounds(248, 195, 109, 29);
			textField_Telefone.setColumns(10);
			painel_Principal.add(textField_Telefone);
			
			lbl_Cpf = new JLabel("CPF:");
			lbl_Cpf.setBounds(10, 235, 46, 14);
			painel_Principal.add(lbl_Cpf);
			
			textField_cpf = new JTextField();
			textField_cpf.setBounds(10, 252, 127, 29);
			textField_cpf.setColumns(10);
			painel_Principal.add(textField_cpf);
			
			lbl_NomeRepresentante = new JLabel("Nome do Representante* :");
			lbl_NomeRepresentante.setBounds(147, 235, 169, 14);
			painel_Principal.add(lbl_NomeRepresentante);
			
			JComboBox<Object> comboBox_Representante = new JComboBox<>();
			comboBox_Representante.setBounds(147, 252, 211, 29);
			painel_Principal.add(comboBox_Representante);
				ArrayList<Representante> listarRep = cli.listar_representantes();
				comboBox_Representante.addItem("Selecione um Representante");
				
				for(Representante rep: listarRep) {
					comboBox_Representante.addItem(rep.getNome());
				}
			
			JLabel lbl_ListaClientes = new JLabel("Lista de Clientes:");
			lbl_ListaClientes.setBounds(368, 61, 109, 14);
			painel_Principal.add(lbl_ListaClientes);
			
			//Inicializa a lista de Clientes na JList
			listarTodosCliente();
			
			//FUNÇÃO DE INCLUIR NO BANCO DE DADOS
			JButton btn_Salvar = new JButton("SALVAR");			
			btn_Salvar.setBounds(129, 317, 100, 35);
			btn_Salvar.addActionListener(new ActionListener() {
				//@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent e) {
					
					//INSERINDO COMPONENTES DE TELA EM VARIAVEIS
					String nomeRepresentante = (String) comboBox_Representante.getSelectedItem();
					
					cli.setNome(getNomeCliente());
					cli.setLogradouro(textField_Logradouro.getText());
					cli.setNumero(textField_Numero.getText());
					cli.setBairro(textField_Bairro.getText());
					cli.setCidade(textField_Cidade.getText());
					cli.setTelefone(textField_Telefone.getText());
					cli.setCpf(textField_cpf.getText());
					cli.setNome_representante(nomeRepresentante);
					
					if(getNomeCliente().isBlank() == false) {
						
						if(nomeRepresentante != "Selecione um Representante") {						
							cli.realizar_cadastro();
							listarTodosCliente();
							JOptionPane.showMessageDialog(painel_Principal, "Cliente "+ cli.getNome() +"! \nSalvo(a) com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
							
						}else {
							JOptionPane.showMessageDialog(painel_Principal, "Não é possível Cadastrar o Cliente: "+ cli.getNome() +"! \nSelecione ou Cadastre um Representante!", "Atenção!", JOptionPane.OK_OPTION);
						}
						
					}else {
						JOptionPane.showMessageDialog(painel_Principal,"Não é possível Cadastrar o Cliente! \nPreencha o Campo Nome!", "Atenção!", JOptionPane.OK_OPTION);
					}
				}
			});
			painel_Principal.add(btn_Salvar);
			
			//FUNÇÃO DE ALTERAR NO BANCO DE DADOS
			btn_Editar = new JButton("EDITAR");
			btn_Editar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(textField_NomeCliente.getText().isEmpty() == false) {
					
						//INSERINDO COMPONENTES DE TELA EM VARIAVEIS
						String nomeRepresentante = (String) comboBox_Representante.getSelectedItem();
						
						cli.setId(Integer.parseInt(textField_id.getText()));
						cli.setNome(getNomeCliente());
						cli.setLogradouro(textField_Logradouro.getText());
						cli.setNumero(textField_Numero.getText());
						cli.setBairro(textField_Bairro.getText());
						cli.setCidade(textField_Cidade.getText());
						cli.setTelefone(textField_Telefone.getText());
						cli.setCpf(textField_cpf.getText());
						cli.setNome_representante(nomeRepresentante);
						
						if(nomeRepresentante.equals("Selecione um Representante") != true ) {						
							boolean verificar = cli.editar_cliente();
							
							if(verificar == true) {				
								JOptionPane.showMessageDialog(painel_Principal, "Cliente "+ cli.getNome() +"! \nEditado(a) com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(painel_Principal, "Não foi Possível editar o(a) Cliente "+ cli.getNome() +"! \nOccorreu um Erro!", "Atenção!", JOptionPane.OK_OPTION);
							}
							listarTodosCliente();
							
						}else {
							JOptionPane.showMessageDialog(painel_Principal, "Não é possível Editar o Cliente! \nSelecione ou Cadastre um Representante!", "Atenção!", JOptionPane.OK_OPTION);
						}
					
					}else {
						System.err.println("Erro ao Editar o cliente, pois não foi informado o nome do mesmo!");
						JOptionPane.showMessageDialog(painel_Principal, "Não é possível Editar o Cliente! \nPreencha o campo Nome e realize a Busca, para poder Editar!", "Campo Nome do Cliente Incorreto", JOptionPane.OK_OPTION);
					}
					
				}
			});
			btn_Editar.setBounds(254, 317, 100, 35);
			painel_Principal.add(btn_Editar);
			
			//FUNÇÃO DE CONSULTAR NO BANCO DE DADOS
			JButton btn_Buscar = new JButton("BUSCAR");
			btn_Buscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(textField_NomeCliente.getText().isEmpty() == false) {
						
						ClienteDB clienteBD = new ClienteDB();
						ArrayList<Cliente> listaClientes = clienteBD.BuscarCliente(textField_NomeCliente.getText());
						
						if(listaClientes != null) {
							for(Cliente c: listaClientes) {
								textField_id.setText("" + c.getId());
								textField_NomeCliente.setText("" + c.getNome());
								textField_Logradouro.setText("" + c.getLogradouro());
								textField_Numero.setText("" + c.getNumero());
								textField_Bairro.setText("" + c.getBairro());
								textField_Cidade.setText("" + c.getCidade());
								textField_Telefone.setText("" + c.getTelefone());
								textField_cpf.setText("" + c.getCpf());
								comboBox_Representante.setSelectedItem(c.getNome_representante());
								
								JOptionPane.showMessageDialog(painel_Principal, "Busca do Cliente "+ c.getNome() +" Realizada com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
							}
							
						}else {
							JOptionPane.showMessageDialog(painel_Principal, "Não foi possível Buscar o Cliente! \nOcorreu um erro ao tentar encontrá-lo!", "Atenção!!!", JOptionPane.OK_OPTION);
						}
						
					}else {
						System.err.println("Erro ao buscar o cliente, pois não foi informado o nome do mesmo!");
						JOptionPane.showMessageDialog(painel_Principal, "Não é possível Buscar o Cliente! \nPreencha o campo Nome para Buscar!", "Campo Nome do Cliente Incorreto", JOptionPane.OK_OPTION);
					}
					
				}
			});
			btn_Buscar.setBounds(380, 317, 100, 35);
			painel_Principal.add(btn_Buscar);
			
			//FUNÇÃO DE DELETAR DO BANCO DE DADOS
			btn_Deletar = new JButton("DELETAR");
			btn_Deletar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
											
					if(textField_NomeCliente.getText().isEmpty() == false) {
						
						Cliente c = new Cliente(
								Integer.parseInt(textField_id.getText()),
								textField_NomeCliente.getText(), 
								textField_Logradouro.getText(),
								textField_Numero.getText(), 
								textField_Bairro.getText(), 
								textField_Cidade.getText(), 
								textField_Telefone.getText(), 
								textField_cpf.getText(), 
								(String)comboBox_Representante.getSelectedItem()
							);
						
						int confirma = JOptionPane.showConfirmDialog(painel_Principal, "Deseja Realmente Excluir o(a) Cliente: "+ c.getNome() + "?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
						if(confirma == 0) {
							
							boolean verifica = c.deletar_cadastro(c);
							
							if(verifica == true) {
								JOptionPane.showMessageDialog(painel_Principal, "Cliente "+ c.getNome() +" Deletado(a) com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(painel_Principal, "Não foi possível Deletar o Cliente: "+ c.getNome() +"! \nOcorreu um Erro!", "Atenção!!!", JOptionPane.OK_OPTION);
							}
							listarTodosCliente();
							
							
						}else {
							JOptionPane.showMessageDialog(painel_Principal, "O Cliente: "+ c.getNome() +"! \nNão foi Deletado(a)!!!", "Informação", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}else {
						JOptionPane.showMessageDialog(painel_Principal, "Entre com o Nome do Cliente para Deletá-lo!", "Atenção!!!", JOptionPane.OK_OPTION);
					}
					
				}
			});
			btn_Deletar.setBounds(504, 317, 100, 35);
			painel_Principal.add(btn_Deletar);
			
			//LIMPA TODOS OS TEXTFIELDS
			btn_Limpar = new JButton("LIMPAR");
			btn_Limpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField_id.setText("");
					textField_NomeCliente.setText("");
					textField_Logradouro.setText("");
					textField_Numero.setText("");
					textField_Bairro.setText("");
					textField_Cidade.setText("");
					textField_Telefone.setText("");
					textField_cpf.setText("");
					comboBox_Representante.setSelectedItem("");
				}
			});
			btn_Limpar.setBounds(627, 317, 100, 35);
			painel_Principal.add(btn_Limpar);		
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(368, 81, 492, 201);
			painel_Principal.add(scrollPane);
			
			JList<String> list_ListarClientes = new JList<>(model);
			scrollPane.setViewportView(list_ListarClientes);
			list_ListarClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			JLabel Label_Obs = new JLabel("* Campos Obrigat\u00F3rios.");
			Label_Obs.setForeground(Color.RED);
			Label_Obs.setBounds(10, 292, 193, 14);
			painel_Principal.add(Label_Obs);
			
	}
	
	public void listarTodosCliente() {
		ArrayList<Cliente> listarClientes = cli.listar_clientes();
		
		model.clear();
		
		if(listarClientes != null) {
			for(Cliente c: listarClientes) {
				
				model.addElement(c.getId()+": "+ c.getNome() + " - " + c.getLogradouro() + " - " + c.getNumero() + " - " + 
				c.getBairro() + " - " + c.getCidade() + " - " + c.getTelefone() + " - " + c.getCpf() + " - " + c.getNome_representante());
				
			}
		}
	}
	
	
}
