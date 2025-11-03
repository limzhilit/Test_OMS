package ie.atu;

import java.lang.classfile.attribute.CodeAttribute;
import java.util.ArrayList;
import java.util.Scanner;

public class OMS {

    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Select action: \n1 Add Order\n2 Update Order\n3 List Order\n4 Quit");
            String action = sc.nextLine();
            switch (action) {
                case "1":
                    addOrder(orders);
                    break;
                case "2":
                    updateOrder(orders);
                    break;
                case "3":
                    listOrders(orders);
                    break;
                case "4":
                    return;
            }
        }

    }
    public static void addOrder(ArrayList<Order> orders) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter order ID: ");
        String orderId = sc.nextLine().strip();
        for (Order order : orders) {
            if (orderId.equals(order.getOrderId())) {
                System.out.println("Order ID already exists! ");
                return;
            }
        }
        System.out.println("Please enter customer name: ");
        String customerName = sc.nextLine().strip();
        System.out.println("Please enter product name: ");
        String productName = sc.nextLine().strip();
        double price = 0;
        while(true) {
            System.out.println("Please enter the price: ");
            String priceString = sc.nextLine().strip();
            try {
                price = Double.parseDouble(priceString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Price is not a number");
            }
        }
        int quantity = 0;
        while(true) {
            System.out.println("Please enter the quantity: ");
            String quantityString = sc.nextLine().strip();
            try {
                quantity = Integer.parseInt(quantityString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Quantity is not a number");
            }
        }

        Order order = new Order(orderId, customerName, productName, price, quantity);
        orders.add(order);
    }

    public static void updateOrder(ArrayList<Order> orders) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter order ID: ");
        String orderId = sc.nextLine().strip();
        for (Order order : orders) {
            if (orderId.equals(order.getOrderId())) {
                while(true) {
                    System.out.println("Select property: \n1 Customer Name\n2 Product Name\n3 Price\n4 Quantity\n5 Quit ");
                    String userInput = sc.nextLine().strip();

                    switch (userInput) {
                        case "1":
                            System.out.println("Current customer Name = " + order.getCustomerName() + "\nNew data: ");
                            String newCustomerName = sc.nextLine().strip();
                            order.setCustomerName(newCustomerName);
                            break;
                        case "2":
                            System.out.println("Current product = " + order.getProductName() + "\nNew data: ");
                            String newProductName = sc.nextLine().strip();
                            order.setProductName(newProductName);
                            break;
                        case "3":
                            double newPrice = 0;
                            while(true) {
                                System.out.println("Current price = " + order.getPrice() + "\nNew data: ");
                                String newPriceString = sc.nextLine().strip();
                                try {
                                    newPrice = Double.parseDouble(newPriceString);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Price is not a number");
                                }
                            }
                            order.setPrice(newPrice);
                            break;
                        case "4":
                            int newQuantity = 0;
                            while(true) {
                                System.out.println("Current quantity = " + order.getQuantity() + "\nNew data: ");
                                String newQuantityString = sc.nextLine().strip();
                                try {
                                    newQuantity = Integer.parseInt(newQuantityString);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Price is not a number");
                                }
                            }
                            order.setQuantity(newQuantity);
                            break;
                        case "5":
                            System.out.println("Quit update");
                        default:
                            System.out.println("Invalid input");
                    }
                }
            }
        }
        System.out.println("Order not found");
        System.out.println("Quit update");


    }

    public static void listOrders(ArrayList<Order> orders) {
        for (Order order : orders) {
            order.toString();
        }
    }
}
