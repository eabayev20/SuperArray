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
    if (size() >= size) {
      resize();
    }
    int pos = size();
    data[pos] = element;
    return true;
  }
  public String get(int index) {
    return data[index];
  }
  public String set (int index, String element) {
    String temp = "";
    temp = data[index];
    data[index] = element;
    return temp;
  }
  private void resize(){
    String [] data2;
    data2 = new String [size + 10];
    data2 = data;
    data = data2;
  }


}
