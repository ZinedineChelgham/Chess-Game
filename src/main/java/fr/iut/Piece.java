package fr.iut;

public abstract class Piece {
	/**
	 * 0 si blanc, 1 si noir.
	 */
	private Boolean isBlack;
	private String symbole;
	
	public Piece(Boolean isBlack) {
		this.isBlack = isBlack;
		symbole = "?";
	}
	
	public abstract boolean deplacementValide(int departColonne,int departLigne, int arriveeColonne,int arriveeLigne);

	void setSymbole(String c) {
		symbole = c;
	}

	/**
	 * Affiche le symbole et la couleur d'une pièce
	 * Exemple : si une pièce est un pion noire, affiche "Pn"
	 */
	public String toString() {
	if(isBlack)
		return symbole+"n";
	return symbole+"b";
	}

	public Boolean getIsBlack() {
		return isBlack;
	}

	public void setIsBlack(Boolean isBlack) {
		this.isBlack = isBlack;
	}

	public String getSymbole() {
		return symbole;
	}
}
