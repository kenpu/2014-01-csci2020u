package helpers;

class Utility {
  public static String[] slice(String[] array, int a, int b) throws Exception {
    String[] newarray = new String[b-a];
    if(! (a < array.length && b <= array.length)) {
        throw new Exception("out of bound:" + a + "," + b);
    }
    for(int i=a; i < b; i++) {
      newarray[i-a] = array[i];
    }

    return newarray;
  }

  public static String[] merge(String[] arr1, String[] arr2) {
    String[] result = new String[arr1.length + arr2.length];
    int p1 = 0;
    int p2 = 0;
    int q  = 0;
    while(p1 < arr1.length || p2 < arr2.length) {
      if(p1 < arr1.length && p2 < arr2.length) {
        int compare = arr1[p1].compareTo(arr2[p2]);
        if(compare <= 0) {
          result[q] = arr1[p1];
          p1 ++; q ++;
        } else if(compare > 0) {
          result[q] = arr2[p2];
          p2 ++; q ++;
        }
      } else {
        if(p1 == arr1.length) {
          Utility.copy(arr2, p2, arr2.length, result, q);
        } else {
          Utility.copy(arr1, p1, arr1.length, result, q);
        }
        break;
      }
    }
    return result;
  }

  /**
   * Copy elements from `src` array to `target` array.
   * Elements are taken from src[a] upto but not including src[b]
   * and placed into target[start]...
   */
  public static void copy(String[] src, int a, int b, 
                          String[] target, int start) {
    for(int i=0; i < b-a; i++) {
      target[start+i] = src[a+i];
    }
  }
}
