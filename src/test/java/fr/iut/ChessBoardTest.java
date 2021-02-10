package fr.iut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChessBoardTest {

	ChessBoard test1, testCSV;
	@BeforeEach
	void init(){
		test1 = new ChessBoard();

		try {
			testCSV = new ChessBoard("test.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testTranslator(){
		assertTrue(test1.translator('A') == 0);
		assertTrue(test1.translator('B') == 1);
		assertTrue(test1.translator('C') == 2);
		assertTrue(test1.translator('D') == 3);
		assertTrue(test1.translator('E') == 4);
		assertTrue(test1.translator('F') == 5);
		assertTrue(test1.translator('G') == 6);
		assertTrue(test1.translator('H') == 7);
	}

	@Test
	void testEchecEtMat(){
		test1.loadgame();
		assertFalse(test1.echecEtMat(false));
		assertFalse(test1.echecEtMat(true));
	}
	@Test
    public void loadgamesTest() {
		test1.loadgame();
		// Asserts loadgame()

		// Ligne du bas blanche

		assertEquals("T", test1.getCases()[0][0].getSymbole());
		assertEquals(false, test1.getCases()[0][0].getIsBlack());

		assertEquals("C", test1.getCases()[1][0].getSymbole());
		assertEquals(false, test1.getCases()[1][0].getIsBlack());

		assertEquals("F", test1.getCases()[2][0].getSymbole());
		assertEquals(false, test1.getCases()[2][0].getIsBlack());

		assertEquals("Re", test1.getCases()[3][0].getSymbole());
		assertEquals(false, test1.getCases()[3][0].getIsBlack());

		assertEquals("Ro", test1.getCases()[4][0].getSymbole());
		assertEquals(false, test1.getCases()[4][0].getIsBlack());

		assertEquals("F", test1.getCases()[5][0].getSymbole());
		assertEquals(false, test1.getCases()[5][0].getIsBlack());

		assertEquals("C", test1.getCases()[6][0].getSymbole());
		assertEquals(false, test1.getCases()[6][0].getIsBlack());

		assertEquals("T", test1.getCases()[7][0].getSymbole());
		assertEquals(false, test1.getCases()[7][0].getIsBlack());

		// Pions blancs

		for (int i = 0; i < 8; i++) {
			assertEquals("P", test1.getCases()[i][1].getSymbole());
			assertEquals(false, test1.getCases()[i][1].getIsBlack());
		}

		// Lignes vides

		for (int i = 0; i < 8; i++) {
			for (int j = 2; j < 6; j++) {
				assertNull(test1.getCases()[i][j]);
			}
		}

		// Pions noirs

		for (int i = 0; i < 8; i++) {
			assertEquals("P", test1.getCases()[i][6].getSymbole());
			assertEquals(true, test1.getCases()[i][6].getIsBlack());
		}

		// Ligne du haut noire

		assertEquals("T", test1.getCases()[0][7].getSymbole());
		assertEquals(true, test1.getCases()[0][7].getIsBlack());

		assertEquals("C", test1.getCases()[1][7].getSymbole());
		assertEquals(true, test1.getCases()[1][7].getIsBlack());

		assertEquals("F", test1.getCases()[2][7].getSymbole());
		assertEquals(true, test1.getCases()[2][7].getIsBlack());

		assertEquals("Re", test1.getCases()[3][7].getSymbole());
		assertEquals(true, test1.getCases()[3][7].getIsBlack());

		assertEquals("Ro", test1.getCases()[4][7].getSymbole());
		assertEquals(true, test1.getCases()[4][7].getIsBlack());

		assertEquals("F", test1.getCases()[5][7].getSymbole());
		assertEquals(true, test1.getCases()[5][7].getIsBlack());

		assertEquals("C", test1.getCases()[6][7].getSymbole());
		assertEquals(true, test1.getCases()[6][7].getIsBlack());

		assertEquals("T", test1.getCases()[7][7].getSymbole());
		assertEquals(true, test1.getCases()[7][7].getIsBlack());

		// Asserts loadgame("test.csv")

		// Ligne 1

		assertEquals("T", testCSV.getCases()[0][0].getSymbole());
		assertEquals(false, testCSV.getCases()[0][0].getIsBlack());

		assertEquals("C", testCSV.getCases()[1][0].getSymbole());
		assertEquals(false, testCSV.getCases()[1][0].getIsBlack());

		assertEquals("F", testCSV.getCases()[2][0].getSymbole());
		assertEquals(false, testCSV.getCases()[2][0].getIsBlack());

		assertNull(testCSV.getCases()[3][0]);

		assertEquals("Ro", testCSV.getCases()[4][0].getSymbole());
		assertEquals(false, testCSV.getCases()[4][0].getIsBlack());

		assertNull(testCSV.getCases()[5][0]);

		assertEquals("C", testCSV.getCases()[6][0].getSymbole());
		assertEquals(false, testCSV.getCases()[6][0].getIsBlack());

		assertEquals("T", testCSV.getCases()[7][0].getSymbole());
		assertEquals(false, testCSV.getCases()[7][0].getIsBlack());

		// Ligne 2

		for (int i = 0; i < 4; i++) {
			assertEquals("P", testCSV.getCases()[i][1].getSymbole());
			assertEquals(false, testCSV.getCases()[i][1].getIsBlack());
		}

		assertNull(testCSV.getCases()[4][1]);

		for (int i = 5; i < 8; i++) {
			assertEquals("P", testCSV.getCases()[i][1].getSymbole());
			assertEquals(false, testCSV.getCases()[i][1].getIsBlack());
		}

		// Ligne 3

		for (int i = 0; i < 8; i++) {
			assertNull(testCSV.getCases()[i][2]);
		}

		// Ligne 4

		assertEquals(null, testCSV.getCases()[0][3]);

		assertEquals(null, testCSV.getCases()[1][3]);

		assertEquals("F", testCSV.getCases()[2][3].getSymbole());
		assertEquals(false, testCSV.getCases()[2][3].getIsBlack());

		assertEquals(null, testCSV.getCases()[3][3]);

		assertEquals("P", testCSV.getCases()[4][3].getSymbole());
		assertEquals(false, testCSV.getCases()[4][3].getIsBlack());

		for (int i = 5; i < 8; i++) {
			assertNull(testCSV.getCases()[i][3]);
		}

		// Ligne 5

		for (int i = 0; i < 4; i++) {
			assertNull(testCSV.getCases()[i][4]);
		}

		assertEquals("P", testCSV.getCases()[4][4].getSymbole());
		assertEquals(true, testCSV.getCases()[4][4].getIsBlack());

		assertNull(testCSV.getCases()[5][4]);

		assertNull(testCSV.getCases()[6][4]);

		assertEquals("Re", testCSV.getCases()[7][4].getSymbole());
		assertEquals(false, testCSV.getCases()[7][4].getIsBlack());

		// Ligne 6

		for (int i = 0; i < 8; i++) {
			if (i != 2 && i != 5)
				assertNull(testCSV.getCases()[i][5]);
		}

		assertEquals("C", testCSV.getCases()[2][5].getSymbole());
		assertEquals(true, testCSV.getCases()[2][5].getIsBlack());

		assertEquals("C", testCSV.getCases()[5][5].getSymbole());
		assertEquals(true, testCSV.getCases()[5][5].getIsBlack());

		// Ligne 7

		for (int i = 0; i < 8; i++) {
			if (i != 4) {
				assertEquals("P", testCSV.getCases()[i][6].getSymbole());
				assertEquals(true, testCSV.getCases()[i][6].getIsBlack());
			}
		}

		assertNull(testCSV.getCases()[4][6]);

		// Ligne 8

		assertEquals("T", test1.getCases()[0][7].getSymbole());
		assertEquals(true, test1.getCases()[0][7].getIsBlack());

		assertNull(testCSV.getCases()[1][7]);

		assertEquals("F", test1.getCases()[2][7].getSymbole());
		assertEquals(true, test1.getCases()[2][7].getIsBlack());

		assertEquals("Re", test1.getCases()[3][7].getSymbole());
		assertEquals(true, test1.getCases()[3][7].getIsBlack());

		assertEquals("Ro", test1.getCases()[4][7].getSymbole());
		assertEquals(true, test1.getCases()[4][7].getIsBlack());

		assertEquals("F", test1.getCases()[5][7].getSymbole());
		assertEquals(true, test1.getCases()[5][7].getIsBlack());

		assertNull(testCSV.getCases()[6][7]);

		assertEquals("T", test1.getCases()[7][7].getSymbole());
		assertEquals(true, test1.getCases()[7][7].getIsBlack());
    }

    @Test
	void testCheminValideHautGauche(){
		//E4 vers B7
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[1][6] = new Pawn(false);
		assertTrue(test1.cheminValide(4,3,1,6));
	}

	@Test
	void testCheminValideHautDroit(){
		//E4 vers H7
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[7][6] = new Pawn(false);
		assertTrue(test1.cheminValide(4,3,7,6));
	}
	@Test
	void testCheminValideBasGauche(){
		//E4 vers B1
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[1][0] = new Pawn(false);
		assertTrue(test1.cheminValide(4,3,1,0));
	}
	@Test
	void testCheminValideBasDroit(){
		//E4 vers H1
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[7][0] = new Pawn(false);
		assertTrue(test1.cheminValide(4,3,7,0));
	}

	@Test
	void testCheminValideBas(){
		//E4 vers E1
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[4][0] = new Pawn(false);
		assertTrue(test1.cheminValide(4,3,4,0));
	}

	@Test
	void testCheminValideHaut(){
		//E4 vers E7
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[4][7] = new Pawn(false);
		assertTrue(test1.cheminValide(4,3,4,7));
	}

	@Test
	void testCheminValideGauche(){
		//E4 vers A4
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[0][3] = new Pawn(false);
		assertTrue(test1.cheminValide(4,3,0,3));
	}

	@Test
	void testCheminValideDroite(){
		//E4 vers H1
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[7][3] = new Pawn(false);
		assertTrue(test1.cheminValide(4,3,7,3));
	}

	@Test
	void testCheminValideHautGaucheObstacle(){
		//E4 vers B7, avec obstacle
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[3][4] = new Bishop(true);
		test1.getCases()[1][6] = new Pawn(false);
		assertFalse(test1.cheminValide(4,3,1,6));
	}

	@Test
	void testCheminValideHautDroitObstacle(){
		//E4 vers H7, avec obstacle
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[5][4] = new Bishop(true);
		test1.getCases()[7][6] = new Pawn(false);
		assertFalse(test1.cheminValide(4,3,7,6));
	}
	@Test
	void testCheminValideBasGaucheObstacle(){
		//E4 vers B1, avec obstacle
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[2][1] = new Queen(true);
		test1.getCases()[1][0] = new Pawn(false);
		assertFalse(test1.cheminValide(4,3,1,0));
	}
	@Test
	void testCheminValideBasDroitObstacle(){
		//E4 vers H1, avec obstacle
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[6][1] = new Queen(true);
		test1.getCases()[7][0] = new Pawn(false);
		assertFalse(test1.cheminValide(4,3,7,0));
	}

	@Test
	void testCheminValideBasObstacle(){
		//E4 vers E1, avec obstacle
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[4][1] = new Queen(true);
		test1.getCases()[4][0] = new Pawn(false);
		assertFalse(test1.cheminValide(4,3,4,0));
	}

	@Test
	void testCheminValideHautObstacle(){
		//E4 vers E7, avec obstacle
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[4][4] = new Rook(true);
		test1.getCases()[4][7] = new Pawn(false);
		assertFalse(test1.cheminValide(4,3,4,7));
	}

	@Test
	void testCheminValideGaucheObstacle(){
		//E4 vers A4, avec obstacle
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[2][3] = new Queen(true);
		test1.getCases()[0][3] = new Pawn(false);
		assertFalse(test1.cheminValide(4,3,0,3));
	}

	@Test
	void testCheminValideDroiteObstacle(){
		//E4 vers H1, avec obstacle
		test1.getCases()[4][3] = new Queen(true);
		test1.getCases()[6][3] = new Queen(true);
		test1.getCases()[7][3] = new Pawn(false);
		assertFalse(test1.cheminValide(4,3,7,3));
	}

	@Test
	void testCheminValideSautCavalier(){
		//Cavalier en E4, test de saut
		test1.getCases()[4][3] = new Knight(false);

		test1.getCases()[5][2] = new Pawn(true);
		test1.getCases()[5][3] = new Pawn(true);
		test1.getCases()[5][4] = new Pawn(true);
		test1.getCases()[4][2] = new Pawn(true);
		test1.getCases()[4][4] = new Pawn(true);
		test1.getCases()[3][2] = new Pawn(true);
		test1.getCases()[3][3] = new Pawn(true);
		test1.getCases()[3][4] = new Pawn(true);
		assertTrue(test1.cheminValide(4,3,3,5));
	}

	@Test
	void testCheminValideDiagonalePion(){
		test1.getCases()[4][3] = new Pawn(false);
		test1.getCases()[5][3] = new Pawn(true);
		test1.getCases()[5][4] = new Pawn(true);

		assertFalse(test1.cheminValide(4,3,5,3));
		assertTrue(test1.cheminValide(4,3,5,4));
	}

	@Test
	void testTourGetter(){
		assertFalse(test1.getTour());
	}

	@Test
	void testTourChangement(){
		test1.setTour(!test1.getTour());
		assertTrue(test1.getTour());
	}

	@Test
	void testEchec(){
		test1.getCases()[4][4] = new King(true);
		test1.getCases()[3][4] = new Rook(false);
		assertTrue(test1.estEnEchec(true));
	}
	@Test
	void testEchecObstacle(){
		test1.getCases()[4][4] = new King(true);
		test1.getCases()[3][4] = new Pawn(false);
		test1.getCases()[2][4] = new Rook(false);
		test1.display();
		assertFalse(test1.estEnEchec(true));
	}

	@Test
	void testEchecEtMatCoupDuBerger(){
		try{
			testCSV.getCases()[5][6] = testCSV.getCases()[7][4];
			testCSV.getCases()[7][4] = null;
			testCSV.display();
			assertTrue(testCSV.estEnEchec(true));

		}catch (Exception ignored){}

	}
}
