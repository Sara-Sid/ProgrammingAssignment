
public class HashCodeGenerator {

    public static Integer generateHashCode(String x) {
        Integer code = 0;
        char[] input = x.toCharArray();

        for (char c : input) {
            code += (int) c;
        }
        return code;
    }

    public static Integer generateHashCode(String x, int bias) {

        Integer code = 0;
        char[] input = x.toCharArray();

        for (char c : input) {
            code = code + (int) c * bias;
        }
        return code;
    }

    public static Integer generateHashCode(String x, int bias, int uptoZ) {

        Integer code = 0;
        char[] input = x.toCharArray();

        int i = 0;
        for (char c : input) {
            code = code * bias + (int) c;
            i++;
            if (uptoZ < i) break;
        }
        return code;
    }

    public static Integer generateHashCode(String x, int bias, int uptoZ, int[] nums) {
        Integer code = 0;
        char[] input = x.toCharArray();
        int i = 0;
        for (char c : input) {
            code = code * bias + (int) c;
            i++;
            if (uptoZ < i) break;
        }
        for (int num : nums) {
            code += num;

        }
        return code;

    }

    public static void main(String[] args) {
        String[] initialData = {"John", "Jerry", "Mike", "Abby", "Tina", "Fahmida", "CatWoman"};
        int[] extraNums = {100, 200};
        System.out.println("\n >> Working with the simplest version (ASCII code) >>");
        for (String s : initialData) {
            System.out.println("input = " + s +
                    ", hash code = " + HashCodeGenerator.generateHashCode(s));
        }
        System.out.println("\n >> Working with Bias 2: >>");
        for (String s : initialData) {
            System.out.println("input = " + s +
                    ", hash code = " + HashCodeGenerator.generateHashCode(s, 2));
        }
        System.out.println("\n >> Working with Bias 10: >> ");

        for (String s : initialData) {
            System.out.println("input = " + s +
                    ", hash code = " + HashCodeGenerator.generateHashCode(s, 10));
        }
            System.out.println("\n >> Working with Bias 3, length 5 (max): >>");
            for (String s : initialData) {
                System.out.println("input = " + s +
                        ", hash code = " + HashCodeGenerator.generateHashCode(s, 3, 5));
            }
            System.out.println("\n >> Working with Bias 3, length 5 (max) AND extra numbers: >>");
            for (String s : initialData) {
                System.out.println("input = " + s + " + [100, 200]" +
                        ", hash code = " + HashCodeGenerator.generateHashCode(s, 3, 5, extraNums));
            }
        }


    }
