class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TreeSet<String> set = new TreeSet<>();
        for(String str : dictionary) {
            set.add(str);
        }
        String arr[] = sentence.split(" ");
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            String s = arr[i];
            String curr = "";
            for(char c: s.toCharArray()) {
                curr += c;
                // System.out.println(curr);
                if(set.contains(curr)) {
                    arr[i] = curr;
                    break;
                }
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}