package com.github.Piscary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Created by helltux on 18.02.17.
 */
class SquareTest {

    @Test
    void groupTest() {
        for (int i = 0; i < 81; i++) {
            Square square = new Square(1, 1, i, 0);
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 9:
                case 10:
                case 11:
                case 18:
                case 19:
                case 20:
                    assertEquals(square.getGroup(), 1);
                    break;
                case 3:
                case 4:
                case 5:
                case 12:
                case 13:
                case 14:
                case 21:
                case 22:
                case 23:
                    assertEquals(square.getGroup(), 2);
                    break;
                case 6:
                case 7:
                case 8:
                case 15:
                case 16:
                case 17:
                case 24:
                case 25:
                case 26:
                    assertEquals(square.getGroup(), 3);
                    break;
                case 27:
                case 28:
                case 29:
                case 36:
                case 37:
                case 38:
                case 45:
                case 46:
                case 47:
                    assertEquals(square.getGroup(), 4);
                    break;
                case 30:
                case 31:
                case 32:
                case 39:
                case 40:
                case 41:
                case 48:
                case 49:
                case 50:
                    assertEquals(square.getGroup(), 5);
                    break;
                case 33:
                case 34:
                case 35:
                case 42:
                case 43:
                case 44:
                case 51:
                case 52:
                case 53:
                    assertEquals(square.getGroup(), 6);
                    break;
                case 54:
                case 55:
                case 56:
                case 63:
                case 64:
                case 65:
                case 72:
                case 73:
                case 74:
                    assertEquals(square.getGroup(), 7);
                    break;
                case 57:
                case 58:
                case 59:
                case 66:
                case 67:
                case 68:
                case 75:
                case 76:
                case 77:
                    assertEquals(square.getGroup(), 8);
                    break;
                case 60:
                case 61:
                case 62:
                case 69:
                case 70:
                case 71:
                case 78:
                case 79:
                case 80:
                    assertEquals(square.getGroup(), 9);
                    break;
            }

        }
    }

}
