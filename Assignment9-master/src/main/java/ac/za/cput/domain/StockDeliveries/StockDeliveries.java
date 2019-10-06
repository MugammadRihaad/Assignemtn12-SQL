package ac.za.cput.domain.StockDeliveries;

import java.util.Objects;

public class StockDeliveries {
    private String delId,stockdelId,stockId;

    private StockDeliveries(){}

    private StockDeliveries(Builder builder) {
        this.delId = builder.delId;
        this.stockdelId = builder.stockdelId;
        this.stockId=builder.stockId;

    }

    public String getDelId() {
        return delId;
    }

    public void setDelId(String delId) {
        this.delId = delId;
    }

    public String geStockdelId() {
        return stockdelId;
    }

    public void setStockdelId(String stockdelId) {
        this.stockdelId = stockdelId;
    }

    public String getStockId(){
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockdelId = stockId;
    }

    public static class Builder{

        private String delId, stockdelId,stockId;


        public Builder delId(String delId) {
            this.delId = delId;
            return this;
        }

        public Builder stockdelId(String stockdelId) {
            this.stockdelId = stockdelId;
            return this;
        }

        public Builder stockId(String stockId) {
            this.stockId =stockId;
            return this;
        }

        public Builder copy(StockDeliveries stockDel){
            this.delId = stockDel.delId;
            this.stockdelId = stockDel.stockdelId;
            this.stockId = stockDel.stockId;
            return this;
        }

        public StockDeliveries build() {
            return new StockDeliveries(this);
        }

    }

    @Override
    public String toString() {
        return "Stock Deliveries{" +
                " Delivery Id='" + delId + '\'' +
                ",Stock Delivery Id='" + stockdelId + '\'' +
                ", Stock Id='" + stockId + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDeliveries stockDel = (StockDeliveries) o;
        return stockdelId.equals(stockDel.stockdelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockdelId);
    }

}
