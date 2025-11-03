package ie.atu;

import java.util.ArrayList;
import java.util.Scanner;

public class OMS {

    public static void addOrder(ArrayList<Order> orders) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter order ID: ");
        String orderId = sc.nextLine();
        for (Order order : orders) {
            if (orderId.equals(order.getOrderId())) {
                System.out.println("Order ID already exists! ");
                return;
            }
        }
        System.out.println("Please enter customer name: ");
        String customerName = sc.nextLine();
        System.out.println("Please enter product name: ");
        String productName = sc.nextLine();
        System.out.println("Please enter the price: ");
        String priceString = sc.nextLine();
        double price = Double.parseDouble(priceString);
        System.out.println("Please enter the quantity: ");
        String quantityString = sc.nextLine();
        int quantity = Integer.parseInt(quantityString);
        Order order = new Order(orderId, customerName, productName, price, quantity);
        orders.add(order);
    }

    public static void updateOrder(ArrayList<Order> orders) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter order ID: ");
        String orderId = sc.nextLine();
        for (Order order : orders) {
            if (orderId.equals(order.getOrderId())) {
                System.out.println("Select property: \n1 Customer Name\n2 Product Name\n3 Price\n4 Quantity ");
            }
        }
        System.out.println("Order not found");

    }
}
