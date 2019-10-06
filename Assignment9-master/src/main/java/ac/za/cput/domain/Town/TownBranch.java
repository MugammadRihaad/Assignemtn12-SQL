package ac.za.cput.domain.Town;

import java.util.Objects;

public class TownBranch {
    private String tnBrId,tnStaffId;


    private TownBranch(){}

    private TownBranch(Builder builder) {
        this.tnBrId = builder.tnBrId;
        this.tnStaffId = builder.tnStaffId;

    }

    public String getTnBrId() {
        return tnBrId;
    }

    public void setTnBrId(String tnBrId) {
        this.tnBrId = tnBrId;
    }

    public String getTnStaffId() {
        return tnStaffId;
    }

    public void setTnStaffId(String tnStaffId) {
        this.tnStaffId = tnStaffId;
    }



    public static class Builder{

        private String tnBrId, tnStaffId;


        public Builder tnBrId(String tnBrId) {
            this.tnBrId = tnBrId;
            return this;
        }

        public Builder tnStaffId(String tnStaffId) {
            this.tnStaffId = tnStaffId;
            return this;
        }

        public Builder copy(TownBranch tnBranch){
            this.tnBrId = tnBranch.tnBrId;
            this.tnStaffId = tnBranch.tnStaffId;
            return this;
        }

        public TownBranch build() {
            return new TownBranch(this);
        }

    }

    @Override
    public String toString() {
        return "Bellville Branch{" +
                "Bellville Branch Id='" + tnBrId + '\'' +
                ", Bellville Staff Id='" + tnStaffId + '\'' +

                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownBranch tnBranch = (TownBranch) o;
        return tnBrId.equals(tnBranch.tnBrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tnBrId);
    }
}
