package core.directory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Box<T extends Fruit> { // Коробка может иметь внутри себя список любых фруктов одного типа.
    private ArrayList<T> fruits;
    public Box() {
        this.fruits = new ArrayList<T>();
    }

    public void putFruit(T fruit) { // Метод добавления одного фрукта в коробку
        this.fruits.add(fruit);
    }
    public void putFruits(Collection<T> newFruits) { // Добавить сразу список фруктов в коробку
        this.fruits.addAll(newFruits);
    }
    public void putFruits(T[] newFruits) {  // Если входной список является массивом
        this.fruits.addAll(Arrays.asList(newFruits));   // Получаем из массива список и добавляем его в коробку.
    }
    public float getWeight() { // Получаем вес коробки, посчитав их количество и умножив на вес одного фрукта
        if (fruits.size() == 0) return 0.0f;
        return fruits.size() * fruits.get(0).weight;
    }
    public boolean compare(Box box) {
        float myWeight = this.getWeight();
        float otherWeight = box.getWeight();
        return Float.compare(myWeight, otherWeight) == 0; // Используем встроенную функцию для сравнения двух плавающих чисел, чтобы избежать проблем с точностью
    }
    public void emptyTo(Box<T> box) { // Опустошаем одну коробку в другую
        box.putFruits(this.fruits); // Добавляем список фруктов этой коробки целиком в новую
        this.fruits.clear(); // И очищаем его в этой коробке.
    }
}
