package apresentacao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TelaErro extends JFrame {

	private JPanel contentPane;

	public TelaErro(String Erro) {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Erro");
		setType(Type.UTILITY);
		setSize(300, 180);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErro = new JLabel("Error:");
		lblErro.setVerticalAlignment(SwingConstants.TOP);
		lblErro.setHorizontalAlignment(SwingConstants.LEFT);
		lblErro.setBounds(21, 11, 242, 14);
		contentPane.add(lblErro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 35, 242, 49);
		contentPane.add(scrollPane);
		
		JTextArea textAreaErro = new JTextArea(Erro);
		textAreaErro.setLineWrap(true);
		scrollPane.setViewportView(textAreaErro);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOK.setBounds(89, 95, 100, 35);
		contentPane.add(btnOK);
		
		
	}
}
