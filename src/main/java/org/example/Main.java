package org.example;


public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        for (int i = 4; i < 10; i++) {
            integerMyArrayList.add(i);
        }
        System.out.println(integerMyArrayList);
        integerMyArrayList.add(0, 2);
        System.out.println(integerMyArrayList);
        integerMyArrayList.add(5, 1);
        System.out.println(integerMyArrayList);
        integerMyArrayList.add(3,11);
        integerMyArrayList.add(2,13);
        System.out.println(integerMyArrayList);
        integerMyArrayList.add(10,0);
//        integerMyArrayList.add(20);
        System.out.println(integerMyArrayList);
//        integerMyArrayList.add(20,0);
        integerMyArrayList.remove(6);
        System.out.println(integerMyArrayList);
        integerMyArrayList.remove((Integer) 9 );
        System.out.println(integerMyArrayList);
//        integerMyArrayList.clear();
//        System.out.println(integerMyArrayList);
//        System.out.println(integerMyArrayList.get(2));
        integerMyArrayList.set(4,3);
        System.out.println(integerMyArrayList);
        integerMyArrayList.sort(Integer::compareTo);
        System.out.println(integerMyArrayList);
    }
}