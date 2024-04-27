package system.university.pds.controller;

import system.university.pds.model.Course;
import system.university.pds.model.Order;
import system.university.pds.model.User;

import java.math.BigInteger;
import java.util.Map;

public class OrderController {

    private Map<BigInteger, Order> orders;

    private static BigInteger orderId = BigInteger.ZERO;

    private static OrderController instance = null;

    public static OrderController getInstance() {
        if (instance == null) {
            instance = new OrderController();
        }
        return instance;
    }

    private OrderController() {
    }

    public void generateOrder(User student) {
        Order order = new Order(student);
        orders.put(orderId, order);
        orderId.add(BigInteger.ONE);
        for (Course course : student.getAssignedCourses()) {
            order.addCourse(course.getId(), course);
        }
    }
}
