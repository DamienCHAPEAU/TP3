package bowling;

import java.util.ArrayList;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
	/**
	 * Constructeur
	 */
       
	private ArrayList<Integer> nbQuilleTombee;    
                
	public SinglePlayerGame() {            
            nbQuilleTombee = new ArrayList<>();
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            nbQuilleTombee.add(nombreDeQuillesAbattues);
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {    
                int score = 0;
		int tour = 0;
                	
		for (int i = 0; i < 10; i++) {
                        //Strike
			if ((nbQuilleTombee.get(tour))==10) {
				score += 10 + (nbQuilleTombee.get(tour+1) + nbQuilleTombee.get(tour+2));
				tour++;
                        //Spare
			} else if ((nbQuilleTombee.get(tour)+nbQuilleTombee.get(tour+1))==10) {
				score += 10 + nbQuilleTombee.get(tour+2);
				tour+=2;
                        //Autres
			} else {
				score += nbQuilleTombee.get(tour)+nbQuilleTombee.get(tour+1);
				tour+=2;
			}
		}
		return score;
	}

}