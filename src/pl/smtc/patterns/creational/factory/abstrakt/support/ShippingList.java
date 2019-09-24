package pl.smtc.patterns.creational.factory.abstrakt.support;

import pl.smtc.patterns.creational.factory.abstrakt.product.lamp.Lamp;

import java.util.ArrayList;
import java.util.List;

public class ShippingList {
    protected List<ShippingItem> list = new ArrayList<>();

    public void addItem(ShippingItem item) {
        list.add(item);
    }

    public void printList() {
        System.out.println("Created shipping list has: " + list.size() + " elements.");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  " + (i + 1) + ") " + list.get(i).getDescription());
        }
    }

    public void testItem(int listIndex) {
        if(listIndex > 0 && listIndex <= list.size()) {
            testItem(list.get(listIndex - 1));
        } else {
            System.out.println("Specified number [" + listIndex + "] is outside list.");
        }
    }

    public int size() {
        return list.size();
    }

    private void testItem(ShippingItem item) {
        Lamp lamp = item.getLamp();
        lamp.mount();
        lamp.power(true);
        lamp.power(false);
    }
}
