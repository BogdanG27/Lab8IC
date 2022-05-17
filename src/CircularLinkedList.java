/**
 * Class that represents a Linked List with a sentinel
 * It has a head and a tail, that are the limits of the list
 * every node has a reference to the next element in the list
 */
public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;


    /**
     * Constructor
     */
    public CircularLinkedList() {
    }

    /**
     * Adds a new value to the list and creates the required links
     * @param value the value to be added to the list
     */

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * Checks if the list contains a certain value
     * @param searchValue the value to be searched
     * @return true if the list contains the value otherwise false
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * deletes a certain node to the list, the node it's searched by a value
     * @param valueToDelete the value to be deleted
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * Returns a reference to the next node
     * @param currentNode the node
     * @return the next nod
     */
    public Node getNode(Node currentNode) {
        return currentNode.nextNode;
    }

}