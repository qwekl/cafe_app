package org.techtown.mandk;

/**
 * Created by LG on 2017-12-04.
 */

public class Chart {
    String orderId;
    String menuName;
    String menuSize;
    String menuNum;
    String menuPrice;

    public Chart(){

    }

    public Chart(String orderId, String menuName, String menuSize, String menuNum, String menuPrice) {
        this.orderId = orderId;
        this.menuName = menuName;
        this.menuSize = menuSize;
        this.menuNum = menuNum;
        this.menuPrice = menuPrice;
    }

    public Chart(String orderId,String menuName, String menuNum, String menuPrice) {
        this.orderId = orderId;
        this.menuName = menuName;
        this.menuSize = null;
        this.menuNum = menuNum;
        this.menuPrice = menuPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuSize() { return menuSize; }

    public String getMenuNum() {
        return menuNum;
    }

    public String getMenuPrice() {
        return menuPrice;
    }
}