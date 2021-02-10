package fr.iut;

/**
 * Reine
 * se déplace de plusieurs cases dans une direction
 */
public class Queen extends Piece {

	public Queen(Boolean c) {
		super(c);
		setSymbole("Re");
	}
	
	public boolean deplacementValide(int departColonne,int departLigne, int arriveeColonne,int arriveeLigne) {
		int x = Math.abs(departColonne - arriveeColonne);//La diagonale faisant que les coordonn�e s'incr�mentent ou se d�cr�mentent
		int y = Math.abs(departLigne - arriveeLigne);// proportionnellement, il suffit de regarder si la diff des deux valeurs est toujours �gale
		if((x == y) || (departColonne == arriveeColonne || departLigne == arriveeLigne) )
			return true;
		else 
			return false;
	}
}
