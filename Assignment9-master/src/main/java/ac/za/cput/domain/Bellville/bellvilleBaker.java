package ac.za.cput.domain.Bellville;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class bellvilleBaker {
    @Id
    private String bellBakerId,bellBakerName;
    private double bellBakerSalary;


    private bellvilleBaker(){}

    private bellvilleBaker(Builder builder) {
        this.bellBakerId = builder.bellBakerId;
        this.bellBakerName = builder.bellBakerName;
        this.bellBakerSalary=builder.bellBakerSalary;

    }

    public String getBellBakerId() {
        return bellBakerId;
    }

    public void setBellBakerID(String bellBakerId) {
        this.bellBakerId = bellBakerId;
    }

    public String getBellBakerName() {
        return bellBakerName;
    }

    public void setBellBakerName(String bellBakerName) {
        this.bellBakerName = bellBakerName;
    }

    public double getBellBakerSalary(){
        return bellBakerSalary;
    }

    public void setBellBakerSalary(double bellBakerSalary) {
        this.bellBakerSalary = bellBakerSalary;
    }

    public static class Builder{

        private String bellBakerId, bellBakerName;
        private double bellBakerSalary;


        public Builder bellBakerId(String bellBakerId) {
            this.bellBakerId = bellBakerId;
            return this;
        }

        public Builder bellBakerName(String bellBakerName) {
            this.bellBakerName = bellBakerName;
            return this;
        }

        public Builder bellBakerSalary(double bellBakerSalary) {
            this.bellBakerSalary =bellBakerSalary;
            return this;
        }

        public Builder copy(bellvilleBaker bellBaker){
            this.bellBakerId = bellBaker.bellBakerId;
            this.bellBakerName = bellBaker.bellBakerName;
            this.bellBakerSalary = bellBaker.bellBakerSalary;
            return this;
        }
        public bellvilleBaker build() {
            return new bellvilleBaker(this);
        }

    }

    @Override
    public String toString() {
        return "bellville Baker{" +
                " Bellville Baker Id='" + bellBakerId + '\'' +
                ", Bellville Baker Name='" + bellBakerName + '\'' +
                ", Bellville Baker Salary='" + bellBakerSalary + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        bellvilleBaker bellBaker = (bellvilleBaker) o;
        return bellBakerId.equals(bellBaker.bellBakerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bellBakerId);
    }

}
