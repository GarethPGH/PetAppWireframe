import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create JSON
 * 
 * This class creates properly formatted JSON files given an Array of PetClass
 * objects The counter class is used in conjunction with this class to be able
 * to create as many JSON files as is needed If program is terminated and
 * started up again, JSON files that were previously created will not be
 * over-written.
 * 
 * JSON files are created in the JSON folder.
 */
public class CreateJSON {
    /**
     * Outputs JSON files. If file already exists, it appends an incremented value
     * to it.
     * 
     * @param petList
     */
    public static void writeFile(ArrayList<PetClass> petList) {

        String fileName = "PetRecord";
        File file;
        FileWriter fileWriter;
        int currentPet = 0;

        PetClass[] pets = new PetClass[petList.size()];
        for (int index = 0; index < pets.length; index++) {
            pets[index] = petList.get(index);
        }
        try {
            file = new File("JSON", fileName + Count.counter + ".json");
            if (file.createNewFile()) {
                fileWriter = new FileWriter(file);
            } else {
                Count.increment();
                file = new File("JSON", fileName + Count.counter + ".json");
                fileWriter = new FileWriter(file);
            }

            fileWriter.write("{\n");
            for (PetClass pet : pets) {
                fileWriter.write("\"" + pet.getPetName() + "\":{\n");
                fileWriter.write("\"Pet Name\" : \"" + pet.getPetName() + "\",\n");
                fileWriter.write("\"Pet Species\" : \"" + pet.getSpecies() + "\",\n");
                if (pet.getLostStatus()) {
                    fileWriter.write("\"Pet Missing\" : \"true\",\n");
                } else {
                    fileWriter.write("\"Pet Missing\" : \"false\",\n");
                }
                fileWriter.write("\"Pet Date Lost\" : \"" + pet.getDateLost() + "\",\n");
                fileWriter.write("\"Pet Sex\" : \"" + pet.gender + "\",\n");
                if (pet.getNeuterStatus()) {
                    fileWriter.write("\"Pet Fixed\" : \"true\",\n");
                } else {
                    fileWriter.write("\"Pet Fixed\" : \"false\",\n");
                }
                fileWriter.write("\"Pet Photos\" : [");
                for (int index = 0; index < pet.photos.length; index++) {
                    if (index == pet.photos.length - 1) {
                        fileWriter.write("\"" + pet.photos[index] + "\"]\n");
                    } else {
                        fileWriter.write("\"" + pet.photos[index] + "\",");
                    }
                }
                // if is the last pet
                if (currentPet == pets.length - 1) {
                    fileWriter.write("}\n");
                } else {
                    fileWriter.write("},\n");
                }
                currentPet++;
            }
            fileWriter.write("}\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
