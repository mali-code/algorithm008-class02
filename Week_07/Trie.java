package week7;

class Trie {
    class Node{
        Node next[] = new Node[26];
        boolean end ;
        int cnt;
    }

    Node root  = new Node();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.cnt++;
        Node p = root;
        for(int i=0;i<word.length();i++){
            int k = word.charAt(i)-'a';
            if(p.next[k]==null){
                p.next[k] = new Node();
            }
            p= p.next[k];
            p.cnt++;

        }
        p.end = true;


    }

    /** Returns if the word is in the trie. */
    public boolean search(String s) {
        Node p = root;
        for(int i=0;i<s.length();i++){
            int k = s.charAt(i) - 'a';
            if(p.next[k]==null) return false;
            p = p.next[k];
        }
        return p.end;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p = root;
        for(int i=0;i<prefix.length();i++){
            int k = prefix.charAt(i) - 'a';
            if(p.next[k]==null) return false;
            p = p.next[k];
        }
        return p.cnt>0 ? true : false;

    }
}