package org.cursoutn.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Objects;

public class VentanaInicio extends JFrame {
    private JComboBox[] comboBoxes;
    private JPanel buttonPanel;

    public VentanaInicio() {

        setTitle("Button Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*// Create buttons
        JButton button1 = createButton("Ingresar datos", "Action 1");
        JButton button2 = createButton("Buscar datos", "Action 2");
        JButton button3 = createButton("Eliminar", "Action 3");
        JButton button4 = createButton("Actualizar", "Action 4");
        JButton button5 = createButton("Consultas", "Action 5");
        JButton button6 = createButton("Salir", "Action 6");
        */

        // Set layout manager for the content pane
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        String[] opcionesBotones = {"Ingresar datos", "Buscar datos", "Eliminar datos", "Actualizar datos", "Consultas", "Salir"};
        // Add buttons to the new button panel

        // Add buttons to the content pane
        buttonPanel = crearBotoneraConOpciones(opcionesBotones);

        buttonPanel.setLayout(new FlowLayout());


        add(buttonPanel, BorderLayout.NORTH);

        comboBoxes = new JComboBox[6];

        // Set an explicit size for the frame
        setSize(new Dimension(800, 400));

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
        pack();

    }
    private JButton createButton(String buttonText, final String action) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(action, button);
            }
        });
        return button;
    }

    private void handleButtonClick(String action, JButton button) {
        int index = Integer.parseInt(action.substring(action.length() - 1)) - 1;
        // index >> Indice para asignar funciones
        String[] opcionesCuadroDeDialogo = {"Ingresar nuevo Incidente", "Ingresar nuevo cliente", "Ingresar nuevo técnico", "Ingresar nueva especialidad", "Ingresar nuevo servicio", "Menú inicial"};
        String seleccionDatos = showOptionDialog(opcionesCuadroDeDialogo, "Ingresar Datos", "Seleccione los datos a ingresar");
        switch (seleccionDatos){
            case "Ingresar nuevo Incidente":
                JOptionPane.showMessageDialog(null, "Ingresar nuevo Incidente" + seleccionDatos);
                break;
            case "Ingresar nuevo Cliente":
                JOptionPane.showMessageDialog(null, "Ingresar nuevo Cliente" + seleccionDatos);
                break;
            case "Ingresar nuevo Técnico":
                JOptionPane.showMessageDialog(null, "Ingresar nuevo Técnico" + seleccionDatos);
                break;
            case  "Ingresar nueva Especialidad":
                JOptionPane.showMessageDialog(null, "Ingresar nueva Especialidad" + seleccionDatos);
                break;
            case "Ingresar nuevo Servicio":
                JOptionPane.showMessageDialog(null, "Ingresar nuevo Servi" + seleccionDatos);
                break;
            default:
                break;
        }
        /*// Add buttons to the content pane
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        String[] opcionesBotones = {"Ingresar datos", "Buscar datos", "Eliminar datos", "Actualizar datos", "Consultas", "Salir"};
        // Add buttons to the new button panel

        buttonPanel = crearBotoneraConOpciones(opcionesBotones);

        buttonPanel.setLayout(new FlowLayout());

        add(buttonPanel, BorderLayout.NORTH);

        comboBoxes[index] = new JComboBox<>(opcionesComboBox);
        comboBoxes[index].addItem("Choose your option");
        comboBoxes[index].setSelectedIndex(comboBoxes.length); // Set to -1 to keep the default message selected

        setSize(new Dimension(800, 400));


        setLocationRelativeTo(null);

        comboBoxes[index] = new JComboBox<>(opcionesComboBox);

        // Add ActionListener to the JComboBox
        comboBoxes[index].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleComboBoxSelection(index);
            }
        });

        comboBoxes[index].setBounds(button.getX(), button.getY() + button.getHeight(), button.getWidth(), 25);

        // Add JComboBox to the content pane
        buttonPanel.add(comboBoxes[index], BorderLayout.SOUTH);

        setContentPane(buttonPanel);
        //setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        revalidate();
        repaint();
        pack();

         */
    }
    private String showOptionDialog(String[] options, String title, String message) {
        return (String) JOptionPane.showInputDialog(
                this,
                message,
                title,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0] // Default selection
        );
    }

    private JPanel crearBotoneraConOpciones (String[] arrayDeOpciones){
        JPanel newButtonPanel = new JPanel();
        newButtonPanel.setLayout(new BoxLayout(newButtonPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < arrayDeOpciones.length; i++) {
            newButtonPanel.add(createButton(arrayDeOpciones[i], "Action " + (i + 1)));
        }
        return newButtonPanel;
    }
    private void handleComboBoxSelection(int index) {
        String selectedOption = (String) comboBoxes[index].getSelectedItem();
        // Open a new window or perform an action based on the selected option
        JOptionPane.showMessageDialog(this, "Button " + (index + 1) + " - Selected Option: " + selectedOption);

        switch (index) {
            case 0:
                JOptionPane.showMessageDialog(null, "Performing Action 1" + selectedOption);
                // Add your code for Action 1
                break;
            case 1:
                JOptionPane.showMessageDialog(null,"Performing Action 2" + selectedOption);
                // Add your code for Action 2
                break;
            case 2:
                // Add your code for Action 3
                JOptionPane.showMessageDialog(null,"Performing Action 3" + selectedOption);
                break;
            case 3:
                // Add your code for Action 4
                JOptionPane.showMessageDialog(null,"Performing Action 4" + selectedOption);
                break;
            case 4:
                // Add your code for Action 5
                JOptionPane.showMessageDialog(null,"Performing Action 5" + selectedOption);
                break;
            case 5:
                // Add your code for Action 6
                JOptionPane.showMessageDialog(null,"Performing Action 6" + selectedOption);
                break;
            default:
                System.out.println("Unknown action");
                break;
        }
    }

}