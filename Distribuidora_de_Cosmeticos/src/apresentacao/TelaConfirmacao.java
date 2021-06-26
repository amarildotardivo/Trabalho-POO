package apresentacao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaConfirmacao extends JFrame {

	private JPanel contentPane;
	
	public TelaConfirmacao(String labelConfirmacao) {
		setAlwaysOnTop(true);
		setTitle("Confirma\u00E7\u00E3o:");
		setType(Type.UTILITY);
		setSize(300, 180);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfirmacao = new JLabel(labelConfirmacao);
		lblConfirmacao.setVerticalAlignment(SwingConstants.TOP);
		lblConfirmacao.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmacao.setBounds(20, 24, 243, 53);
		contentPane.add(lblConfirmacao);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(40, 88, 100, 35);
		contentPane.add(btnOK);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(150, 88, 100, 35);
		contentPane.add(btnCancelar);
	}
	
	class btnOKDelete {
		
		public int confirmado() {
			
			return 0;
		}
	}
}


