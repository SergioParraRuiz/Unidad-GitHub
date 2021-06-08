package Fondo;
import javax.swing.*;




public class Main_Fondo {
	public static void main(String [] args)
	{
		JFrame frame = new JFrame("Rebound");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Generamos un objeto elemento y se lo introducimos a nuestro objeto settings 
		
		Elemento d= new Elemento();
		Settings a=new Settings(d);
		
		//creamos un tabbedPane para poder generar dos pestañas en nuestra ventana del juego
		
		JTabbedPane tp = new JTabbedPane(); 
		tp.addTab("Game",  d);
		tp.addTab("Settings", a );
		frame.getContentPane().add(tp);
		
		
		// Finalmente lo hacemos visible 
		
		frame.pack();
		frame.setVisible(true);
		
	}
}

