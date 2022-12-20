class Solution {
    
    public String reverse(String str, int start, int end){
        char arr[] = str.toCharArray();
        while(start < end){
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        return new String(arr);
    }
    
    public String reverseWords(String str) {
        return Arrays.stream(str.split(" "))
                     .map(String::trim)
                     .filter(word -> !word.isEmpty())
                     .reduce((word1, word2) -> word2 + " " + word1)
                     .orElse("");
    }
}