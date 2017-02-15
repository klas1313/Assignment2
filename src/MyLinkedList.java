
/**
 *  MyLinkedList
 *
 * COMP 2140 SECTION D01
 * ASSIGNMENT    Assignment 2
 * @author       Jeongwon Park, 7821584
 * @version      2/17/2017
 *
 * PURPOSE:
 */
public class MyLinkedList {

    private static Node firstNode;
    private static int size;


    public MyLinkedList(){
//        Provide a default constructor that initializes an empty
//        Linked List, with a size of 0
       firstNode = new Node(null);
       size = 0;
    }

    public void insert(Object theItem, Node newNode){
//        Insert a new item at the front of the list.
//        Duplicate items are permitted.
        Node insertedNode = new Node(theItem);
        firstNode = insertedNode;

        if (firstNode != null) {
            while (firstNode.getNext() != null) {
                firstNode = firstNode.getNext();
            }
            firstNode.setNext(insertedNode);
        }
        size++;
    }

    public Object delete(String newString){
//        Delete the first instance of a given item, if
//        it exists in the list. Use the equals method of the Object class to compare two
//                Objects. Return a reference to the deleted item, or null if it was not found.
        //Node deletedNode = new Node(newString);

        if(firstNode != null){
            firstNode.setNext(firstNode);
        }
        size--;
        return firstNode;
    }

    public int getSize(){
//        Return the number of items in the list. In order to implement this
//        efficiently, you should keep a private instance variable that maintains a count of the
//        number of items in the list.
        return size;
    }

    public Object initTraversal(){
//        Initialize a private instance variable to point to the
//        first Node in the list (or null if the list is empty). Return the item in the first Node (if
//        the list is not empty) or else return null.
        if (firstNode.getNext() != null) {
            return firstNode.getItem();
        } else {
            return null;
        }
    }

    public Object traverse(){
//        Advance the instance variable from initTraversal to the next
//        node in the list (if it exists) or else set it to null if the end of the list has been reached.
//        Return the item pointed to (if the traversal variable is not null) or else return null
        if (firstNode.getNext() != null) {
            return firstNode.getNext().getItem();
        } else {
            return null;
        }

    }

//    public MyLinkedList reverse(){
////        Return a new MyLinkedList object which contains
////        the same items but in reverse order. This method should create a new empty list, and
////        then must call a private, recursive method named addRecursively(...) to add
////        elements to this new list. In other words, your reverse() method will call
////        addRecursively(...) and then addRecursively(...) will call itself a
////        sufficient number of times to correctly fill the new list. The parameters of the recursive
////        method are given as (…) to indicate that the list of parameters is up to you. The return
////                value, if any, is also for you to choose.
//
//    }

//    public String toString(){
////        Return a String representation of the list. Separate each
////        item with an underscore “_”, and enclose the items in braces, e.g. {anItem_78_5.9_z}.
////        This public method must call a private, recursive method named
////        toStringItem(...) to generate the underscore-separated list of items (you may
////                add the braces in the public method though). As was the case for reverse(), the
////        choice of parameters and return type, if any, are up to you.
//
//        //add braces here.
//
//
//    }

    public String toStringItem(Object theItem){

        theItem = firstNode.getItem();
        String itemToString = theItem.toString();

        if (firstNode == null) {
            return theItem.toString();
        } else {
            return toStringItem(itemToString + "_");
        }
    }
}

class Node {  //need to implement my own. This must store "object"
    private Object item;
    private Node next;

    public Node(Object item) {//initial Node
        this.item = item;
        next = null;
    }

    public Node(Object item, Node next) {//in case, I need a specific node
        this.item = item;
        this.next = next;
    }

    public Object getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}