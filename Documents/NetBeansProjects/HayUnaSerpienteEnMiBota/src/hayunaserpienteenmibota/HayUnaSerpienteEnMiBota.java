package hayunaserpienteenmibota;

/**
 * @author Alfonso Fernández Álvarez
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class HayUnaSerpienteEnMiBota extends JFrame {

    public HayUnaSerpienteEnMiBota() {
        initUI();
    }

    public void initUI() {

        add(new VideoGame());

        setResizable(false);
        pack();

        setTitle("Hay una serpiente en mi bota!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new HayUnaSerpienteEnMiBota();
            ex.setVisible(true);
        });
    }

}
