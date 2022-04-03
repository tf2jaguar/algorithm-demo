package zgd.base.org;

/**
 * 手写堆的实现
 * <p>
 * 内部使用数组存储。数组内存具有连续性，访问速度较快。
 * i 结点的父结点 par = (i-1)/2
 * i 结点的左子结点 2 * i + 1
 * i 结点的右子结点 2 * i + 2
 *
 * @author ：guodongzhang
 * @date ：Created in 2021/8/10 16:31
 */
public class Heap {

    private int[] data = null;
    private int size = 0;

    public Heap(int[] data) {
        this.data = data;
    }

    /**
     * 下沉
     * <p>
     * 传入待处理的下标。通过寻找左右两个子节点中最大值，逐步下沉至 data[idx]
     */
    public void sink(int idx) {
        int tmp = data[idx];
        int j;
        // 找到左右两个子节点中较大的
        while ((j = (idx << 1) + 1) < size) {
            if (j + 1 < size && data[j] < data[j + 1]) {
                j++;
            }

            // 如果子节点比当前节点大，将子节点替换到idx的位置
            // 否则，找到了tmp值该沉降到的位置
            if (data[j] > tmp) {
                data[idx] = data[j];
                idx = j;
            } else {
                break;
            }
        }
        // 将tmp值，放到已更新好的idx位置
        data[idx] = tmp;
    }

    /**
     * 上浮
     * <p>
     * 传入待处理的下标。通过判断父节点和当前值的大小，逐步上浮至 data[idx]
     */
    public void swim(int idx) {
        int tmp = data[idx];
        int j;
        // 父节点最小为0
        while ((j = (idx - 1) >> 1) >= 0) {
            // 父节点比待上浮的值小，调整父节点值到idx位置
            // 否则，找到了上浮的最终位置
            if (data[j] < tmp) {
                data[idx] = data[j];
                idx = j;
            } else {
                break;
            }
        }
        // 将tmp值，放到已更新好的idx位置
        data[idx] = tmp;
    }

    /**
     * 压入。主要是上浮操作，所以时间复杂度为 O(lgN)
     * <p>
     * （1）往堆的尾巴 data[n] 上添加新来的元素
     * （2）新来元素 data[n] 进行上浮的操作
     */
    public void push(int val) {
        data[size++] = val;
        swim(size - 1);
    }

    /**
     * 弹出。主要是下沉操作，所以时间复杂度为 O(lgN)
     * <p>
     * （1）取出 data[0] 的值作为返回值
     * （2）然后将 data[n-1] 存放至 data[0]
     * （3）将 data[0] 进行下沉操作
     */
    public int pop() {
        int tmp = data[0];
        data[0] = data[--size];
        sink(0);
        return tmp;
    }

    /**
     * 当前堆大小
     */
    public int size() {
        return size;
    }

    public void status() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 7、8、9、10
        // 11、12、1、2、3、4、5、6、7
        Heap heap = new Heap(new int[5]);
        for (int i = 5; i < 10; i++) {
            heap.status();
            heap.push(i);
        }
        for (int i = 35; i >= 15; i -= 5) {
            int pop = heap.pop();
            System.out.println("pop " + pop);
            heap.push(i);
            heap.status();
        }

    }
}
