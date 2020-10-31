public class SuperArray {
  private String [] data;
  private int size;
  public SuperArray() {
    data = new String [10];
  }
  public int size() {
    return data.length;
  }
  public boolean add(String element) {
    int pos = size();
    data[pos] = element;
    return true;
  }



}
