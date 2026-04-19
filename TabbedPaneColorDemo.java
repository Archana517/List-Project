package String_Functions;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TabbedPaneColorDemo extends JFrame {

    JTabbedPane tabbedPane;
    JLabel label;

    public TabbedPaneColorDemo() {

        // Frame settings
        setTitle("Tabbed Pane Color Demo");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create TabbedPane
        tabbedPane = new JTabbedPane();

        // Create panels for each tab
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        // Add tabs
        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);

        // Label to display selected color
        label = new JLabel("Select a Tab", JLabel.CENTER);

        // Add Change Listener
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int index = tabbedPane.getSelectedIndex();
                String color = tabbedPane.getTitleAt(index);
                label.setText("Selected Color: " + color);
            }
        });

        // Add components
        add(tabbedPane, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TabbedPaneColorDemo();
    }
}