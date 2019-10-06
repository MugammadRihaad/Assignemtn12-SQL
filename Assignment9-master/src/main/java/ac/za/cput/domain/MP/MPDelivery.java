package ac.za.cput.domain.MP;

import java.util.Objects;

public class MPDelivery {
    private String mpDeliveId,mpStockId;

    private MPDelivery(){}

    private MPDelivery(Builder builder) {
        this.mpDeliveId = builder.mpDeliveId;
        this.mpStockId = builder.mpStockId;

    }

    public String getMpDeliveId() {
        return mpDeliveId;
    }

    public void setMpDeliveId(String mpDeliveId) {
        this.mpDeliveId = mpDeliveId;
    }

    public String getMpStockId() {
        return mpStockId;
    }

    public void setMpStockId(String mpStockId) {
        this.mpStockId = mpStockId;
    }



    public static class Builder{

        private String mpDeliveId, mpStockId;


        public Builder mpDeliveId(String mpDeliveId) {
            this.mpDeliveId = mpDeliveId;
            return this;
        }

        public Builder mpStockId(String mpStockId) {
            this.mpStockId = mpStockId;
            return this;
        }

        public Builder copy(MPDelivery mpDeliv){
            this.mpDeliveId = mpDeliv.mpDeliveId;
            this.mpStockId = mpDeliv.mpStockId;
            return this;
        }

        public MPDelivery build() {
            return new MPDelivery(this);
        }

    }

    @Override
    public String toString() {
        return "Mitchells Plain Delivery{" +
                " Mitchells Plain Delivery Id='" + mpDeliveId + '\'' +
                ",Mitchells Plain Stock Id='" + mpStockId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MPDelivery mpDeliv = (MPDelivery) o;
        return mpDeliveId.equals(mpDeliv.mpDeliveId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mpDeliveId);
    }
}
