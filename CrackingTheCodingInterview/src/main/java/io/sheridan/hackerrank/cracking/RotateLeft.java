package io.sheridan.hackerrank.cracking;

public final class RotateLeft {

    public static void main(String[] args) throws Exception {
        int[] a = { 1, 2, 3, 4, 5 };
        int d = 14;

        if (d > a.length) {
            d %= a.length;
        }

        int[] result = new int[a.length];
        System.arraycopy(a, d, result, 0, a.length - d);
        System.arraycopy(a, 0, result, result.length - d, d);
        print(a);
        print(result);
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

