package location;

import java.io.Serializable;

public class voiture implements Serializable {
	private long ID;
	private String Voiture;
	private String CarImage;
	private String description;
	private long prix;
	private String active;
	private String date_debut;
	private String date_fin;
	public voiture() {
		super();
	}
	public voiture(String Voiture,String CarImage,String description,long prix,String active,String date_debut,String date_fin) {
		super();
		this.Voiture=Voiture;
		this.CarImage=CarImage;
		this.description=description;
		this.prix=prix;
		this.active=active;
		this.date_debut=date_debut;
		this.date_fin=date_fin;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public float getID() {
		return ID;
	}
	public void setID(long iD) {
		this.ID = iD;
	}
	public String getVoiture() {
		return Voiture;
	}
	public void setVoiture(String voiture) {
		this.Voiture = voiture;
	}
	public String getCarImage() {
		return CarImage;
	}
	public void setCarImage(String carImage) {
		this.CarImage = carImage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "voiture [ID=" + ID + ", Voiture=" + Voiture + ", CarImage=" + CarImage + ", description=" + description
				+ ", prix=" + prix + ", active=" + active + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ "]";
	}
	
	
	
}
