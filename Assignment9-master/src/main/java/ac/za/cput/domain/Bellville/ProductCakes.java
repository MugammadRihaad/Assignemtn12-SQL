package ac.za.cput.domain.Bellville;

import java.util.Objects;

public class ProductCakes {
    private String productCakeId,category;
    private int amount;


    private ProductCakes(){}

    private ProductCakes(Builder builder) {
        this.productCakeId = builder.productCakeId;
        this.category = builder.category;
        this.amount=builder.amount;

    }

    public String getProductCakeId() {
        return productCakeId;
    }

    public void setProductCakeId(String productCakeId) {
        this.productCakeId = productCakeId;
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

        private String productCakeId, category;
        private int amount;


        public Builder productCakeId(String productCakeId) {
            this.productCakeId = productCakeId;
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

        public Builder copy(ProductCakes prodCakes){
            this.productCakeId = prodCakes.productCakeId;
            this.category = prodCakes.category;
            this.amount = prodCakes.amount;
            return this;
        }

        public ProductCakes build() {
            return new ProductCakes(this);
        }

    }

    @Override
    public String toString() {
        return " Cake Product{" +
                "Cake product Id='" + productCakeId + '\'' +
                ", Cake Category ='" + category + '\'' +
                ", Cake Amount Id='" + amount + '\'' +

                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCakes cakes = (ProductCakes) o;
        return productCakeId.equals(cakes.productCakeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCakeId);
    }
}
