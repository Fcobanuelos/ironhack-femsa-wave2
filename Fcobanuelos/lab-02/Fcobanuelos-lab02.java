package Fcobanuelos.lab02;

public interface InventoryService {
    void verifyInventory(Order order) throws OutOfStockException;
}

public interface PaymentService {
    boolean processPayment(Order order);
}

public interface DatabaseService {
    void updateOrderStatus(String orderId, String status);
}

public interface NotificationService {
    void notifyCustomer(Order order);
}

public class Order {
    public String id;
    public String type;
    public int quantity;
    public double amount;
    public String customerEmail;
}

public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

public class InventoryServiceImpl implements InventoryService {
    @Override
    public void verifyInventory(Order order) throws OutOfStockException {
        if (inventory < order.quantity) {
            throw new OutOfStockException("Out of stock");
        }
    }
}

public class StandardPaymentService implements PaymentService {
    @Override
    public boolean processPayment(Order order) {
        return paymentService.process(order.amount);
    }
}

public class ExpressPaymentService implements PaymentService {
    @Override
    public boolean processPayment(Order order) {
        return expressPaymentService.process(order.amount, "highPriority");
    }
}

public class DatabaseServiceImpl implements DatabaseService {
    @Override
    public void updateOrderStatus(String orderId, String status) {
        database.updateOrderStatus(orderId, status);
    }
}

public class NotificationServiceImpl implements NotificationService {
    @Override
    public void notifyCustomer(Order order) {
        emailService.sendEmail(order.customerEmail, "Your order has been processed.");
    }
}

public class SystemManager {
    private final InventoryService inventoryService;
    private final PaymentService standardPaymentService;
    private final PaymentService expressPaymentService;
    private final DatabaseService databaseService;
    private final NotificationService notificationService;

    public SystemManager(
            InventoryService inventoryService,
            PaymentService standardPaymentService,
            PaymentService expressPaymentService,
            DatabaseService databaseService,
            NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.standardPaymentService = standardPaymentService;
        this.expressPaymentService = expressPaymentService;
        this.databaseService = databaseService;
        this.notificationService = notificationService;
    }

    public void processOrder(Order order) throws OutOfStockException {
        inventoryService.verifyInventory(order);
        boolean paymentSuccess;
        if (order.type.equals("standard")) {
            paymentSuccess = standardPaymentService.processPayment(order);
        } else if (order.type.equals("express")) {
            paymentSuccess = expressPaymentService.processPayment(order);
        } else {
            throw new IllegalArgumentException("Unknown order type");
        }

        if (paymentSuccess) {
            databaseService.updateOrderStatus(order.id, "processed");
            notificationService.notifyCustomer(order);
        } else {
            throw new RuntimeException("Payment failed");
        }
    }
}

