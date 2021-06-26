package apresentacao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaInformacao extends JFrame {

	private JPanel contentPane;
	
	public TelaInformacao( String LabelNome, String labelInformacao) {
		setType(Type.UTILITY);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Informa\u00E7\u00E3o");
		setSize(300, 180);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel(LabelNome);
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setBounds(20, 11, 242, 14);
		contentPane.add(lblNome);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOK.setBounds(88, 81, 100, 35);
		contentPane.add(btnOK);
		
		JLabel lblInformacao = new JLabel(labelInformacao);
		lblInformacao.setVerticalAlignment(SwingConstants.TOP);
		lblInformacao.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformacao.setBounds(20, 35, 242, 14);
		contentPane.add(lblInformacao);
	}

}
