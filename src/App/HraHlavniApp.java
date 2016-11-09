package App;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hra.HraciPlocha;

public class HraHlavniApp extends JFrame {
	private HraciPlocha hp;
	public HraHlavniApp() {
		
		
		
	}
	public void initGUI(){
		setSize(HraciPlocha.SIRKA, HraciPlocha.VYSKA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FlappyFIM");
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
	}
	
	public void spust(){
		
		hp = new HraciPlocha();
		hp.pripravHraciPlochu();
		getContentPane().add(hp, "Center");
		hp.setVisible(true);
		this.revalidate();
		this.repaint();
		
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				HraHlavniApp app = new HraHlavniApp();
				app.initGUI();
				app.spust();
			
			}
		});

	}

}
