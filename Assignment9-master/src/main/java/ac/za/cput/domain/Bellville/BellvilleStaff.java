package ac.za.cput.domain.Bellville;

import java.util.Objects;

public class BellvilleStaff {
    private String bellStaffId,bellAccountId,bellDelivId,bellBakerId;

    private BellvilleStaff(){}

    private BellvilleStaff(Builder builder) {
        this.bellStaffId = builder.bellStaffId;
        this.bellAccountId = builder.bellAccountId;
        this.bellDelivId=builder.bellDelivId;
        this.bellBakerId=builder.bellBakerId;
    }

    public String getBellStaffId() {
        return bellStaffId;
    }

    public void setBellStaffId(String bellStaffId) {
        this.bellStaffId = bellStaffId;
    }

    public String getBellAccountId() {
        return bellAccountId;
    }

    public void setBellAccountId(String bellAccountId) {
        this.bellAccountId = bellAccountId;
    }

    public String getBellDelivId(){
        return bellDelivId;
    }

    public void setBellDelivId(String bellDelivId) {
        this.bellDelivId = bellDelivId;
    }

    public String getBellBakerId(){
        return bellBakerId;
    }

    public void setBellBakeId(String bellBakeId) {
        this.bellBakerId = bellBakerId;
    }

    public static class Builder{

        private String bellStaffId, bellAccountId,bellDelivId,bellBakerId;


        public Builder bellStaffId(String bellStaffId) {
            this.bellStaffId = bellStaffId;
            return this;
        }

        public Builder bellAccountId(String bellAccountId) {
            this.bellAccountId = bellAccountId;
            return this;
        }

        public Builder bellBakerId(String bellBakerId) {
            this.bellBakerId =bellBakerId;
            return this;
        }
        public Builder bellDelivId(String bellDelivId) {
            this.bellDelivId =bellDelivId;
            return this;
        }

        public Builder copy(BellvilleStaff bellStaff){
            this.bellBakerId = bellStaff.bellBakerId;
            this.bellDelivId = bellStaff.bellDelivId;
            this.bellAccountId = bellStaff.bellAccountId;
            this.bellStaffId = bellStaff.bellStaffId;
            return this;
        }
        public BellvilleStaff build() {
            return new BellvilleStaff(this);
        }

    }

    @Override
    public String toString() {
        return "Bellville Staff{" +
                " Bellville Staff Id='" + bellStaffId + '\'' +
                ",Bellville Accountant Id='" + bellAccountId + '\'' +
                ", Bellville Delivery Id='" + bellDelivId + '\'' +
                ", Bellville Baker Id='" + bellBakerId + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BellvilleStaff bellStaff = (BellvilleStaff) o;
        return bellStaffId.equals(bellStaff.bellStaffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bellStaffId);
    }

}
