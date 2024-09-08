package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase denominada VentanaPirámide define una ventana para
 * ingresar los datos de una pirámide y calcular su volumen y superficie.
 * @version 1.2/2020
 */
public class VentanaPirámide extends JFrame implements ActionListener {

    // Un contenedor de elementos gráficos
    private Container contenedor;

    // Etiquetas estáticas para identificar los campos de texto a ingresar y calcular
    private JLabel base, altura, apotema, volumen, superficie;

    // Campos de texto a ingresar
    private JTextField campoBase, campoAltura, campoApotema;

    // Botón para realizar los cálculos numéricos
    private JButton calcular;

    /**
     * Constructor de la clase VentanaPirámide
     */
    public VentanaPirámide() {
        inicializarComponentes();
        setTitle("Pirámide"); // Establece el título de la ventana
        setSize(280, 240); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // La ventana se posiciona en el centro de la pantalla
        setResizable(false); // Establece que la ventana no sea redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
    }

    /**
     * Método que crea la ventana con sus diferentes componentes gráficos
     */
    private void inicializarComponentes() {
        contenedor = getContentPane(); // Obtiene el panel de contenidos de la ventana
        contenedor.setLayout(null); // Establece un diseño nulo

        // Configuración de las etiquetas y campos de texto
        base = new JLabel("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        apotema = new JLabel("Apotema (cms):");
        apotema.setBounds(20, 80, 135, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 135, 23);

        // Configuración del botón de calcular
        calcular = new JButton("Calcular");
        calcular.setBounds(120, 110, 135, 23);
        calcular.addActionListener(this);

        // Configuración de las etiquetas de resultados
        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 140, 135, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 170, 135, 23);

        // Agregar los componentes al contenedor
        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Maneja los eventos de acción
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        Piramide pirámide;
        boolean error = false;
        double base = 0;
        double altura = 0;
        double apotema = 0;

        try {
            // Se obtienen y convierten los valores numéricos de los campos
            base = Double.parseDouble(campoBase.getText());
            altura = Double.parseDouble(campoAltura.getText());
            apotema = Double.parseDouble(campoApotema.getText());

            // Se crea un objeto Pirámide
            pirámide = new Piramide(base, altura, apotema);

            // Se muestran el volumen y la superficie
            volumen.setText("Volumen (cm3): " + String.format("%.2f", pirámide.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", pirámide.calcularSuperficie()));

        } catch (NumberFormatException e) {
            error = true; // Si ocurre una excepción por formato de número incorrecto
        } finally {
            if (error) {
                // Si ocurre una excepción, se muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
