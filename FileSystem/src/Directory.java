import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Directory extends Node{
    ArrayList<Node>slaves = new ArrayList<>(); 
    
    Directory(String dirName){
        name = dirName;
        is_dir = true;
    }
    
    public String get_now_time() {
    	// 現在日時を取得
		LocalDateTime date1 = LocalDateTime.now();

		// 表示形式を指定
		DateTimeFormatter dtformat = 
			DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
		
		String fdate1 = dtformat.format(date1); //表示形式+Stringに変換
		
		return fdate1;
    }
    
    public void delete(Node node) {
    	if(slaves.remove(node) != true) {
    		System.err.println("No such file or directory!");
    	}
    }
    
    public void add(Node node){
        if(node.is_dir == true) {
            node.master = this;
        }
        slaves.add(node);
        slave_size += 1;
        this.updated_time = get_now_time();
    }
    
    public int size() {
        int whole_size = 0;
        Node slave;
        for(int i = 0; i < slaves.size(); i++) {
            slave = slaves.get(i);
            if(slave.is_dir == true) {
                whole_size += slave.size();
            }else if(slave.size != 0) {
                whole_size += slave.size;
            }
        }
        return whole_size;
    }
    
    public void print() {
        Node slave;
        System.out.println("/" + name + "("+size()+")");
        for(int i = 0; i < slaves.size(); i++) {
            if(master != null) {
                System.out.print("/" + master.name);
            }
            System.out.print("/" + name + ":" + updated_time);
            slave = slaves.get(i);
            slave.print();
        }
    }

}
