package hugohenriquee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TelaListar extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListar() {
        setTitle("Lista de Livros");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        modelo = new DefaultTableModel(
                new Object[]{"Título", "Autor", "Gênero"}, 0
        );

        tabela = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabela);
        getContentPane().add(scroll, BorderLayout.CENTER);

        JButton btnEmprestar = new JButton("Emprestar");
        btnEmprestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaEmprestar().setVisible(true);
                dispose();
            }
        });

        getContentPane().add(btnEmprestar, BorderLayout.SOUTH);

        exibirLivros();
    }

    private void exibirLivros() {
        for (int i = 0; i < TelaPrincipal.titulos.size(); i++) {
            modelo.addRow(new Object[]{
                    TelaPrincipal.titulos.get(i),
                    TelaPrincipal.autores.get(i),
                    TelaPrincipal.generos.get(i)
            });
        }
    }
}
