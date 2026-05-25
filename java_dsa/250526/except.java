public class except {
	public static int max(int[] arr) {
		int i = 0, j = arr.length - 1;
		int m = arr[0];
		while (i <= j) {
			if (arr[i] > m) m = arr[i];
			if (arr[j] > m) m = arr[j];
			i++;
			j--;
		}
		return m;
	}

	public static void main(String[] args) {
		int[] a = {};
		
		try {
			System.out.println("Max of a: " + max(a));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
}
}
