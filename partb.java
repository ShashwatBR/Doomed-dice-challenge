import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void diceACombo(List<Integer> elements, int length, List<Integer> current, List<List<Integer>> allCombinations) {
        if (current.size() == length) {
            allCombinations.add(new ArrayList<>(current));
            return;
        }
        for (int element : elements) {
            current.add(element);
            diceACombo(elements, length, current, allCombinations);
            current.remove(current.size() - 1);
        }
    }

    public static void diceBCombo(List<Integer> elements, int length, int start, List<Integer> current, List<List<Integer>> allCombinations) {
        if (current.size() == length) {
            allCombinations.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < elements.size(); i++) {
            current.add(elements.get(i));
            diceBCombo(elements, length, i + 1, current, allCombinations);
            current.remove(current.size() - 1);
        }
    }

    public static List<Double> probSum(List<Integer> arr1, List<Integer> arr2) {
        List<Double> psum1 = new ArrayList<>(List.of(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        for (int i : arr1) {
            for (int j : arr2) {
                int k = i + j;
                psum1.set(k - 1, psum1.get(k - 1) + 1);
            }
        }
        for (int i = 0; i < psum1.size(); i++) {
            if (psum1.get(i) != 0) {
                psum1.set(i, psum1.get(i) / 36);
            }
        }
        return psum1;
    }

    public static void transform(List<Integer> dieA, List<Integer> dieB) {
        List<Integer> elements1 = List.of(1, 2, 3, 4);
        int length = 6;
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> combo1 = new ArrayList<>();
        diceACombo(elements1, length, current, combo1);

        List<Integer> elements2 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        int start = 0;
        List<List<Integer>> combo2 = new ArrayList<>();
        diceBCombo(elements2, length, start, current, combo2);

        List<Double> psum = List.of(0.0, 1.0 / 36, 2.0 / 36, 3.0 / 36, 4.0 / 36, 5.0 / 36, 6.0 / 36, 5.0 / 36, 4.0 / 36, 3.0 / 36, 2.0 / 36, 1.0 / 36);

        boolean flag = false;
        for (List<Integer> i : combo1) {
            for (List<Integer> j : combo2) {
                if (probSum(i, j).equals(psum)) {
                    System.out.print("new die_a: ");
                    for (int x : i) {
                        System.out.print(x + " ");
                    }
                    System.out.println("\nnew die_b: ");
                    for (int x : j) {
                        System.out.print(x + " ");
                    }
                    System.out.println();
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> dieA = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> dieB = List.of(1, 2, 3, 4, 5, 6);
        transform(dieA, dieB);
    }
}
