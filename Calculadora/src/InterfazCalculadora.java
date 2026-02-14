import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class InterfazCalculadora {
    //Variables globales
    static boolean acabaDeCalcular = false;

    // Crear botones
    public static void crearBotones(JPanel panelBotones, JTextField pantalla) {
        panelBotones.setLayout(new GridLayout(4,4,5,5));

        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", ".", "+",
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            panelBotones.add(boton);
            boton.addActionListener(e -> {
                String cmd = e.getActionCommand();

                if (cmd.equals("C")) {
                    pantalla.setText("");
                } else {
                    boolean esOperador =    cmd.equals("+") || cmd.equals("-") ||
                                            cmd.equals("/") || cmd.equals("*");

                    if (acabaDeCalcular && !esOperador) {
                        pantalla.setText(cmd);
                        acabaDeCalcular = false;
                    } else {
                        pantalla.setText(pantalla.getText() + cmd);
                        acabaDeCalcular = false;
                    }
                }
            });
        }
    }


    // Crear ventana
    public static void crearVentana(JPanel panelBotones, JTextField pantalla) {
        JFrame ventana = new JFrame("Calculadora");
        ventana.setSize(300, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        pantalla.setEditable(false);
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));

        JButton botonBorrar = new JButton("⌫");
        botonBorrar.addActionListener(e -> {
            String textoPantalla = pantalla.getText();
            if (!acabaDeCalcular && textoPantalla != null && textoPantalla.length() > 0) {
                pantalla.setText(textoPantalla.substring(0, textoPantalla.length() - 1));
            }
        });

        JButton botonIgual = new JButton("=");
        botonIgual.setFont(new Font("Arial", Font.BOLD, 30));
        botonIgual.addActionListener(e -> {
            Double calculo = Calculadora.calcular(pantalla.getText());
            String calculoString = calculo.toString();
            if (calculo == (int)Math.round(calculo)) {
                pantalla.setText(calculoString.substring(0, calculoString.length() - 2));
            } else {
                pantalla.setText(calculoString);
            }
            acabaDeCalcular = true;
            });

        ventana.add(pantalla, BorderLayout.NORTH);
        ventana.add(panelBotones, BorderLayout.CENTER);
        ventana.add(botonIgual, BorderLayout.SOUTH);
        ventana.add(botonBorrar, BorderLayout.EAST);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }    
}
