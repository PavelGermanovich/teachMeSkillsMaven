package homework.lesson14.task2;

public class Demo {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Good shoes = new Good(1, "Shoes", 100);
        Good table = new Good(2, "Table", 110);
        Good car = new Good(3, "Car", 130);

        shop.addGoodsToShop(shoes);
        shop.addGoodsToShop(table);
        shop.addGoodsToShop(car);

        System.out.println(shop.getGoodsList());
    }
}
