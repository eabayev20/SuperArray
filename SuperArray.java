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
    int j = 0;
    String end = "";
    end = end + "[";
    if (size == 0) {
      return "[]";

    }
    else {
    for (int i = 0; i < size -  1; i++) {
      end = end + data[i] + ", ";
      j = i;
    }

    end = end + data[j+1] + "]";
    return end;
  }
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
    newdata = new String [size];
    size = 0;
    data = newdata;
  }
  public void add(int index, String element){
    for(int i = size; i > index;i--){
      data[i] = data[i-1];
    }
    data[index] = element;
    size++;
  }
  public String remove (int index) {
    String value = "";
    String [] newdata;
    newdata = new String [size - 1];
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
    newdata = new String[size];
    for (int i = 0; i < size; i++) {
      newdata[i] = data[i];
    }
    data = newdata;
    return data;
  }
  public static void removeDuplicates(SuperArray s) {
    for (int i = 0; i < s.size();) {
      if (s.indexOf(s.get(i)) != i) {
        s.remove(i);
      }
      else {
        i = i + 1;
      }
    }
  }
  public static SuperArray findOverlap(SuperArray a, SuperArray b) {
    SuperArray c = new SuperArray();
    for (int i = 0; i < a.size();i++) {
      if (a.indexOf(a.get(i)) != -1 && b.indexOf(a.get(i)) != -1) {
        c.add(a.get(i));

      }
      else {

      }
    }
    removeDuplicates(c);
    return c;
  }
  public int lastIndexOf(String value) {
    int j = 0;
    for (int i = 0; i < size; i++) {
      if (data[i].equals(value)) {
        j = i;
      }
    }
    return j;
  }
  public boolean equals(SuperArray other) {
    if (other.size()!= size) {
      return false;
    }
    else {
      for (int i = 0; i < size; i++) {
        if (other.get(i).equals(data[i])) {

        }
        else {
          return false;
        }
      }
    }
    return true;
  }


}
