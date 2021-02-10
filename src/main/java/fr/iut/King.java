package fr.iut;
import java.util.*;
/**
 * Roi
 * ne se déplace que d'une seule case dans toutes les directions
 */
    public class King extends Piece {

	private Boolean inCheckMate;
	private Boolean inCheck;

	public King(Boolean c) {
		super(c);
		setSymbole("Ro");
	}
	
	public boolean deplacementValide(int departColonne,int departLigne, int arriveeColonne,int arriveeLigne)
	{
		int x = Math.abs(departColonne - arriveeColonne);//La diagonale faisant que les coordonn�e s'incr�mentent ou se d�cr�mentent
		int y = Math.abs(departLigne - arriveeLigne);// proportionnellement, il suffit de regarder si la diff des deux valeurs est toujours �gale
		if((x==1 && y==1) || (x == 0 && y==1) || (x==1 && y==0)) // 1�re condition=> pour les diag 2�me et 3�me cond=> lignes et colo
			return true;
		else 
			return false;
	}

}
