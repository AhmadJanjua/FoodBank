import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

    String OUTPUT_FILENAME = "orderout.txt";

    Delivery testDelivery;
    Hamper testHamper;
    Order testOrder;
    OrderFormat testOrderFormat;

    @Before
    public void setup() {
        testHamper = new Hamper();
        testOrder = new Order();
        testOrderFormat = new OrderFormat();

        // Delete the orderout file
        File orderoutFile = new File(OUTPUT_FILENAME);
        orderoutFile.delete();
    }
    
    @Test
    public void testGetDeliveryId() {
        int expectedDeliveryId = 1;
        testDelivery = new Delivery(expectedDeliveryId, 0);
        assertEquals(expectedDeliveryId, testDelivery.getDeliveryId());
    }

    @Test
    public void testGetDeliveryTime() {
        int expectedDeliveryTime = 1;
        testDelivery = new Delivery(0, expectedDeliveryTime);
        assertEquals(expectedDeliveryTime, testDelivery.getDeliveryTime());
    }

    @Test
    public void testSetDeliveryId() {
        int expectedDeliveryId = 1;
        testDelivery = new Delivery(0, 0);
        testDelivery.setDeliveryId(expectedDeliveryId);
        assertEquals(expectedDeliveryId, testDelivery.getDeliveryId());
    }

    @Test
    public void testSetDeliveryTime() {
        int expectedDeliveryTime = 1;
        testDelivery = new Delivery(0, 0);
        testDelivery.setDeliveryTime(expectedDeliveryTime);
        assertEquals(expectedDeliveryTime, testDelivery.getDeliveryTime());
    }

    @Test
    public void testCreateOrderForm() {
        testOrderFormat.createOrderForm();
        File file = new File(OUTPUT_FILENAME);

        assertTrue(file.exists());
    }

    @Test
    public void testUpdateStock() {
        testOrderFormat.updateStock();

        // I'm not sure what to assert here
    }

    @Test
    public void testCanComplete() {
        Hamper newHamper = new Hamper(new ArrayList<Integer>() {{ add(1); }});
        testOrder.addHamper(newHamper);
        assertTrue(testOrder.canComplete());
    }

    @Test
    public void testAddHamper() {
        int expectedHamperSize = 1;
        Hamper newHamper = new Hamper(new ArrayList<Integer>() {{ add(1); }});
        testOrder.addHamper(newHamper);
        assertEquals(expectedHamperSize, testOrder.getHampers().size());
    }

    @Test
    public void testResetOrder() {
        // Not sure how to test this one yet   
    }

    @Test
    public void testGetHampers() {
        Hamper newHamper = new Hamper(new ArrayList<Integer>() {{ add(1); }});
        testOrder.addHamper(newHamper);
        assertEquals(new ArrayList<Hamper>() {{ add(newHamper); }}, testOrder.getHampers());
    }
}
