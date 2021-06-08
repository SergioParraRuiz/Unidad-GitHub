package Fondo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Fondo.Settings.SliderListener;

//mport Fondo.Settings.SliderListener;

//import Fondo.Settings.SliderListener;


public class Fondo extends JPanel {


	
	private final int WIDTH = 600, HEIGHT = 700;

	private ImageIcon fondo,escalera2,escalera1,vacuna,personaje,covid1,covid2,covid3;
	public int xfondo, yfondo,xescalera2,yescalera2,xescalera1,yescalera1,xvacuna,yvacuna,xpersonaje,ypersonaje,xcovid1,ycovid1,xcovid2,ycovid2,xcovid3,ycovid3;
	
	private final int DELAY = 20;
	private Timer timer;
	static int moveX1,moveX2,moveX3;
	
	

	public Fondo(){
		
		timer = new Timer(DELAY, new ReboundListener());
		
		moveX1 =3;
		moveX2 =3;
		moveX3=4;
		
	
		fondo = new ImageIcon("background.png");
		escalera2= new ImageIcon("escalera2.png");
		escalera1= new ImageIcon("escalera1.png");
		vacuna= new ImageIcon("vacuna.png");
		personaje= new ImageIcon("prota.png");
		covid1= new ImageIcon("covid.png");
		covid2= new ImageIcon("covid.png");
		covid3= new ImageIcon("covid.png");


		xcovid1=520;
		ycovid1=552;//568-16
		xcovid2=520;
		ycovid2=301;//317-16
		xcovid3=520;
		ycovid3=93;//105-12
		
		xpersonaje=30;
		ypersonaje=532;
		xvacuna=240;
		yvacuna=150;
		xescalera1=100;
		yescalera1=177;
		xescalera2=300;
		yescalera2=390;
		
		xfondo = 0;
		yfondo = 0;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		timer.start();

	}

	public void paintComponent(Graphics page){
		super.paintComponent(page);
		fondo.paintIcon(this,  page,  xfondo,  yfondo);
		escalera2.paintIcon(this, page, xescalera2, yescalera2);
		escalera1.paintIcon(this, page, xescalera1, yescalera1);
		vacuna.paintIcon(this, page, xvacuna, yvacuna);
		personaje.paintIcon(this, page, xpersonaje, ypersonaje);
		covid1.paintIcon(this, page, xcovid1, ycovid1);
		covid2.paintIcon(this, page, xcovid2, ycovid2);
		covid3.paintIcon(this, page, xcovid3, ycovid3);





	}
	
	private class ReboundListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			


			xcovid1+= moveX1;
			xcovid2+=moveX2;
			xcovid3+=moveX3;


			if(xcovid1>=WIDTH-covid1.getIconWidth() | xcovid1<100) moveX1 = moveX1 * -1;
			if(xcovid2>=WIDTH-covid2.getIconWidth() | xcovid2<0) moveX2 = moveX2 * -1;
			if(xcovid3>=WIDTH-covid3.getIconWidth() | xcovid3<0) moveX3 = moveX3 * -1;

			repaint();
	}
		
	}
	
	
}


	
	
