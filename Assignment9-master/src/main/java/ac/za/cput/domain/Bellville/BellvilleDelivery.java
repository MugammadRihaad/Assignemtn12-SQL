package ac.za.cput.domain.Bellville;

import java.util.Objects;

public class BellvilleDelivery {
    private String bellDeliveId,bellStockId;

    private BellvilleDelivery(){}

    private BellvilleDelivery(Builder builder) {
        this.bellDeliveId = builder.bellDeliveId;
        this.bellStockId = builder.bellStockId;

    }

    public String getBellDeliveId() {
        return bellDeliveId;
    }

    public void setBellDeliveId(String bellDeliveId) {
        this.bellDeliveId = bellDeliveId;
    }

    public String getBellStockId() {
        return bellStockId;
    }

    public void setBellStockId(String bellStockId) {
        this.bellStockId = bellStockId;
    }



    public static class Builder{

        private String bellDeliveId, bellStockId;


        public Builder bellDeliveId(String bellDeliveId) {
            this.bellDeliveId = bellDeliveId;
            return this;
        }

        public Builder bellStockId(String bellStockId) {
            this.bellStockId = bellStockId;
            return this;
        }

        public Builder copy(BellvilleDelivery bellDeliv){
            this.bellDeliveId = bellDeliv.bellDeliveId;
            this.bellStockId = bellDeliv.bellStockId;
            return this;
        }

        public BellvilleDelivery build() {
            return new BellvilleDelivery(this);
        }

    }

    @Override
    public String toString() {
        return "Bellville Delivery{" +
                " Bellville Delivery Id='" + bellDeliveId + '\'' +
                ",Bellville Stock Id='" + bellStockId + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BellvilleDelivery bellDelivery = (BellvilleDelivery) o;
        return bellDeliveId.equals(bellDelivery.bellDeliveId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bellDeliveId);
    }
}
