class Solution:

    def shortestPalindrome(self, s: str) -> str:
        if not s:
            return ""

        rev_s = s[::-1]
        temp = s + "#" + rev_s
        n = len(temp)
        lps = [0] * n
        length = 0
        i = 1

        while i < n:
            if temp[i] == temp[length]:
                length += 1
                lps[i] = length
                i += 1
            else:
                if length != 0:
                    length = lps[length - 1]
                else:
                    lps[i] = 0
                    i += 1

        longest_palindromic_prefix_len = lps[-1]
        suffix_to_add = s[longest_palindromic_prefix_len:]

        return suffix_to_add[::-1] + s