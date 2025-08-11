public class PlaceTilesinAFloor {
    public static int placeTiles(int n, int m) {
        if (n == m) {
            return 2;
        }
        if (n < m) {
            return 1;
        }
        // place a tile vertically
        int vertPlace = placeTiles(n - m, m);
        // place a tile horizontally
        int horPlace = placeTiles(n - 1, m);
        return vertPlace + horPlace;
    }

    public static void main(String args[]) {
        int n = 4, m = 2;
        System.out.println(placeTiles(n, m));
    }
}
