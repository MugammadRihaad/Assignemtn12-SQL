package ac.za.cput.domain.Bellville;

import java.util.Objects;

public class BellvilleBranch {
    private String bellBrId,bellStaffId;


    private BellvilleBranch(){}

    private BellvilleBranch(Builder builder) {
        this.bellBrId = builder.bellBrId;
        this.bellStaffId = builder.bellStaffId;

    }

    public String getBellBrId() {
        return bellBrId;
    }

    public void setBellBrId(String bellBrId) {
        this.bellBrId = bellBrId;
    }

    public String getBellStaffId() {
        return bellStaffId;
    }

    public void setBellStaffId(String bellStaffId) {
        this.bellStaffId = bellStaffId;
    }



    public static class Builder{

        private String bellBrId, bellStaffId;


        public Builder bellBrId(String bellBrId) {
            this.bellBrId = bellBrId;
            return this;
        }

        public Builder bellStaffId(String bellStaffId) {
            this.bellStaffId = bellStaffId;
            return this;
        }



        public BellvilleBranch build() {
            return new BellvilleBranch(this);
        }

        public Builder copy(BellvilleBranch bellBranch){
            this.bellBrId = bellBranch.bellBrId;
            this.bellStaffId = bellBranch.bellStaffId;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Bellville Branch{" +
                "Bellville Branch Id='" + bellBrId + '\'' +
                ", Bellville Staff Id='" + bellStaffId + '\'' +

                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BellvilleBranch bellBranch = (BellvilleBranch) o;
        return bellBrId.equals(bellBranch.bellBrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bellBrId);
    }
}
