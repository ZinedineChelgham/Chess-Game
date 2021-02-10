package fr.iut;

/**
 * Pion
 * se déplace en avant d'une seule case, sauf à la rangée du début.
 *
 */
public class Pawn extends Piece {
	
	public Pawn(Boolean c) {
		super(c);
		setSymbole("P");
	}
	public boolean deplacementValide(int departColonne,int departLigne, int arriveeColonne,int arriveeLigne) {
		int x = Math.abs(departColonne - arriveeColonne);//La diagonale faisant que les coordonnée s'incrémentent ou se décrémentent
		int y = Math.abs(departLigne - arriveeLigne);// proportionnellement, il suffit de regarder si la diff des deux valeurs est toujours égale
		if(((x == 0 && y==1) && (arriveeLigne==departLigne-1) && getIsBlack()) || ((x == 0 && y==1) && (arriveeLigne==departLigne+1) && !getIsBlack()) ) // 1ère condition=> 1 en avant; 2ème cond=> pas de retour en arrière
			return true;
		else if(x==0 && y==2 && ((departLigne == 6 && getIsBlack()) || (departLigne == 1 && !getIsBlack())))//2case si premier deplacement
			return true;
		else
			return ((x==1 && y==1 && arriveeLigne==departLigne-1  && getIsBlack())||((x==1 && y==1) && (arriveeLigne==departLigne+1) && !getIsBlack()));
	}
}
