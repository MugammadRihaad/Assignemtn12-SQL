package ac.za.cput.domain.Bellville;

import java.util.Objects;

public class BellvilleAccountant {
    private String bellAccountId,bellLedgerId,bellGeneralLId,
            bellBusinessLId,bellCreditorsLId;

    private BellvilleAccountant(){}

    private BellvilleAccountant(Builder builder) {
        this.bellAccountId=builder.bellAccountId;
        this.bellLedgerId = builder.bellLedgerId;
        this.bellGeneralLId = builder.bellGeneralLId;
        this.bellBusinessLId=builder.bellBusinessLId;
        this.bellCreditorsLId=builder.bellCreditorsLId;
    }

    public String getBellAccountId(){
        return bellAccountId;
    }

    public void setBellAccountID(String bellAccountId) {
        this.bellAccountId = bellAccountId;
    }

    public String getBellLedgerId() {
        return bellLedgerId;
    }

    public void setBellLedgerID(String bellLedgerId) {
        this.bellLedgerId = bellLedgerId;
    }

    public String getBellGeneralLId() {
        return bellGeneralLId;
    }

    public void setBellGeneralID(String bellGeneralLId) {
        this.bellGeneralLId = bellGeneralLId;
    }

    public String getBellBusinessLId(){
        return bellBusinessLId;
    }

    public void setBellBusinessID(String bellBusinessLId) {
        this.bellBusinessLId = bellBusinessLId;
    }

    public String getBellCreditorsLId(){
        return bellCreditorsLId;
    }

    public void setBellCreditorsID(String bellCreditorsLId) {
        this.bellCreditorsLId = bellCreditorsLId;
    }

    public static class Builder{

        private String bellAccountId,bellLedgerId, bellGeneralLId,bellBusinessLId,bellCreditorsLId;


        public Builder bellAccountId(String bellAccountId) {
            this.bellAccountId = bellAccountId;
            return this;
        }

        public Builder bellLedgerId(String bellLedgerId) {
            this.bellLedgerId = bellLedgerId;
            return this;
        }

        public Builder bellGeneralLId(String bellGeneralLId) {
            this.bellGeneralLId = bellGeneralLId;
            return this;
        }

        public Builder bellBusinessLId(String bellBusinessLId) {
            this.bellBusinessLId =bellBusinessLId;
            return this;
        }

        public Builder bellCreditorsLId(String bellCreditorsLId) {
            this.bellCreditorsLId =bellCreditorsLId;
            return this;
        }
        public Builder copy(BellvilleAccountant bellAccount){
            this.bellAccountId = bellAccount.bellAccountId;
            this.bellLedgerId = bellAccount.bellLedgerId;
            this.bellBusinessLId = bellAccount.bellBusinessLId;
            this.bellGeneralLId = bellAccount.bellGeneralLId;
            this.bellCreditorsLId = bellAccount.bellCreditorsLId;
            return this;
        }

        public BellvilleAccountant build() {
            return new BellvilleAccountant(this);
        }

    }

    @Override
    public String toString() {
        return "Bellville Accountant{" +
                " Bellville Accountant Id='" + bellAccountId + '\'' +
                " Bellville Ledger Id='" + bellLedgerId + '\'' +
                ",Bellville General Ledger Id='" + bellGeneralLId + '\'' +
                ",Bellville Business Ledger Id='" + bellBusinessLId + '\'' +
                ",Bellville  Creditors Ledger Id'" + bellCreditorsLId + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BellvilleAccountant bellAccountant = (BellvilleAccountant) o;
        return bellAccountId.equals(bellAccountant.bellAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bellAccountId);
    }
}
