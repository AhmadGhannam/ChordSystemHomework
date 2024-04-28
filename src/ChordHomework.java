import java.util.Arrays;
import java.util.Scanner;

public class ChordHomework {
    private static Node[] nodes;
    ChordHomework(int MAX_NODES){
        nodes = new Node[MAX_NODES];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i]=new Node(i,new int[]{},false);
        }
    }
    public static void searchData(int element){
        for (int i = 0; i < nodes.length; i++) {
            if(element<=nodes[i].getId()){
                if(nodes[i].getisActive()){
                    int res=binarySearch(nodes[i].getData(),0,nodes[i].getData().length-1,element,false);
                    if(res==-1){
                        System.out.println("the element isn't exist");
                        return;
                    }
                    else {
                        System.out.println("this element exists in node: "+i);
                        System.out.println("the index element in the array of this node is: "+res);
                        return;
                    }
                }
            }
        }
    }

    public static void deleteElement(int element){
        for (int i = 0; i < nodes.length; i++) {
            if(element<=nodes[i].getId()){
                if(nodes[i].getisActive()){
                    int res=binarySearch(nodes[i].getData(),0,nodes[i].getData().length-1,element,false);
                    if(res==-1){
                        System.out.println("the element isn't exist");
                        return;
                    }
                    else {
                        System.out.println("the elements in node "+ i + " before delete operation is:");
                        for (int j = 0; j < nodes[i].getData().length; j++) {
                            System.out.print(nodes[i].getData()[j]+" ");
                        }
                        System.out.println();
                        int indexToDelete = res;
                        for (int j = res; j <nodes[i].getData().length-1 ; j++) {
                            nodes[i].getData()[j]=nodes[i].getData()[j+1];
                        }
                        nodes[i].getData()[nodes[i].getData().length-1]=0;
                        int[] newArray = Arrays.copyOf(nodes[i].getData(), nodes[i].getData().length - 1);
                        nodes[i].setData(newArray);
                        System.out.println("the elements in node "+i+" after delete operation is: ");
                        for (int j = 0; j < nodes[i].getData().length; j++) {
                            System.out.print(nodes[i].getData()[j]+" ");
                        }
                        System.out.println();
                        return;
                    }
                }
            }
        }
    }


    public static void addData(int data){

        for (int i = 0; i < nodes.length; i++) {
            if(data<=nodes[i].getId()){
                if(nodes[i].getisActive()){
                    if (nodes[i].getData().length == 0) {
                        nodes[i].setData(new int[]{data}); // Create a new array with the element
                        return;
                    }
                    else if(nodes[i].getData().length == 1){
                        if(nodes[i].getData()[0]>data){
                            nodes[i].setData(new int[]{data,nodes[i].getData()[0]}); // Create a new array with the element
                            return;
                        }
                        else {
                            nodes[i].setData(new int[]{nodes[i].getData()[0],data}); // Create a new array with the element
                            return;
                        }
                    }
                    int index=binarySearch(nodes[i].getData(),0,nodes[i].getData().length-1,data,true);
                    int []arr=new int[nodes[i].getData().length+1];
                    for (int j = 0; j < nodes[i].getData().length; j++) {
                        arr[j]=nodes[i].getData()[j];
                    }
                    for (int j = arr.length - 1; j > index; j--) {
                        arr[j] = arr[j - 1];
                    }
                    System.out.println();
                    arr[index] = data;
                    nodes[i].setData(arr);
                    return;
                }
            }
        }
    }

    public static int binarySearch(int arr[], int l, int r, int x,boolean isAdded) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if(!isAdded)
        return -1;
        else return l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number of nodes");
        int maxNodes = scanner.nextInt();

        ChordHomework chordHomework=new ChordHomework(maxNodes);
        System.out.println("enter number of active nodes");
        int numberOfActiveNodes = scanner.nextInt();
//        System.out.println("");
        int []activeArray=new int[numberOfActiveNodes];
        for (int i = 0; i < numberOfActiveNodes; i++) {
            System.out.println("enter index of node you want to activate it ");
            activeArray[i]=scanner.nextInt();
            nodes[activeArray[i]].setActive(true);
        }
        System.out.println("the nodes active is:");
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i].getisActive()){
                System.out.println("node id active is: "+nodes[i].getId());
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("enter the number of elements you want to store it in nodes");
        int numOfElements= scanner.nextInt();
        for (int i = 0; i < numOfElements; i++) {
            System.out.println("enter number and will inserted in the appropriate node automatically");
            int num= scanner.nextInt();
            addData(num);
        }
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i].getisActive()){
                System.out.print("the elements in node "+i+" is: ");
                for (int j = 0; j < nodes[i].getData().length; j++) {
                    System.out.print(nodes[i].getData()[j]+" ");
                }
                System.out.println();
            }
        }
        System.out.println("enter the number of searching operations ");
        int numOfSearchingOperations= scanner.nextInt();
        for (int i = 0; i < numOfSearchingOperations; i++) {
            int query=scanner.nextInt();
            searchData(query);
        }
        System.out.println("enter the number of deleting operations ");
        int numOfDeletingOperations= scanner.nextInt();
        for (int i = 0; i < numOfDeletingOperations; i++) {
            int numYouWantToDelete=scanner.nextInt();
            deleteElement(numYouWantToDelete);
        }

    }


}
