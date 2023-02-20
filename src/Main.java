import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arrayList.add(i + 1);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        SmartArray smartArray = new SmartArray();

        for (int i = 0; i < 5; i++) {
            smartArray.add(i + 1);
        }
        for (int i = 0; i < smartArray.size(); i++) {
            System.out.println(smartArray.get(i));
        }

        System.out.println(smartArray.get(5));
    }
}