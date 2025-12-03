package hugohenriquee;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaPrincipal extends JFrame {

    private JPanel contentPane;
    private JTextField tfTitulo;
    private JTextField tfAutor;
    private JRadioButton rdbtnFicticio;
    private JRadioButton rdbtnNaoFicticio;

    public static ArrayList<String> titulos = new ArrayList<>();
    public static ArrayList<String> autores = new ArrayList<>();
    public static ArrayList<String> generos = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaPrincipal frame = new TelaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaPrincipal() {
        setTitle("Tela Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 408, 286);
        setResizable(false);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(42, 70, 46, 14);
        contentPane.add(lblTitulo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(193, 70, 36, 14);
        contentPane.add(lblAutor);

        tfTitulo = new JTextField();
        tfTitulo.setBounds(83, 67, 86, 20);
        contentPane.add(tfTitulo);

        tfAutor = new JTextField();
        tfAutor.setBounds(228, 67, 86, 20);
        contentPane.add(tfAutor);

        JLabel lblGenero = new JLabel("Gênero:");
        lblGenero.setBounds(42, 113, 46, 14);
        contentPane.add(lblGenero);

        rdbtnFicticio = new JRadioButton("Fictício");
        rdbtnFicticio.setBounds(104, 109, 76, 23);
        contentPane.add(rdbtnFicticio);

        rdbtnNaoFicticio = new JRadioButton("Não Fictício");
        rdbtnNaoFicticio.setBounds(197, 109, 99, 23);
        contentPane.add(rdbtnNaoFicticio);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rdbtnFicticio);
        grupo.add(rdbtnNaoFicticio);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(93, 148, 76, 20);
        contentPane.add(btnSalvar);

        btnSalvar.addActionListener(e -> {

            String titulo = tfTitulo.getText().trim();
            String autor = tfAutor.getText().trim();

            if (titulo.isEmpty() || autor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            if (titulos.contains(titulo)) {
                JOptionPane.showMessageDialog(null, "Esse livro já está cadastrado!");
                return;
            }

            if (!rdbtnFicticio.isSelected() && !rdbtnNaoFicticio.isSelected()) {
                JOptionPane.showMessageDialog(null, "Escolha um gênero!");
                return;
            }

            titulos.add(titulo);
            autores.add(autor);
            generos.add(rdbtnFicticio.isSelected() ? "Fictício" : "Não Fictício");

            JOptionPane.showMessageDialog(null, "Livro cadastrado!");

            tfTitulo.setText("");
            tfAutor.setText("");
            grupo.clearSelection();
        });

        JButton btnLista = new JButton("Ver Lista");
        btnLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaListar().setVisible(true);
                dispose();
            }
        });
        btnLista.setBounds(197, 148, 99, 20);
        contentPane.add(btnLista);
    }
}
