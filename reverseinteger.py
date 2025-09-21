class Solution:
    def reverse(self, x: int) -> int:
        INT_MIN, INT_MAX = -2*31, 2*31 - 1
        sign = 1 if x >= 0 else -1
        x_abs = abs(x)
        rev = 0
        while x_abs:
            rev = rev * 10 + (x_abs % 10)
            x_abs //= 10
        rev *= sign
        if rev < INT_MIN or rev > INT_MAX:
            return 0
        return revs