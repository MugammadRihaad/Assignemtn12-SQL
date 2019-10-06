package ac.za.cput.domain.Town;

import java.util.Objects;

public class TownAccountant {
    private String tnAccountId,tnLedgerId,tnGeneralLId,
            tnBusinessLId,tnCreditorsLId;

    private TownAccountant(){}

    private TownAccountant(Builder builder) {
        this.tnAccountId=builder.tnAccountId;
        this.tnLedgerId = builder.tnLedgerId;
        this.tnGeneralLId = builder.tnGeneralLId;
        this.tnBusinessLId=builder.tnBusinessLId;
        this.tnCreditorsLId=builder.tnCreditorsLId;
    }

    public String getTnAccountId(){
        return tnAccountId;
    }

    public void setTnAccountId(String tnAccountId) {
        this.tnAccountId = tnAccountId;
    }

    public String getTnLedgerId() {
        return tnLedgerId;
    }

    public void setTnLedgerId(String tnLedgerId) {
        this.tnLedgerId = tnLedgerId;
    }

    public String getTnGeneralLId() {
        return tnGeneralLId;
    }

    public void setTnGeneralLId(String tnGeneralLId) {
        this.tnGeneralLId = tnGeneralLId;
    }

    public String getTnBusinessLId(){
        return tnBusinessLId;
    }

    public void setTnBusinessLId(String tnBusinessLId) {
        this.tnBusinessLId = tnBusinessLId;
    }

    public String getTnCreditorsLId(){
        return tnCreditorsLId;
    }

    public void setTnCreditorsLId(String tnCreditorsLId) {
        this.tnCreditorsLId = tnCreditorsLId;
    }


    public static class Builder{

        private String tnAccountId,tnLedgerId, tnGeneralLId,tnBusinessLId,tnCreditorsLId;


        public Builder tnAccountId(String tnAccountId) {
            this.tnAccountId = tnAccountId;
            return this;
        }

        public Builder tnLedgerId(String tnLedgerId) {
            this.tnLedgerId = tnLedgerId;
            return this;
        }

        public Builder tnGeneralLId(String tnGeneralLId) {
            this.tnGeneralLId = tnGeneralLId;
            return this;
        }

        public Builder tnBusinessLId(String tnBusinessLId) {
            this.tnBusinessLId =tnBusinessLId;
            return this;
        }

        public Builder tnCreditorsLId(String tnCreditorsLId) {
            this.tnCreditorsLId =tnCreditorsLId;
            return this;
        }

        public Builder copy(TownAccountant tnAccount){
            this.tnAccountId = tnAccount.tnAccountId;
            this.tnLedgerId = tnAccount.tnLedgerId;
            this.tnBusinessLId = tnAccount.tnBusinessLId;
            this.tnGeneralLId = tnAccount.tnGeneralLId;
            this.tnCreditorsLId = tnAccount.tnCreditorsLId;
            return this;
        }
        public TownAccountant build() {
            return new TownAccountant(this);
        }

    }

    @Override
    public String toString() {
        return "Town Accountant{" +
                " Town Accountant Id='" + tnAccountId + '\'' +
                " Town Ledger Id='" + tnLedgerId + '\'' +
                ",Town General Ledger Id='" + tnGeneralLId + '\'' +
                ",Town Business Ledger Id='" + tnBusinessLId + '\'' +
                ",Town  Creditors Ledger Id'" + tnCreditorsLId + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownAccountant tnAccountant = (TownAccountant) o;
        return tnAccountId.equals(tnAccountant.tnAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tnAccountId);
    }
}
