package fr.iut;

/**
 * Tour
 * se déplace sur un seul axe à la fois
 *
 */
public class Rook extends Piece {

	public Rook(Boolean c) {
		super(c);
		setSymbole("T");
	}
	public boolean deplacementValide(int departColonne,int departLigne, int arriveeColonne,int arriveeLigne) {
		if(departColonne == arriveeColonne || departLigne == arriveeLigne)
			return true;
		return false;
	}
}
