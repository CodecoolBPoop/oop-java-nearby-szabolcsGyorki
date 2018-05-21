import java.util.Arrays;

public class NearbyElements {
    private static int[][] multi = new int[][]{
            {2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
            {1, 3, 5, 7},
            {321, 320, 32, 3, 41241, -11, -12, -13, -66, -688}
    };


    private static int[] nearby(int x, int y, int range) {
        int beforeFrom, elementsCountBefore, elementsCountAfter;
        int[] base, before, after, result;
        base = Arrays.copyOf(multi[x], multi[x].length);

        beforeFrom = (y < range) ? 0 : y-range;
        elementsCountBefore = (y < range) ? y : range;
        elementsCountAfter = (base.length-1-y < range) ? base.length-1-y : range;

        before = Arrays.copyOfRange(base, beforeFrom, y);
        after = Arrays.copyOfRange(base, y+1, y+1+elementsCountAfter);

        if (y == base.length-1) {
            return before;
        }
        if (y == 0) {
            return after;
        }

        result = Arrays.copyOf(before, elementsCountBefore + elementsCountAfter);
        System.arraycopy(after, 0, result, before.length, after.length);
        return result;
    }


    public static void main(String[] args) {
//        write your code here
        String errorMessage = "Usage: \"com.codecool.nearbyelements.NearbyElements x y z\"" +
                " where x, y and z is an integer.\n";
        if (args.length != 3) {
            System.out.println(errorMessage);
        } else {
            int x = 0, y = 0, range = 0;
            try {
                x = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println(errorMessage + e);
            }
            try {
                y = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println(errorMessage + e);
            }
            try {
                range = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println(errorMessage + e);
            }
            try {
                int[] result = nearby(x, y, range);
                System.out.println(Arrays.toString(result));
            } catch (IllegalArgumentException e) {
                System.out.println("There are less than " + y +
                " elements in the list nr." + x + ". Try a lower number!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("There is no list with the index " + x +
                "! Please try a lower number!");
            }
        }
    }
}
