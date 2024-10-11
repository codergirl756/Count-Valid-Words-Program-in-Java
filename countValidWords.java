 class Solution {
        public int countValidWords(String sentence) {
            int count = 0;
            String[] potentialWords = sentence.trim().split("\\s+");
            for (String word : potentialWords) {
                boolean isWord = true;
                boolean hyphen = true;
                for (int i = 0; i < word.length(); ++i) {
                    char c = word.charAt(i);
                    if (Character.isDigit(c)) {
                        isWord = false;
                        break;
                    }
                    if (c == '-') {
                        if (!hyphen || i == 0 || i == word.length() - 1) {
                            isWord = false;
                            break;
                        }
                        if (!Character.isAlphabetic(word.charAt(i - 1)) || 
                            !Character.isAlphabetic(word.charAt(i + 1))) {
                            isWord = false;
                            break;
                        }
                        hyphen = false;
                        continue;
                    }
                    if (!Character.isLetter(c)) {
                        if (i < word.length() - 1) {
                            isWord = false;
                            break;
                        }
                    }
                }
                if (isWord) {
                    ++count;
                }
            }
            return count;
        }
    }

