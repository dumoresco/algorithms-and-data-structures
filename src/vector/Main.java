package vector;

    public class Main {
    public static void main(String[] args) throws Exception {

        // Um vetor armazena uma sequencia de valores onde todos são do mesmo tipo

        Vector vector = new Vector(1);



            vector.add("A");
            vector.add("B");
            vector.add("C");
            vector.add("D");

            vector.add(1, "Z");
            vector.remove(1);


        System.out.println(vector);
        vector.size();




    }
}