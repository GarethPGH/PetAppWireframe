import java.util.ArrayList;

/**
 * Name: PetClass
 * 
 * This class is to be used to create Pet objects that are saved to a JSON file
 * to be parsed into database information at a later date, For the purposes of
 * the assignment, there are only a few data items here.
 */
public class PetClass {
    /** Fields */
    public String petName;
    public String petSpecies;
    public String petDescription;
    public String dateLost;
    public String gender;
    public boolean isNeutered;
    public boolean isLost;
    public String[] photos;
    /**
     * addPics ArrayList was added as a field, because when it was only part of the
     * setPhotos method, it added all photos entered into the photos text field from
     * PetObjectsUI to the same object
     */
    ArrayList<String> addPics = new ArrayList<>();

    /**
     * Constructor PetClass creates generic PetClass objects with a single default
     * image
     */
    public PetClass() {
        petName = "Pet Name";
        petSpecies = "Earthling";
        petDescription = "Some Words Here";
        dateLost = "Put a date here";
        isNeutered = false;
        isLost = true;
        gender = "male or female";
        photos = new String[1];
        photos[0] = "Images/Default.jpg";
    }

    /**
     * Constructor PetClass(String name, String description, String date, boolean
     * status, boolean lost, String gender,String photo) Creates PetClass objects
     * given the appropriate input values. It also parses the photos String into an
     * array of photo strings
     * 
     * @param name
     * @param description
     * @param date
     * @param status
     * @param lost
     * @param gender
     * @param photo
     */
    public PetClass(String name, String species, String description, String date, boolean status, boolean lost,
            String gender, String photo) {
        this.petName = name;
        this.petSpecies = species;
        this.petDescription = description;
        this.dateLost = date;
        this.isNeutered = status;
        this.isLost = lost;
        this.gender = gender;
        this.photos = this.setPhotos(photo);
    }

    /**
     * getPetName returns a reference to petName
     * 
     * @return String petName
     */
    public String getPetName() {
        return this.petName;
    }

    /**
     * getSpecies returns a reference to petSpecies
     * 
     * @return String petSpecies
     */

    public String getSpecies() {
        return this.petSpecies;
    }

    /**
     * getPetDescription returns a reference to petDescription
     * 
     * @return String petDescription
     */
    public String getPetDescription() {
        return this.petDescription;
    }

    /**
     * getDateLost returns a reference to dateLost
     * 
     * @return String dateLost
     */
    public String getDateLost() {
        return this.dateLost;
    }

    /**
     * getGender returns a reference to gender
     * 
     * @return String gender
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * getLostStatus returns a reference to isLost
     * 
     * @return boolean isLost
     */
    public Boolean getLostStatus() {
        return this.isLost;
    }

    /**
     * getNeuterStatus returns a reference to isNeutered
     * 
     * @return boolean isNeutered
     */
    public Boolean getNeuterStatus() {
        return this.isNeutered;
    }

    /**
     * getPhotos returns a reference to photos
     * 
     * @return String[] photos
     */
    public String[] getPhotos() {
        return this.photos;
    }

    /**
     * setPetName sets field petName to supplied parameter Name otherwise, generic
     * "Pet Name"
     * 
     * @param name
     */
    public void setPetName(String name) {
        if (!name.isEmpty()) {
            this.petName = name;
        } else {
            this.petName = "Pet Name";
        }
    }

    /**
     * setPetSpecies sets field petSpecies to supplied parameter species otherwise,
     * generic "Earthling"
     * 
     * @param species
     */
    public void setPetSpecies(String species) {
        if (!species.isEmpty()) {
            this.petSpecies = species;
        } else {
            this.petSpecies = "Earthling";
        }
    }

    /**
     * setPetDescription sets field petDescription to supplied parameter description
     * otherwise, generic "Some Words Here"
     * 
     * @param description
     */
    public void setPetDescription(String description) {
        if (!description.isEmpty()) {
            this.petDescription = description;
        } else {
            this.petDescription = "Some Words Here";
        }
    }

