class Min_3740 {
    public int minimumDistance(int[] nums) {
       Map<Integer, int[]> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{-1, -1});
            }

            int[] last = map.get(nums[i]);

            if (last[0] != -1 && last[1] != -1) {
                minDist = Math.min(minDist, 2 * (i - last[0]));
            }

            last[0] = last[1];
            last[1] = i;
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
