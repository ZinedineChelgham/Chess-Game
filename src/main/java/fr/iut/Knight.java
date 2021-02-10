package fr.iut;

/**
 * Cavalier
 * se déplace en sautant dans la forme d'un L dans toutes les directions
 */
public class Knight extends Piece {

	public Knight(Boolean c) {
		super(c);
		setSymbole("C");
	}
	public boolean deplacementValide(int departColonne,int departLigne, int arriveeColonne,int arriveeLigne) {
		int x = Math.abs(departColonne - arriveeColonne);//La diagonale faisant que les coordonn�e s'incr�mentent ou se d�cr�mentent
		int y = Math.abs(departLigne - arriveeLigne);// proportionnellement, il suffit de regarder si la diff des deux valeurs est toujours �gale
		if((!(x == y) || (departColonne == arriveeColonne || departLigne == arriveeLigne)) && ((x==1 && y==2) || x==2 && y==1) )//on enleve les diagonales et lignes,colonnes. et on verifie que le deplacement ne depasse pas deux+une cases.
			return true;
		else 
			return false;
	}
}
