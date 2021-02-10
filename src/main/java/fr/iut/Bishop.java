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
		int x = Math.abs(departColonne - arriveeColonne);//La diagonale faisant que les coordonn�e s'incr�mentent ou se d�cr�mentent
		int y = Math.abs(departLigne - arriveeLigne);// proportionnellement, il suffit de regarder si la diff des deux valeurs est toujours �gale.
		if(departColonne != arriveeColonne && departLigne != arriveeLigne && (x == y) ) {
				return true;
		}
		else
			return false;
	}
}
