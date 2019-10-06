package ac.za.cput.domain.Ledger;

import java.util.Objects;

public class BusinessLedger {
    private String businessLId,custName;
    private double custAmountOwed;

    private BusinessLedger(){}

    private BusinessLedger(Builder builder) {
        this.businessLId = builder.businessLId;
        this.custName = builder.custName;
        this.custAmountOwed=builder.custAmountOwed;
    }

    public String getBusniessLId() {
        return businessLId;
    }

    public void setBusinessLId(String businessLId) {
        this.businessLId = businessLId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public double getCustamountOwed(){
        return custAmountOwed;
    }

    public void setCustAmountOwed(double custAmountOwed) {
        this.custAmountOwed = custAmountOwed;
    }

    public static class Builder{

        private String businessLId, custName;
        private double custAmountOwed;

        public Builder businessLId(String businessLId) {
            this.businessLId = businessLId;
            return this;
        }

        public Builder custName(String custName) {
            this.custName = custName;
            return this;
        }

        public Builder custAmountOwed(double custAmountOwed) {
            this.custAmountOwed =custAmountOwed;
            return this;
        }
        public Builder copy(BusinessLedger busLedger){
            this.businessLId = busLedger.businessLId;
            this.custName = busLedger.custName;
            this.custAmountOwed = busLedger.custAmountOwed;
            return this;
        }
        public BusinessLedger build() {
            return new BusinessLedger(this);
        }

    }

    @Override
    public String toString() {
        return "BusinessLedger{" +
                "Business Ledger Id='" + businessLId + '\'' +
                ", Customer Name='" + custName + '\'' +
                ",Customer Total amount Owed='" + custAmountOwed + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessLedger busLedger = (BusinessLedger) o;
        return businessLId.equals(busLedger.businessLId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessLId);
    }
}
