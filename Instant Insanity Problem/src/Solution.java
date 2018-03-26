public class Solution{

    private static int numCalls;
    private Cube[] cs;



    public Solution(Cube[] cubes){

        this.cs = new Cube[cubes.length];

        for(int i = 0; i < cubes.length; i++){

            this.cs[i] = cubes[i].copy();
        }


    }

    public Solution(Solution other, Cube c){

        this.cs = new Cube[other.size() + 1];


        int i;

        for(i = 0; i < other.size(); i++){

            this.cs[i] = other.getCube(i).copy();
        }

        this.cs[i] = c.copy();

    }

    public int size(){
        return this.cs.length;
    }

    public Cube getCube(int i){
        return this.cs[i];
    }



    public Boolean isValid(){

        numCalls += 1;

        int i;

        if(this.cs.length == 1){
            return true;
        }

        for(i = 0;i < this.cs.length - 1; i++) {
            if (this.cs[i].getFront() == this.cs[i + 1].getFront()) {
                return false;
            }

            if (this.cs[i].getBack() == this.cs[i + 1].getBack()) {
                return false;
            }

            if (this.cs[i].getLeft() == this.cs[i + 1].getLeft()) {
                return false;
            }

            if (this.cs[i].getRight() == this.cs[i + 1].getRight()) {
                return false;
            }

            if (this.cs[i].getUp() == this.cs[i + 1].getUp()) {
                return false;
            }

            if (this.cs[i].getDown() == this.cs[i + 1].getDown()) {
                return false;
            }
        }

        return true;

    }


    public Boolean isValid(Cube next){
        numCalls += 1;
        int i;

        for(i = 0;i < this.cs.length; i++) {
            if (this.cs[i].getFront() == this.cs[i + 1].getFront()) {
                return false;
            }

            if (this.cs[i].getBack() == this.cs[i + 1].getBack()) {
                return false;
            }

            if (this.cs[i].getLeft() == this.cs[i + 1].getLeft()) {
                return false;
            }

            if (this.cs[i].getRight() == this.cs[i + 1].getRight()) {
                return false;
            }

            if (this.cs[i].getUp() == this.cs[i + 1].getUp()) {
                return false;
            }

            if (this.cs[i].getDown() == this.cs[i + 1].getDown()) {
                return false;
            }


        }

        i++;


        if (this.cs[i].getFront() == next.getFront()) {
            return false;
        }

        if (this.cs[i].getBack() == next.getBack()) {
            return false;
        }

        if (this.cs[i].getLeft() == next.getLeft()) {
            return false;
        }

        if (this.cs[i].getRight() == next.getRight()) {
            return false;
        }

        if (this.cs[i].getUp() == next.getUp()) {
            return false;
        }

        if (this.cs[i].getDown() == next.getDown()) {
            return false;
        }

        return true;

    }




    public String toString(){

         String x = "";

         for(int i = 0; i < this.cs.length ; i++){
             x += this.cs[i].toString();
        }

        return x;

    }

    public static int getNumberOfCalls(){
        return numCalls;
    }

    public static void resetNumberOfCalls(){
        numCalls = 0;
    }

}