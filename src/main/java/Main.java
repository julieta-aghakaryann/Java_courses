import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new DIYarrayList<>();
//        List<Integer> list = new ArrayList<>();
//        myList.add(1);
//        myList.add(2);
//        myList.add(3);
//        myList.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//
//        Collections.addAll(myList,5,6,7,8,9, 10);
//        Collections.copy(myList, list);
//        Collections.sort(myList);
//
//        for (int i = 0; i < myList.size(); i++) {
//            System.out.println(myList.get(i));
//        }
        for (int i = 0; i < 22; i++) {
            myList.add(i);
            System.out.println(myList.get(i));
        }
        System.out.println("size " + myList.size());
    }
}
