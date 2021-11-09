package loc;
import java.util.List;

import location.reservation;
import location.voiture;

public interface IVoiture {
	public voiture save(voiture p);
	public void delete(int Id);
	public void update (int id , String nom,String carI,String desc,int prix,String active ,String date_debut,String date_fin);
	public List<voiture> voitureParf(String f);
	public voiture voitureParid(int id);
	public List<voiture> voiturePara(String a);
	public List<voiture> unique(List<voiture> v1);
	public List<voiture> inter(List<voiture> v1,List<voiture> v2);
	public List<voiture> datedf(String date_d,String date_f);
	public void save_r (int id , String nom, String prenom,String tel);
	public void switch_a (int id);
	public List<reservation> mes_r();
	public void annuler_r(int id);
	public void switch_a_n (int id);	
//	public voiture updateVoiture(voiture v);
//	public void deleteVoiture(Long ID);
}
