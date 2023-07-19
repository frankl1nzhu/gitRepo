import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        //声明数组，在内存中占一片连续空间，大小取决于数组元素类型和数组长度
        //索引从0开始，因为索引即是与首地址的偏移量（距离），第一个变量对应首地址
        double[] prices;

        //初始化，初始化后长度确定且不能更改
        //直接赋值：静态初始化
        prices = new double[]{1.1, 2.2, 3.3};
        //可以省略写法：
        double[] num = {1.1, 2.2, 3.3};

        //定义数组长度：动态初始化
        String[] products = new String[3];

        //数组调用
        System.out.println(num[0]);
        products[1] = "我";
        System.out.println(products[1]);

        //数组长度
        System.out.println(num.length);

        //数组遍历
        for (int i = 0;i < prices.length;i++){
            System.out.println(prices[i]);
        }

        //数组默认初始化值：
        //整型，char --> 0
        //浮点型 --> 0.0
        //boolean --> false
        //引用数据类型（如string） --> null

        /*一维数组内存解析
         * 栈(stack)中存放数组类型和对应首地址
         * 堆中在首地址开始存放具体变量
         * new数组会在堆中新开辟空间，若只是定义新数组等于已有数组，则不会有新空间，两个数组栈中指向同一地址
         * 改变其中一个数组的变量，另一个也会改变，因为指向同一片空间
         * */

        //二维数组动态初始化外层默认初始值为地址和数组类型
        int[][] arr1 = new int[4][3];
        //特殊
        int[][] arr2 = new int[4][]; //声明正确
        //System.out.println(arr2[0][0]);    外层为null，内层空指针报错

        /*
         * 二维数组内存解析
         * 栈中存放数组对应首地址，指向堆中的外层元素，各个外层元素又指向堆中的内层元素*/

        int[] arr3 = new int[4];
        byte[] arr4  = new byte[4];
        //arr3 = arr4 报错，数组类型不同

        int[][] arr5 = new int[4][4];
        //arr5 = arr3 报错，数组维度不同
        arr5[1] = arr3; //可以

        //数组扩容，缩容是定义新数组，新长度。而后对新数组操作，最后原数组=新数组
        /*Arrays工具类
         * java.util.Arrays*/
        int[] arr6 = new int[]{1,2,3,4,5};
        int[] arr7 = new int[]{1,2,3,4,5};

        //用==比较地址，用Arrays.equals比较内容
        if (arr6 == arr7){
            System.out.println("地址相同");
        } else {
            System.out.println("地址不同");
        }
        boolean contenu = false;
        contenu = Arrays.equals(arr6, arr7);
        System.out.println(contenu);

        //转为字符串
        System.out.println(Arrays.toString(arr6));

        //快速排序
        int[] arr8 = new int[]{1,3,2,5,213,55,54};
        Arrays.sort(arr8);
        System.out.println("排序的后的数组为" + Arrays.toString(arr8));

        //二分查找，数组必须有序
        int index = Arrays.binarySearch(arr8, 5);
        System.out.println(index);

    }
}