package String_Functions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends JFrame implements MouseListener {

    JButton button;
    JLabel label;

    public MouseEventDemo() {

        // Frame settings
        setTitle("Mouse Event Demo");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create button
        button = new JButton("Click Me");

        // Create label
        label = new JLabel("Perform Mouse Action");

        // Add Mouse Listener to button
        button.addMouseListener(this);

        // Add components
        add(button);
        add(label);

        setVisible(true);
    }

    // Mouse Pressed (Mouse Down)
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Down (Pressed)");
    }

    // Mouse Released (Mouse Up)
    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Up (Released)");
    }

    // Mouse Clicked (Single / Double Click)
    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2) {
            label.setText("Double Click");
        } else if (e.getClickCount() == 1) {
            label.setText("Single Click");
        }
    }

    // Not used but must be implemented
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }

    // Main method
    public static void main(String[] args) {
        new MouseEventDemo();
    }
}