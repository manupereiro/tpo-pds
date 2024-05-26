package system.university.pds.controller;

import system.university.pds.model.Course;
import system.university.pds.model.Order;
import system.university.pds.model.User;

import java.util.HashMap;
import java.util.Map;

public class OrderController {

    private Map<Integer, Order> orders;

    private static int orderId = 0;

    private static OrderController instance = null;

    public static OrderController getInstance() {
        if (instance == null) {
            instance = new OrderController();
        }
        return instance;
    }

    private OrderController() {
        this.orders = new HashMap<>();
    }

    public Order generateOrder(User student) {
        Order order = new Order(student);
        for (Course course : student.getAssignedCourses()) {
            order.addCourse(course.getId(), course);
        }
        addOrder(order);
        return order;
    }

    private void addOrder(Order order) {
        orders.put(orderId, order);
        orderId++;
    }

}
