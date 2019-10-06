package ac.za.cput.domain.Ledger;

import java.util.Objects;

public class CreditorsLedger {
    private String creditorsLId,supplierName;
    private double suppAmountOwed;

    private CreditorsLedger(){}

    private CreditorsLedger(Builder builder) {
        this.creditorsLId = builder.creditorsLId;
        this.supplierName = builder.supplierName;
        this.suppAmountOwed=builder.suppAmountOwed;
    }

    public String getCreditorsLId() {
        return creditorsLId;
    }

    public void setCreditorsLId(String creditorsLId) {
        this.creditorsLId = creditorsLId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public double getSuppAmountOwed(){
        return suppAmountOwed;
    }

    public void setSuppAmountOwed(double suppAmountOwed) {
        this.supplierName = supplierName;
    }

    public static class Builder{

        private String creditorsLId, supplierName;
        private double suppAmountOwed;

        public Builder creditorsLId(String creditorsLId) {
            this.creditorsLId = creditorsLId;
            return this;
        }

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder suppAmountOwed(double suppAmountOwed) {
            this.suppAmountOwed =suppAmountOwed;
            return this;
        }

        public Builder copy(CreditorsLedger credLedger){
            this.creditorsLId = credLedger.creditorsLId;
            this.supplierName = credLedger.supplierName;
            this.suppAmountOwed = credLedger.suppAmountOwed;
            return this;
        }
        public CreditorsLedger build() {
            return new CreditorsLedger(this);
        }

    }

    @Override
    public String toString() {
        return "CreditorsLedger{" +
                "Creditors Ledger Id='" + creditorsLId + '\'' +
                ", Supplier Name='" + supplierName + '\'' +
                ",Supplier Total amount Owed='" + suppAmountOwed + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditorsLedger credLedger = (CreditorsLedger) o;
        return creditorsLId.equals(credLedger.creditorsLId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditorsLId);
    }
}
