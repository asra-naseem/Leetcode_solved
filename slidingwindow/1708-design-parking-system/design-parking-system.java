class ParkingSystem {
    int bigLimit;
    int mediumLimit;
    int smallLimit;

    public ParkingSystem(int big, int medium, int small) {
        this.bigLimit=big;
        this.mediumLimit=medium;
        this.smallLimit=small;
        
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
            if(this.bigLimit>=1){
                this.bigLimit--;
                return true;
            }
        }
        else if(carType==2){
            if(this.mediumLimit>=1){
                this.mediumLimit--;
                return true;
            }
        }
        else{
            if(this.smallLimit>=1){
                this.smallLimit--;
                return true;
            }

        }

        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */