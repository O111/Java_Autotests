package ru.geekbrains.lesson_7;

import java.util.HashMap;
import java.util.Map;

public class MapStart {

    public static void main(String[] args) {
        Map<CarModel, String> carMap = new HashMap<>();

        CarModel vaz = new CarModel("vaz");

        carMap.put(vaz, "very bad!");
        carMap.put(new CarModel("bmw"), "nice car!");
        carMap.put(new CarModel("zaporozhets"), "amazing driving experience! Wow!");

        System.out.println(carMap.get(vaz));
        System.out.println(carMap.containsKey(vaz));
        System.out.println(carMap.containsValue("nice car!"));

        Map<String, String> countryCity = new HashMap<>();
        countryCity.put("Russia", "Moscow");
        countryCity.put("Belarus", "Minsk");
        countryCity.put("Ukraine", "Kiev");

        System.out.println(countryCity);
    }
}
