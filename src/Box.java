import java.util.Random;

/**
 * Box class that for Box objects that contain a color and a weight
 * 
 * @author front
 *
 */
public class Box implements Comparable<Box> {
  private static Random randGen = new Random(); // generator of random numbers
  private int color; // color of this box
  private int weight; // weight of this box in lbs between 1 inclusive and 31 exclusive

  // methods

  // Creates a new Box and initializes its instance fields color and weight to
  // random values
  /**
   * Constructs a new Box object with random instance fields
   */
  public Box() {
    weight = randGen.nextInt(30) + 1;
    color = randGen.nextInt();
  }

  // Creates a new Box and initializes its instance fields color and weight to the
  // specified values
  // Throws IllegalArgumentException if the provided weight value is out of the
  // range of [1..30]
  /**
   * Constructs a box object with specified instance fields
   * 
   * @param color
   * @param weight
   */
  public Box(int color, int weight) {
    try {
      if (weight < 1 || weight > 30) {// checks if the input variable for weight is valid
        throw new IllegalArgumentException("ERROR: The input weight MUST be between 1 and 31");
      }
    } catch (IllegalArgumentException e) {// catches an error if the weight is invalid
      System.out.println(e.getMessage());
    }
    this.weight = weight;
    this.color = color;
  }

  @Override
  /**
   * checks if the color and weight of the boxes being compared are equals
   * 
   * @return true if weight and color are equal
   */
  public boolean equals(Object other) {
    if (other.getClass().equals(this.getClass())) {// checks if the classes being compared are the
                                                   // same
      Box otherBox = (Box) other;
      if (this.color == otherBox.getColor() && this.weight == otherBox.getWeight()) {// checks if
                                                                                     // the weights
                                                                                     // and colors
                                                                                     // are the same
        return true;
      }
    }
    return false;
  } // equals method defined in Object class

  @Override
  /**
   * checks if this object's weight is larger than the other objects
   */
  public int compareTo(Box otherBox) {
    if (this.getWeight() > otherBox.getWeight()) {
      return 1;// returns 1 if the weight is greater than the other objects
    } else if (this.getWeight() == otherBox.getWeight()) {
      return 0;
    } else
      return -1;
  } // compareTo method defined in Comparable<Box>
    // interface

  /**
   * returns the color of the box
   * 
   * @return int representing the color of the box
   */
  public int getColor() {
    return this.color;
  } // Getter for the instance field color of this box

  /**
   * returns the weight of the box
   * 
   * @return the weight of the box
   */
  public int getWeight() {
    return this.weight;
  } // Getter for the instance field weight of this box
}
