import javax.swing.*;
import java.awt.*;

public class FancyLayout extends JFrame {
    public FancyLayout() {
        // create all the containers
        JPanel root = new JPanel();
        JPanel top  = new JPanel();
        JPanel left = new JPanel();
        JPanel main = new JPanel();
        JPanel topmain = new JPanel();
        JPanel botmain = new JPanel();

        // connect the containers
        this.getContentPane().add(root);
        root.setLayout(new BorderLayout());
        root.add(top, BorderLayout.NORTH);
        root.add(left, BorderLayout.WEST);
        root.add(main, BorderLayout.CENTER);

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(topmain);
        main.add(botmain);

        top.setLayout(new FlowLayout());
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        topmain.setLayout(new GridLayout(3,4));
        botmain.setLayout(new BoxLayout(botmain, BoxLayout.Y_AXIS));

        // add lots of stuff into the containers

        for(int i=0; i < 5; i++) {
            JButton button = new JButton("top " + i);
            top.add(button);
        }

        for(int i=0; i < 10; i++) {
            JButton button = new JButton("left " + i);
            left.add(button);
        }

        for(int i=0; i < 3; i++) {
            for(int j=0; j < 4; j++) {
                topmain.add(new JButton("Grid " + i + "," + j));
            }
        }

        int[] value = new int[]{-10, 0, 10};
        for(int i=0; i < 3; i++) {
            JSlider slider = new JSlider(-10, 10, value[i]);
            botmain.add(slider);
        }

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FancyLayout();
    }
}
