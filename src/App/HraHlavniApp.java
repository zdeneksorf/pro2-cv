package App;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hra.HraciPlocha;

public class HraHlavniApp extends JFrame{
	private HraciPlocha hp;

	public HraHlavniApp(){
		//TODO
	}
	
	public void spust(){
		hp = new HraciPlocha();
		hp.pripravHraciPlochu();
		
		getContentPane().add(hp, "Center");
		hp.setVisible(true);
		this.revalidate();
		hp.repaint();
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
