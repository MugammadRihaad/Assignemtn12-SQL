package ac.za.cput.domain.MP;

import java.util.Objects;

public class MPStaff {
    private String mpStaffId,mpAccountId,mpDelivId,mpBakerId;

    private MPStaff(){}

    private MPStaff(Builder builder) {
        this.mpStaffId = builder.mpStaffId;
        this.mpAccountId = builder.mpAccountId;
        this.mpDelivId=builder.mpDelivId;
        this.mpBakerId=builder.mpBakerId;
    }

    public String getMpStaffId() {
        return mpStaffId;
    }

    public void setMpStaffId(String mpStaffId) {
        this.mpStaffId = mpStaffId;
    }

    public String getMpAccountId() {
        return mpAccountId;
    }

    public void setMpAccountId(String mpAccountId) {
        this.mpAccountId = mpAccountId;
    }

    public String getMpDelivId(){
        return mpDelivId;
    }

    public void setMpDelivId(String mpDelivId) {
        this.mpDelivId = mpDelivId;
    }

    public String getMpBakerId(){
        return mpBakerId;
    }

    public void setMpBakerId(String mpBakerId) {
        this.mpBakerId = mpBakerId;
    }

    public static class Builder{

        private String mpStaffId, mpAccountId,mpDelivId,mpBakerId;


        public Builder mpStaffId(String mpStaffId) {
            this.mpStaffId = mpStaffId;
            return this;
        }

        public Builder mpAccountId(String mpAccountId) {
            this.mpAccountId = mpAccountId;
            return this;
        }

        public Builder mpDelivId(String mpDelivId) {
            this.mpDelivId =mpDelivId;
            return this;
        }
        public Builder mpBakerId(String mpBakerId) {
            this.mpBakerId =mpBakerId;
            return this;
        }

        public Builder copy(MPStaff mpStaff){
            this.mpBakerId = mpStaff.mpBakerId;
            this.mpDelivId = mpStaff.mpDelivId;
            this.mpAccountId = mpStaff.mpAccountId;
            this.mpStaffId = mpStaff.mpStaffId;
            return this;
        }

        public MPStaff build() {
            return new MPStaff(this);
        }

    }

    @Override
    public String toString() {
        return "Bellville Staff{" +
                " Bellville Staff Id='" + mpStaffId + '\'' +
                ",Bellville Accountant Id='" + mpAccountId + '\'' +
                ", Bellville Delivery Id='" + mpDelivId + '\'' +
                ", Bellville Baker Id='" + mpBakerId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MPStaff mpStaff = (MPStaff) o;
        return mpStaffId.equals(mpStaff.mpStaffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mpStaffId);
    }

}
