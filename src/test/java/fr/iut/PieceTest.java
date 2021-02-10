package fr.iut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PieceTest {

	private Piece Re;
	private Piece C;
	private Piece F;
	private Piece Pb;
	private Piece Pn;
	private Piece Ro;
	private Piece T;
	private int pDepLettre, pDepChiffre;
	private int aL1, aC1;
	private int aL2, aC2;
	private int aL3, aC3;
	private int aL4, aC4;
	private int aL5, aC5;
	private int aL6, aC6;
	private int aL7, aC7;
	private int aL8, aC8;

	@BeforeEach
	void init() {
		System.out.println("init");
		Re = new Queen(true);
		C = new Knight(true);
		F = new Bishop(true);
		Pb  = new Pawn(false);
		Pn  = new Pawn(true);
	    Ro  = new King(true);
	    T = new Rook(true);
	    pDepLettre = 4; pDepChiffre = 3; //E4

		aL1 = 3; aC1 = 4; //D5
		aL2 = 4; aC2 = 4; //E5
		aL3 = 5; aC3 = 4; //F5

		aL4 = 3; aC4 = 3; //D4
		aL5 = 5; aC5 = 3; //F4

		aL6 = 3; aC6 = 2; //D3
		aL7 = 4; aC7 = 2; //E3
		aL8 = 5; aC8 = 2; //F3

	}

	@Test
	void testSymboleSetter(){
		Piece t = new Queen(true);
		t.setSymbole("test");
		assertTrue(t.getSymbole().equals("test"));
	}
	@Test
	void testSymboleSetterToString(){
		Piece t = new Queen(true);
		t.setSymbole("test");
		assertTrue("testn".equals(t.toString()));
	}
	@Test
	void testDepValideQueen() {
		assertTrue(Re.deplacementValide(pDepLettre,pDepChiffre,aL1,aC1));
		assertTrue(Re.deplacementValide(pDepLettre,pDepChiffre,aL2,aC2));
		assertTrue(Re.deplacementValide(pDepLettre,pDepChiffre,aL3,aC3));

		assertTrue(Re.deplacementValide(pDepLettre,pDepChiffre,aL4,aC4));
		assertTrue(Re.deplacementValide(pDepLettre,pDepChiffre,aL5,aC5));

		assertTrue(Re.deplacementValide(pDepLettre,pDepChiffre,aL6,aC6));
		assertTrue(Re.deplacementValide(pDepLettre,pDepChiffre,aL7,aC7));
		assertTrue(Re.deplacementValide(pDepLettre,pDepChiffre,aL8,aC8));
		//tests pour vérifier que le déplacement est valide après les premières cases
	}
	@Test
	void testDepValideKnight(){

		assertFalse(C.deplacementValide(pDepLettre,pDepChiffre,aL1,aC1));
		assertFalse(C.deplacementValide(pDepLettre,pDepChiffre,aL2,aC2));
		assertFalse(C.deplacementValide(pDepLettre,pDepChiffre,aL3,aC3));

		assertFalse(C.deplacementValide(pDepLettre,pDepChiffre,aL4,aC4));
		assertFalse(C.deplacementValide(pDepLettre,pDepChiffre,aL5,aC5));

		assertFalse(C.deplacementValide(pDepLettre,pDepChiffre,aL6,aC6));
		assertFalse(C.deplacementValide(pDepLettre,pDepChiffre,aL7,aC7));
		assertFalse(C.deplacementValide(pDepLettre,pDepChiffre,aL8,aC8));
	}
	@Test
	void testDepValideBishop(){
		assertTrue(F.deplacementValide(pDepLettre,pDepChiffre,aL1,aC1));
		assertFalse(F.deplacementValide(pDepLettre,pDepChiffre,aL2,aC2));
		assertTrue(F.deplacementValide(pDepLettre,pDepChiffre,aL3,aC3));

		assertFalse(F.deplacementValide(pDepLettre,pDepChiffre,aL4,aC4));
		assertFalse(F.deplacementValide(pDepLettre,pDepChiffre,aL5,aC5));

		assertTrue(F.deplacementValide(pDepLettre,pDepChiffre,aL6,aC6));
		assertFalse(F.deplacementValide(pDepLettre,pDepChiffre,aL7,aC7));
		assertTrue(F.deplacementValide(pDepLettre,pDepChiffre,aL8,aC8));
	}

	@Test
	void testDepValideWhitePawn(){
		assertTrue(Pb.deplacementValide(pDepLettre,pDepChiffre,aL1,aC1));
		assertTrue(Pb.deplacementValide(pDepLettre,pDepChiffre,aL2,aC2));
		assertTrue(Pb.deplacementValide(pDepLettre,pDepChiffre,aL3,aC3));

		assertFalse(Pb.deplacementValide(pDepLettre,pDepChiffre,aL4,aC4));
		assertFalse(Pb.deplacementValide(pDepLettre,pDepChiffre,aL5,aC5));

		assertFalse(Pb.deplacementValide(pDepLettre,pDepChiffre,aL6,aC6));
		assertFalse(Pb.deplacementValide(pDepLettre,pDepChiffre,aL7,aC7));
		assertFalse(Pb.deplacementValide(pDepLettre,pDepChiffre,aL8,aC8));
	}

	@Test
	void testDepValideWhitePawnSaut(){
		assertTrue(Pb.deplacementValide(1,1,1,3));
		assertFalse(Pb.deplacementValide(1,5,1,3));
		assertFalse(Pb.deplacementValide(1,6,1,4));
	}
	@Test
	void testDepValideBlackPawn(){
		assertFalse(Pn.deplacementValide(pDepLettre,pDepChiffre,aL1,aC1));
		assertFalse(Pn.deplacementValide(pDepLettre,pDepChiffre,aL2,aC2));
		assertFalse(Pn.deplacementValide(pDepLettre,pDepChiffre,aL3,aC3));

		assertFalse(Pn.deplacementValide(pDepLettre,pDepChiffre,aL4,aC4));
		assertFalse(Pn.deplacementValide(pDepLettre,pDepChiffre,aL5,aC5));

		assertTrue(Pn.deplacementValide(pDepLettre,pDepChiffre,aL6,aC6));
		assertTrue(Pn.deplacementValide(pDepLettre,pDepChiffre,aL7,aC7));
		assertTrue(Pn.deplacementValide(pDepLettre,pDepChiffre,aL8,aC8));

	}

	@Test
	void testDepValideBlackPawnSaut(){
		assertTrue(Pn.deplacementValide(1,6,1,4));
		assertFalse(Pn.deplacementValide(1,2,1,4));
		assertFalse(Pn.deplacementValide(1,1,1,3));
	}

	@Test
	void testDepValideKing(){
		assertTrue(Ro.deplacementValide(pDepLettre,pDepChiffre,aL1,aC1));
		assertTrue(Ro.deplacementValide(pDepLettre,pDepChiffre,aL2,aC2));
		assertTrue(Ro.deplacementValide(pDepLettre,pDepChiffre,aL3,aC3));

		assertTrue(Ro.deplacementValide(pDepLettre,pDepChiffre,aL4,aC4));
		assertTrue(Ro.deplacementValide(pDepLettre,pDepChiffre,aL5,aC5));

		assertTrue(Ro.deplacementValide(pDepLettre,pDepChiffre,aL6,aC6));
		assertTrue(Ro.deplacementValide(pDepLettre,pDepChiffre,aL7,aC7));
		assertTrue(Ro.deplacementValide(pDepLettre,pDepChiffre,aL8,aC8));
	}

	@Test
	void testDepValideRook(){
		assertFalse(T.deplacementValide(pDepLettre,pDepChiffre,aL1,aC1));
		assertTrue(T.deplacementValide(pDepLettre,pDepChiffre,aL2,aC2));
		assertFalse(T.deplacementValide(pDepLettre,pDepChiffre,aL3,aC3));

		assertTrue(T.deplacementValide(pDepLettre,pDepChiffre,aL4,aC4));
		assertTrue(T.deplacementValide(pDepLettre,pDepChiffre,aL5,aC5));

		assertFalse(T.deplacementValide(pDepLettre,pDepChiffre,aL6,aC6));
		assertTrue(T.deplacementValide(pDepLettre,pDepChiffre,aL7,aC7));
		assertFalse(T.deplacementValide(pDepLettre,pDepChiffre,aL8,aC8));
	}


}
