package fr.iut;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws Exception {
    	boolean veuxJouer = true;
    	String choix;
    	System.out.println("Welcome to the chess game \n");
    	ChessBoard cB;
    	String joueur;
    	while(veuxJouer){
			if (args.length == 1)
				cB = new ChessBoard(args[0]);
			else{
				cB = new ChessBoard();
				cB.loadgame();
			}
			cB.display();
			System.out.println("Les blancs commencent : ");
			System.out.println(format());
			cB.movePiece();
			cB.display();


			while (!cB.estEnEchec(!cB.getTour())) {
	            if (cB.getTour() == true)
	                joueur = "noirs";
	            else
	                joueur = "blancs";
	            System.out.println("C'est au tour des " + joueur + ".");
				System.out.println(format());
	            cB.movePiece();
	            cB.display();
	        }
	        

			System.out.println("Fin de la partie !\nSouhaitez-vous recommencer ? [o/N]");
			choix = new Scanner(System.in).nextLine();
			veuxJouer = choix.equalsIgnoreCase("o") || choix.equalsIgnoreCase("oui");
		}

    	System.exit(0);

    }

    public static String format(){
    	return "Format de l'entrée :\nLC_LC (Lettre, Chiffre, Espace, Lettre, Chiffre)\nExemple: A2 A4";
	}
}
