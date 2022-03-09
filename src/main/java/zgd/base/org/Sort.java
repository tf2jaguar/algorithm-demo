package zgd.base.org;

/**
 * @author zhangguodong
 * @since 2021/12/29 14:24
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 5, 3, 3, 6, 2};
        Sort sort = new Sort();
        printArr(arr);
//        sort.bubbling(arr);
//        sort.insert(arr);
//        sort.select(arr);
//        sort.merge(arr);
//        sort.quick(arr);
        sort.bucket(arr);
        printArr(arr);

    }

    public static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     * 原地排序算法
     * 稳定的排序算法
     * 最好时间复杂度O(n)
     * 最坏时间复杂度O(n^2)
     * 平均时间复杂度O(n^2)
     */
    public void bubbling(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     * 原地排序算法
     * 稳定的排序算法
     * 最好时间复杂度O(n)
     * 最坏时间复杂度O(n^2)
     * 平均时间复杂度O(n^2)
     */
    public void insert(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 选择排序
     * 原地排序算法
     * 非稳定的排序算法
     * 最好时间复杂度O(n^2)
     * 最坏时间复杂度O(n^2)
     * 平均时间复杂度O(n^2)
     */
    public void select(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            swap(arr, i, minIdx);
        }
    }

//======================================================================================================================

    /**
     * 归并排序
     * 非原地排序算法
     * 稳定的排序算法
     * 最好时间复杂度O(nlogn)
     * 最坏时间复杂度O(nlogn)
     * 平均时间复杂度O(nlogn)
     */
    public void merge(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l == r) return;
        int mid = l + ((r - l) >> 1);

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int left = l, right = mid + 1, i = 0;

        while (left <= mid && right <= r)
            help[i++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        while (left <= mid)
            help[i++] = arr[left++];
        while (right <= r)
            help[i++] = arr[right++];
        //将help数组拷贝到arr数组中
        System.arraycopy(help, 0, arr, l, help.length);
    }

    /**
     * 快速排序
     * 原地排序算法
     * 非稳定的排序算法
     * 最好时间复杂度O(nlogn)
     * 最坏时间复杂度O(n^2)
     * 平均时间复杂度O(nlogn)
     */
    public void quick(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        // 找出随机数字比较
        int randomIdx = (int) (l + Math.random() * (r - l + 1));
        swap(arr, r, randomIdx);

        int[] p = partition(arr, l, r);
        quickSort(arr, l, p[0]);
        quickSort(arr, p[1], r);
    }

    private int[] partition(int[] arr, int l, int r) {
        int less = l - 1, more = r;
        while (l < more) {
            if (arr[l] < arr[r]) swap(arr, ++less, l++);
            else if (arr[l] > arr[r]) swap(arr, --more, l);
            else l++;
        }
        swap(arr, more, r);
        return new int[]{less, more};
    }

//======================================================================================================================

    /**
     * 桶排序
     * 非原地排序算法
     * 稳定的排序算法
     * 最好时间复杂度O(n)
     * 最坏时间复杂度O(n)
     * 平均时间复杂度O(n)
     */
    public void bucket(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            max = Math.max(max, a);
        }
        int[] bucket = new int[max + 1];
        for (int a : arr) {
            bucket[a]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
