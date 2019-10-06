package ac.za.cput.domain.Town;

import java.util.Objects;

public class ProductBiscuits {
    private String productBiscuitsId,category;
    private int amount;


    private ProductBiscuits(){}

    private ProductBiscuits(Builder builder) {
        this.productBiscuitsId = builder.productBiscuitsId;
        this.category = builder.category;
        this.amount=builder.amount;

    }

    public String getProductBiscuitsId() {
        return productBiscuitsId;
    }

    public void setProductBiscuitsId(String productBiscuitsId) {
        this.productBiscuitsId = productBiscuitsId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



    public static class Builder{

        private String productBiscuitsId, category;
        private int amount;


        public Builder productBiscuitsId(String productBiscuitsId) {
            this.productBiscuitsId = productBiscuitsId;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder amount(int amount){
            this.amount=amount;
            return this;
        }

        public Builder copy(ProductBiscuits prodBiscuit){
            this.productBiscuitsId = prodBiscuit.productBiscuitsId;
            this.category = prodBiscuit.category;
            this.amount = prodBiscuit.amount;
            return this;
        }

        public ProductBiscuits build() {
            return new ProductBiscuits(this);
        }

    }

    @Override
    public String toString() {
        return " Biscuits Product{" +
                "Biscuits product Id='" + productBiscuitsId + '\'' +
                ", Biscuits Category ='" + category + '\'' +
                ", Biscuits Amount Id='" + amount + '\'' +

                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBiscuits biscuits = (ProductBiscuits) o;
        return productBiscuitsId.equals(biscuits.productBiscuitsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productBiscuitsId);
    }
}
