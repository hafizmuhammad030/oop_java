import java.util.*;


class Vehicle{
    String  vehicleID;
    String Location;
    String Status;

    public Vehicle(String vehicleID, String location, String status) {
        this.vehicleID = vehicleID;
        Location = location;
        Status = status;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID='" + vehicleID + '\'' +
                ", Location='" + Location + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }

}
class fleetManagement {
    LinkedList<Vehicle> linkList = new LinkedList<>();

    public void addFleet(String vehicleID, String Location, String Status) {
        linkList.add(new Vehicle(vehicleID, Location, Status));
            System.out.println("Added:" + vehicleID);
        }


    public void removeVehicle(String vehicleID){
        boolean found = false;
        for(Vehicle v : linkList){
            if(v.vehicleID.equals(vehicleID)){
                linkList.remove(v);
                System.out.println("remove" + vehicleID);

                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Does not add");
        }
    }
    void displayForward(){
        System.out.println("display forward");
        for (Vehicle v : linkList)
        {
            System.out.println(v);
        }
    }

    void displayBackward(){
        ListIterator<Vehicle>itr = linkList.listIterator(linkList.size());
        while(itr.hasPrevious()){
            itr.previous();
            System.out.println("Moved to previous");
        }

    }



}