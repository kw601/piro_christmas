package christmas.model;

import christmas.constant.MenuEnum;

public class Menu {
    private final int size;
    private MenuEnum menu;

    public Menu(String menuName, int size) {
        if(!checkMenuKind(menuName))
            throw new IllegalArgumentException();

        this.size = size;
    }

    private boolean checkMenuKind(String menuName) {
        MenuEnum orderedMenu = MenuEnum.getMenuInfo(menuName);
        this.menu = orderedMenu;
        return orderedMenu != null;
    }

    public int getSize() {
        return size;
    }

    public boolean checkKind(MenuEnum checkMenu) {
        return checkMenu.getMenuKind() == menu.getMenuKind();
    }

    public int getPrice() {
        return menu.getPrice() * size;
    }

    public String getMenuKind() {return menu.getMenuKind();}

    @Override
    public String toString() {
        return menu.getMenuName() + " "  + size + "개";
    }

    public MenuEnum getMenu() {
        return menu;
    }

    public void setMenu(MenuEnum menu) {
        this.menu = menu;
    }
}
