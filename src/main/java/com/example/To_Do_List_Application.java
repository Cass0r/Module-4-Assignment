package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class To_Do_List_Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. Display Items");
            System.out.println("3. Remove Item by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addItem(sessionFactory, scanner);
                case "2" -> displayItems(sessionFactory);
                case "3" -> removeItem(sessionFactory, scanner);
                case "4" -> {
                    sessionFactory.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addItem(SessionFactory sessionFactory, Scanner scanner) {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter short description: ");
        String description = scanner.nextLine();

        System.out.print("Enter task status (0 = incomplete, 1 = complete): ");
        int status = Integer.parseInt(scanner.nextLine());

        Items item = new Items(id, name, description, status);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            System.out.println("Item added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayItems(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Items> itemList = session.createQuery("FROM Items", Items.class).list();

            if (itemList.isEmpty()) {
                System.out.println("No items found.");
            } else {
                for (Items item : itemList) {
                    System.out.println("ID: " + item.getId());
                    System.out.println("Name: " + item.getName());
                    System.out.println("Description: " + item.getShortDescription());
                    System.out.println("Status: " + item.getTaskStatus());
                    System.out.println("-----------");
                }
            }

            session.getTransaction().commit();
        }
    }

    private static void removeItem(SessionFactory sessionFactory, Scanner scanner) {
        System.out.print("Enter the ID of the item to remove: ");
        String id = scanner.nextLine();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Items item = session.get(Items.class, id);
            if (item != null) {
                session.delete(item);
                System.out.println("Item deleted.");
            } else {
                System.out.println("Item not found.");
            }

            session.getTransaction().commit();
        }
    }
}
