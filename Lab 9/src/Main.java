import java.util.List;

 class RecursiveSum {

    public static int sumList(List<Integer> list, int index) {

        if (index == list.size()) {
            return 0;
        }


        return list.get(index) + sumList(list, index + 1);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40);
        int sum = sumList(numbers, 0);
        System.out.println(sum);
    }
}
