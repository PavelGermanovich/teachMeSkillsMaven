package homework.lesson14.task2;

import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
    private HashMap<Integer, Good> goodsList = new HashMap<>();

    public void addGoodsToShop(Good good) {
        if (goodsList.containsKey(good.getId())) {
            System.out.println("Goods already exist in the shop!");
        } else {
            goodsList.put(good.getId(), good);
            System.out.println(good + " is put in the shop!");
        }
    }

    public ArrayList<Good> getGoodsList() {
        return new ArrayList<>(goodsList.values());
    }

    public void removedGoodFromShop(int goodId) {
        if (goodsList.containsKey(goodId)) {
            goodsList.remove(goodId);
            System.out.println("Good removed, id " + goodId);
        }
        {
            System.out.println("There is no such good in the shop!!");
        }
    }

    public void editGoodInShop(Good good) {
        if (goodsList.containsKey(good.getId())) {
            goodsList.put(good.getId(), good);
            System.out.println("The good is edited!");
        } else {
            System.out.println("There is no such good in the shop!");
        }
    }
}
