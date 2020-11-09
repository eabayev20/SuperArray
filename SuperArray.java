public class SuperArray {
  private String [] data;
  private int size;
  public SuperArray(){
    data = new String[10];
    size = 0;
  }
  public SuperArray (int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("InitialCapacity" + initialCapacity + "cannot be negative" );

    }
    data = new String[initialCapacity];
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
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index" + index + "is unfortunatley out of bounds!");
    }
    else {
    return data[index];
  }
  }
  public String set (int index, String element) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index" + index + "is unfortunatley out of bounds!");
    }
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
  public String toString(){
    if (size==0) {
      return "[]";
    }
    String result="[";
    for (int i=0; i<size-1;i++){
      if (data[i] != null) {
      result += data[i] + ", ";
    }
    }
    if (data[size-1] != null) {
    result += data[size-1];
  }
    return result + "]";
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
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index" + index + "is unfortunatley out of bounds!");
    }
    for(int i = size; i > index;i--){
      data[i] = data[i-1];
    }
    data[index] = element;
    size++;
  }
  public String remove (int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index" + index + "is unfortunatley out of bounds!");
    }
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
  public String[] toArray(){
    String[] newdata = new String[size];
    for(int i = 0; i < size; i ++){
      newdata[i]=data[i];
    }
    return newdata;
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
  public static SuperArray zip(SuperArray a, SuperArray b) {

    int a1 = 0;
    int b1 = 0;
    SuperArray c = new SuperArray();
    if (a.size()==b.size()) {
      for (int i = 0; i < a.size(); i++) {
        c.add(a.get(i));
        c.add(b.get(i));
      }
    }
    else if (a.size()>b.size()) {
      for (a1 = 0; a1 < b.size(); a1++){
        c.add(a.get(a1));
        c.add(b.get(a1));
      }
      for (int i = a1; a1 < a.size(); a1++) {
        c.add(a.get(a1));
      }
    }
    else {
      for (b1 = 0; b1 < a.size(); b1++){
        c.add(a.get(b1));
        c.add(b.get(b1));
      }
      for (int i = b1; b1 < b.size(); b1++) {
        c.add(b.get(b1));
      }
    }
    return c;
  }




}
