package homework.lesson14.task2;

import java.util.*;

public class ShopApplication {
    private Shop shop = new Shop();

    public void start() {
        boolean exit = false;
        do {
            int selectedAction = selectAction();
            if (selectedAction != 5) {
                switchSelectedAction(selectedAction);
            } else {
                exit = true;
            }
        } while (!exit);
    }

    private int selectAction() {
        System.out.println("Select action in the shop:");
        System.out.println("1 - Show all the goods\n2 - Adding a good to the shop" +
                "\n3 - Removing Good from the Shop" + "\n4 - Editing good" + "\n5 - Exit\n");
        boolean isActionInputOk = false;
        int selectedAction = -1;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                selectedAction = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nIncorrect symbols input, Please try again");
                continue;
            }
            if (!(selectedAction < 1 || selectedAction > 5)) {
                isActionInputOk = true;
            } else {
                System.out.println("Incorrect option selected, Please select other value:");
            }
        } while (!isActionInputOk);

        return selectedAction;
    }

    private void switchSelectedAction(int actionId) {
        switch (actionId) {
            case 1:
                int option = showGoodsOptions();
                displayGoodsSorting(option);
                break;
            case 2:
                addGoodToTheShop();
                break;
            case 3:
                removeGood();
                break;
            case 4:
                editGood();
                break;
        }
    }

    private int showGoodsOptions() {
        System.out.println("Select sorting of the goods:\n1) By price ascending\n2) By price descending\n" +
                "3) By adding (newly added at first)");
        boolean isActionInputOk = false;
        int selectedAction = -1;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                selectedAction = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (selectedAction < 1 || selectedAction > 3) {
                System.out.println("Incorrect option selected");
                continue;
            } else {
                isActionInputOk = true;
            }
        } while (!isActionInputOk);
        return selectedAction;
    }

    private void displayGoodsSorting(int sortingId) {
        List<Good> shopGoodsList = shop.getGoodsList();
        switch (sortingId) {
            case 1:
                shopGoodsList.sort(Good.getComparatorPriceAscending());
                System.out.println(shopGoodsList);
                break;
            case 2:
                shopGoodsList.sort((g1, g2) -> g2.getPrice() - g1.getPrice());
                System.out.println(shopGoodsList);
                break;
            case 3:
                List<Good> shopGoodsByAdding = shop.getGoodsList();
                Collections.reverse(shopGoodsByAdding);
                System.out.println(shopGoodsByAdding);
                break;
        }
    }

    private void addGoodToTheShop() {
        System.out.println("Input new good info: id, name and price:");
        int id = validateInputGoodId();
        System.out.println("Please input name of the good");
        String name = new Scanner(System.in).next();
        int price = validateInputPrice();
        shop.addGoodsToShop(new Good(id, name, price));
    }

    private int validateInputGoodId() {
        boolean isInputValidated = false;
        int id = -1;
        do {
            System.out.println("Please input ID");
            Scanner scanner = new Scanner(System.in);
            try {
                id = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect id input, should be integer value, please correct:");
                continue;
            }
            if (!(id < 0)) {
                isInputValidated = true;
            }
        } while (!isInputValidated);
        return id;
    }

    private int validateInputPrice() {
        boolean isInputValidated = false;
        int price = -1;
        do {
            System.out.println("Please input Price");
            Scanner scanner = new Scanner(System.in);
            try {
                price = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect price input, should be integer value, please correct:");
                continue;
            }
            if (!(price < 0)) {
                isInputValidated = true;
            }
        } while (!isInputValidated);
        return price;
    }

    private void removeGood() {
        System.out.println("Please input ID of the good to remove");
        int id = validateInputGoodId();
        shop.removedGoodFromShop(id);
    }

    private void editGood() {
        System.out.println("Input good info to EDIT: id, new name and new price");
        int id = validateInputGoodId();
        System.out.println("Please input new Good name");
        String newName = new Scanner(System.in).next();
        int newPrice = validateInputPrice();
        shop.editGoodInShop(new Good(id, newName, newPrice));
    }
}
