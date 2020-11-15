package demo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestVendingMachine {

    private static VendingMachine machine;
    @BeforeAll
    static void setUp() {
        machine = new VendingMachine();
        machine.loadItems();
        machine.loadInventories();
    }


    @Test
    @Order(4)
    void testQuantityInStock() {
        System.out.println("*********** 4. testQuantityInStock *******");
        assertEquals(19, machine.getInventoriesDB().get(VendingMachine.COKE));
        assertEquals(20, machine.getInventoriesDB().get(VendingMachine.PEPSI));
        assertEquals(20, machine.getInventoriesDB().get(VendingMachine.SODA));
    }

    @Test
    @Order(1)
    void testInsertMoney() {
        System.out.println("*********** 1. testInsertMoney *******");
        machine.insertMoney(VendingMachine.TEN);
        assertEquals(10.0, machine.getBalance());
        machine.insertMoney(VendingMachine.TEN);
        assertEquals(20.0, machine.getBalance());
        machine.insertMoney(VendingMachine.TEN);
        assertEquals(30.0, machine.getBalance());
    }



    @Test
    @Order(3)
    void testComputeChange() {
        System.out.println("*********** 3. testComputeChange *******");
        assertEquals(5.0, machine.getChange());

    }

    @Test
    @Order(2)
    void testBuyItem() {
        System.out.println("*********** 2. testBuyItem *******");
        double result = machine.buyItem(VendingMachine.COKE);
        assertEquals(5.0, result);
    }

    @Test
    @Order(5)
    void testRefundMoney() {
        System.out.println("*********** 5. testRefundMoney *******");
        machine.insertMoney(VendingMachine.TEN);
        assertEquals(10.0, machine.getBalance());
    }

    @Test
    @Order(6)
    void testReset() {
        System.out.println("*********** 6. testReset *******");
        machine = new VendingMachine();
        machine.loadItems();
        machine.loadInventories();

        assertEquals(20, machine.getInventoriesDB().get(VendingMachine.COKE));
        assertEquals(20, machine.getInventoriesDB().get(VendingMachine.PEPSI));
        assertEquals(20, machine.getInventoriesDB().get(VendingMachine.SODA));
    }
}