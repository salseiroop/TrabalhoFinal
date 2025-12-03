package hugohenriquee;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEmprestar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmprestar frame = new TelaEmprestar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaEmprestar() {
		setTitle("Tela Emprestar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		setResizable(false);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Título do Livro:");
		lblTitulo.setBounds(173, 90, 120, 23);
		contentPane.add(lblTitulo);

		textField = new JTextField();
		textField.setBounds(124, 115, 186, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnEmprestar = new JButton("Emprestar");

		btnEmprestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tituloDigitado = textField.getText().trim();

				if (tituloDigitado.isEmpty()) {
					JOptionPane.showMessageDialog(
							btnEmprestar,
							"Digite o título do livro!",
							"Atenção",
							JOptionPane.WARNING_MESSAGE
					);
					return;
				}

				if (!TelaPrincipal.titulos.contains(tituloDigitado)) {
					JOptionPane.showMessageDialog(
							btnEmprestar,
							"Livro não cadastrado!",
							"Erro",
							JOptionPane.ERROR_MESSAGE
					);
					return;
				}

				JOptionPane.showMessageDialog(
						btnEmprestar,
						"Livro emprestado com sucesso!"
				);
			}
		});

		btnEmprestar.setBounds(163, 146, 102, 23);
		contentPane.add(btnEmprestar);
	}
}
