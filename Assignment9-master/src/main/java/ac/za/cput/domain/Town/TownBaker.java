package ac.za.cput.domain.Town;

import java.util.Objects;

public class TownBaker {

    private String tnBakerId,tnBakerName;
    private double tnBakerSalary;


    private TownBaker(){}

    private TownBaker(Builder builder) {
        this.tnBakerId = builder.tnBakerId;
        this.tnBakerName = builder.tnBakerName;
        this.tnBakerSalary=builder.tnBakerSalary;

    }

    public String getTnBakerId() {
        return tnBakerId;
    }

    public void setTnBakerId(String tnBakerId) {
        this.tnBakerId = tnBakerId;
    }

    public String getTnBakerName() {
        return tnBakerName;
    }

    public void setTnBakerName(String tnBakerName) {
        this.tnBakerName = tnBakerName;
    }

    public double getTnBakerSalary(){
        return tnBakerSalary;
    }

    public void setTnBakerSalary(double tnBakerSalary) {
        this.tnBakerSalary = tnBakerSalary;
    }
    public static class Builder{

        private String tnBakerId, tnBakerName;
        private double tnBakerSalary;


        public Builder tnBakerId(String tnBakerId) {
            this.tnBakerId = tnBakerId;
            return this;
        }

        public Builder tnBakerName(String tnBakerName) {
            this.tnBakerName = tnBakerName;
            return this;
        }

        public Builder tnBakerSalary(double tnBakerSalary) {
            this.tnBakerSalary =tnBakerSalary;
            return this;
        }
        public Builder copy(TownBaker tnBaker){
            this.tnBakerId = tnBaker.tnBakerId;
            this.tnBakerName = tnBaker.tnBakerName;
            this.tnBakerSalary = tnBaker.tnBakerSalary;
            return this;
        }

        public TownBaker build() {
            return new TownBaker(this);
        }

    }

    @Override
    public String toString() {
        return "Town Baker{" +
                " Town Id='" + tnBakerId + '\'' +
                ", Town Name='" + tnBakerName + '\'' +
                ",  Town Salary='" + tnBakerSalary + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownBaker tnBaker = (TownBaker) o;
        return tnBakerId.equals(tnBaker.tnBakerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tnBakerId);
    }
}
