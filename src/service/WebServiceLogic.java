package service;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import domain.*;

@WebService(endpointInterface = "service.WebServiceLogicInterface")
public class WebServiceLogic {

    private List<Owner> allOwners = new ArrayList<Owner>();
    private List<RuralHouse> allRHs = new ArrayList<RuralHouse>();

    @WebMethod
    public List<Owner> getAllOwners() {
        return this.allOwners;
    }

    @WebMethod
    public List<RuralHouse> getAllRuralHouses() {
        return this.allRHs;
    }

    @WebMethod
    public Owner getOwnerByName(String aName) {
        for (Owner o : this.allOwners) {
            if (o.getName().equals(aName))
                return o;
        }
        return null;
    }
    @WebMethod
    public RuralHouse getRuralHouseByAddress(String anAddress) {
        for (RuralHouse rh : this.allRHs) {
            if (rh.getAddress().equals(anAddress)) return rh;
        }
        return null;
    }
    private void initialize() {
// Remember that the association Owner---RuralHouse is two-way navigable
        Owner o1 = new Owner("Ainara");
        RuralHouse rh1 = new RuralHouse("Tolosa");
        RuralHouse rh2 = new RuralHouse("Donostia");
        rh1.setOwner(o1);
        rh2.setOwner(o1);
        o1.addRuralHouse(rh1);
        o1.addRuralHouse(rh2);
        Owner o2 = new Owner("Beñat");
        RuralHouse rh3 = new RuralHouse("Aizarna");
        RuralHouse rh4 = new RuralHouse("Zizurkil");
        rh3.setOwner(o2);
        rh4.setOwner(o2);
        o2.addRuralHouse(rh3);
        o2.addRuralHouse(rh4);
        this.allOwners = new ArrayList<Owner>();
        this.allOwners.add(o1);
        this.allOwners.add(o2);
        this.allRHs = new ArrayList<RuralHouse>();
        this.allRHs.add(rh1);
        this.allRHs.add(rh2);
        this.allRHs.add(rh3);
        this.allRHs.add(rh4);
    }

}