package ac.za.cput.domain.MP;

import java.util.Objects;

public class MPBranch {
    private String mpBrId,mpStaffId;


    private MPBranch(){}

    private MPBranch(Builder builder) {
        this.mpBrId = builder.mpBrId;
        this.mpStaffId = builder.mpStaffId;

    }

    public String getMpBrId() {
        return mpBrId;
    }

    public void setMpBrId(String mpBrId) {
        this.mpBrId = mpBrId;
    }

    public String getMpStaffId() {
        return mpStaffId;
    }

    public void setMpStaffId(String mpStaffId) {
        this.mpStaffId = mpStaffId;
    }



    public static class Builder{

        private String mpBrId, mpStaffId;


        public Builder mpBrId(String mpBrId) {
            this.mpBrId = mpBrId;
            return this;
        }

        public Builder mpStaffId(String mpStaffId) {
            this.mpStaffId = mpStaffId;
            return this;
        }


        public Builder copy(MPBranch mpBranch){
            this.mpBrId = mpBranch.mpBrId;
            this.mpStaffId = mpBranch.mpStaffId;
            return this;
        }
        public MPBranch build() {
            return new MPBranch(this);
        }

    }

    @Override
    public String toString() {
        return "Mitchells Plain Branch{" +
                "Mitchells Plain Branch Id='" + mpBrId + '\'' +
                ", MitchellsPlain Staff Id='" + mpStaffId + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MPBranch mpBranch = (MPBranch) o;
        return mpBrId.equals(mpBranch.mpBrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mpBrId);
    }
}
