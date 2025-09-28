import javax.swing.*;
import java.awt.*;


public class window {



    public static void openWindow(int sizeX, int sizeY, String windowTitle){
        //Initiators
        JFrame frame = new JFrame();
        //JTextField textField = new JTextField(16);
        JButton button = new JButton("Submit");
        JPanel panel = new JPanel();

        //FrameSettings
        frame.setSize(sizeX, sizeY);
        frame.setLocationRelativeTo(null);
        frame.setTitle(windowTitle);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        //textField.add(panel);
        button.add(panel, BorderLayout.CENTER);

        frame.add(panel);

        frame.setVisible(true);

    }


}
