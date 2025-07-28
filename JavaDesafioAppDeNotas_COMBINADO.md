
# 🧩 Desafio 01: App de Notas

---

## 🎯 Objetivo:

Criar um aplicativo de anotações em Java, que funcione como um bloquinho de notas simples, parecido com o Notepad do Windows!

---

## 📋 Requisitos:

1. Área de texto para digitar anotações.
2. Menu “Arquivo” com as opções:
   - Novo
   - Abrir
   - Salvar
   - Sair

---

## 🧠 Conceitos que você vai praticar:

✅ Java Swing (interface gráfica)  
✅ Componentes: JTextArea, JScrollPane, JMenu, JMenuItem  
✅ Manipulação de arquivos com BufferedReader e BufferedWriter  
✅ Eventos com ActionListener  
✅ JFrame para janelas

---

## 🧪 Nível: Intermediário

---

## 🛠️ Ferramentas recomendadas:

- Java JDK 8+
- IntelliJ IDEA ou outro editor

---

## 💡 Desafio proposto por ChatGPT

---

## 💻 Resultado (App.java):

```java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AppDeNotas extends JFrame {
    private JTextArea areaDeTexto;

    public AppDeNotas() {
        setTitle("📝 App de Anotações");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        areaDeTexto = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaDeTexto);
        add(scroll);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opções");

        JMenuItem salvar = new JMenuItem("Salvar");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem limpar = new JMenuItem("Limpar");

        salvar.addActionListener(e -> salvarTexto());
        abrir.addActionListener(e -> abrirTexto());
        limpar.addActionListener(e -> areaDeTexto.setText(""));

        menu.add(salvar);
        menu.add(abrir);
        menu.add(limpar);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void salvarTexto() {
        try {
            FileWriter fw = new FileWriter("notas.txt");
            fw.write(areaDeTexto.getText());
            fw.close();
            JOptionPane.showMessageDialog(this, "Notas salvas com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar!");
        }
    }

    private void abrirTexto() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("notas.txt"));
            areaDeTexto.read(br, null);
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir arquivo!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppDeNotas().setVisible(true));
    }
}

```