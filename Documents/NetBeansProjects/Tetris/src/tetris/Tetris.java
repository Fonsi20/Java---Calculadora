package tetris;

/**
 *
 * @author mallo
 */
import java.util.Random;

public class Tetris {

    protected enum Piezas {
        Nada, FichaZ, FichaS, FichaLinea,
        FichaT, FichaCuadrado, FichaL, FichaLinvertida
    };

    private Piezas pieceShape;
    private int coords[][];
    private int[][][] coordsTable;

    public Tetris() {

        initTetris();
    }

    private void initTetris() {

        coords = new int[4][2];
        setShape(Piezas.Nada);
    }

    protected void setShape(Piezas shape) {

        coordsTable = new int[][][]{
            {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
            {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
            {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
            {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
            {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
            {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
        };

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 2; ++j) {

                coords[i][j] = coordsTable[shape.ordinal()][i][j];
            }
        }

        pieceShape = shape;
    }

    private void setX(int index, int x) {
        coords[index][0] = x;
    }

    private void setY(int index, int y) {
        coords[index][1] = y;
    }

    public int x(int index) {
        return coords[index][0];
    }

    public int y(int index) {
        return coords[index][1];
    }

    public Piezas getShape() {
        return pieceShape;
    }

    public void setRandomShape() {

        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Piezas[] values = Piezas.values();
        setShape(values[x]);
    }

    public int minX() {

        int m = coords[0][0];

        for (int i = 0; i < 4; i++) {

            m = Math.min(m, coords[i][0]);
        }

        return m;
    }

    public int minY() {

        int m = coords[0][1];

        for (int i = 0; i < 4; i++) {

            m = Math.min(m, coords[i][1]);
        }

        return m;
    }

    public Tetris rotateLeft() {

        if (pieceShape == Piezas.FichaCuadrado) {
            return this;
        }

        Tetris result = new Tetris();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {

            result.setX(i, y(i));
            result.setY(i, -x(i));
        }

        return result;
    }

    public Tetris rotateRight() {

        if (pieceShape == Piezas.FichaCuadrado) {
            return this;
        }

        Tetris result = new Tetris();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {

            result.setX(i, -y(i));
            result.setY(i, x(i));
        }

        return result;
    }
}
