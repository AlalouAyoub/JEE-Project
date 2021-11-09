package web;

import java.util.ArrayList;
import java.util.List;


import location.voiture;

public class VoitureModele {
	private String f;
	private String a="oui" ;
	private String date_min ;
	private String date_fin;
	private int check =2;
	private List<voiture> voitures = new ArrayList<>();
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public String getDate_min() {
		return date_min;
	}
	public void setDate_min(String date_min) {
		this.date_min = date_min;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public List<voiture> getVoitures() {
		return voitures;
	}
	public void setVoitures(List<voiture> voitures) {
		this.voitures = voitures;
	}

}
