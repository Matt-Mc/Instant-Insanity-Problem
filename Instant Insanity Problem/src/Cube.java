public class Cube{

    public Color[] identity;
    public Color UP;
    public Color FRONT;
    public Color RIGHT;
    public Color BACK;
    public Color LEFT;
    public Color DOWN;


    public Color PU;
    public Color PD;
    public Color PL;
    public Color PR;
    public Color PB;
    public Color PF;



    public int count;



    public Cube(Color[] x){

        this.count = 0;
        this.identity =  new Color[x.length];


        for(int i = 0; i < x.length; i++){
            this.identity[i] = x[i];
        }

        this.setIdentity();





    }


    public Cube(Cube other){

        this.UP = other.getUp();
        this.DOWN = other.getDown();
        this.FRONT = other.getFront();
        this.RIGHT = other.getRight();
        this.BACK = other.getBack();
        this.LEFT = other.getLeft();


    }


    public Cube copy(){

        return new Cube(this);



    }


    public boolean hasNext(){

        try{

            this.next();


        }catch(IllegalStateException e){

            return false;
        }

        return true;

    }



    public void next() throws IllegalStateException {
        count += 1;

        if(count == 4 || count == 8 || count == 20) {
            this.rightRoll();
            return;
        }

        if (count == 12 || count == 16) {
            this.leftRoll();
            return;

        }

        if (count == 24) {
            count = 0;
            throw new IllegalStateException("Nani");
        }

        this.rotate();
    }


    public void rotate(){

        this.PF = this.FRONT;
        this.PR = this.RIGHT;
        this.PB = this.BACK;
        this.PL = this.LEFT;

        this.FRONT = this.PL;
        this.RIGHT = this.PF;
        this.BACK = this.PR;
        this.LEFT = this.PB;

    }

    public void rightRoll(){

        this.PL = this.LEFT;
        this.PR = this.RIGHT;
        this.PU = this.UP;
        this.PD = this.DOWN;

        this.LEFT = this.PD;
        this.UP = this.PL;
        this.RIGHT = this.PU;
        this.DOWN = this.PR;


    }

    public void leftRoll(){

        this.PL = this.LEFT;
        this.PR = this.RIGHT;
        this.PU = this.UP;
        this.PD = this.DOWN;

        this.LEFT = this.PU;
        this.UP = this.PR;
        this.RIGHT = this.PD;
        this.DOWN = this.PL;


    }


    public void reset(){

        this.setIdentity();
        this.count = 0;

    }



    private void setIdentity(){
        this.UP = this.identity[0];
        this.FRONT = this.identity[1];
        this.RIGHT = this.identity[2];
        this.BACK = this.identity[3];
        this.LEFT = this.identity[4];
        this.DOWN = this.identity[5];
    }




    public Color getUp(){
        return this.UP;
    }

    public Color getFront(){
        return this.FRONT;
    }

    public Color getRight(){
        return this.RIGHT;
    }

    public Color getBack(){
        return this.BACK;
    }
    public Color getLeft(){
        return this.LEFT;
    }

    public Color getDown(){
        return this.DOWN;
    }


    public String toString(){
        String x = "";

        x += "[ ";

        x += this.UP.toString();
        x += ",";
        x += this.FRONT.toString();
        x += ",";
        x += this.RIGHT.toString();
        x += ",";
        x += this.BACK.toString();
        x += ",";
        x += this.LEFT.toString();
        x += ",";
        x += this.DOWN.toString();
        x += " ]";

        return x;
    }






}