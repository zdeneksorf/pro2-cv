package obrazek;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ZdrojObrazkuSoubor extends ZdrojObrazku {
	private static final String CESTA = "img/";
	
	
	
	@Override
	public void naplnMapu() {
		getMapa().put(Obrazek.POZADI.getKlic(), "plocha4.png");
		
	}

	@Override
	public BufferedImage getObrazek() throws IOException {
		
		return ImageIO.read(new File(CESTA + getZdroj()));
	}
	

	
	
	
	
	
	
	
	
	
	
}
