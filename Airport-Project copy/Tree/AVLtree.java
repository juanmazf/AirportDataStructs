package Tree;


import Objects.*;


public class AVLtree {
    class Node{
        int balanced;
        int height;
        Passenger person;
        Node left, right;

        public Node(Passenger person){
            this.person = person;
        }
    }

    Node root;
    private int nodeCount = 0;

    // returns the height of the tree
    public int height(){
        if(root == null){
            return 0;
        }else{
            return root.height;
        }
    }
    // returns the number of nodes in the tree
    public int size(){
        return nodeCount;
    }
    // checks if the tree is empty
    public boolean isEmpty(){
        return size() == 0;
    }
    //adds a passenger into the tree
    public boolean add(Passenger person){
        if(person == null){
            return false;
        }else if(!findHelper(root,person)){
            root = addHelper(root,person);
            nodeCount++;
            return true;
        }
        return false;
    }
    // the remove method removes a passenger from the tree
    public boolean remove(Passenger person){
        if(person == null){
            return false;
        }

        if(findHelper(root, person)){
            System.out.println("REMOVED\n");
            root = removeHelper(root, person);
            nodeCount--;
            return true;
        }else{
            System.out.println("Passenger not found");
            return false;
        }
    }
    //checks if a specific passenger is in the tree
    public boolean find(Passenger p){
        return findHelper(root, p);
    }
    // returns the passenger
    public Passenger getPassenger(String identifier) {
            return getPassengerHelper(root, identifier);
        }
    //helper method for find
    private boolean findHelper(Node node, Passenger person){
        if(node == null){
            return false;
        }
        int compare = person.compareTo(node.person);

        if(compare < 0){
            return findHelper(node.left, person);
        }else if(compare > 0){
            return findHelper(node.right, person);
        }else{
            System.out.println(node.person.toString());
        return true;
        }
    }
    //helper method for insert
    private Node addHelper(Node node, Passenger person){
        if(node == null){
            return new Node(person);
        }

        int compare = person.compareTo(node.person);

        if(compare < 0){
            node.left = addHelper(node.left, person);
        }else{
            node.right = addHelper(node.right, person);
        }

        update(node);

        return balance(node);
    }
    // update method updates the height and the balance factor of the nodes in the tree
    private void update(Node node){
        int leftHeigh, rightHeight;

        if(node.left == null) {
            leftHeigh = -1;
        }else{
            leftHeigh = node.left.height;
        }
        if(node.right == null) {
            rightHeight = -1;
        }else{
            rightHeight = node.right.height;
        }

        node.height = 1 + Math.max(leftHeigh, rightHeight);

        node.balanced = rightHeight - leftHeigh;
    }
    // the balance method is responsible for balancing the tree at the given node
    private Node balance(Node node){
        if(node.balanced == -2){
            if(node.left.balanced <= 0){
                return leftCase(node);
            }else{
                return leftRightCase(node);
            }
        }else if(node.balanced == 2){
            if(node.right.balanced >= 0){
                return rightCase(node);
            }else{
                return rightLeftCase(node);
            }
        }
        return node;
    }
    // balances the tree for leftleft cases
    private Node leftCase(Node node){
        return rightRotate(node);
    }
    // balances the tree for leftright cases
    private Node leftRightCase(Node node){
        node.left = leftRotate(node.left);
        return leftCase(node);
    }
    // balances the tree for rightright cases
    private Node rightCase(Node node){
        return leftRotate(node);
    }
    // balances the tree for rightleft cases
    private Node rightLeftCase(Node node){
        node.right = rightRotate(node.right);
        return rightCase(node);
    }
    // left rotates the tree
    private Node leftRotate(Node node){
        Node newP = node.right;
        node.right = newP.left;
        newP.left = node;
        update(node);
        update(newP);
        return newP;
    }
    // right rotates the tree
    private Node rightRotate(Node node){
        Node newP = node.left;
        node.left = newP.right;
        newP.right = node;
        update(node);
        update(newP);
        return newP;
    }
    // helper method for remove 
    private Node removeHelper(Node node, Passenger person) {

        if(node == null){
            return null;
        }

        int compare = person.compareTo(node.person);

        if(compare < 0){
          node.left = removeHelper(node.left, person);
        }else if(compare > 0){
          node.right = removeHelper(node.right, person);
        }else{
          if (node.left == null){
            return node.right;
          }else if(node.right == null){
            return node.left;
          }else{
            if(node.left.height > node.right.height){
              Passenger successorperson = findMax(node.left);
              node.person = successorperson;
              node.left = removeHelper(node.left, successorperson);
            }else{
              Passenger successorperson = findMin(node.right);
              node.person = successorperson;
              node.right = removeHelper(node.right, successorperson);
            }
          }
        }

        update(node);
        return balance(node);
    
      }  
    // get Passenger helper method
    private Passenger getPassengerHelper(Node node, String identifier) {
        if (node == null) {
            return null;
        }
        int compare = identifier.compareTo(node.person.getName());
        if (compare == 0 || identifier.equals(node.person.getPassport())) {
            return node.person;
        } else if (compare < 0) {
            return getPassengerHelper(node.left, identifier);
        } else {
            return getPassengerHelper(node.right, identifier);
        }
    }
    // findMin finds the leftmost node in the tree
    private Passenger findMin(Node node) {
        while(node.left != null) 
          node = node.left;
        return node.person;
      }
    // findMax finds the rightmost node in the tree
    private Passenger findMax(Node node) {
        while(node.right != null) 
          node = node.right;
        return node.person;
      }
      // print tree prints all the nodes in the tree
    public void printTree(){
        print(root);
    }
      // print is the helper method for printTree
    private void print( Node node )
        {
            if( node != null )
            {
                print( node.left );
                System.out.println( node.person );
                print( node.right );
            }
        }


}
