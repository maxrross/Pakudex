public class Pakudex {
    private Pakuri[] pakuArray;

    public Pakudex() {
        //Default constructor; if called, the default size for the Pakudex should be 20
        this.pakuArray = new Pakuri[20];
    }

    public Pakudex(int capacity) {
        //Initializes this object to contain exactly capacity objects when completely full
        this.pakuArray = new Pakuri[capacity];
    }

    public int getSize() {
        //Returns the number of critters currently being stored in the Pakudex
        int counter = 0;
        for (int i = 0; i < pakuArray.length; i++) {
            if (pakuArray[i] != null)
                counter++;
        }
        return counter;
    }
    public int getCapacity() {
        //Returns the number of critters that the Pakudex has the capacity to hold at most
        return pakuArray.length;
    }
    public String[] getSpeciesArray() {
        //Returns a String array containing the species of the critters as ordered in the Pakudex; if there are no species
        //added yet, this method should return null
        String[] result = new String[pakuArray.length];
        if (pakuArray[0]==null) {
            return null;
        }
        for (int i = 0; i < pakuArray.length; i++) {
            if (pakuArray[i]==null){
                continue;
            }
            result[i]=(pakuArray[i].getSpecies());
        }
        return result;
    }

    public int[] getStats(String species) {
        //Returns  an  int  array  containing  the  attack,  defense,  and  speed  statistics  of  species  at  indices  0,  1,  and  2
        //respectively; if species is not in the Pakudex, returns null
        //need to find species in pakudex, then find its stuff, then append to new array
        int[] stats = new int[3];
        for (int i = 0; i < pakuArray.length; i++) {
            if (pakuArray[i]==null){
                return null;
            }
            if (species.equals(pakuArray[i].getSpecies())){
                stats[0]= pakuArray[i].getAttack();
                stats[1]= pakuArray[i].getDefense();
                stats[2]= pakuArray[i].getSpeed();
                return stats;
            }
        }
        return null;
    }

    public void sortPakuri() {
        //Sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name
        for (int i = 0; i < pakuArray.length; i++) {
            //need 2nd for loop, iterate forward to length-1
            for (int j = 1; j< pakuArray.length-1; j++) {
                if (pakuArray[j-1] == null || pakuArray[j]==null) {
                    continue;
                } else if (pakuArray[j].getSpecies().compareTo(pakuArray[j - 1].getSpecies()) < 0) {
                    Pakuri temp = pakuArray[j];
                    pakuArray[j] = pakuArray[j-1];
                    pakuArray[j-1] = temp;
                }
            }
        }
    }

    public boolean addPakuri(String species) {
        //Adds species to the Pakudex; if successful, return true, and false otherwise
        for (int i = 0; i < pakuArray.length; i++) {
            if (pakuArray[i]!=null && pakuArray[i].getSpecies().equals(species)) {
                return false;
            }
            if (pakuArray[i] == null){
                pakuArray[i]= new Pakuri(species);
                return true;
            }
        }
        return false;
    }

    public boolean evolveSpecies(String species) {
        //Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
        if (pakuArray[0]==null){
            return false;
        }
        for (int i = 0; i < pakuArray.length; i ++) {
            if (pakuArray[i]==null){
                continue;
            }
            if (pakuArray[i].getSpecies().equals(species)){
                pakuArray[i].evolve();
                return true;
            }
        }
        return false;
    }
}
