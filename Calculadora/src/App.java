import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) {
        JPanel panelBotones = new JPanel();
        JTextField pantalla = new JTextField();
        InterfazCalculadora.crearBotones(panelBotones, pantalla);
        InterfazCalculadora.crearVentana(panelBotones, pantalla);
    }
};
