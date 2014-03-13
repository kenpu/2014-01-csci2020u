import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class View extends JFrame {
    JButton load;
    JButton save;
    JTextField filename;
    JTextArea  content;

    public View() {
        // create the UI elements
        this.load = new JButton("Load");
        this.save = new JButton("Save");
        this.filename = new JTextField("File name here");
        this.content  = new JTextArea();

        // hack
       JButton exit = new JButton("Exit");
       exit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
       });

        // layout
        JPanel root = new JPanel();
        JPanel left = new JPanel();
        JPanel main = new JPanel();

        this.getContentPane().add(root);

        root.setLayout(new BorderLayout());
        root.add(left, BorderLayout.WEST);
        root.add(main, BorderLayout.CENTER);

        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.add(exit);
        left.add(load);
        left.add(save);

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(filename);
        main.add(content);

        // set UI dimensions
        this.setPreferredSize(new Dimension(600, 600));
        this.filename.setMaximumSize(new Dimension(300, 50));
        this.content.setMinimumSize(new Dimension(300, 600));

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

