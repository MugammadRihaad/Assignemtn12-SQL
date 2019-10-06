package ac.za.cput.domain.MP;

import java.util.Objects;

public class ProductBread {
    private String productBreadId,category;
    private int amount;


    private ProductBread(){}

    private ProductBread(Builder builder) {
        this.productBreadId = builder.productBreadId;
        this.category = builder.category;
        this.amount=builder.amount;

    }

    public String getProductBreadId() {
        return productBreadId;
    }

    public void setProductBreadId(String productBreadId) {
        this.productBreadId = productBreadId;
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

        private String productBreadId, category;
        private int amount;


        public Builder productBreadId(String productBreadId) {
            this.productBreadId = productBreadId;
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

        public Builder copy(ProductBread prodBread){
            this.productBreadId = prodBread.productBreadId;
            this.category = prodBread.category;
            this.amount = prodBread.amount;
            return this;
        }

        public ProductBread build() {
            return new ProductBread(this);
        }

    }

    @Override
    public String toString() {
        return " Bread Product{" +
                "Bread product Id='" + productBreadId + '\'' +
                ", Bread Category ='" + category + '\'' +
                ", Bread Amount Id='" + amount + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBread bread = (ProductBread) o;
        return productBreadId.equals(bread.productBreadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productBreadId);
    }
}
