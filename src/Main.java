import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arrayList.add(i + 1);
        }

        SmartArray smartArray = new SmartArray();

        for (int i = 0; i < 5; i++) {
            smartArray.add(i + 1);
        }

        System.out.println(smartArray.contains(3));

        System.out.println(smartArray.remove(2));

        System.out.println(smartArray.contains(3));



    }
}