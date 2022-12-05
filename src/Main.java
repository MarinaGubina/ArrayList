import Exceptions.ItemEqualsNullException;

public class Main {
    public static void main(String[] args) throws ItemEqualsNullException {
        ArrayListService arrayList = new ArrayListService(2);
        arrayList.add(0,"Pasha");
        arrayList.add("Masha");
        arrayList.add("Marina");
        arrayList.add(0,"Maksim");
        arrayList.add(3,"Katya");

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.get(3));
        //System.out.println(arrayList.get(4));
        //System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.toArray());
        arrayList.clear();
        //System.out.println(arrayList.get(0));

    }

}