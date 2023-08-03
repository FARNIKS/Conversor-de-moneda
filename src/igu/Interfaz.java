package igu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Interfaz extends JPanel {
	private ImageIcon logo;
	
    public Interfaz() {
    	setBackground(SystemColor.menu);
    	logo= new ImageIcon(getClass().getResource("/imgs/LogoLinkedIn.png"));
    	
    	setLayout(null);
    	JLabel lblLinkedIn = new JLabel();
    	lblLinkedIn.setBounds(310, 393, 50, 51);
    	lblLinkedIn.setForeground(Color.BLUE);
    	lblLinkedIn.setIcon(new ImageIcon(logo.getImage().getScaledInstance(46,41,Image.SCALE_SMOOTH)));
    	lblLinkedIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	lblLinkedIn.addMouseListener(new MouseAdapter() {
    	    @Override
    	    public void mouseClicked(MouseEvent e) {
    	        abrirEnlace("https://www.linkedin.com/in/miguel-jimenez-b34899264/");
    	    }
    	});
    	add(lblLinkedIn);
    	
    	logo= new ImageIcon(getClass().getResource("/imgs/LogoGithub.png"));
    	JLabel lblGitHub = new JLabel();
    	lblGitHub.setBounds(250, 393, 50, 51);
    	lblGitHub.setIcon(new ImageIcon(logo.getImage().getScaledInstance(46,41,Image.SCALE_SMOOTH)));
    	add(lblGitHub);
    	lblGitHub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	lblGitHub.addMouseListener(new MouseAdapter() {
    	     @Override
    	     public void mouseClicked(MouseEvent e) {
    	         abrirEnlace("https://github.com/FARNIKS");
    	     }
    	 });
    	
    	         add(lblGitHub);
    	
         
         
         
         JLabel lblNewLabel = new JLabel("CONVERSOR");
         lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
         lblNewLabel.setBounds(10, 0, 604, 51);
         add(lblNewLabel);
         
         JTextArea txtrEsteEsUn = new JTextArea();
         txtrEsteEsUn.setBackground(SystemColor.menu);
         txtrEsteEsUn.setEditable(false);
         txtrEsteEsUn.setFont(new Font("Century Gothic", Font.BOLD, 13));
         txtrEsteEsUn.setText("Este es un conversor creado para ONE(Oracle Next Education). se debe elegir el\r\n tipo de conversor para que se ejecuten las funciones acontinuacion:\r\n\r\n      •Moneda: Se hace el cambio de distintas divisas, al seleccionarlo se demora\r\n      Entre 3 a 5 segundos y también si eligen los mismos valores se demorará \r\n      lo mismo (La demora solo sucede en esta). \r\n             - Las monedas presentes son Libra Esterlina, Dólar Estadounidense,\r\n            Pesos Colombianos, Yen Japones, Won Sur Coreano y Euro \r\n\r\n      •Temperatura: Se calculan los grados Fahrenheit, Celsius y Kelvin. \r\n\r\n      •Velocidad: Se calculan las velocidades de Pie por segundo, Metros por \r\n      Segundo, Milla por hora, Kilómetros por hora y Nudos.\r\n \r\n      •Tiempo: Calcular cantidades de tiempo mas generales como: \r\n      Milisegundo, Minuto, Segundo, Hora y Dia.\r\n\r\n      •Longitud: Se calcula las diferentes formas de medición como:\r\n      Centímetro, Milímetro, Metro y Kilometro.\r\n ");
         txtrEsteEsUn.setBounds(39, 44, 545, 327);
         add(txtrEsteEsUn);
         
         JLabel lblNewLabel_1 = new JLabel("Creado por Miguel Angel Jimenez Fajardo");
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel_1.setBounds(10, 371, 604, 31);
         add(lblNewLabel_1);

         
     }

     // Método para abrir el enlace en el navegador predeterminado
     private void abrirEnlace(String url) {
         try {
             URI uri = new URI(url);
             Desktop.getDesktop().browse(uri);
         } catch (IOException | URISyntaxException e) {
             e.printStackTrace();
         }
     }
}
