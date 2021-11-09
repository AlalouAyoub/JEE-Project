package loc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import location.SingletonConnection;
import location.reservation;
import location.voiture;

public class VoitureImpl implements IVoiture {
	public voiture save(voiture v) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO voitures ( Voiture, carImage, description, Prix, active, date_debut, date_fin) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, v.getVoiture());
			ps.setString(2, v.getCarImage());
			ps.setString(3, v.getDescription());
			ps.setLong(4, v.getPrix());
			ps.setString(5, v.getActive());
			ps.setString(6, v.getDate_debut());
			ps.setString(7, v.getDate_fin());
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return v;	
	}
	public List<voiture> voitureParf(String f){
		List<voiture> voitures = new ArrayList<voiture>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voitures where Voiture LIKE ?");
			ps.setString(1, "%"+f+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				voiture v = new voiture();
				v.setID(rs.getLong("ID"));
				v.setVoiture(rs.getString("Voiture"));
				v.setCarImage(rs.getString("carImage"));
				v.setDescription(rs.getString("description"));
				v.setPrix(rs.getLong("prix"));
				v.setActive(rs.getString("active"));
				voitures.add(v);
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return voitures;
	}
	public List<voiture> voiturePara(String a){
		List<voiture> voitures = new ArrayList<voiture>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voitures where active LIKE ?");
			ps.setString(1, "%"+a+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				voiture v = new voiture();
				v.setID(rs.getLong("ID"));
				v.setVoiture(rs.getString("Voiture"));
				v.setCarImage(rs.getString("carImage"));
				v.setDescription(rs.getString("description"));
				v.setPrix(rs.getLong("prix"));
				v.setActive(rs.getString("active"));
				voitures.add(v);
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return voitures;
	}
	@Override
	public List<voiture> unique(List<voiture> v1) {
		for (int i =0 ;i<v1.size()-1;i++) {
			for (int j =i+1 ;j<v1.size();j++) {
				if(v1.get(i).getID()==v1.get(j).getID()) {
					v1.remove(j);
				}
			}
		}
		return v1;
	}
	@Override
	public List<voiture> inter(List<voiture> v1,List<voiture> v2) {
		List<voiture> voitures = new ArrayList<>();
		for (voiture v_1:v1) {
			for (voiture v_2:v2) {
				if(v_1.getID()==v_2.getID()) {voitures.add(v_1);}
			}
		}
		return voitures;

	}
	@Override
	public List<voiture> datedf(String date_d, String date_f) {
		// TODO Auto-generated method stub
		List<voiture> voitures = new ArrayList<>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voitures where date_debut<=? and date_fin>=?");
			ps.setString(1, date_d);
			ps.setString(2, date_f);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				voiture v = new voiture();
				v.setID(rs.getLong("ID"));
				v.setVoiture(rs.getString("Voiture"));
				v.setCarImage(rs.getString("carImage"));
				v.setDescription(rs.getString("description"));
				v.setPrix(rs.getLong("prix"));
				v.setActive(rs.getString("active"));
				v.setDate_debut(rs.getString("date_debut"));
				v.setDate_fin(rs.getString("date_fin"));
				voitures.add(v);
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return voitures;
	}
	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM voitures WHERE ID = ?;");
			ps.setInt(1, Id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	@Override
	public voiture voitureParid(int id) {
		// TODO Auto-generated method stub
		voiture v = new voiture();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from voitures where ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			v.setID(rs.getLong("ID"));
			v.setVoiture(rs.getString("Voiture"));
			v.setCarImage(rs.getString("carImage"));
			v.setDescription(rs.getString("description"));
			v.setPrix(rs.getLong("prix"));
			v.setActive(rs.getString("active"));
			v.setDate_debut(rs.getString("date_debut"));
			v.setDate_fin(rs.getString("date_fin"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	@Override
	public void update(int id, String nom, String carI, String desc, int prix, String active, String date_debut,
			String date_fin) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("update voitures set Voiture= ?, carImage= ?, description =?, prix=?, active= ? , date_debut = ? ,date_fin = ? where ID=?");
			ps.setString(1, nom);
			ps.setString(2, carI);
			ps.setString(3, desc);
			ps.setLong(4, prix);
			ps.setString(5, active);
			ps.setString(6, date_debut);
			ps.setString(7, date_fin);
			ps.setInt(8, id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void save_r(int id, String nom, String prenom, String tel) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO utilisateur ( ID_voiture, nom, prenom, Numero_Tel) VALUES(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, nom);
			ps.setString(3, prenom);
			ps.setString(4, tel);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void switch_a(int id) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("update voitures set active= 'non' where ID=? ;");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	@Override
	public List<reservation> mes_r() {
		// TODO Auto-generated method stub
		List<reservation> mes_r = new ArrayList<reservation>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from utilisateur,voitures where utilisateur.ID_voiture=voitures.ID;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reservation r = new reservation();
				r.setID(rs.getLong("ID"));
				r.setNom_v(rs.getString("Voiture"));
				r.setNom_u(rs.getString("nom"));
				r.setPrenom_u(rs.getString("prenom"));
				r.setPrix(rs.getLong("prix"));
				r.setTel(rs.getString("Numero_Tel"));
				mes_r.add(r);
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return mes_r;
	}
	@Override
	public void annuler_r(int id) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM utilisateur WHERE ID_voiture = ?;");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	@Override
	public void switch_a_n(int id) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("update voitures set active= 'oui' where ID=? ;");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
}
