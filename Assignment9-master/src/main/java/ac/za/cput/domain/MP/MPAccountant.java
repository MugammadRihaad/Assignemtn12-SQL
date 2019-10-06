package ac.za.cput.domain.MP;

import java.util.Objects;

public class MPAccountant {
    private String mpAccountId,mpLedgerId,mpGeneralLId,
            mpBusinessLId,mpCreditorsLId;

    private MPAccountant(){}

    private MPAccountant(Builder builder) {
        this.mpAccountId=builder.mpAccountId;
        this.mpLedgerId = builder.mpLedgerId;
        this.mpGeneralLId = builder.mpGeneralLId;
        this.mpBusinessLId=builder.mpBusinessLId;
        this.mpCreditorsLId=builder.mpCreditorsLId;
    }

    public String getMpAccountId(){
        return mpAccountId;
    }

    public void setMpAccountId(String mpAccountId) {
        this.mpAccountId = mpAccountId;
    }

    public String getMpLedgerId() {
        return mpLedgerId;
    }

    public void setMpLedgerId(String mpLedgerId) {
        this.mpLedgerId = mpLedgerId;
    }

    public String getMpGeneralLId() {
        return mpGeneralLId;
    }

    public void setMpGeneralLId(String mpGeneralLId) {
        this.mpGeneralLId = mpGeneralLId;
    }

    public String getMpBusinessLId(){
        return mpBusinessLId;
    }

    public void setMpBusinessLId(String mpBusinessLId) {
        this.mpBusinessLId = mpBusinessLId;
    }

    public String getMpCreditorsLId(){
        return mpCreditorsLId;
    }

    public void setMpCreditorsLId(String mpCreditorsLId) {
        this.mpCreditorsLId = mpCreditorsLId;
    }

    public static class Builder{

        private String mpAccountId,mpLedgerId, mpGeneralLId,mpBusinessLId,mpCreditorsLId;


        public Builder mpAccountId(String mpAccountId) {
            this.mpAccountId = mpAccountId;
            return this;
        }

        public Builder mpLedgerId(String mpLedgerId) {
            this.mpLedgerId = mpLedgerId;
            return this;
        }

        public Builder mpGeneralLId(String mpGeneralLId) {
            this.mpGeneralLId = mpGeneralLId;
            return this;
        }

        public Builder mpBusinessLId(String mpBusinessLId) {
            this.mpBusinessLId =mpBusinessLId;
            return this;
        }

        public Builder mpCreditorsLId(String mpCreditorsLId) {
            this.mpCreditorsLId =mpCreditorsLId;
            return this;
        }
        public Builder copy(MPAccountant mpAccount){
            this.mpAccountId = mpAccount.mpAccountId;
            this.mpLedgerId = mpAccount.mpLedgerId;
            this.mpBusinessLId = mpAccount.mpBusinessLId;
            this.mpGeneralLId = mpAccount.mpGeneralLId;
            this.mpCreditorsLId = mpAccount.mpCreditorsLId;
            return this;
        }
        public MPAccountant build() {
            return new MPAccountant(this);
        }

    }

    @Override
    public String toString() {
        return "Mitchells Plain Accountant{" +
                " Mitchells Plain Accountant Id='" + mpAccountId + '\'' +
                ",Mitchells Plain Ledger Ledger Id='" + mpLedgerId + '\'' +
                ",Mitchells Plain General Ledger Id='" + mpGeneralLId + '\'' +
                ",Mitchells Plain Business Ledger Id'" + mpBusinessLId + '\'' +
                ",Mitchells Plain Creditors Ledger Id'" + mpCreditorsLId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MPAccountant mpAccountant = (MPAccountant) o;
        return mpAccountId.equals(mpAccountant.mpAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mpAccountId);
    }
}
