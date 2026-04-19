package String_Functions;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;

public class CountryCapitalList extends JFrame {

    JList<String> countryList;

    public CountryCapitalList() {

        // Frame settings
        setTitle("Country Capitals");
        setSize(300, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Country list
        String countries[] = {
            "USA", "India", "Vietnam", "Canada",
            "Denmark", "France", "Great Britain",
            "Japan", "Africa", "Greenland", "Singapore"
        };

        // Create JList
        countryList = new JList<>(countries);
        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Capital mapping
        HashMap<String, String> capitals = new HashMap<>();
        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "Addis Ababa");
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        // Add List Selection Listener
        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    String selectedCountry = countryList.getSelectedValue();

                    if (selectedCountry != null) {
                        System.out.println("Capital of " + selectedCountry +
                                " is: " + capitals.get(selectedCountry));
                    }
                }
            }
        });

        // Add list inside scroll pane
        add(new JScrollPane(countryList));

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryCapitalList();
    }
}