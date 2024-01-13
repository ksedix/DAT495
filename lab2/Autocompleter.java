import java.util.Arrays;

public class Autocompleter {
    private final Term[] dictionary;

    // Initializes the dictionary from the given array of terms.
    public Autocompleter(Term[] dictionary) {
        this.dictionary = dictionary;
        sortDictionary();
    }

    // Sorts the dictionary in *case-insensitive* lexicographic order.
    // Complexity: O(N log N) where N is the number of dictionary terms
    private void sortDictionary() {
        // TODO
        Arrays.sort(dictionary, Term.byLexicographicOrder);
    }

    // Returns the number of terms that start with the given prefix.
    // Precondition: the internal dictionary is in lexicographic order.
    // Complexity: O(log N) where N is the number of dictionary terms
    public int numberOfMatches(String prefix) {
        // TODO
        Term key = new Term(prefix, 0);
        int first = -1;
        int last = -1;
        int matches = 0;

        first = RangeBinarySearch.<Term>firstIndexOf(dictionary, key, Term.byPrefixOrder(key.getWord().length()));
        last = RangeBinarySearch.<Term>lastIndexOf(dictionary, key, Term.byPrefixOrder(key.getWord().length()));

        if ( first > -1 && last > -1) {
            //if (first == last )
              //  return 1;
           // else
                matches = (last + 1) - first;
        }

        return matches;
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Precondition: the internal dictionary is in lexicographic order.
    // Complexity: O(log N + M log M) where M is the number of matching terms
    public Term[] allMatches(String prefix) {
        // TODO
        Term key = new Term(prefix, 0);
        int first = -1;
        int last = -1;
        int size = 0;

        first = RangeBinarySearch.<Term>firstIndexOf(dictionary, key, Term.byPrefixOrder(key.getWord().length()));
        last = RangeBinarySearch.<Term>lastIndexOf(dictionary, key, Term.byPrefixOrder(key.getWord().length()));

        if ( first > -1 && last > -1) {
            //if (first == last )
              //  size = 1;
            //else
                size = (last + 1) - first;

            Term[] terms = new Term[size];
            int index = 0;
            for (int i = first; i <= last; i++){
                terms[index] = dictionary[i];
                index++;
            }

            Arrays.sort(terms, Term.byReverseWeightOrder);
            return terms;
        }

        else
            return new Term[0];
    }

}
