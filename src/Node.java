import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    private int id;
    private boolean isActive;
    private int[] data; // Data stored in the node

    Node(int id,int[]data,boolean isActive) {
        this.id = id;
        this.data =data;
        this.isActive=isActive;
    }

    public boolean getisActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}