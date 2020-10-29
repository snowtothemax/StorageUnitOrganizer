//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Creates a list of boxes that are visualized and stacked by weight
// Files:           LinkedBoxNode.java, StorageUnitTests.java, Box.java
// Course:          CS  300, Spring, 2019
//
// Author:          Max Johnson
// Email:           mkjohnson9@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * LinkedBoxList class representing a linked list of LinkedBoxNode Objects
 * 
 * @author front
 *
 */
public class LinkedBoxList {
  private LinkedBoxNode head; // head of this LinkedBoxList (refers to the element
  // stored at index 0 within this list)
  private int size; // number of boxes already stored in this list
  private int capacity; // capacity of this LinkedBoxList
  // maximum number of box elements that this LinkedBoxList
  // can store


  // Creates an empty LinkedBoxList with a given initial capacity
  /**
   * Constructor for LinkedBoxList.
   * 
   * @param capacity
   */
  public LinkedBoxList(int capacity) {
    head = null;
    size = 0;
    this.capacity = capacity;
  }

  // Returns the size of this list
  /**
   * Getter method for list size.
   * 
   * @return size
   */
  public int size() {
    return size;
  }

  // Return the capacity of this list
  /**
   * getter method for list capacity
   * 
   * @return capacity
   */
  public int getCapacity() {
    return capacity;
  }

  // Expands the capacity of this LinkedBoxList with the specified number a of
  // additional elements
  /**
   * expands the capacity of the box list.
   * 
   * @param a
   */
  public void expandCapacity(int a) {
    capacity += a;
  }

  // Checks whether this LinkedBoxList is empty
  // returns true if this LinkedBoxList is empty, false otherwise
  /**
   * Tells whether the list is empty or not
   * 
   * @return true if the list is empty, false otherwise.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  // Checks whether this LinkedBoxList is full
  // Returns true if this list is full, false otherwise
  /**
   * Tells whether the list is full or not.
   * 
   * @return true if the size = capacity, false otherwise.
   */
  public boolean isFull() {
    return size == capacity;
  }

  // Adds a new box into this sorted list
  // Throws IllegalArgumentException if newBox is null
  // Throws IllegalStateException if this list is full
  /**
   * Adds a box to the list.
   * 
   * @param newBox
   * @throws IllegalArgumentException if box is null
   * @throws IllegalStateException    if the list is full
   */
  public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {
    boolean isLarger = false;// boolean used to check if the while loop should run.
    if (newBox == null) {// checks if the box to be added is null and throws an exception if that is
                         // the case
      throw new IllegalArgumentException("ERROR: The box to be added is null.");
    }
    if (isFull()) {// checks if the list is full and if it is it throws an exception
      throw new IllegalStateException("ERROR: The list is full!");
    }
    if (head == null) {// if the list is empty
      head = new LinkedBoxNode(newBox);// the new box is assigned to the head
      isLarger = true;// boolean changed so loop doesn't iterate
      size++;// increments the size
    } else {
      size++;// otherwise the size will be incremented no matter what
      if (newBox.compareTo(head.getBox()) > 0) {// checks if the newBox weighs more than the head
        head = new LinkedBoxNode(newBox, head);// if so, the new box is set as the head with the
                                               // head as next
        isLarger = true;
      } else if (newBox.compareTo(head.getBox()) <= 0 && head.getNext() == null) {// checks if the
                                                                                  // newBox weighs
                                                                                  // more than the
                                                                                  // head and there
                                                                                  // is no other box
                                                                                  // after the head
        head.setNext(new LinkedBoxNode(newBox));// sets the new box as the next for the head node
        isLarger = true;
      }
      LinkedBoxNode compBox = head.getNext();
      LinkedBoxNode prevBox = head;// two variables that represent two nodes on the list next to
                                   // eachother
      while (!isLarger) {// loop to iterate through the list of box nodes
        if (compBox == null) {// checks if the node being checked is null
          prevBox.setNext(new LinkedBoxNode(newBox));// if so, the previous node's next node is set
                                                     // to the newBox node
          isLarger = true;
          break;
        }
        if (newBox.compareTo(compBox.getBox()) > 0) {// checks if the newBox is a greater weight
                                                     // than the box being currently checked on the
                                                     // list
          prevBox.setNext(new LinkedBoxNode(newBox, compBox));// the previous nodes next node is set
                                                              // equal to the newBox node, whos next
                                                              // node is set to the current nodes
                                                              // being checked
          isLarger = true;
          break;
        }
        prevBox = compBox;
        compBox = compBox.getNext();// sets each variable equal to the next node on the list
      }
    }
  }

