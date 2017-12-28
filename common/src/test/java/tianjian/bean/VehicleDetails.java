package tianjian.bean;

public class VehicleDetails {
    private String make;

    private String model;

    public VehicleDetails(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleDetails() {
    }

    @Override
    public boolean equals(Object vehicleDetails){
        VehicleDetails details = (VehicleDetails) vehicleDetails;
        if(!(vehicleDetails instanceof  VehicleDetails)) {
            return false;
        }
        if((model == null && details.getModel() != null)||!model.equals(details.getModel())) {
            return false;
        }

        if((make == null && details.getMake() != null)||!make.equals(details.getMake())) {
            return false;
        }

        return true;

    }
}
