package ac.za.cput.domain.Ledger;

import java.util.Objects;

public class Ledger {
   private String ledgerId,generalLId,businessLId,creditorsLId;

    private Ledger(){}

    private Ledger(Builder builder) {
        this.ledgerId = builder.ledgerId;
        this.generalLId = builder.generalLId;
        this.businessLId=builder.businessLId;
        this.creditorsLId=builder.creditorsLId;
    }

    public String getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(String ledgerId) {
        this.ledgerId = ledgerId;
    }

    public String getGeneralLId() {
        return generalLId;
    }

    public void setGeneralLId(String generalLId) {
        this.generalLId = generalLId;
    }

    public String getBusinessLId(){
        return businessLId;
    }

    public void setBusinessLId(String businessLId) {
        this.businessLId = businessLId;
    }

    public String getCreditorsLId(){
        return creditorsLId;
    }

    public void setCreditorsLId(String creditorsLId) {
        this.creditorsLId = creditorsLId;
    }

    public static class Builder{

        private String ledgerId, generalLId,businessLId,creditorsLId;


        public Builder ledgerId(String ledgerId) {
            this.ledgerId = ledgerId;
            return this;
        }

        public Builder generalLId(String generalLId) {
            this.generalLId = generalLId;
            return this;
        }

        public Builder businessLId(String businessLId) {
            this.businessLId =businessLId;
            return this;
        }

        public Builder creditorsLId(String creditorsLId) {
            this.creditorsLId =creditorsLId;
            return this;
        }
        public Builder copy(Ledger ledger){
            this.ledgerId = ledger.ledgerId;
            this.generalLId = ledger.generalLId;
            this.businessLId = ledger.businessLId;
            this.creditorsLId = ledger.creditorsLId;
            return this;
        }
        public Ledger build() {
            return new Ledger(this);
        }

    }

    @Override
    public String toString() {
        return "Ledger{" +
                " Ledger Id='" + ledgerId + '\'' +
                ",General Ledger Id='" + generalLId + '\'' +
                ", Business Ledger Id='" + businessLId + '\'' +
                ",Creditors Ledger Id'" + creditorsLId + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ledger ledger = (Ledger) o;
        return ledgerId.equals(ledger.ledgerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ledgerId);
    }
}
