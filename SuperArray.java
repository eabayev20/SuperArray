public class SuperArray {
  private String [] data;
  private int size;
  public SuperArray(){
    data = new String[10];
    size = 0;
  }
  public SuperArray (int InitialCapacity) {
    data = new String[InitialCapacity];
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
    data2 = new String [data.length * 2];
    for (int i = 0; i < data.length; i++) {
      data2[i] = data[i];
    }
    data = data2;
  }
  public boolean isEmpty() {
    return size == 0;
  }
  public String toString() {
    String end = "";
    end = end + "[";
    for (int i = 0; i < size; i++) {
      end = end + data[i] + ", ";

    }
    end = end + "]";
    return end;
  }
  public boolean contains(String s) {
    for (int i = 0; i < size; i++) {

      if (data[i].equals(s)) {
        return true;
      }

    }
    return false;
  }
  public void clear() {
    String [] newdata;
    newdata = new String [data.length];
    size = 0;
    data = newdata;
  }
  public void add (int index, String element) {
    String [] newdata;
    newdata = new String [data.length + 1];
    int j = 0;
    for (int i = 0; i < size; i++) {
      if (i == index) {
        j = j + 1;
        newdata[i] = element;
      }
      else {
      newdata[i + j] = data[i];
    }
    }
    size = size + 1;
    data = newdata;
  }
  public String remove (int index) {
    String value = "";
    String [] newdata;
    newdata = new String [data.length - 1];
    int j = 0;
    for (int i = 0; i < size; i++) {
      if (i == index) {
        j = j - 1;
        value = data[i];
      }
      else {
      newdata[i + j] = data[i];
    }
    }
    size = size - 1;
    data = newdata;
    return value;
  }
  public int indexOf(String s) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(s)) {
        return i;
      }
    }
    return -1;
  }
  public String[] toArray() {
    String [] newdata;
    newdata = new String[data.length-1];
    for (int i = 0; i < size; i++) {
      newdata[i] = data[i];
    }
    data = newdata;
    return data;
  }


}
