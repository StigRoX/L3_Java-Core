package core.directory;

import core.directory.Apple;
import core.directory.Box;

import java.util.Arrays;
import java.util.List;

public class Main {
    /// Создаем типизированный метод.
    // <T> - универсальный параметр, обозначающий любой тип
    // На вход принимаем массив элементов любого типа, номер первого и второго элементов для замены
    public static <T> void swapElements(T[] array, int first, int second) {
        T buffer = array[first];        // Создаем буфферную переменную типа, соответствующего типу массива, и вносим туда первый элемент
        array[first] = array[second];   // Заменяем первый на второй
        array[second] = buffer;         // Заменяем второй на первый из буфера
    }


    public static void main(String[] args) {
        // Проверяем работу метода
        System.out.println("Массив до перемены мест:");
        String[] strings = new String[] {"world", ", ", "Hello", "!"};
        for(String s: strings) {
            System.out.print(s);
        }
        System.out.println("\nМассив после перемены мест:");
        swapElements(strings, 0, 2);
        for(String s: strings) {
            System.out.print(s);
        }
        System.out.println("\n===");

        // Фрукты и коробки
        Box<Apple> appleBox = new Box<>(); // Коробка для яблок
        appleBox.putFruit(new Apple()); // Добавляем в неё одно яблоко
        Apple[] apples = new Apple[] {new Apple(), new Apple()}; // Создаём массив фруктов
        appleBox.putFruits(apples); // Добавляем сразу несколько фруктов из массива

        Box<Orange> orangeBox = new Box<>(); // Коробка для апельсинов
        List<Orange> oranges = Arrays.asList(new Orange(), new Orange()); // Создаем список апельсинов
        orangeBox.putFruits(oranges); // Добавляем их во вторую коробку

        if (appleBox.compare(orangeBox)) {
            System.out.println("Коробки равны по весу");
        } else {
            System.out.println("Коробки имеют разный вес");
        }

        Box<Apple> newBox = new Box<>();
        appleBox.emptyTo(newBox); // Высыпаем фрукты из первой коробки в новую
        System.out.println("Вес первой коробки, где раньше были яблоки: " + appleBox.getWeight());
        System.out.println("Вес новой коробки: " + newBox.getWeight());
    }
}
