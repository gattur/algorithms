package sort;

public class Sorter {

// Bubble sort
	int a[] = { 2, 3, 9, 8, 7, 6, 4 };
	int arr[] = { 2, 3, 9, 8, 7, 6, 4 };
	int len = a.length;

	LNode head;

	void bubleSort() {
		if (len == 0)
			return;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}

	void selectionSort() {
		if (len == 0)
			return;

		for (int i = 0; i < len; i++) {
			// int min=a[i];
			int pos = i;
			for (int j = i; j < len; j++) {
				if (a[j] < a[pos]) {
					// min=a[j];
					pos = j;
				}
			}
			swap(pos, i);
		}
	}

	void insertionSort() {
		if (len == 0)
			return;
		for (int i = 1; i < len; i++) {
			int j = i - 1;
			int temp = a[i];
			while (j >= 0 && temp < a[j]) {
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = temp;

		}
	}

	void quickSort() {
		quickSort(a, 0, len - 1);
	}

	void quickSort(int[] arr, int min, int max) {
		if (min >= max)
			return;

		int pivoit = seper(a, min, max);
		quickSort(arr, min, pivoit - 1);
		quickSort(arr, pivoit + 1, max);
	}

	int seper(int[] ar, int min, int max) {
		int pindex = max;
		int left = min;
		int right = max;
		while (left < right) {
			while (a[left] < ar[pindex]) {
				left = left + 1;
			}
			while (ar[right] > ar[pindex]) {
				right = right - 1;

			}
			if (left < right) {
				swap(ar, left, right);
			}
		}
		if (pindex != right)
			swap(ar, pindex, right);

		return right;
	}

	void mergeSort() {
		mergeSort(0, len - 1, new int[len]);
	}

	void mergeSort(int low, int high, int[] tmp) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		mergeSort(low, mid, tmp);
		mergeSort(mid + 1, high, tmp);
		merge(low, mid, high, tmp);
	}

	void merge(int low, int mid, int high, int[] tmp) {
		int i = low;
		int j = mid + 1;
		int pointer = i;
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				tmp[pointer] = arr[i];
				i = i + 1;
				pointer = pointer + 1;
			} else {
				tmp[pointer] = arr[j];
				j = j + 1;
				pointer = pointer + 1;
			}
		}
		while (i <= mid) {
			tmp[pointer] = arr[i];
			i = i + 1;
			pointer = pointer + 1;
		}
		while (j <= high) {
			tmp[pointer] = arr[j];
			j = j + 1;
			pointer = pointer + 1;
		}
		for (int k = low; k <= high; k++) {
			arr[k] = tmp[k];
		}
	}

	void qkSort() {
		qkSort(0, len - 1);
	}

	void qkSort(int min, int max) {
		if (min >= max)
			return;
		int pivoit = sepr(min, max);
		qkSort(min, pivoit - 1);
		qkSort(pivoit + 1, max);
	}

	int sepr(int min, int max) {

		int piv = max;
		max = max - 1;
		while (min < piv) {

			while (a[min] < a[piv])
				min = min + 1;
			while (a[max] > a[piv])
				max = max + 1;
			if (min < max)
				swap(a, min, max);
		}
		// System.out.println(min+" "+piv);
		if (min != piv)
			swap(a, min, piv);
		return min;
	}

	void mergeSo() {
		mergeSo(0, len - 1);
	}

	void mergeSo(int min, int max) {
		if (min >= max)
			return;
		int mid = (min + max) / 2;
		mergeSo(min, mid);
		mergeSo(mid + 1, max);

		sumUp(min, mid, max, new int[len]);
	}

	void sumUp(int min, int mid, int max, int[] temp) {
		int t = min;
		int m = min;
		int maxum = mid + 1;
		while (min <= mid && maxum <= max) {
			if (a[min] > a[maxum]) {
				temp[t] = a[maxum];
				maxum = maxum + 1;
				t = t + 1;
			} else {
				temp[t] = a[min];
				min = min + 1;
				t = t + 1;
			}
		}
		while (min <= mid) {
			temp[t] = a[min];
			min = min + 1;
			t = t + 1;
		}
		while (maxum <= max) {
			temp[t] = a[maxum];
			maxum = maxum + 1;
			t = t + 1;
		}
		while (m <= max) {
			a[m] = temp[m];
			m = m + 1;
		}

	}
	// merge sort using nodes

	LNode getMid(LNode prev, LNode head) {
		while (head.getNext() != null && head.getNext().getNext() != null) {
			head = head.getNext().getNext();
			prev = prev.getNext();
		}
		return prev;
	}

	LNode mergeSorter() {

		return mergeSorter(head);
	}

	LNode mergeSorter(LNode head) {
		if (head == null || head.getNext() == null)
			return head;
		// System.out.println("head "+head.getData());
		LNode mid = getMid(head, head);
		// System.out.println("mid "+mid.getData());
		LNode shead = mid.getNext();
		mid.setNext(null);
		LNode lhead = mergeSorter(head);
		System.out.println("lhead " + lhead.getData());
		LNode rhead = mergeSorter(shead);
		System.out.println("rhead " + rhead.getData());
		return merger(lhead, rhead);
	}

	LNode merger(LNode lhead, LNode rhead) {
		if (lhead == null && rhead == null)
			return null;
		LNode hea = null;
		LNode another = null;
		while (lhead != null && rhead != null) {
			if (lhead.getData() < rhead.getData()) {
				if (hea == null) {
					hea = lhead;
					another = lhead;
					lhead = lhead.getNext();
					// hea.setNext(null);
				} else {
					hea.setNext(lhead);
					lhead = lhead.getNext();
					hea = hea.getNext();
					// hea.setNext(null);
				}
			} else {
				if (hea == null) {
					hea = rhead;
					another = rhead;
					rhead = rhead.getNext();
					// hea.setNext(null);
				} else {
					hea.setNext(rhead);
					rhead = rhead.getNext();
					hea = hea.getNext();
					// hea.setNext(null);
				}
			}
		}
		if (lhead == null)
			hea.setNext(rhead);
		if (rhead == null)
			hea.setNext(lhead);
		if (hea.getData() == 5)
			System.out.println("return " + hea.getNext().getData());
		return another;
	}

	void print() {
		for (int i = 0; i < len; i++) {
			System.out.println(a[i]);
		}
	}

	void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
