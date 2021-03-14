package fr.iut;

/**
 * Fou
 * se déplace de plusieurs cases dans la diagonale
 */
public class Bishop extends Piece {

	public Bishop(Boolean c) {
		super(c);
		setSymbole("F");
	}
	
	public boolean deplacementValide(int departColonne,int departLigne, int arriveeColonne,int arriveeLigne) {
		int x = Math.abs(departColonne - arriveeColonne);
		int y = Math.abs(departLigne - arriveeLigne);
		if(departColonne != arriveeColonne && departLigne != arriveeLigne && (x == y) ) { // proportionally always equals
				return true;
		}
		else
			return false;
	}
}
