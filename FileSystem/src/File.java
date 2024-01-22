import java.util.ArrayList;

public class File extends Node{
    ArrayList<Node>slaves = new ArrayList<>(); 
    
    File(String fileName, int fileSize){
        name = fileName;
        size = fileSize;
    }
    public int size() {
        return size;
    }
    public void print() {
        System.out.println("/"+name+"("+size+")");
    }
}
