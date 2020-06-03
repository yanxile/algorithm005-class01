class LeetCode_64_0082 {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0) return 0;
		for (int i = 0; i < grid.length; i ++) {
			for (int j = 0; j < grid[0].length; j ++) {
				if (i < 1 && j < 1) {
					grid[i][j] = grid[i][j];
				} else if (i < 1) {
					grid[i][j] = grid[i][j - 1] + grid[i][j];
				} else if (j < 1) {
					grid[i][j] = grid[i - 1][j] + grid[i][j];
				} else {
					grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
				}
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}
}