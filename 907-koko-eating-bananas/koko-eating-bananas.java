class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                right = mid; // shrink right boundary
            } else {
                left = mid + 1; // need faster speed
            }
        }
        return left; // left == right is the minimum speed
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        long hours = 0; // use long to avoid overflow
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil division
            if (hours > h) return false; // early exit
        }
        return hours <= h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