  // Checks if this list contains a box that matches with (equals) a specific box object
  // Returns true if this list contains findBox, false otherwise
  /**
   * Checks if the list contains a certain box
   * 
   * @param findBox
   * @return true if the list contains the box, false otherwise
   */
  public boolean contains(Box findBox) {
    LinkedBoxNode box = head;// the first node on the list
    for (int i = 0; i < size; i++) {// iterates through each node on the list
      if (findBox.equals(box.getBox())) {// checks if the box to be found equals the current box
                                         // being checked on the list
        return true;// returns true
      }
      box = box.getNext();// sets the current pointer equal to the next node on the list
    }
    return false;// false otherwise
  }

  // Returns a box stored in this list given its index
  // Throws IndexOutOfBoundsException if index is out of the range 0..size-1
  /**
   * Returns the box from a node on the list with the input index
   * 
   * @param index
   * @return Box from the list
   * @throws IndexOutOfBoundsException
   */
  public Box get(int index) throws IndexOutOfBoundsException {
    LinkedBoxNode box = head;
    if (index > size - 1) {// checks if the input index is valid
      throw new IndexOutOfBoundsException("ERROR: The index input is invalid");
    }
    for (int i = 0; i <= index; i++) {// iterates through the list of nodes
      if (i == index) {
        return box.getBox();// returns the box with the matching index
      }
      box = box.getNext();
    }
    return null;// otherwise returns null
  }

  // Removes a returns the box stored at index from this LinkedBoxList
  // Throws IndexOutOfBoundsException if index is out of bounds. index should be in
  // the range of [0.. size()-1]
  /**
   * Removes and returns a Box from the list with the matching index.
   * 
   * @param index
   * @return
   * @throws IndexOutOfBoundsException
   */
  public Box remove(int index) throws IndexOutOfBoundsException {
    LinkedBoxNode box = head;// head node of the list
    Box returnBox = null;// box to be returned from the list
    if (index > size || index < 0) {// checks the validity of the input
      throw new IndexOutOfBoundsException("ERROR: The index input is invalid");
    }
    if (index == 0) {// checks if the input index is the first index, then removes the head node
      Box headBox = head.getBox();
      head = head.getNext();// uses a placeholder to remove and return the box from the list
      size--;
      return headBox;
    }
    for (int i = 1; i < index; i++) {// iterates through the list of boxes until it reaches the
                                     // index
      returnBox = box.getBox();// the box to be returned is set to the box on the list
      box = box.getNext();
    }

    size--;
    return returnBox;// returns the last box on the list iterated through
  }

  // Removes all the boxes from this list
  /**
   * Clears the list of all boxes
   */
  public void clear() {
    head = null;
    size = 0;
  }

  /**
   * Returns a String representation for this LinkedBoxList
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(); // creates a StringBuilder object
    String newLine = System.getProperty("line.separator");
    result.append("------------------------------------------------" + newLine);
    if (!isEmpty()) {
      LinkedBoxNode runner = head;
      int index = 0;
      // traverse the list and add a String representation for each box
      while (runner != null) {
        result.insert(0,
            "Box at index " + index + ": " + runner.getBox().getWeight() + " lbs" + newLine);
        runner = runner.getNext();
        index++;
      }
      result.insert(0, "Box List Content:" + newLine);
    }
    result.insert(0, "List size: " + size + " box(es)." + newLine);
    result.insert(0, "Box List is empty: " + isEmpty() + newLine);
    result.insert(0, "------------------------------------------------" + newLine);
    return result.toString();
  }
}
