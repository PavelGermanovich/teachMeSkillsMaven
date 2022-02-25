package homework.lesson14.task2;

import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Good shoes = new Good(1, "Shoes", 100);
        Good table = new Good(2, "Table", 110);
        Good car = new Good(3, "Car", 130);
        Good comp = new Good(4, "Comp", 40);
        shop.addGoodsToShop(car);
        shop.addGoodsToShop(shoes);
        shop.addGoodsToShop(table);
        shop.addGoodsToShop(comp);

        System.out.println(shop.getGoodsList());
        List<Good> goodsFromShop = shop.getGoodsList();
        goodsFromShop.sort(Good.getComparatorPriceAscending());
        System.out.println(goodsFromShop);

        shop.removedGoodFromShop(3);
        goodsFromShop = shop.getGoodsList();
        Collections.reverse(goodsFromShop);
        System.out.println(goodsFromShop);

        comp.setName("SUPER COMPUTER");
        shop.editGoodInShop(comp);
        System.out.println(shop.getGoodsList());

        ShopApplication shopApplication = new ShopApplication();
        shopApplication.start();
    }
}
