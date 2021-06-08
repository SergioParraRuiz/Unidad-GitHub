package Fondo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Fondo.Settings.SliderListener;


//En primer lugar herededaremos de JPanel, para poder crear contenedores

public class Elemento extends JPanel {

	//Definimos  las variables de nuestro proyecto
	
	private final int WIDTH = 600, HEIGHT = 700;
	private JPanel	etiqueta;

	private ImageIcon fondo,escalera2,escalera1,vacuna;
	private int xfondo, yfondo,xescalera2,yescalera2,xescalera1,yescalera1,xvacuna,yvacuna;
	
	private ImageIcon personaje,covid1,covid2,covid3;
	public int xpersonaje,ypersonaje,xcovid1,ycovid1,xcovid2,ycovid2,xcovid3,ycovid3;
	
	private final int DELAY = 20;
	private Timer timer;
	public int moveX1,moveX2,moveX3,aux,playAgain;
	public double JUMP;
	
	public Elemento(){
		
		//En el constructor de elemento, asignaremos el valor a algunas de las variables, iniciaremos 
		//el timmer, y añadiremos Listener para poder trabajar en función de un evento determinado.
		
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
		
		addKeyListener(new DirectionListener());
		JUMP=7;
		
		
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		timer.start();
		setFocusable(true);
		
		


	}
	
	//Esta clase es la que nos permitirá definir la forma en la que se mueven los covids. Los tres 
	//primeros if son los que delimitan el movimiento en el eje 'x' de estos. Además, gracias a esta 
	//clase podremos implementar nuesrto algoritmo de choque.
	
	private class ReboundListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			

			xcovid1+= moveX1;
			xcovid2+=moveX2;
			xcovid3+=moveX3;

			if(xcovid1>=WIDTH-covid1.getIconWidth()+10 | xcovid1<100) moveX1 = moveX1 * -1;
			if(xcovid2>=WIDTH-covid2.getIconWidth()+10 | xcovid2<0) moveX2 = moveX2 * -1;
			if(xcovid3>=WIDTH-covid3.getIconWidth()+10 | xcovid3<0) moveX3 = moveX3 * -1;

			
	//Para el algoritmo de choque, he dividido al personaje en tres zonas distintas, ya que si lo definia 
	//como un rectángulo, había veces donde detectaba choque cuando en el juego realmente no se veia 
	//como tal. De esta forma, separo el personaje en tres rectángulos, una primera zona que abarca la
	// partesuperior de su cabeza, una segunda zona con la parte ancha de su pelo, y por último otra 
	// para el cuerpo y piernas
		
			
//ALGORITMO DE CHOQUE--------------------------------------------------------------------------------
			if(((xpersonaje<=(xcovid1)& (xcovid1)<=(xpersonaje+55))||((xpersonaje-69)<=(xcovid1)& (xcovid1)<=xpersonaje)) & (ypersonaje<=532 & ypersonaje>=528) ) { 			
				detenerJuego();

			}
			if(((xpersonaje<=(xcovid1)& (xcovid1)<=(xpersonaje+35))||((xpersonaje-49)<=(xcovid1)& (xcovid1)<=xpersonaje)) & (ypersonaje<=524 & ypersonaje>=468)) { 	
				detenerJuego();

			}
			if(((xpersonaje<=(xcovid1)& (xcovid1)<=(xpersonaje+25))||((xpersonaje-39)<=(xcovid1)& (xcovid1)<=xpersonaje)) & (ypersonaje<=464 & ypersonaje>=452)) { 			
				detenerJuego();

			}
//SEGUNDA PLANTA ----------------------------------------------------------------------------------------------------------------------------------------
			
			if(((xpersonaje<=(xcovid2)& (xcovid2)<=(xpersonaje+55))||((xpersonaje-69)<=(xcovid2)& (xcovid2)<=xpersonaje)) & (ypersonaje<=280 & ypersonaje>=276)) { 				
				detenerJuego();

			}
			if(((xpersonaje<=(xcovid2)& (xcovid2)<=(xpersonaje+40))||((xpersonaje-54)<=(xcovid2)& (xcovid2)<=xpersonaje)) & (ypersonaje<=272 & ypersonaje>=216)) { 			
				detenerJuego();

			}
			
