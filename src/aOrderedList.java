import java.util.Arrays;

public class aOrderedList {

    final int SIZEINCREMENTS = 20;//size of increments for increasing ordered list
    private Comparable[] oList;  //the ordered list
    private int listSize;       //the size of the ordered list
    private int numObjects;    //the number of objects in the ordered list
    private int curr; //index of current element accessed via iterator methods

    //_______________________________________________________________
    /**
     * Ordered List
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public aOrderedList(){
        numObjects = 0;
        listSize = SIZEINCREMENTS;
        oList = new Car[SIZEINCREMENTS];
    }
    //_______________________________________________________________
    /**
     * Car Adding Method
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    void add(Comparable newCar) {
       Comparable car1 = newCar;
       oList[size()] = car1;

        if(size() < 2){
        }
        else{

        for(int j = 0; j < size(); j++) {

            Comparable car2 = oList[j];

            if (car1.compareTo(car2) == -1) { ;

               for(int i = size() - 2; i >= j; i--){
                   oList[i + 1] = oList[i];
               }

                oList[j] = car1;
                j = size();
            }

            if (car1.compareTo(car2) == 0) {

                for(int i = size() - 2; i >= j; i--){
                    oList[i + 1] = oList[i];
                }

                oList[j] = car1;
                j = size();
            }

            if (car1.compareTo(car2) == 1) {

            }
        }
        }

        if(size() == 19){
            Comparable[] temp = Arrays.copyOf(oList, oList.length + SIZEINCREMENTS);
            oList = temp;
        }
    }
    //_______________________________________________________________
    /**
     * Output method
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public String toString() {

       int x = size();

        String string = "";

        for(int i = 0; i < x + 1; i++) {

            if (oList[i] == null){

            }
            else {
                Car car = (Car)oList[i];

                String make = car.getMake();
                int year = car.getYear();
                int price = car.getPrice();

                String tempString = ("[Make: " + make + ", Year: " + year + ", Price: " + price + ";]");
                string = string + "\r\n" + tempString;

            }
        }



        return string;
    }
    //_______________________________________________________________
    /**
     * Size Retrieval Method
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    int size(){

        int x = 0;

        for(int i = 0; i < oList.length - 1; i++){
            if (oList[i] != null){
                x++;
            }
        }

        return x;
    }
    //_______________________________________________________________
    /**
     * oList Comparable object Value Retriever
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    Comparable get(int index){
        Comparable car = oList[index];
        return car;
    }
    //_______________________________________________________________
    /**
     * Boolean Empty Array Identifier
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public Boolean isEmpty(){
        Boolean state = true;

        int x = 0;
        for(int i = 0; i < oList.length - 1; i++){ if (oList[i] != null){ x++; } }
        if (x != 0){ state = false; }

        return state;
    }
    //_______________________________________________________________
    /**
     * Array Content Remover
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    void remove(int index) {

      int listNull = size() - 1;

      int a = index + 1;

      if(a - 1 < 0){

      }
      else {
          oList[a - 1] = null;
      }

      if (size() == 0) {
      }
      else {
          while (a - 1 < listNull) {
              int i = a;
              oList[i - 1] = oList[i];
              a++;
          }
      }


  }
    //_______________________________________________________________
    /**
     * Iterator Reset
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public void reset(){
        curr = -1;
    }
    //_______________________________________________________________
    /**
     * Next Array Value Retriever
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public Comparable next(){
        curr++;
        return oList[curr];
    }
    //_______________________________________________________________
    /**
     * Iterator end identifier
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public boolean hasNext(){
        if(curr < size()){
            return true;
        }
        else{
            return false;
        }
    }
    //_______________________________________________________________
    /**
     * Element Remover integrating Iterator
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public void remove(){
       Comparable removeNext = next();
       int index = arrSearch(removeNext);
       remove(index);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Array Value Search
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    private int arrSearch(Comparable element){
        int index = 0;

        for(int i = 0; i < size() - 1; i++){
            if(oList[i] == element){
                index = i;
            }
        }

        return index;
    }

}
