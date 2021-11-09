package location;

import java.io.Serializable;

public class reservation implements Serializable {
	private long ID;
	private String nom_v;
	private String nom_u;
	private long prix;
	private String prenom_u;
	private String tel;
	public reservation() {
		super();
	}
	public reservation(long ID,String nom_v,long prix,String nom_u,String prenom_u,String tel) {
		super();
		this.ID=ID;
		this.nom_v=nom_v;
		this.nom_u=nom_u;
		this.prenom_u=prenom_u;
		this.prix=prix;
		this.tel=tel;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		this.ID = iD;
	}
	public String getNom_v() {
		return nom_v;
	}
	public void setNom_v(String nom_v) {
		this.nom_v = nom_v;
	}
	public String getNom_u() {
		return nom_u;
	}
	public void setNom_u(String nom_u) {
		this.nom_u = nom_u;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	public String getPrenom_u() {
		return prenom_u;
	}
	public void setPrenom_u(String prenom_u) {
		this.prenom_u = prenom_u;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "reservation [ID=" + ID + ", nom_v=" + nom_v + ", nom_u=" + nom_u + ", prix=" + prix + ", prenom_u="
				+ prenom_u + ", tel=" + tel + "]";
	}
}
