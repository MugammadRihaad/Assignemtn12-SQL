package ac.za.cput.domain;

import java.util.Objects;

public class HeadOffice {
    private String officeId,bellvilleBrId,townBrId,
            mpBrId;

    private HeadOffice(){}

    private HeadOffice(Builder builder) {
        this.officeId=builder.officeId;
        this.bellvilleBrId = builder.bellvilleBrId;
        this.townBrId = builder.townBrId;
        this.mpBrId=builder.mpBrId;

    }

    public String getOfficeId(){
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getBellvilleBrId() {
        return bellvilleBrId;
    }

    public void setBellvilleBrId(String bellvilleBrId) {
        this.bellvilleBrId = bellvilleBrId;
    }

    public String getTownBrId() {
        return townBrId;
    }

    public void setTownBrId(String townBrId) {
        this.townBrId = townBrId;
    }

    public String getMpBrId(){
        return mpBrId;
    }

    public void setMpBrId(String mpBrId) {
        this.mpBrId = mpBrId;
    }


    public static class Builder{

        private String officeId,bellvilleBrId, townBrId,mpBrId;


        public Builder officeId(String officeId) {
            this.officeId = officeId;
            return this;
        }

        public Builder bellvilleBrId(String bellvilleBrId) {
            this.bellvilleBrId = bellvilleBrId;
            return this;
        }

        public Builder townBrId(String townBrId) {
            this.townBrId = townBrId;
            return this;
        }

        public Builder mpBrId(String mpBrId) {
            this.mpBrId =mpBrId;
            return this;
        }

        public Builder copy(HeadOffice headOffice){
            this.officeId = headOffice.officeId;
            this.bellvilleBrId = headOffice.bellvilleBrId;
            this.townBrId = headOffice.townBrId;
            this.mpBrId = headOffice.mpBrId;
            return this;
        }

        public HeadOffice build() {
            return new HeadOffice(this);
        }

    }

    @Override
    public String toString() {
        return "Head Office {" +
                " Head Office Id='" + officeId + '\'' +
                " Bellville Branch Id='" + bellvilleBrId + '\'' +
                ",Town Branch Id='" + townBrId + '\'' +
                ",Mitchells Plain  Branch Id='" + mpBrId + '\'' +

                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadOffice headOffice = (HeadOffice) o;
        return officeId.equals(headOffice.officeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeId);
    }
}
