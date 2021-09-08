package leetcode;

public class JumpGame {
	public static void main(String[] args) {
		JumpGame game = new JumpGame();
		System.out.println(game.canJump(new int[] { 2, 3, 1, 1, 4 }));
	}

	class Interval {
		int begin;
		int end;

		public Interval(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}
	}

	public boolean canJump(int[] nums) {
		int len = nums.length;
		if (len <= 1)
			return true;
		Interval interval = new Interval(0, 0);
		while (true) {
			int canReach = -1;
			for (int i = interval.begin; i <= interval.end; i++) {
				canReach = Math.max(canReach, i + nums[i]);
			}
			if (canReach >= len - 1)
				return true;
			interval = new Interval(interval.end + 1, canReach);
			if (interval.begin > interval.end)
				return false;
		}
	}
}
