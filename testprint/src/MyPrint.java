import java.util.Arrays;

import javax.naming.ldap.SortControl;
import javax.swing.text.AbstractDocument.LeafElement;

public class MyPrint {
//	int[] number = new int[] { 8, 3, 0, 4, 6, 9, 2, 5, 1, 7 };
//	public static void main(String[] args) {
//
//		MyPrint myPrint = new MyPrint();
//		myPrint.printNumber(2);
//		int[] number = new int[] { 8, 3, 0, 4, 6, 9, 2, 5, 1, 7 };
//		// number = myPrint.sort(number);
//		myPrint.threadsort(number,0, number.length-1);
//		for (int i = 0; i < number.length; i++) {
//			System.err.println(number[i]);
//		}
//
//	}

	public void printNumber(int n) {
		if (n < 0) {
			return;
		}
		char[] inputchar = new char[n];

		printOrder(inputchar, n, 0);
	}

	public void printOrder(char[] input, int n, int loc) {

		if (input.length == loc) {
			return;
		}
		for (int i = 0; i <= 9; i++) {
			input[loc] = (char) ('0' + i);
			if (loc == n - 1) {
				print(input);
			}
			printOrder(input, n, loc + 1);
		}
	}

	public void print(char[] input) {
		int j = 0;
		int n = input.length;
		while (j < n && input[j] == '0') {
			j++;
		}
		if (j == n) {
			return;
		} else {
			char[] printNum = Arrays.copyOfRange(input, j, n);
			System.out.println(printNum);
		}
	}

	public int[] sort(int[] number) {
		if (number != null && number.length > 0) {
			int temp;
			boolean flag = false;
			int count = number.length;
			for (int i = 0; i < count - 1; i++) {
				flag = true;
				for (int j = 0; j < count - i - 1; j++) {
					if (number[j] > number[j + 1]) {
						temp = number[j];
						number[j] = number[j + 1];
						number[j + 1] = temp;
						flag = false;
					}
				}
				if (flag) {
					break;
				}
			}
			return number;
		} else {
			return null;
		}
	}

	// 快速排序算法
	public void quickSort(int[] number, int low, int height) {
		int start = low;
		int end = height;
		int key = number[0];

		// 从后往前比较
		while (end > start) {
			while (end > start && number[end] >= key) {
				end--;
			}
			if (number[end] <= key) {
				int temp = number[end];
				number[end] = number[start];
				number[start] = temp;
			}
			// 从前往后比较
			while (end > start && number[start] <= key) {
				start++;
			}
			if (number[start] >= key) {
				int temp = number[start];
				number[start] = number[end];
				number[end] = temp;
			}
		}
		if (start > low) {
			quickSort(number, low, start - 1);
		}
		if (end > height) {
			quickSort(number, end + 1, height);
		}

	}

	public void sort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];

		while (end > start) {
			// 从后往前比较
			while (end > start && a[end] >= key)
				// 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
				end--;
			if (a[end] <= key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			// 从前往后比较
			while (end > start && a[start] <= key)
				// 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
				start++;
			if (a[start] >= key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
		}
		// 递归
		if (start > low)
			sort(a, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
		if (end < high)
			sort(a, end + 1, high);// 右边序列。从关键值索引+1到最后一个
	}

	public void SecondQuickSort(int[] number,int left, int right) {
		int i, j, t, temp;
		if (left > right) {
			return;
		}
		temp = number[left];
		i = left;
		j = right;
		while (i != j) {

			while (number[j] >= temp && i < j) {
				j--;
			}
			while (number[j] <= temp && i < j) {
				i++;
			}

			if (i==j) {
				t=number[i];
				number[i]=number[j];
				number[j]=t;
				}
		}
		
		number[left]=number[i];
		number[i]=temp;
		SecondQuickSort(number,left, i-1);
		SecondQuickSort(number,i+1, right);

	}
	 public static void threadsort(int a[], int low, int hight) {
	        int i, j, index;
	        if (low > hight) {
	            return;
	        }
	        i = low;
	        j = hight;
	        index = a[i]; // 用子表的第一个记录做基准
	        while (i < j) { // 从表的两端交替向中间扫描
	            while (i < j && a[j] >= index)
	                j--;
	            if (i < j)
	                a[i++] = a[j];// 用比基准小的记录替换低位记录
	            while (i < j && a[i] < index)
	                i++;
	            if (i < j) // 用比基准大的记录替换高位记录
	                a[j--] = a[i];
	        }
	        a[i] = index;// 将基准数值替换回 a[i]
	        threadsort(a, low, i - 1); // 对低子表进行递归排序
	        threadsort(a, i + 1, hight); // 对高子表进行递归排序

	    }
}
