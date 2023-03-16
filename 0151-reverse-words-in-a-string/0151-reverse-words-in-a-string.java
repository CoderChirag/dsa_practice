class Solution {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" ")).filter(word -> !word.isEmpty()).reduce((a, b) -> b + " " + a).orElse("");
    }
}