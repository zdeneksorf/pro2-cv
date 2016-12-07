package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import hra.HraciPlocha;
import obrazek.ManagerObrazku;
import obrazek.ZdrojObrazku;
import obrazek.ZdrojObrazkuSoubor;

public class HraHlavniApp extends JFrame{
	private ManagerObrazku mo;
	
	
	
	public HraHlavniApp(){
		mo = new ManagerObrazku(new ZdrojObrazkuSoubor());
	}
	
	public void spust(){
		
		class Vlakno extends SwingWorker<Object, Object>{
			
			private JFrame vlastnik;
			private JLabel lb;
			private HraciPlocha hraciPlocha;
			
			public void setVlastnik(JFrame vlastnik) {
				this.vlastnik = vlastnik;
			}
			
			
			public void doBeforeExecute(){
				lb = new JLabel("Pripravuji hru...");
				lb.setFont(new Font("Arial", Font.BOLD, 41));
				lb.setForeground(Color.red);
				lb.setHorizontalAlignment(SwingConstants.CENTER);
				
				vlastnik.add(lb);
				lb.setVisible(true);			
				vlastnik.revalidate();
				vlastnik.repaint();
				
				
				
			}
			
			@Override
			protected Object doInBackground() throws Exception {
				mo.pripravObrazky();
				hraciPlocha = new HraciPlocha(mo);
				hraciPlocha.pripravHraciPlochu();
				return null;
			}
			
			@Override
			protected void done() {
				
				super.done();
				
				vlastnik.remove(lb);
				vlastnik.revalidate();
				vlastnik.add(hraciPlocha);
				hraciPlocha.setVisible(true);
				vlastnik.revalidate();
				vlastnik.repaint();
				
			}
					
		}
		
		Vlakno vlakno = new Vlakno();
		vlakno.setVlastnik(this);
		vlakno.doBeforeExecute();
		vlakno.execute();
		
	}
	
	public void initGUI(){
		setSize(HraciPlocha.sirka, HraciPlocha.vyska);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FlappyFIM");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				HraHlavniApp app = new HraHlavniApp();
				app.initGUI();
				app.spust();
			}
		});

	}

}
