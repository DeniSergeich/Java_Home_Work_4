package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args)
            throws java.io.IOException {
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> middleName = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        ArrayList<Integer> sortList = new ArrayList<>();
        char choice, ignore;
        for (;;){
            do {
                System.out.println("Выберите действие: ");
                System.out.println("    1. Добавить запись");
                System.out.println("    2. Вывести список");
                System.out.println("    3. Вывести список отсортированный по возрасту");
                System.out.print("Выберите вариант: (или q для завершения): ");

                choice = (char) System.in.read();
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (choice < '1' | choice > '3' & choice != 'q');
            if (choice == 'q') break;
            System.out.println("\n");

            switch (choice) {
                case '1':
                    System.out.print("Введите Ф.И.О., возраст и пол (через пробел): ");
                    Scanner scanner = new Scanner(System.in);
                    String[] addList = scanner.nextLine().split(" ");
                    lastName.add(addList[0]);
                    firstName.add(addList[1]);
                    middleName.add(addList[2]);
                    age.add(Integer.parseInt(addList[3]));
                    gender.add(addList[4]);
                    sortList = getSortList(lastName);
                    break;
                case '2':
                    print(lastName, firstName, middleName, age, gender, sortList);
                    break;
                case '3':
                    ArrayList<Integer> ageSortList = new ArrayList<>();
                    ageSortList = getAgeSortList(age, sortList);
                    print(lastName, firstName, middleName, age, gender, ageSortList);
                    break;

            }
            System.out.println("\n");
        }
    }
    public static void print (ArrayList<String> lastName, ArrayList<String> firstName,
                              ArrayList<String> middleName, ArrayList<Integer> age,
                              ArrayList<String> gender, ArrayList<Integer> sortList){
        String result = "";
        for (Integer i: sortList) {
            result += lastName.get(i) + " " + firstName.get(i) + " " + middleName.get(i) + " " +
                        age.get(i) + " " + gender.get(i) + "\n";
        }
        System.out.println(result);
    }
    public static ArrayList<Integer> getSortList (ArrayList<String> age){
        ArrayList sortList = new ArrayList<>();
        for (int i = 0; i < age.size(); i++) {
            sortList.add(i);
        }
        return sortList;
    }
    public static ArrayList<Integer> getAgeSortList (ArrayList<Integer> age, ArrayList<Integer> sortList){
        Collections.sort(sortList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return age.get(o1) - age.get(o2);
            }
        });
        return sortList;
    }

}