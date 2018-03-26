import java.util.ArrayDeque;
import java.util.Queue;

public class Solve {

    public static Cube[] cubes = new Cube[]{
            new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED}),
            new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED}),
            new Cube(new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED}),
            new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE})
    };

    public static Cube[] cubes2 = new Cube[]{
            new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED}),
            new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED}),
            new Cube(new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED}),
            new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE})
    };






    public static void main(String[] args) {
        long start, stop;


        StudentInfo.display();


        System.out.println("generateAndTest:");
        start = System.currentTimeMillis();

        System.out.println(generateAndTest().size());


        stop = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (stop - start) + " milliseconds");


        System.out.println("BreadthFirstSearch:");
        start = System.currentTimeMillis();

        System.out.println(breadthFirstSearch().size());

        stop = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (stop - start) + " milliseconds");


    }



    public static Queue generateAndTest(){

        Solution.resetNumberOfCalls();

        Queue<Solution> open = new ArrayDeque<>();
        Queue<Solution> solutions = new ArrayDeque<>();

        int curCube = 0;

        do{
            open.offer(new Solution(new Cube[]{cubes[curCube]}));
        } while(cubes[curCube].hasNext());


        for(curCube = 0; curCube < cubes.length; curCube++){
            while(!open.isEmpty()){
                Solution current = open.poll();

                do{
                    Solution ext = new Solution(current,cubes[curCube]);

                    if (ext.size() >= cubes.length){
                        open.offer(ext);
                    }



                } while(cubes[curCube].hasNext());

            }
        }

        while(!open.isEmpty()){
            Solution s = open.poll();

            if(s.isValid() && (s.size() == cubes.length)){
                solutions.offer(s);

            }
        }

        return solutions;



    }




    public static Queue breadthFirstSearch(){

        Queue<Solution> open = new ArrayDeque<>();
        Queue<Solution> solutions = new ArrayDeque<>();

        int curCube = 0;

        do{
            open.offer(new Solution(new Cube[]{cubes2[curCube]}));
        }while(cubes2[curCube].hasNext());

        if(cubes2.length == 1) return open;



        for(curCube = 0; curCube < cubes2.length; curCube++){
            while(!open.isEmpty()){
                Solution current = open.poll();

                do{
                    Solution ext = new Solution(current,cubes2[curCube]);
                    if(ext.isValid()){
                        if(ext.size() == cubes2.length){
                            solutions.offer(ext);
                        }else{
                            open.offer(ext);
                        }
                    }
                }while(cubes2[curCube].hasNext());
            }
        }

        return solutions;

    }

}