
public class StorageUnitTests {

  // Checks whether the behavior of equals method is correct
  /**
   * Checks if the boxEquals() method works correctly
   * 
   * @return true if it works correctly, false otherwise
   */
  public static boolean testBoxEquals() {
    boolean test1 = false;
    Box box1 = new Box(1, 1);
    Box box2 = new Box(1, 1);// creates two new Box objects with the same weight and color

    if (box1.equals(box2)) {// tests if they are equal
      test1 = true;
    }

    return test1;
  }


  // Checks whether the behavior of compareTo method is correctly implemented
  /**
   * Checks if the compareTo() method works correctly
   * 
   * @return true if it works correctly, false otherwise
   */
  public static boolean testBoxCompareTo() {
    Box box1 = new Box(1, 21);
    Box box2 = new Box(1, 22);// creates two new box objects with the different weights

    if (box1.compareTo(box2) > 0) {// checks if the weight of the first box is greater than the
                                   // other
      return false;
    }
    return true;
  }


  // Checks whether remove method defined in your LinkedBoxList works correctly
  /**
   * Checks if the remove() method works correctly
   * 
   * @return true if it works correctly, false otherwise
   */
  public static boolean testLinkedBoxListRemove() {
    LinkedBoxList boxList = new LinkedBoxList(1);// creates a new list
    Box box = new Box();// creates a new box to be added
    boxList.add(box);// adds the box
    boxList.remove(0);// removes the box
    return boxList.isEmpty();// checks if the list is empty
  }

  /**
   * Checks if the add() method works correctly
   * 
   * @return true if it works correctly, false otherwise
   */
  public static boolean testLinkedBoxListAdd() {
    LinkedBoxList boxList = new LinkedBoxList(2);// creates a new list
    boolean test1 = false;
    Box box = new Box();
    Box box2 = new Box();// creates two new box objects to the list
    boxList.add(box);
    boxList.add(box2);// adds two new box objects to the list
    test1 = boxList.contains(box);// checks if the list has the first box
    return test1;
  }

  /**
   * Checks if the contains() method works correctly
   * 
   * @return true if it works correctly, false otherwise
   */
  public static boolean testLinkedBoxListContains() {
    LinkedBoxList boxList = new LinkedBoxList(1);
    Box box = new Box();
    boxList.add(box);// adds a new box to the list
    return boxList.contains(box);// checks if contains() will return the correct thing
  }

  /**
   * Main method for the class to test all the methods
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testBoxEquals(): " + testBoxEquals());
    System.out.println("testLinkedBoxListRemove(): " + testLinkedBoxListRemove());
    System.out.println("testBoxCompareTo(): " + testBoxCompareTo());
    System.out.println("testLinkedBoxListAdd(): " + testLinkedBoxListAdd());
    System.out.println("testLinkedBoxListContains(): " + testLinkedBoxListContains());
  }
}
