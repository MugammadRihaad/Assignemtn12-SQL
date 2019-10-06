package ac.za.cput.domain.Town;

import java.util.Objects;

public class TownStaff {
    private String tnStaffId,tnAccountId,tnDelivId,tnBakerId;

    private TownStaff(){}

    private TownStaff(Builder builder) {
        this.tnStaffId = builder.tnStaffId;
        this.tnAccountId = builder.tnAccountId;
        this.tnDelivId=builder.tnDelivId;
        this.tnBakerId=builder.tnBakerId;
    }

    public String getTnStaffId() {
        return tnStaffId;
    }

    public void setTnStaffId(String tnStaffId) {
        this.tnStaffId = tnStaffId;
    }

    public String getTnAccountId() {
        return tnAccountId;
    }

    public void setTnAccountId(String tnStaffId) {
        this.tnStaffId = tnStaffId;
    }

    public String getTnDelivId(){
        return tnDelivId;
    }

    public void setTnDelivId(String tnDelivId) {
        this.tnDelivId = tnDelivId;
    }

    public String getTnBakerId(){
        return tnBakerId;
    }

    public void setTnBakerId(String tnBakerId) {
        this.tnBakerId = tnBakerId;
    }

    public static class Builder{

        private String tnStaffId, tnAccountId,tnDelivId,tnBakerId;


        public Builder tnStaffId(String tnStaffId) {
            this.tnStaffId = tnStaffId;
            return this;
        }

        public Builder tnAccountId(String tnAccountId) {
            this.tnAccountId = tnAccountId;
            return this;
        }

        public Builder tnDelivId(String tnDelivId) {
            this.tnDelivId =tnDelivId;
            return this;
        }
        public Builder tnBakerId(String tnBakerId) {
            this.tnBakerId =tnBakerId;
            return this;
        }
        public Builder copy(TownStaff tnStaff){
            this.tnBakerId = tnStaff.tnBakerId;
            this.tnDelivId = tnStaff.tnDelivId;
            this.tnAccountId = tnStaff.tnAccountId;
            this.tnStaffId = tnStaff.tnStaffId;
            return this;
        }

        public TownStaff build() {
            return new TownStaff(this);
        }

    }

    @Override
    public String toString() {
        return "Town Staff{" +
                " Town Staff Id='" + tnStaffId + '\'' +
                ",Town Accountant Id='" + tnAccountId + '\'' +
                ", Town Delivery Id='" + tnDelivId + '\'' +
                ", Town Baker Id='" + tnBakerId + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownStaff tnStaff = (TownStaff) o;
        return tnStaffId.equals(tnStaff.tnStaffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tnStaffId);
    }

}
