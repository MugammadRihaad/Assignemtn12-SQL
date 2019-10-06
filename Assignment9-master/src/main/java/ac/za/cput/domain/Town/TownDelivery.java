package ac.za.cput.domain.Town;

import java.util.Objects;

public class TownDelivery {
    private String tnDeliveId,tnStockId;

    private TownDelivery(){}

    private TownDelivery(Builder builder) {
        this.tnDeliveId = builder.tnDeliveId;
        this.tnStockId = builder.tnStockId;

    }

    public String getTnDeliveId() {
        return tnDeliveId;
    }

    public void setTnDeliveId(String tnDeliveId) {
        this.tnDeliveId = tnDeliveId;
    }

    public String getTnStockId() {
        return tnStockId;
    }

    public void setTnStockId(String tnStockId) {
        this.tnStockId = tnStockId;
    }



    public static class Builder{

        private String tnDeliveId, tnStockId;


        public Builder tnDeliveId(String tnDeliveId) {
            this.tnDeliveId = tnDeliveId;
            return this;
        }

        public Builder tnStockId(String tnStockId) {
            this.tnStockId = tnStockId;
            return this;
        }

        public Builder copy(TownDelivery tnDeliv){
            this.tnDeliveId = tnDeliv.tnDeliveId;
            this.tnStockId = tnDeliv.tnStockId;
            return this;
        }

        public TownDelivery build() {
            return new TownDelivery(this);
        }

    }

    @Override
    public String toString() {
        return "Mitchells Plain Delivery{" +
                " Mitchells Plain Delivery Id='" + tnDeliveId + '\'' +
                ",Mitchells Plain Stock Id='" + tnStockId + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownDelivery tnDeliv = (TownDelivery) o;
        return tnDeliveId.equals(tnDeliv.tnDeliveId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tnDeliveId);
    }
}
