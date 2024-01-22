import java.util.ArrayList;

public class SymbolicLink extends Node{
    ArrayList<Node>slaves = new ArrayList<>(); 
    
    SymbolicLink(String pathName, String objName){
        path = pathName + "->";
        name = objName;
    }
    public int size() {
        return 0;
    }
    public void print() {
        System.out.print("/"+path);
        System.out.println(name);
    }
}
