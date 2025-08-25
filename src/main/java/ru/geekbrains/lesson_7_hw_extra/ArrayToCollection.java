/*
* Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
* вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
* Посчитать, сколько раз встречается каждое слово.
 */

package ru.geekbrains.lesson_7_hw_extra;

import java.util.*;

public class ArrayToCollection {

    private static final String[] SURNAMES = {"Ivanov", "Petrova", "Sidorov", "Sidorova", "Delfinova",
                                                "Ivanov", "Sidorov","Ivanov", "Sidorova", "Petrova",
                                                "Sidorova", "Ivanov", "Petrova", "Ivanov", "Sidorova"};

    public static void main(String[] args) {

        System.out.println(uniqueSurnames(SURNAMES));
        System.out.println(countSurnames(SURNAMES));
    }

    public static HashSet<String> uniqueSurnames(String[] surnames) {

        return new HashSet<>(Arrays.asList(surnames));
    }

    public static HashMap<String, Integer> countSurnames(String[] surnames) {

        List<String> surnamesList = new ArrayList<>(Arrays.asList(surnames));
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String surname : uniqueSurnames(surnames)) {
            int counter = 0;
            Iterator<String> iter = surnamesList.iterator();

            while (iter.hasNext()) {
                if (iter.next().equals(surname)) {
                    counter++;
                }
            }
            hashMap.put(surname, counter);
        }
        return hashMap;
    }
}
