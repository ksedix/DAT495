
import java.util.Comparator;

public class RangeBinarySearch {

    // Returns the index of the *first* element in `a` that equals the search key,
    // according to the given comparator, or -1 if there is no matching element.
    // Precondition: `a` is sorted according to the given comparator.
    // Complexity: O(log N) comparisons where N is the length of `a`
    public static<T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {
        // TODO
        int lo = 0;
        int hi = a.length -1;
        int index = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (comparator.compare(a[mid], key) == 0) {
                index = mid;
                hi = mid - 1;
            }

            else if (comparator.compare(a[mid], key) < 0)
                lo = mid +1;

            else
                hi = mid -1;
        }

        return index;
    }

    // Returns the index of the *last* element in `a` that equals the search key,
    // according to the given comparator, or -1 if there are is matching element.
    // Precondition: `a` is sorted according to the given comparator.
    // Complexity: O(log N) comparisons where N is the length of `a`
    public static<T> int lastIndexOf(T[] a, T key, Comparator<T> comparator) {
        // TODO
        int lo = 0;
        int hi = a.length -1;
        int index = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (comparator.compare(a[mid], key) == 0) {
                index = mid;
                lo = mid + 1;
            }

            else if (comparator.compare(a[mid], key) < 0)
                lo = mid +1;

            else
                hi = mid -1;
        }

        return index;
    }


    // For testing purposes.
    public static void main(String[] args) {
        // Here you can write some tests if you want.

        /*
        Term t1 = new Term("abc", 0);
        Term t2 = new Term("ABCD", 1);
        Term t3 = new Term("ABCD", 1);
        Term t4 = new Term("ABCD", 1);
        Term t5 = new Term("abd", 2);
        Term[] arr = {t1, t2, t3, t4, t5};

        System.out.println(RangeBinarySearch.<Term>firstIndexOf(arr, t2, Term.byLexicographicOrder));
        System.out.println(RangeBinarySearch.<Term>lastIndexOf(arr, t2, Term.byLexicographicOrder));
        */

    }
}
