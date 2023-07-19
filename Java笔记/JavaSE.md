### 多态

三个条件：

1.  子类继承父类，或类继承接口
2.  重写所有父类或接口中方法
3.  父类引用指向子类对象，如：Parent p = new child();

    此时若使用p.method，效果为child重写的方法

    ***

### 封装

即利用权限修饰符

权限排名：public > protected > 缺省 > private

类只能用public或缺省

***

### 继承

即extends父类，可拥有父类中除private的所有属性和方法

***

### 抽象类 abstract

不可实例化，必须被继承才能使用

目的：强迫子类实现其中的抽象方法，避免一些错误

***

### 接口 interface

类实现接口 implements，并实现其中所有方法（接口中方法默认隐式public abstract）

接口可用extends继承接口，从而实现类必须实现该接口及其上级的所有方法

jdk1.8后允许静态方法和方法体

***

### 枚举类 enum

用逗号隔开各个元素，如：

`public enum enum1(){SMALL, MEDIUM, LARGE; }`

`enum1.SMALL.toString()`  转换为字符串

`enum1[] enumTest = enum1.values();`   获取所有枚举值，得到数组格式

***

### ArrayList 泛型数组

可以动态修改，没有固定大小

`ArrayList <引用数据类型> objectName = new ArrayList<>();`

可用`Collections.sort(objectName);` 进行排序

***

### 重载 overload

同类中同名方法，参数列表不同

用如`int ... nums`表示可变数量的参数

***

### 堆 heap

存放new出来的结构、对象和数组，包括对象中的属性

先进先出，后进后出

***

### 栈 stack

存放方法、其中定义的变量和变量地址

先进后出，后进先出

***

### 方法区 method area

存放类的模板

***

### 反射 Reflexion

编译时不知道类或对象的具体信息，运行时读取xml文件，动态获取类的信息

方法：1.创建一个类的Class实例：`Class clazz1 = Person.class;`

&#x9;	   2.调用运行时类对象的getClass方法：`Person p1 = new Person();      `

&#x9;																	  `Class clazz2 = p1.getClass();`

***

### 值传递机制

基本数据类型：byte short int long; float double; boolean

引用数据类型：类，数组，String

对于局部变量，基本数据类型传递数值，引用数据类型传地址；所以用方法直接交换int变量值无效

***

### 数组 array

初始化：静态：直接赋值，如 `prices = new double[]{ 1.1, 2.2, 3.3};`

&#x9;	      动态：只确定长度，如 `prices = new double[3];`

一维数组内存解析：*栈(stack)中存放数组类型和对应首地址*

&#x9;							 *堆中在首地址开始存放具体变量*

&#x20;                             new数组会在堆中新开辟空间，若只是定义新数组等于已有数组，则不会有                                新空间，两个数组栈中指向同一地址，*改变其中一个数组的变量，另一个也                               会改变，因为指向同一片空间*

用==比较地址，用`Arrays.equals(a1, a2);` 比较内容

`Arrays.sort(a1);` 快速排序

`Arrays.binarySearch(a1, 5);` 二分查找，数组必须有序
