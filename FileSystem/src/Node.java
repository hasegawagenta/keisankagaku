

abstract class Node {
	String updated_time;
    int size;
    String name;
    String path = null;
    int slave_size = 0;
    boolean is_dir = false;
    Node master = null;
    protected abstract void print();
    protected abstract int size();
//    protected abstract void delete(Node node);
}

