/**
 * Test Pets Class This is a static class for the purpose of testing. Contains
 * an array of four PetClass objects and references to the photos in the Images
 * folder.
 * 
 * Contains a method to get a reference to that array.
 */
public class TestPets {

        public static PetClass derp = new PetClass("Derp", "Dog/ Canis Lupus Familiaris",
                        "A very stupid but loveable dog", "", true, false, "male", "Derp");

        public static PetClass rats = new PetClass("Rat Boyz", "Rat/ Rattus Norvegicus", "A bunch of fun little dudes",
                        "12/24/2016", false, true, "male", "Ratbutts Ratbutts2");
        public static PetClass queen = new PetClass("Queen", "Cat/ Felis Catus",
                        "A regal cat with golden eyes and a sweet demeanor", "5/15/2011", true, true, "female",
                        "Queen");
        public static PetClass gromp = new PetClass("Gromp", "Leopard Gecko/ Eublepharis Macularius",
                        "A grumpy old gecko who wants everyone to stay off his lawn", "", false, false, "Unknown",
                        "GROMP");
        public static PetClass[] pets = { derp, rats, queen, gromp };

        /**
         * Returns a reference to the Pets Array containing 4 PetClass objects
         * 
         * @return pets
         */
        public static PetClass[] getPetArray() {
                return pets;
        }
}
