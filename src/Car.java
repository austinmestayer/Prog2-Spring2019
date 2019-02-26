public class Car implements Comparable<Car> {

    private String make;
    private int year;
    private int price;

    /**
     * Car Object Creator
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public Car (String make, int year, int price){
        this.make = make;
        this.year = year;
        this.price = price;
    }
    //_______________________________________________________________
    /**
     * Make Retriever
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public String getMake(){

        return make;
    }
    //_______________________________________________________________
    /**
     * Year Retriever
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public int getYear(){

        return year;
    }
    //_______________________________________________________________
    /**
     * Price Retriever
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public int getPrice(){

        return price;
    }
    //_______________________________________________________________
    /**
     * CompareTo Method
     *
     * CSC 1351 Programming Project No 2
     * Section 2
     *
     * @author <amesta2>
     * @since <25 February,2019>
     *
     */
    public int compareTo(Car other) {
        int retVal;
        if (price < other.getPrice())
            retVal = -1;
        else if (price == other.getPrice()) {
            if (year < other.getYear())
                retVal = -1;
            else if (year == other.getYear())
                retVal = 0;
            else
                retVal = 1;
        }
        else
            retVal = 1;
        return retVal;
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
    public String toString(Car car) {
    String string = null;

        string.equals("Make: " + car.getMake() + ", Year: "
                + car.getYear() + ", Price: " + car.getPrice() + ";");

        return string;
    }
    //_______________________________________________________________

}
