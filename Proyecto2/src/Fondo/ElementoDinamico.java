package Fondo;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class ElementoDinamico extends Elemento{

	ImageIcon imagen;
	int PosX;
	int PosY;
	
	
	public ElementoDinamico(ImageIcon imagen,int pos_x, int pos_y) {
		
		this.imagen=imagen;
		PosX=pos_x;
		PosY=pos_y;
		
		
	}
		
	
	public int getPosX() {
		
		return PosX;
	}
	
	public int getPosY() {
		
		return PosY;
	}
	
	public ImageIcon getImage() {
		
		return imagen;
	}
}
