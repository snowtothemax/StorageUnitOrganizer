/**
 * LinkedBox class that holds the data of a box
 * 
 * @author front
 *
 */
public class LinkedBoxNode {

  private Box box; // box that represents the data for this Linked node
  private LinkedBoxNode next; // reference to the next Linked Box Node

  // constructors
  /**
   * Constructor for the LinkedBoxNode object
   * 
   * @param box
   */
  public LinkedBoxNode(Box box) {
    this.box = box;
  } // creates a new LinkedBoxNode object with a given
    // box and without referring to any next LinkedBoxNode

  /**
   * Constructor for a LinkedBoxNode object with specified instance fields
   * 
   * @param box
   * @param next
   */
  public LinkedBoxNode(Box box, LinkedBoxNode next) {
    this.box = box;
    this.next = next;
  } // creates a new LinkedBoxNode
  // object and sets its instance fields box and next to the specified ones

  // getters and setters methods
  /**
   * Returns the nodes next
   * 
   * @return the next node
   */
  public LinkedBoxNode getNext() {
    return next;
  }

  /**
   * Sets the next instance field.
   * 
   * @param next
   */
  public void setNext(LinkedBoxNode next) {
    this.next = next;
  }

  /**
   * gets the nodes box
   * 
   * @return
   */
  public Box getBox() {
    return box;
  }

  /**
   * Sets the nodes box to an input box
   * 
   * @param box
   */
  public void setBox(Box box) {
    this.box = box;
  }
}
