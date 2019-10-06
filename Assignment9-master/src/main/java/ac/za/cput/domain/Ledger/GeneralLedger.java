package ac.za.cput.domain.Ledger;

import java.util.Objects;

public class GeneralLedger {
   private  String date,generalLId;
   private  int totalTransaction;
   private   double totalAmount;

    private GeneralLedger(){}

    private GeneralLedger(Builder builder) {
        this.generalLId = builder.generalLId;
        this.date = builder.date;
        this.totalTransaction=builder.totalTransaction;
        this.totalAmount=builder.totalAmount;
    }

    public String getGeneralLId() {
        return generalLId;
    }

    public void setGeneralLId(String generalLId) {
        this.generalLId = generalLId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalTrans(){
        return totalTransaction;
    }

    public void setTotalTransaction(int totalTransaction) {
        this.totalTransaction = totalTransaction;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static class Builder{

        private String generalLId, date;
        private   int   totalTransaction;
        private double totalAmount;

        public Builder generalLId(String generalLId) {
            this.generalLId = generalLId;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder totalTrans(int totalTransaction){
            this.totalTransaction =totalTransaction;
            return this;
        }

        public Builder totalAmount(double totalAmount) {
            this.totalAmount =totalAmount;
            return this;
        }
        public Builder copy(GeneralLedger genLedger){
            this.generalLId = genLedger.generalLId;
            this.date = genLedger.date;
            this.totalTransaction = genLedger.totalTransaction;
            this.totalAmount = genLedger.totalAmount;
            return this;
        }

        public GeneralLedger build() {
            return new GeneralLedger(this);
        }

    }

    @Override
    public String toString() {
        return "GeneralLedger{" +
                "General Ledger Id='" + generalLId + '\'' +
                ", Date='" + date + '\'' +
                ", Total Transactions='" + totalTransaction + '\'' +
                ", Total amount='" + totalAmount + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralLedger genLedger = (GeneralLedger) o;
        return generalLId.equals(genLedger.generalLId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generalLId);
    }
}
