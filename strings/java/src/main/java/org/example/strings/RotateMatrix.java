package org.example.strings;

public class RotateMatrix {
    public static char[][] rotate(char[][] matrix) {
        int size = matrix.length;
        char[][] rotated = new char[size][size];

        // index order: [0,0] [0,1] [1,1] [1,0]
        // new order: [1,0] [0,0] [0,1] [1,1]
        // x_new = m_size - 1 - y; y_new = x;

        // [0,0] [0,1] [0,2] [1,0] [1,1] [1,2] [2,0] [2,1] [2,2]
        // [2,0] [1,0] [0,0] [2,1] [1,1] [0,1] [2,2] [1,2] [0,2]

        // 1 2 3 7 4 1
        // 4 5 6 8 5 2
        // 7 8 9 9 6 3

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                rotated[x][y] = matrix[size - 1 - y][x];
            }
        }

        return rotated;
    }
}
