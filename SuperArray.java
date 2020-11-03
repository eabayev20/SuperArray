public class SuperArray {
  private String [] data;
  private int size;
  public SuperArray(){
    data = new String[10];
    size = 0;
  }
  public int size() {
    return size;
  }
  public boolean add(String element) {
    if (size >= data.length) {
      resize();
    }
    int pos = size;
    data[pos] = element;
    size ++;
    return true;
  }
  public String get(int index) {
    if (index >= size || index < 0) {
      return null;
    }
    else {
    return data[index];
  }
  }
  public String set (int index, String element) {
    String temp = "";
    if (index >= size || index < 0) {
      return null;
    }
    temp = data[index];
    data[index] = element;
    return temp;
  }
  private void resize(){
    String [] data2;
    data2 = new String [data.length + 10];
    for (int i = 0; i < data.length; i++) {
      data2[i] = data[i];
    }
    data = data2;
  }


}
