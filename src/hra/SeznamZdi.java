package hra;

import java.util.ArrayList;

public class SeznamZdi extends ArrayList<Zed>{
	private static final long serialVersionUID = 1L;
	private int ktera;
	
	public SeznamZdi(){
		super();
		ktera = 0;
	}
	
	@Override
	public void clear(){
		super.clear();
		ktera = 0;     //smaze se seznam a hodnota se recykluje
	}
	
	public Zed getAktualniZed(){
		return this.get(ktera);
	}
	
	public Zed getPredchoziZed(){
		if(ktera > 0){
			return this.get(ktera - 1);
		}
		return this.get(this.size()-1);
	}
	
	public void nastavDalsiZedNaAktualni(){
		if(ktera < this.size()-1){
			ktera = ktera + 1;
		}else{
			ktera = 0;
		}
	}
}