			if(((xpersonaje<=(xcovid2)& (xcovid2)<=(xpersonaje+25))||((xpersonaje-39)<=(xcovid2)& (xcovid2)<=xpersonaje)) & (ypersonaje<=216 & ypersonaje>=202)) { 			
				detenerJuego();

			}
			
			//Primera escalera-------------------------------------------------------------------------
			
			if(((xpersonaje<=(xcovid2)& (xcovid2)<=(xpersonaje+30))||((xpersonaje-44)<=(xcovid2)& (xcovid2)<=xpersonaje)) & (ypersonaje<=370 & ypersonaje>=344)) { 			
				detenerJuego();

			}
			
			if(((xpersonaje<=(xcovid2)& (xcovid2)<=(xpersonaje+45))||((xpersonaje-59)<=(xcovid2)& (xcovid2)<=xpersonaje)) & (ypersonaje<=344 & ypersonaje>=308)) { 			
				detenerJuego();

			}
			if(((xpersonaje<=(xcovid2)& (xcovid2)<=(xpersonaje+55))||((xpersonaje-69)<=(xcovid2)& (xcovid2)<=xpersonaje)) & (ypersonaje<=308 & ypersonaje>=282)) { 			
				detenerJuego();

			}
			
//TERCERA PLANTA ----------------------------------------------------------------------------------------------------------------------------------------

			if(((xpersonaje<=(xcovid3)& (xcovid3)<=(xpersonaje+55))||((xpersonaje-69)<=(xcovid3)& (xcovid3)<=xpersonaje)) & ypersonaje==70) { 				
				detenerJuego();

			}

//CUANDO SUBE ESCALERA------------------------------------------------------------------------------------------
			if(((xpersonaje<=(xcovid3)& (xcovid3)<=(xpersonaje+15))||((xpersonaje-29)<=(xcovid3)& (xcovid3)<=xpersonaje)) & (ypersonaje<=161 & ypersonaje>=147)) { 				
				detenerJuego();

			}
			
			if(((xpersonaje<=(xcovid3)& (xcovid3)<=(xpersonaje+45))||((xpersonaje-59)<=(xcovid3)& (xcovid3)<=xpersonaje)) & (ypersonaje<=147 & ypersonaje>=110)) { 		
				detenerJuego();

			}
			if(((xpersonaje<=(xcovid3)& (xcovid3)<=(xpersonaje+55))||((xpersonaje-69)<=(xcovid3)& (xcovid3)<=xpersonaje)) & (ypersonaje<=110 & ypersonaje>=77)) { 
				detenerJuego();
			}
			
			
//VACUNA----------------------------------------------------------------------------------------------------------------------------------------			
			if((xpersonaje<=(xvacuna)& (xvacuna)<=(xpersonaje+48)) & ypersonaje==70) { 
				
				//Esta parte del código funciona de la misma manera que detener juego, lo único que 
				//cambia es el mensaje que se muestra.
				
				if(aux==0) {
					JOptionPane.showMessageDialog(null, "¡Enhorabuena, te has vacunado!");
					playAgain=JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?");
				
					if(playAgain==2) {				moveX1=0;moveX2=0;moveX3=0;JUMP=0;aux=1;}
				
						if(playAgain==0) {
							xcovid1=520;
							xcovid2=520;
							xcovid3=520;
							xpersonaje=30;
							ypersonaje=532;

						}
						if(playAgain==1) {System.exit(0);}
				}
				if(aux==1) {moveX1=0;moveX2=0;moveX3=0;JUMP=0;aux=1;}
			}
			
