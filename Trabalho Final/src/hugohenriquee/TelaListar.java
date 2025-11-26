package hugohenriquee;

import javax.swing.*;
import java.awt.*;

public class TelaListar extends JFrame {

    private JTextArea area;

    public TelaListar() {
        setTitle("Lista de Livros");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        area = new JTextArea();
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        getContentPane().add(scroll, BorderLayout.CENTER);

        exibirLivros();
    }

    private void exibirLivros() {
        for (int i = 0; i < TelaPrincipal.titulos.size(); i++) {
            area.append(
                "Título: " + TelaPrincipal.titulos.get(i) + "\n" +
                "Autor: " + TelaPrincipal.autores.get(i) + "\n" +
                "Gênero: " + TelaPrincipal.generos.get(i) + "\n\n"
            );
        }
    }
    
    
}
