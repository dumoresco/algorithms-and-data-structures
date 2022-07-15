package vector;

import java.util.Arrays;

public class Vector {
    private String[] elements;
    private int size;

    // Constructor to set vector size
    public Vector(int size){
        this.elements = new String[size];
        this.size = 0;
    }

    //First way to add an element to a vector, this way is not recommended
    /* public void add(String element){
        // Loop through the array
        for (int i = 0; i < this.elements.length ; i++) {
            // Checks if position i is null, if true add element
            if(this.elements[i] == null){
                this.elements[i] = element;
                break;
            }
        }
    }; */

    //An other way to add an element to a vector, most recommended
    public boolean add(String element){
        this.addSizeToVector();

        if(this.size < this.elements.length){
            this.elements[this.size] = element;
            this.size ++;
            return true;
        }
        return false;
    };
    // 0 1 2 3 4 5 6 = size is 5
    // B C E F G + + =
    public boolean add(int index, String element){
        this.addSizeToVector();
        if(!(index >= 0 && index < this.size)){
            throw new IllegalArgumentException(("Invalid index"));
        }


        for (int i = this.size-1 ; i >= index ; i--) {
            this.elements[i+1] = this.elements[i];
        }
        this.elements[index] = element;
        this.size++;

        // i = 5

        return false;
    };

    // B D E E F -> index to remove (1 -> D)
    // 0 1 2 3 4
    // vector[1] = vector[2]
    // vector[2] = vector[3]
    // vector[3] = vector[4]

    public void remove(int index){
        if(!(index >= 0 && index < this.size)){
            throw new IllegalArgumentException("Invalid index");
        }

        for (int i = index ; i < this.size-1 ; i++) {
            this.elements[i] = this.elements[i+1];
        }
        this.size--;
    };


    public String get(int index){
        if(!(index >= 0 && index < this.size)){
            throw new IllegalArgumentException("Invalid index");
        }
        return "Element in index " + index + ": " + this.elements[index] + "";
    };

    // Get element by element name method
    public boolean get(String element){
        for (int i = 0; i < this.size; i++) {
            if(this.elements[i].equals(element)){
                return true;
            }
        }
        return false;
    };

    private void addSizeToVector(){
        if(this.size == this.elements.length){
            String[] newVector = new String[this.elements.length * 2];
            for(int i = 0; i<this.size; i++){
               newVector[i] = this.elements[i];
            }
            this.elements = newVector;
        }
    };

    public void size(){
        System.out.println("Vetor size: " + this.size);
    };

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.size-1 ; i++) {
            s.append(this.elements[i]);
            s.append(", ");
        }

        if(this.size>0){
            s.append(this.elements[this.size-1]);
        }
        s.append("]");
        return "\n" + s.toString();

    }
}
