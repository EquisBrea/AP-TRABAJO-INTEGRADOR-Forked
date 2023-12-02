package org.cursoutn.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

    public VentanaInicio() {
        setTitle("Button Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons
        JButton button1 = new JButton("Ingresar datos");
        JButton button2 = new JButton("Buscar datos");
        JButton button3 = new JButton("Eliminar");
        JButton button4 = new JButton("Actualizar");
        JButton button5 = new JButton("Consultas");
        JButton button6 = new JButton("Salir");

        // Set layout manager for the content pane
        setLayout(new GridLayout(2, 3));

        // Add buttons to the content pane
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);

        // Set an explicit size for the frame
        setSize(new Dimension(800, 400));

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);

    }
    private JButton createButton(String buttonText, final String action) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(action);
            }
        });
        return button;
    }

    private void handleButtonClick(String action) {
        // Customize this method based on the action
        switch (action) {
            case "Action 1":
                System.out.println("Performing Action 1");
                // Add your code for Action 1
                break;
            case "Action 2":
                System.out.println("Performing Action 2");
                // Add your code for Action 2
                break;
            case "Action 3":
                System.out.println("Performing Action 3");
                // Add your code for Action 3
                break;
            case "Action 4":
                System.out.println("Performing Action 4");
                // Add your code for Action 4
                break;
            case "Action 5":
                System.out.println("Performing Action 5");
                // Add your code for Action 5
                break;
            case "Action 6":
                System.out.println("Performing Action 6");
                // Add your code for Action 6
                break;
            default:
                System.out.println("Unknown action");
                break;
        }
    }
}