    /**
     * setDateLost sets field dateLost to supplied parameter date otherwise, generic
     * "Date Unknown"
     * 
     * @param date
     */
    public void setDateLost(String date) {
        if (!date.isEmpty() && checkDate(date)) {
            this.dateLost = date;
        } else {
            this.dateLost = "Date Unknown";
        }
    }

    /**
     * setNeuterStatus sets field isNeutered to true or false given parameter status
     * 
     * @param status
     */
    public void setNeuterStatus(String status) {
        status = status.toLowerCase();
        if (status.equals("yes")) {
            this.isNeutered = true;
        } else {
            this.isNeutered = false;
        }
    }

    /**
     * setLostStatus sets field isLost to true or false given parameter status
     * 
     * @param status
     */
    public void setLostStatus(String status) {
        status = status.toLowerCase();
        if (status.equals("yes")) {
            this.isLost = true;
        } else {
            this.isLost = false;
        }
    }

    /**
     * setGender sets field gender to "male", or "female", or "unknown" given
     * parameter gender
     * 
     * @param status
     */
    public void setGender(String gender) {
        gender = gender.toLowerCase();
        if (gender.equals("male")) {
            this.gender = "Male";
        } else if (gender.equals("female")) {
            this.gender = "Female";
        } else {
            this.gender = "Unknown";
        }
    }

    /**
     * setPhotos returns an array of strings that reference photos in the Images
     * folder, from the given string picName and appends the ".jpg" file extension
     * to them. Parameter picName can contain many image names separated by spaces
     * 
     * @param picName
     * @return String[] pics
     */
    public String[] setPhotos(String picName) {
        String[] pics;

        if (!picName.isEmpty() || picName.contains(" ")) {
            pics = picName.split(" ");
            for (String pic : pics) {
                String contents = pic;
                addPics.add("Images/" + contents + ".jpg");
            }
            photos = new String[addPics.size()];
            for (int index = 0; index < photos.length; index++) {
                photos[index] = addPics.get(index);
            }
        } else {
            this.photos = new String[1];
            this.photos[0] = "Images/default.jpg";
        }
        return pics = this.photos;
    }

    /**
     * Validation Method checkName Returns true if name only contains upper and
     * lowercase letters, false otherwise
     * 
     * @param name
     * @return true or false
     */
    public boolean checkName(String name) {
        boolean isValid = false;
        String regex = "[A-za-z]";

        // if name contains a space, break it up and check each piece
        if (name.contains(" ")) {
            String[] nameParts = name.split(" ");
            for (String namePart : nameParts) {
                if (namePart.matches(regex)) {
                    isValid = true;
                }
            }
            // Otherwise just check name
        } else {
            if (name.matches(regex)) {
                isValid = true;
            }
        }

        return isValid;
    }

    /**
     * Validation Method checkDate checks if given date matches the pattern
     * MM/DD/YYYY or M/D/YYYY Method should be revised to only accept valid dates!
     * 
     * As of now something like 34/60/7777 would still be valid
     * 
     * @param date
     * @return true or false
     */
    public boolean checkDate(String date) {
        boolean isValid = false;
        String regex = "[0-9]+";

        if (date.contains("/")) {
            String[] dateParts = date.split("/");

            // There must only be 3 items in the array
            if (dateParts.length != 3) {
                return isValid;
            }
            // Check first two parts of each String token MM, DD, M, D
            for (int index = 0; index < dateParts.length - 1; index++) {
                if (dateParts[index].length() < 1 || dateParts[index].length() > 2) {
                    return isValid;
                }
                if (!dateParts[index].matches(regex)) {
                    return isValid;
                }
            }
            // Check final part of String token YYYY
            if (dateParts[dateParts.length - 1].length() != 4) {
                return isValid;
            }
            if (!dateParts[dateParts.length - 1].matches(regex)) {
                return isValid;
            }

            isValid = true;
        }
        return isValid;
    }

}
