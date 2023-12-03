package org.cursoutn.GUI;

import javax.swing.*;
import java.awt.*;

class VentanaIngresarIncidente extends JFrame {
    private JTextField textFieldIncidente;
    private JTextField textFieldDescripcion;
    private JTextField textFieldFecha;

    public VentanaIngresarIncidente() {
        setTitle("Ingresar Incidente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set layout manager for the content pane
        setLayout(new GridLayout(4, 2)); // 4 rows, 2 columns

        // Create and add text fields for incident information
        JLabel labelIncidente = new JLabel("Incidente:");
        textFieldIncidente = new JTextField();
        JLabel labelDescripcion = new JLabel("Descripción:");
        textFieldDescripcion = new JTextField();
        JLabel labelFecha = new JLabel("Fecha:");
        textFieldFecha = new JTextField();

        add(labelIncidente);
        add(textFieldIncidente);
        add(labelDescripcion);
        add(textFieldDescripcion);
        add(labelFecha);
        add(textFieldFecha);

        // Create and add a button for submitting the incident
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> handleSubmitButtonClick());
        add(submitButton);

        // Set an explicit size for the frame
        setSize(new Dimension(400, 200));

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    private void handleSubmitButtonClick() {
        // Get the values from text fields
        String incidente = textFieldIncidente.getText();
        String descripcion = textFieldDescripcion.getText();
        String fecha = textFieldFecha.getText();

        // Perform actions with the entered incident information
        // For now, just display the information in a message dialog
        String message = "Incidente: " + incidente + "\nDescripción: " + descripcion + "\nFecha: " + fecha;
        JOptionPane.showMessageDialog(this, message, "Incident Information", JOptionPane.INFORMATION_MESSAGE);

        // You can add more actions here, such as saving the incident information to a database
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaIngresarIncidente ventanaIncidente = new VentanaIngresarIncidente();
            ventanaIncidente.setVisible(true);
        });
    }
}