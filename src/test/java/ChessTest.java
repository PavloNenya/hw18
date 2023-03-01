import org.junit.jupiter.api.*;
import org.example.Chess.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChessFigureTest {
    static String white = "White";
    static String black = "Black";
    ChessFigure[][] chessTable;

    @BeforeEach
    public void clearTable() {
        ChessTable.clearChessTable();
        chessTable = ChessTable.getChessTable();
    }

    @Test
    @Order(1)
    void pawnStepTest() {
        //Arrange
        Pawn pawn;
        chessTable[1][0] = pawn = new Pawn(white, 1, 0);
        //Act
        boolean res = pawn.stepTo(3, 0);
        boolean res1 = pawn.stepTo(4, 0);
        //Assert
        assertTrue(res);
        assertTrue(res1);
    }

    @Test
    @Order(2)
    void pawnBeatDiagonalShouldReturnTrue() {
        //Arrange
        Pawn pawn;
        chessTable[1][0] = pawn = new Pawn(white, 1, 0);
        chessTable[2][1] = new Pawn(black, 2, 1);
        //Act
        int row = pawn.getRow();
        int column = pawn.getColumn();
        boolean res = pawn.stepTo(2, 1);
        //Assert
        assertTrue(res);
        assertEquals(pawn, chessTable[2][1]);
        assertNull(chessTable[row][column]);
    }

    @Test
    @Order(3)
    void pawnBecomesQueenTest() {
        //Arrange
        Pawn pawn;
        chessTable[6][0] = pawn = new Pawn(white, 6, 0);
        //Act
        boolean res = pawn.stepTo(7, 0);
        //Assert
        assertTrue(res);
        assertEquals(Queen.class, chessTable[7][0].getClass());
    }

    @Test
    @Order(4)
    void RookStepTest() {
        //Arrange
        Rook rook;
        chessTable[0][0] = rook = new Rook(white, 0, 0);
        //Act
        boolean res = rook.stepTo(7, 0);
        boolean res1 = rook.stepTo(7, 6);
        boolean res2 = rook.stepTo(0,0);
        //Assert
        assertTrue(res);
        assertTrue(res1);
        assertFalse(res2);
    }

    @Test
    @Order(4)
    void RookBeatAndThenStepTest() {
        //Arrange
        Rook rook;
        chessTable[0][0] = rook = new Rook(white, 0, 0);
        chessTable[4][0] = new Rook(black, 4, 0);
        chessTable[4][5] = new Rook(black, 4, 5);
        //Act
        boolean res = rook.stepTo(4, 0);    //true
        boolean res1 = rook.stepTo(4, 6);   //false
        //Assert
        assertTrue(res);
        assertFalse(res1);
        assertEquals(rook, chessTable[4][0]);
    }

    @Test
    @Order(5)
    void RookStepWithIllegalCoordsTest() {
        //Arrange
        Rook rook;
        chessTable[0][0] = rook = new Rook(white, 0, 0);
        //Act
        boolean res = rook.stepTo(8, 0);
        boolean res1 = rook.stepTo(0, 8);
        boolean res2 = rook.stepTo(4, 4);
        //Assert
        assertFalse(res);
        assertFalse(res1);
        assertFalse(res2);
    }

    @Test
    @Order(6)
    void BishopStepTest() {
        //Arrange
        Bishop bishop;
        chessTable[0][0] = bishop = new Bishop(white, 0, 0);
        //Act
        boolean res = bishop.stepTo(4, 4);
        boolean res1 = bishop.stepTo(1, 7);
        //Assert
        assertTrue(res);
        assertTrue(res1);
    }

    @Test
    @Order(7)
    void BishopStepWithIllegalCoordsTest() {
        //Arrange
        Bishop bishop;
        chessTable[0][0] = bishop = new Bishop(white, 0, 0);
        //Act
        boolean res = bishop.stepTo(0, 7);
        boolean res1 = bishop.stepTo(0, 4);
        boolean res2 = bishop.stepTo(7, 6);
        //Assert
        assertFalse(res);
        assertFalse(res1);
        assertFalse(res2);
    }

    @Test
    @Order(8)
    void QueenStepAndBeatTest() {
        //Arrange
        Queen queen;
        chessTable[0][0] = queen = new Queen(white, 0, 0);
        chessTable[4][4] = new Queen(black, 4, 4);
        //Act
        boolean res = queen.stepTo(4, 4);
        boolean res1 = queen.stepTo(0, 4);
        boolean res2 = queen.stepTo(4, 0);
        //Assert
        assertTrue(res);
        assertTrue(res1);
        assertTrue(res2);
        assertNull(chessTable[4][4]);
    }

    @Test
    @Order(9)
    void QueenStepWithIllegalCoordsAndObstaclesTest() {
        //Arrange
        Queen queen;
        Queen queen1;
        chessTable[0][0] = queen = new Queen(white, 0, 0);
        chessTable[3][3] = queen1 = new Queen(white, 0, 0);
        //Act
        boolean res = queen.stepTo(4, 4);
        boolean res1 = queen.stepTo(1, 3);
        boolean res2 = queen.stepTo(6, 7);
        //Assert
        assertFalse(res);
        assertFalse(res1);
        assertFalse(res2);
        assertEquals(chessTable[3][3], queen1);
    }

    @Test
    @Order(10)
    void KingStepAndBeatTest() {
        //Arrange
        King king;
        chessTable[1][2] = king = new King(white, 1, 2);
        chessTable[0][2] = new Pawn(black, 0, 2);
        //Act
        boolean res = king.stepTo(0, 2);
        boolean res1 = king.stepTo(1, 3);
        boolean res2 = king.stepTo(2, 2);
        //Assert
        assertTrue(res);
        assertTrue(res1);
        assertTrue(res2);
        assertNull(chessTable[0][2]);
    }

    @Test
    @Order(11)
    void KingStepWithIllegalCoordsAndObstaclesTest() {
        //Arrange
        King king;
        chessTable[1][2] = king = new King(white, 1, 2);
        chessTable[0][2] = new Pawn(white, 0, 2);
        //Act
        boolean res = king.stepTo(0, 2);
        boolean res1 = king.stepTo(1, 4);
        boolean res2 = king.stepTo(1, 2);
        //Assert
        assertFalse(res);
        assertFalse(res1);
        assertFalse(res2);
    }

    @Test
    @Order(12)
    void KnightStepAndBeatTest() {
        //Arrange
        Knight knight;
        chessTable[0][1] = knight = new Knight(white, 0, 1);
        chessTable[2][0] = new Pawn(black, 2, 0);
        //Act
        boolean res = knight.stepTo(2, 0);
        boolean res3 = knight == chessTable[2][0];
        boolean res1 = knight.stepTo(3, 2);
        boolean res2 = knight.stepTo(1, 3);
        //Assert
        assertTrue(res);
        assertTrue(res1);
        assertTrue(res2);
        assertTrue(res3);
    }

    @Test
    @Order(13)
    void KnightStepWithIllegalCoordsAndObstaclesTest() {
        //Arrange
        Knight knight;
        chessTable[0][1] = knight = new Knight(white, 0, 1);
        chessTable[2][0] = new Pawn(white, 2, 0);
        //Act
        boolean res = knight.stepTo(2, 1);
        boolean res3 = knight == chessTable[2][0];
        boolean res1 = knight.stepTo(2, 0);
        boolean res2 = knight.stepTo(0, 3);
        //Assert
        assertFalse(res);
        assertFalse(res1);
        assertFalse(res2);
        assertFalse(res3);
    }


}