package misc.recursions;

public class MazePath {
    public static void main(String[] args) {
        findPath("", 3, 3);
    }

    static void findPath(String path, int row, int column) {
        if (row == 1 && column == 1) {
            System.out.println(path);
            return;
        }

        if (row > 1) {
            findPath(path + 'D', row - 1, column);
        }

        if (column > 1) {
            findPath(path + 'R', row, column - 1);
        }
    }
}