			repaint();	
		}	
	}

	//Con este método dibujaremos los distintos elementos del juego en sus respectivas posiciones
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
		requestFocus();

	}
	
	// Esta clase es la que nos permitirá mover el personaje, gracias a las flechas de nuestro teclado.
	//Definiremos para cada tecla su rango de actuación 
	
	private class DirectionListener extends KeyAdapter{
		public void keyPressed(KeyEvent event){
			
			//Movimiento hacia la derecha
			if((ypersonaje ==532 || ypersonaje==282 || ypersonaje==70||(xpersonaje >=280 & xpersonaje<=357)||(xpersonaje >=86 & xpersonaje<=151))&xpersonaje<=554 ) {
				switch(event.getKeyCode()){	
				case KeyEvent.VK_RIGHT:
					xpersonaje+=JUMP;break;
				
				}			
				repaint();
		}
			
			//Movimiento hacia la izquierda	
			if((ypersonaje ==532 || ypersonaje==282 || ypersonaje==70||(xpersonaje >=287 & xpersonaje<=364)||(xpersonaje >=93 & xpersonaje<=158))& xpersonaje>=0) {
				switch(event.getKeyCode()){
				case KeyEvent.VK_LEFT:
					xpersonaje-=JUMP; break;
				
				}
				repaint();
			}
			
			//Subir escaleras
			if(((xpersonaje >=280 & xpersonaje<=364)& (ypersonaje <=532 & ypersonaje>=288))|| ((xpersonaje >=86 & xpersonaje<=158)& (ypersonaje <=282 & ypersonaje>=74))) {
				if(aux==0) {
				JUMP=4;
				switch(event.getKeyCode()){
				case KeyEvent.VK_UP:
					ypersonaje-=JUMP; break;
					
				}
				}
				JUMP=7;
				repaint();

			}
			
			//Este if sirve para ajustar bien el personaje al suelo de la planta
			
			if((xpersonaje >=280 & xpersonaje<=364)& (ypersonaje ==284)) {
				if(aux==0) {
					JUMP=2;
					switch(event.getKeyCode()){
					case KeyEvent.VK_UP:
						ypersonaje-=JUMP; break;
						
					}
					}

					JUMP=7;
					repaint();
			}
			
			//Bajar escaleras
			if(((xpersonaje >=280 & xpersonaje<=364)& (ypersonaje <=528 & ypersonaje>=284))|| ((xpersonaje >=86 & xpersonaje<=158)& (ypersonaje <=278 & ypersonaje>=70))) {
				if(aux==0) {
				JUMP=4;
				switch(event.getKeyCode()){
				case KeyEvent.VK_DOWN:
					ypersonaje+=JUMP; break;
				
				}
				}

				JUMP=7;
				repaint();
			}
			
			if ((xpersonaje >=280 & xpersonaje<=364)& (ypersonaje ==282)) {
				
				if(aux==0) {
					JUMP=2;
					switch(event.getKeyCode()){
					case KeyEvent.VK_DOWN:
						ypersonaje+=JUMP; break;
					
					}
					}

					JUMP=7;
					repaint();
				
			}
			
		}
	}

	//Este modo nos permitirá detener el jugo en caso de colisión. Una vez que el juego se detiene, 
	//se abrirá una ventana indicándonos que hemos perdido, (en el caso de la vacuna pondría que 
	//hemos ganado), y seguidamente otra ventana que nos dará a elegir entre tres opciones. La primera 
	//de ellas nos reiniciará el juego por completo, colocando al personaje y covids en sus posiciones 
	//iniciales, la segunda opción cerrará por completo la ventana del juego, y la última congelará el juego.
	
	
	public void detenerJuego() {
		
		if(aux==0) {
			JOptionPane.showMessageDialog(null, "Game Over");
			playAgain=JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?");
		
			if(playAgain==2) {				moveX1=0;moveX2=0;moveX3=0;JUMP=0;aux=1;}
		
				if(playAgain==0) {
					xcovid1=520;
					xcovid2=520;
					xcovid3=520;
					xpersonaje=30;
					ypersonaje=532;

				}
				if(playAgain==1) {System.exit(0);}

		}
		// Esta variable auxiliar nos permitirá que al ejecutar la 3ª opción, no nos aparezca repetidas 
		// veces la ventana indicándonos que hemos chocado.
		
		if(aux==1) {moveX1=0;moveX2=0;moveX3=0;JUMP=0;aux=1;}
	}
	
	}
















	
	
