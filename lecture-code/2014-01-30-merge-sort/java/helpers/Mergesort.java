package helpers;

public class Mergesort {
  String[] array;
  public Mergesort(String[] array) {
    this.array = array;
  }

  public String[] sorted() {
    int n = this.array.length;
    if(n <= 1) {
        return this.array;
    }
    String[] firstHalf = Utility.slice(this.array, 0, n/2);
    String[] secondHalf = Utility.slice(this.array, n/2, n);
    return Utility.merge(
        new Mergesort(firstHalf).sorted(),
        new Mergesort(secondHalf).sorted());
  }
}
