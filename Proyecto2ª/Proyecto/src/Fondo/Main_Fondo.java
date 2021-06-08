package Fondo;
import javax.swing.*;




public class Main_Fondo {
	public static void main(String [] args)
	{
		JFrame frame = new JFrame("Rebound");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		JTabbedPane tp = new JTabbedPane();
		tp.addTab("Game",  new Fondo());
		tp.addTab("Settings", new Settings() );
		frame.getContentPane().add(tp);
		
		frame.pack();
		frame.setVisible(true);
	}
} 


//new sett in main
//