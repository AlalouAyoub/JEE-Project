package loc;

import java.util.List;

import location.voiture;

public class Testloc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VoitureImpl Vo = new VoitureImpl();
		List<voiture> voitures = Vo.voitureParf("Peu");
		for (voiture v : voitures )
			System.out.println(v);
	}

}
