package fr.iut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class ChessBoard {
	private Piece[][] cases;
	private boolean tour;

	/**
	 * Instancie un ChessBoard de 64 Pieces (vide), puis instancie des Pieces selon l'emplacement standard
	 */
	public ChessBoard() {
		cases = new Piece[8][8];
		tour = false;
	}

	/**
	 * Instancie un ChessBoard de 64 Piece (vide), puis instancie des Pieces selon un fichier .csv
	 *
	 * @param s Le nom du fichier
	 * @throws Exception Si le fichier n'existe pas.
	 */
	public ChessBoard(String s) throws Exception {
		cases = new Piece[8][8];
		tour = false;
		loadgame(s);
	}

	/**
	 * Instancie les pieces pour une partie standard d'échecs.
	 */
	public void loadgame() {
		for (int i = 0; i < 8; i++) {
			cases[i][1] = new Pawn(false);
		}
		for (int i = 0; i < 8; i++) {
			cases[i][6] = new Pawn(true);
		}
		cases[0][0] = new Rook(false);
		cases[1][0] = new Knight(false);
		cases[2][0] = new Bishop(false);
		cases[3][0] = new Queen(false);
		cases[4][0] = new King(false);
		cases[5][0] = new Bishop(false);
		cases[6][0] = new Knight(false);
		cases[7][0] = new Rook(false);
		cases[0][7] = new Rook(true);
		cases[1][7] = new Knight(true);
		cases[2][7] = new Bishop(true);
		cases[3][7] = new Queen(true);
		cases[4][7] = new King(true);
		cases[5][7] = new Bishop(true);
		cases[6][7] = new Knight(true);
		cases[7][7] = new Rook(true);
	}

	public void loadgame(String s) throws Exception {
		readFile(s);
	}

	/**
	 * Lis les cases du fichier du chemin donné en paramètre
	 *
	 * @param s Le chemin du fichier à lire
	 * @throws Exception si la lecture du fichier par le chemin échoue
	 */
	public void readFile(String s) throws Exception {
		FileReader f = new FileReader(s);
		BufferedReader b = new BufferedReader(f);
		int lineNumber = 7;
		while (b.ready()) {
			String line = b.readLine();
			String[] p = line.split(",");
			for (int i = 0; i < p.length; i++) {
				determinePiece(p[i], i, lineNumber);
			}
			lineNumber--;
		}
		b.close();
		f.close();
	}

	/**
	 * Détermine et instance la pièce dans une case du ChessBoard
	 *
	 * @param s          Le String référencant le type de Pièce
	 * @param i          La position de la Piece sur une ligne
	 * @param lineNumber La position de la Piece sur une colonne
	 * @throws Exception si la Piece référencée est incorrecte
	 */
	public void determinePiece(String s, int i, int lineNumber) throws Exception {
		if (s.length() > 3)
			throw new Exception("Pi�ce non prise en compte");
		if (!s.toLowerCase().startsWith("r") && s.length() > 2)
			throw new Exception("Pi�ce non prise en compte");
		if (s.toLowerCase().startsWith("v") && s.length() > 1)
			throw new Exception("Une case vide doit simplement être représentée par \"v\"");
		boolean color = determineColor(s);
		switch (s.toLowerCase().charAt(0)) {
			case 't':
				cases[i][lineNumber] = new Rook(color);
				break;
			case 'c':
				cases[i][lineNumber] = new Knight(color);
				break;
			case 'f':
				cases[i][lineNumber] = new Bishop(color);
				break;
			case 'p':
				cases[i][lineNumber] = new Pawn(color);
				break;
			case 'r':
				switch (s.toLowerCase().charAt(1)) {
					case 'e':
						cases[i][lineNumber] = new Queen(color);
						break;
					case 'o':
						cases[i][lineNumber] = new King(color);
						break;
					default:
						throw new Exception("Pi�ce non prise en compte");
				}
				break;
			case 'v':
				cases[i][lineNumber] = null;
				break;
			default:
				throw new Exception("Pi�ce non reconnue");
		}
	}

	/**
	 * Lit le second caractère d'une Piece et détermine si cette Piece est blanche ou noire.
	 *
	 * @param s La piece sous forme de String
	 * @return Un booléen, égal à la couleur de la Piece
	 * @throws Exception Si le caractère ne correspond pas à une couleur attendue ('b' ou 'n')
	 */
	public boolean determineColor(String s) throws Exception {
		char color = s.toLowerCase().charAt(s.length() - 1);
		if (color == 'n')
			return true;
		else if (color == 'b' || color == 'v')
			return false;
		else
			throw new Exception("Couleur non prise en compte pour " + color);
	}


	public void movePiece() {
		try {
			Scanner sc = new Scanner(System.in);
			String deplacement = null;
			boolean inputValide = false;
			Piece p = null; // on créer une variable de type piece pour faciliter les conditions
			int lettreDepart = 0; //Pour initialiser la piece et faire des vérifications
			int chiffreDepart = 0;
			int lettreArrivee = 0;
			int chiffreArrivee = 0;
			while (!inputValide) {
				deplacement = sc.nextLine();
				int compteur = 0; //Il va nous permettre de vérifier que toutes les erreurs ont bien été évitées
				if (deplacement.length() != 5) {
					System.out.println("Commande invalide veuillez recommencer");
				} else
					compteur++;

				if (translator(deplacement.charAt(0)) == -1) {
					System.out.println("Lettre invalide veuillez recommencer");
				} else
					compteur++;

				if (translator(deplacement.charAt(3)) == -1) {
					System.out.println("Lettre invalide veuillez recommencer");
				} else
					compteur++;

				if (Integer.parseInt(Character.toString(deplacement.charAt(1))) <= 0 ||
						Integer.parseInt(Character.toString(deplacement.charAt(1))) > 8) {
					System.out.println("Chiffre invalide veuillez recommencer");
				} else
					compteur++;

				if (Integer.parseInt(Character.toString(deplacement.charAt(4))) <= 0 ||
						Integer.parseInt(Character.toString(deplacement.charAt(4))) > 8) {
					System.out.println("Chiffre invalide veuillez recommencer");
				} else
					compteur++;

				lettreDepart = translator(deplacement.charAt(0));
				chiffreDepart = Integer.parseInt(Character.toString(deplacement.charAt(1))) - 1;// ChessBoard Matrice 0-7 et pas 1-8
				p = cases[lettreDepart][chiffreDepart];
				if (p == null) {
					System.out.println("Il n'y a pas de piece dans cette case veuillez en choisir une autre");
				} else
					compteur++;

				if (p != null && p.getIsBlack() != this.tour) { // Vérifie bien que les joueurs déplacent leurs pieces et pas celle de l'autre.
					System.out.println("Vous ne pouvez pas deplacer les pieces d'un autre joueur, veuillez recommencer");
				} else
					compteur++;

				lettreArrivee = translator(deplacement.charAt(3));
				chiffreArrivee = Integer.parseInt(Character.toString(deplacement.charAt(4))) - 1;// ChessBoard Matrice 0-7 et pas 1-8
				if (!cheminValide(lettreDepart, chiffreDepart, lettreArrivee, chiffreArrivee))
					System.out.println("Vous ne pouvez pas vous deplacer ainsi, veuillez recommencer");
				else
					compteur++;

				if (compteur == 8)
					inputValide = true;
			}
			this.cases[lettreArrivee][chiffreArrivee] = p;
			this.cases[lettreDepart][chiffreDepart] = null;
			this.tour = !this.tour;
		} catch (NullPointerException ignore) {}
	}

	/**
	 *
	 * @param s commande du joueur
	 * @return	le numéro de ligne correspondant
	 */
	public int translator (char s) {

		switch(Character.toLowerCase(s)) { // On accepte ici le fait qu'une majuscule soit présente au début
			case 'a' :
				return 0;
			case 'b' :
				return 1;
			case 'c' :
				return 2;
			case 'd' :
				return 3;
			case 'e' :
				return 4;
			case 'f' :
				return 5;
			case 'g' :
				return 6;
			case 'h' :
				return 7;
		}
		return -1;
	}

	/**
	 * Affiche l'échequier dans l'état qu'il se trouve
	 */
	public void display() {
		System.out.print("   A   B   C   D   E   F   G   H\n");
		System.out.print("   _______________________________\n");
		for (int i=7; i>=0;i--) {
			System.out.print((i+1) + " ");
			for (int j =0; j<=7;j++) {
				System.out.print("|");
				if(cases[j][i] == null)
					System.out.print("   ");
				else {
					System.out.print(cases[j][i].toString());
					if (cases[j][i].toString().length() <= 2) // les seules pièces à avoir plus de deux caractères sont le Roi et la Reine
						System.out.print(" ");
				}
			}
			System.out.print("| " + (i+1));
			System.out.print("\n");
		}
		System.out.print("  ---------------------------------\n");
		System.out.print("   A   B   C   D   E   F   G   H\n");
	}
	public boolean estEnEchec(boolean estNoir) {
		int lRoi = 0, cRoi = 0;
		//on cherche le Roi de la bonne couleur
		for(int l = 0; l < 8; l++){
			for(int c = 0; c < 8; c++)
				if(cases[l][c] != null && cases[l][c] instanceof King && cases[l][c].getIsBlack() == estNoir) {
					lRoi = l;
					cRoi = c;
				}
		}
		//si une Piece de la couleur adverse peut manger le Roi allié, il est en echec
		for(int l = 0; l < 8; l++){
			for(int c = 0; c < 8; c++)
				if(cases[l][c] != null && cases[l][c].getIsBlack() != estNoir && cheminValide(l,c,lRoi,cRoi)) {
					return true;
				}
		}
		return false;
	}
	
	public boolean echecEtMat(boolean estNoir) {
		int lRoi = 0, cRoi = 0;
		int[] posCases = new int[16];
		int a = 0;
		int l = 0,c = 0;
		//On veut déterminer où se trouve le Roi de couleur estNoir.
		for( l = 0; l < 8; l++){
			for( c = 0; c < 8; c++)
				if(cases[l][c] != null && cases[l][c] instanceof King && cases[l][c].getIsBlack() == estNoir) {
					lRoi = l;
					cRoi = c;
				}
		}
		//On veut trouver les cases où le Roi peut aller
		// 0 1 2
		// 3 R 4
		// 5 6 7

		if(lRoi != 0 && cRoi != 7) {
			posCases[a * 2] = lRoi - 1; //0
			posCases[a * 2 + 1] = cRoi + 1; //0
			a++;
		}
		if(cRoi != 7){
			posCases[a * 2] = lRoi; //1
			posCases[a * 2 + 1] = cRoi + 1; //1
			a++;
		}
		if(cRoi != 7 && lRoi != 7){
			posCases[a * 2] = lRoi + 1; //2
			posCases[a * 2 + 1] = cRoi + 1; //2
			a++;
		}
		if(lRoi != 0){
			posCases[a * 2] = lRoi - 1; //3
			posCases[a * 2 + 1] = cRoi; //3
			a++;
		}
		if(lRoi != 7){
			posCases[a * 2] = lRoi + 1; //4
			posCases[a * 2 + 1] = cRoi; //4
			a++;
		}
		if(lRoi != 0 && cRoi != 0){
			posCases[a * 2] = lRoi - 1; //5
			posCases[a * 2 + 1] = cRoi - 1; //5
			a++;
		}
		if(cRoi != 0){
			posCases[a * 2] = lRoi; //6
			posCases[a * 2 + 1] = cRoi - 1; //6
			a++;
		}
		if(cRoi != 7 && cRoi != 0){
			posCases[a * 2] = lRoi + 1; //7
			posCases[a * 2 + 1] = cRoi - 1; //7
		}


		//Les cases sont isolées. On vérifie maintenant qu'il existe une ouverture dans ces cases où le Roi peut s'échapper
		//En recherchant les cases pouvant être attaquées par ces Pieces adverses
		for(int i = 0; i < a; i+=2){
			caseBloque:
			//Si, pour toutes les cases que le Roi peut traverser...
			for(l = 0; l < 8; l++){
				for( c = 0; c < 8; c++){
					if(cases[l][c] != null && cases[l][c].getIsBlack() != estNoir && cheminValide(l,c,posCases[i],posCases[i+1])){
						break caseBloque;
					}

				}
			}
			//Il n'en existe aucune qui ne vérifie pas le label de break...
			if(l == 7 && c == 7 && !cheminValide(l,c,posCases[i],posCases[i+1]))
				return false; //Le Roi n'est pas mat.
		}
		return estEnEchec(estNoir);

	}

	public Piece[][] getCases() {
		return cases;
	}

	public void setCases(Piece[][] cases) {
		this.cases = cases;
	}

	/**
	 * Détermine si le chemin vers la piece ou case n'est pas obstruée par quelque chose.
	 * Ne s'applique pas aux Knights
	 *
	 * @param depLettre  la position de départ dans les colonnes (lettres)
	 * @param depChiffre la position de départ dans les lignes (chiffres)
	 * @param arrLettre  la position d'arrivée dans les colonnes (lettres)
	 * @param arrChiffre la position d'arrivée dans les lignes (chiffres)
	 * @return si le chemin est possible
	 */
	public boolean cheminValide(int depLettre, int depChiffre, int arrLettre, int arrChiffre) {
		if(!cases[depLettre][depChiffre].deplacementValide(depLettre,depChiffre,arrLettre,arrChiffre))
			return false;
		/// CONDITIONS SPECIALES POUR CERTAINES PIECES
		if (cases[depLettre][depChiffre] instanceof Knight)
			return  (cases[arrLettre][arrChiffre] == null ||
					cases[depLettre][depChiffre].getIsBlack() != cases[arrLettre][arrChiffre].getIsBlack());


		if(cases[depLettre][depChiffre] instanceof Pawn){
			if(cases[depLettre][depChiffre].getIsBlack()){
				if (cases[arrLettre][arrChiffre] == null) return true;
				if (cases[depLettre][depChiffre].getIsBlack() != cases[arrLettre][arrChiffre].getIsBlack())
					return cases[depLettre - 1][depChiffre - 1] != null || cases[depLettre + 1][depChiffre - 1] != null;
				return false;
						// si les diagonales contiennent une pièce OU il n'y a pas de pièce devant, on avance.
						// (le Pawn sait déjà qu'il se déplace d'une case.)
			}
			else{
				if (cases[arrLettre][arrChiffre] == null) return true;
				if (cases[depLettre][depChiffre].getIsBlack() != cases[arrLettre][arrChiffre].getIsBlack())
					return cases[depLettre - 1][depChiffre + 1] != null || cases[depLettre + 1][depChiffre + 1] != null;
				return false;
			}
		}

		/// CONDITIONS SPECIALES POUR CERTAINES PIECES

		ArrayList<Piece> pListe = new ArrayList<>();

		//Gestion des cas si la Piece se déplace dans une diagonale
		// !! pour ne pas prendre en compte la Piece 2 fois si jamais il y a un soucis avec deplacementValide(),
		// je prend une zone qui comprend la Piece cible mais pas la Piece de depart
		// (cela élimine aussi le problème de détection de la Reine)
		pListe.add(cases[depLettre][depChiffre]);

		if (arrChiffre < depChiffre) {
			// si on descend...
			if (arrLettre < depLettre) {
				//ET qu'on va à gauche...
				for (int c = depChiffre - 1; c >= arrChiffre; c--) {
					for (int l = depLettre - 1; l >= arrLettre; l--) {
						//ET que le deplacement est valide pour la Piece...
						if (cases[depLettre][depChiffre].deplacementValide(depLettre, depChiffre,  l, c)) {
							//on met toutes les cases dans un tableau, que l'on traitera ensuite
							pListe.add(cases[l][c]);
						}
					}
				}
			}
			else if (arrLettre > depLettre) {
				//ET qu'on va à droite...
				for (int c = depChiffre - 1; c >= arrChiffre; c--) {
					for (int l = depLettre + 1; l <= arrLettre; l++) {
						//ET que le deplacement est valide pour la Piece...
						if (cases[depLettre][depChiffre].deplacementValide(depLettre, depChiffre,  l, c)) {
							//on met toutes les cases dans un tableau, que l'on traitera ensuite
							pListe.add(cases[l][c]);
						}
					}
				}
			}
		}

		if (arrChiffre > depChiffre) {
			//sinon, si on monte...
			if (arrLettre < depLettre) {
				//ET qu'on va à gauche...
				for (int c = depChiffre + 1; c <= arrChiffre; c++) {
					for (int l = depLettre - 1; l >= arrLettre; l--) {
						//ET que le deplacement est valide pour la Piece...
						if (cases[depLettre][depChiffre].deplacementValide(depLettre, depChiffre,  l, c)) {
							//on met toutes les cases dans un tableau, que l'on traitera ensuite
							pListe.add(cases[l][c]);
						}
					}
				}
			}
			else if (arrLettre > depLettre) {
				//OU qu'on va à droite...
				for (int c = depChiffre + 1; c <= arrChiffre; c++) {
					for (int l = depLettre + 1; l <= arrLettre; l++) {
						//ET que le deplacement est valide pour la Piece...
						if (cases[depLettre][depChiffre].deplacementValide(depLettre, depChiffre,  l, c)) {
							//on met toutes les cases dans un tableau, que l'on traitera ensuite
							pListe.add(cases[l][c]);
						}
					}
				}
			}
		}

		if (depLettre == arrLettre){
			//Si on ne bouge pas de l'axe des lettres...
			if(arrChiffre - depChiffre < 0){
				//ET que nous allons à gauche...
				for(int c = depChiffre-1; c >= arrChiffre; c--){
					if (cases[depLettre][depChiffre].deplacementValide(depLettre, depChiffre, arrLettre, c)) {
						//on met toutes les cases dans un tableau, que l'on traitera ensuite
						pListe.add(cases[depLettre][c]);
					}
				}
			}
			else if(arrChiffre - depChiffre > 0){
				//ET que nous allons à droite...
				for(int c = depChiffre+1; c <= arrChiffre; c++){
					if (cases[depLettre][depChiffre].deplacementValide(depLettre, depChiffre, arrLettre, c)) {
						//on met toutes les cases dans un tableau, que l'on traitera ensuite
						pListe.add(cases[depLettre][c]);
					}
				}
			}
		}
		if (depChiffre == arrChiffre){
			//Si on ne bouge pas de l'axe des chiffres...
			if(arrLettre < depLettre){
				for(int l = depLettre - 1; l >= arrLettre; l--){
					if (cases[depLettre][depChiffre].deplacementValide(depLettre, depChiffre, l, arrChiffre)) {
						//on met toutes les cases dans un tableau, que l'on traitera ensuite
						pListe.add(cases[l][depChiffre]);
					}
				}
			}
			else if(arrLettre > depLettre){
				for(int l = depLettre + 1; l <= arrLettre; l++){
					if (cases[depLettre][depChiffre].deplacementValide(depLettre, depChiffre, l, arrChiffre)) {
						//on met toutes les cases dans un tableau, que l'on traitera ensuite
						pListe.add(cases[l][depChiffre]);
					}
				}
			}
		}
		//Enfin, on itère dans la liste pour trouver une potentielle Piece qui sert d'obstacle.
		for(Piece p : pListe){
			if(p != null && !(p.equals(cases[depLettre][depChiffre]) || p.equals(cases[arrLettre][arrChiffre])))
				return false;
		}


		return cases[arrLettre][arrChiffre] == null || cases[depLettre][depChiffre].getIsBlack() != cases[arrLettre][arrChiffre].getIsBlack();
	}
	
	public boolean getTour() {
        return tour;
    }

    public void setTour(boolean tour) {
        this.tour = tour;
    }

}