package com.epam.collections.queue;

import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        int i = 0;
        List<Integer> dishOrder = new ArrayList<>();
        List<Integer> dishNumbers = new ArrayList<>(IntStream.range(1, numberOfDishes + 1).boxed().collect(Collectors.toList()));
        while(!dishNumbers.isEmpty())
        {
            for(int j = 0; j < dishNumbers.size(); j++)
            {
                i++;
                if(i % everyDishNumberToEat == 0)
                {
                    dishOrder.add(dishNumbers.get(j));
                    dishNumbers.remove(j);
                    j--;
                    i = 0;
                }
            }
        }
        return dishOrder;
    }
}
