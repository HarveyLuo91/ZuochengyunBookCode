package Day0724;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 能否把一个正数数组分成4部分问题，每部分的累加和相等，分割点的值不算
public class Split4Parts {

	public static boolean canSplits1(int[] arr) {
		if (arr == null || arr.length < 7) {
			return false;
		}
		HashSet<String> set = new HashSet<String>();
		int allSum = 0;
		for (int i = 0; i < arr.length; i++) {
			allSum += arr[i];
		}
		int leftSum = arr[0];
		for (int i = 1; i < arr.length - 1; i++) {
			set.add(String.valueOf(leftSum) + "_" + String.valueOf(allSum - leftSum - arr[i]));
			leftSum += arr[i];
		}
		int l = 1;
		int lsum = arr[0];
		int r = arr.length - 2;
		int rsum = arr[arr.length - 1];
		while (l < r - 3) {
			if (lsum == rsum) {
				String lkey = String.valueOf(lsum * 2 + arr[l]);
				String rkey = String.valueOf(rsum * 2 + arr[r]);
				if (set.contains(lkey + "_" + rkey)) {
					return true;
				}
				lsum += arr[l++];
			} else if (lsum < rsum) {
				lsum += arr[l++];
			} else {
				rsum += arr[r--];
			}
		}
		return false;
	}

	public static boolean canSplits2(int[] arr) {
		if (arr == null || arr.length < 7) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			map.put(sum, i);
			sum += arr[i];
		}
		int lsum = arr[0];
		for (int s1 = 1; s1 < arr.length - 5; s1++) {
			int checkSum = lsum * 2 + arr[s1];
			if (map.containsKey(checkSum)) {
				int s2 = map.get(checkSum);
				checkSum += lsum + arr[s2];
				if (map.containsKey(checkSum)) {
					int s3 = map.get(checkSum);
					if (checkSum + arr[s3] + lsum == sum) {
						return true;
					}
				}
			}
			lsum += arr[s1];
		}
		return false;
	}
	public static void canSplit3(int[] input){
		int[] sums = new int[input.length];
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

		int tmp = 0;
		for (int i = 0; i < input.length; ++i) {
			tmp += input[i];
			sums[i] = tmp;
			hashMap.put(tmp, i);
		}

		for (int pos1 = 1; pos1 < input.length; ++pos1) {
			int sum = sums[pos1] - input[pos1];
			if (hashMap.containsKey(sum + sums[pos1])) {
				int pos2 = hashMap.get(sum + sums[pos1]) + 1;
				if (pos2 < input.length && hashMap.containsKey(sum + sums[pos2])) {
					int pos3 = hashMap.get(sum + sums[pos2]) + 1;
					if (pos3 < input.length && sums[sums.length - 1] - sums[pos3] == sum) {
						System.out.println("result:"+pos1 + "---"+pos2+"----"+pos3);
						return;
					}
				}
			}
		}
		return;

	}

	public static int[] generateRondomArray() {
		int[] res = new int[(int) (Math.random() * 10) + 7];
		for (int i = 0; i < res.length; i++) {
			res[i] = (int) (Math.random() * 10) + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		int testTime = 3000000;
		boolean hasErr = false;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRondomArray();
			if (canSplits1(arr) ^ canSplits2(arr)) {
				hasErr = true;
				break;
			}
		}
		if (hasErr) {
			System.out.println("233333");
		} else {
			System.out.println("666666");
		}

	}
}
