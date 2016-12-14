package obrazek;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

public class ZdrojObrazkuURL extends ZdrojObrazku {
	private static final String SOUBOR = "programkoOdkazy.csv";
	private static final String ODDELOVAC = ";";
	
	
	
	@Override
	public void naplnMapu() {
		nactiCSV();
		
	}

	private void nactiCSV() {
		
		
		try (BufferedReader vstup = new BufferedReader(new FileReader(SOUBOR))) {
			String radek;
			
			for (int i = 0; i < Obrazek.getSize(); i++) {
				if ((radek = vstup.readLine()) != null) {
					
					zpracujRadek(radek);
				}
			}
			
		} catch (IOException e) {
			
			System.out.println("Pri cteni CSV doslo k chybe" + e.getMessage());
		}	
	}

	private void zpracujRadek(String radek) {
		
		StringTokenizer st = new StringTokenizer(radek, ODDELOVAC);
		if (st.countTokens()==2) {
			String prvek = st.nextToken();//hrac
			String odkaz = st.nextToken();//url
			
			if (jePrvekvSeznamu(prvek)) {
				
				getMapa().put(prvek, odkaz);
				
			} else {
				System.out.println("Prvek " + prvek + "neni v seznamu prvku");
			}
	
		}
	
	}

	private boolean jePrvekvSeznamu(String prvek) {
		for (Obrazek o: Obrazek.getObrazky()) {
			if (o.getKlic().equals(prvek)) {
				return true;
			}			
		}
		return false;
	}

	@Override
	public BufferedImage getObrazek() throws IOException {
		URL url = new URL(getZdroj());
		URLConnection urlSpojeni = url.openConnection();		
		urlSpojeni.setReadTimeout(6000);//3 sekundy cti pak prestan		
		InputStream is = urlSpojeni.getInputStream();		
		BufferedImage img = ImageIO.read(is);		
		is.close();		
		return img;
	}

}
