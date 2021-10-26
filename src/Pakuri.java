public class Pakuri {
    private String name;
    private int attack, defense, speed;
    public Pakuri(String species) {
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
        name=species;
    }
    public String getSpecies(){
        return Pakuri.this.name;
    }
    public int getAttack(){
        return Pakuri.this.attack;
    }
    public int getDefense(){
        return Pakuri.this.defense;
    }
    public int getSpeed(){
        return Pakuri.this.speed;
    }
    public void setAttack(int newAttack){
        Pakuri.this.attack=newAttack;
    }
    public void evolve() {
        //Will evolve the critter as follows: a) double the attack; b) quadruple the defense; and c) triple the speed
        Pakuri.this.attack*=2;
        Pakuri.this.defense*=4;
        Pakuri.this.speed*=3;
    }
    public int compareTo(Pakuri target){
        //Returns integer determining order of this object and target object (see Comparable API for details)
        return Pakuri.this.compareTo(target);
    }
}
