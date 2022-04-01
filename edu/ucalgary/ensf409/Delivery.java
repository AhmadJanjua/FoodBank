public class Delivery {

    private int deliveryId;
    private int deliveryTime;

    public Delivery(int deliveryId, int deliveryTime) {
        this.deliveryId = deliveryId;
        this.deliveryTime = deliveryTime;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
