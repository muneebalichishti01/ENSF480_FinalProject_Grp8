import java.util.HashMap;

public class Promotions {
    private int promotionId;
    private String promotionName;

    // Constructor
    public Promotions(int promotionId, String promotionName) {
        this.promotionId = promotionId;
        this.promotionName = promotionName;
    }

    // Getters and setters

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    // toString method

    @Override
    public String toString() {
        return "Promotions{" +
                "promotionId=" + promotionId +
                ", promotionName='" + promotionName + '\'' +
                '}';
    }

    // HashMap to store promotions
    private static HashMap<Integer, Promotions> promotionsTable = new HashMap<>();

    // Add promotions to the HashMap
    public static void addPromotion(Promotions promotion) {
        promotionsTable.put(promotion.getPromotionId(), promotion);
    }

    // Get a promotion from the HashMap by promotionId
    public static Promotions getPromotion(int promotionId) {
        return promotionsTable.get(promotionId);
    }

    // Get all promotions from the HashMap
    public static HashMap<Integer, Promotions> getAllPromotions() {
        return promotionsTable;
    }
}
