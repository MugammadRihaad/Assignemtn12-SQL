package ac.za.cput.domain.MP;

import java.util.Objects;

public class MPBaker {
    private String mpBakerId,mpBakerName;
    private double mpBakerSalary;


    private MPBaker(){}

    private MPBaker(Builder builder) {
        this.mpBakerId = builder.mpBakerId;
        this.mpBakerName = builder.mpBakerName;
        this.mpBakerSalary=builder.mpBakerSalary;

    }

    public String getMpBakerId() {
        return mpBakerId;
    }

    public void setMpBakerId(String mpBakerId) {
        this.mpBakerId = mpBakerId;
    }

    public String getMpBakerName() {
        return mpBakerName;
    }

    public void setMpBakerName(String mpBakerName) {
        this.mpBakerName = mpBakerName;
    }

    public double getMpBakerSalary(){
        return mpBakerSalary;
    }

    public void setMpBakerSalary(double bakerSalary) {
        this.mpBakerSalary = bakerSalary;
    }

    public static class Builder{

        private String mpBakerId, mpBakerName;
        private double mpBakerSalary;


        public Builder mpBakerId(String mpBakerId) {
            this.mpBakerId = mpBakerId;
            return this;
        }

        public Builder mpBakerName(String mpBakerName) {
            this.mpBakerName = mpBakerName;
            return this;
        }

        public Builder mpBakerSalary(double mpBakerSalary) {
            this.mpBakerSalary =mpBakerSalary;
            return this;
        }


        public MPBaker build() {
            return new MPBaker(this);
        }

        public Builder copy(MPBaker mpBaker){
            this.mpBakerId = mpBaker.mpBakerId;
            this.mpBakerName = mpBaker.mpBakerName;
            this.mpBakerSalary = mpBaker.mpBakerSalary;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Mithcells Plain Baker{" +
                " Mitchells Plain Baker Id='" + mpBakerId + '\'' +
                ", Mithcells Plain Baker Name='" + mpBakerName + '\'' +
                ",  Mitchels Plain Baker Salary='" + mpBakerSalary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MPBaker mpBaker = (MPBaker) o;
        return mpBakerId.equals(mpBaker.mpBakerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mpBakerId);
    }

}
