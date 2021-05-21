import java.util.ArrayList;

/**
 * PetsList Class Static class that contains an ArrayList of Pet Objects
 */
public class PetsList {
    /**
     * Field pets, the global ArrayList object
     */
    public static ArrayList<PetClass> pets = new ArrayList<PetClass>();

    /**
     * getPetList returns a reference to the pets ArrayList
     * 
     * @return pets
     */
    public static ArrayList<PetClass> getPetList() {
        return pets;
    }

    /**
     * setPetList sets the pets ArrayList to the values of the supplied ArrayList
     * petList
     * 
     */
    public static void setPetList(ArrayList<PetClass> petList) {
        pets = petList;
    }

    /**
     * add method calls the ArrayList method add to add one PetClass object the the
     * ArrayList pets
     * 
     * @param pet
     */
    public static void add(PetClass pet) {
        pets.add(pet);
    }

    /**
     * get method returns a reference to a single item in the ArrayList pets, by
     * calling the ArrayList method .get Otherwise it returns a null object if the
     * object does not yet exist.
     * 
     * @param index
     * @return
     */
    public static PetClass get(int index) {
        PetClass pet;
        pets.trimToSize();

        if (!pets.isEmpty() && index < pets.size()) {
            pet = pets.get(index);
        } else {
            pet = null;
        }
        return pet;
    }

    /**
     * getSize method returns the size of the List
     * 
     * @return int
     */
    public static int getSize() {
        return pets.size();
    }
}