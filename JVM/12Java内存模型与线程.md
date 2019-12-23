### 物理机内存模型

![1576592547116](pic\1576592547116.png)

处理器和内存运算速度相差很大，所以引入与cpu频率相近高速诉缓存与主内存交互

同时导致缓存不一致问题，就需要缓存一致性协议保证多个cpu处理同一块主内存时候，得到正确的结果



### Java虚拟机内存模型

![1576592818102](pic\1576592818102.png)

1. #### 主内存与工作内存

   没有限制执行引擎使用cpu的特定寄存器或缓存来与主内存交互，没有限制调整代码执行顺序的优化

   与物理机类似，虚拟机线程操作数据只能在工作内存中进行，工作内存由线程享有，其他线程无法访问；

   所有的线程共用一块主内存，线程之间传值需要通过主内存传递

2. #### 内存间的交互操作

   变量在主内存和工作内存之间的相互拷贝，由以下8中操作完成，且保证每种操作都是原子的、不可再分的

   - lock：作用于主内存变量，使变量为某一个线程独占的状态
   - unlock：作用于主内存，把一个处于锁定状态的变量释放，变量才能被其他线程访问
   - read：将主内存中的变量传输到线程工作内存，以便load使用
   - load：作用于工作内存变量，将read从主内存中得到的变量放入工作内存的变量副本
   - use：作用于工作内存变量，把工作内存中的一个变量传递给执行引擎，每当虚拟机遇到一个需要使用到变量的值的字节码指令时执行这个操作
   - assign：作用于工作内存变量，把一个从执行引擎得到的值赋值给内存中的变量，每当虚拟机遇到一个给变量赋值的字节码指令时执行这个操作
   - store：作用于工作内存变量，把工作内存中的一个变量的值传送到主内存，以便后面write使用
   - write：作用于主内存变量，把store操作从工作内存中得到的值放入主内存

3. #### 满足一下规则

   - 不允许read和load、store和write操作之一单独出现，即不允许一个变量从主内存读取了但工作内存不接受，或者从工作内存发起回写了但主内存不接受的情况出现

   - 不允许一个线程丢弃它的最近的assign操作，即变量在工作内存中改变了之后必须把该变化同步回主内存。

   - 不允许一个线程在无任何赋值操作的情况下把数据从工作内存同步至主内存

     ```java
     	
     //在没加volatile的时候，无论write线程如何修改initValue，read线程中initValue的值都不会改变
     //因为read线程中没有对initValue的写操作，所以这个线程内部的initValue始终来自于工作内存
     //加了volatile关键字的时候，所有线程在读取变量的时候不会在工作内存中读取，而是直接从主内存中读取
     private static int initValue = 0;
     private final static int MAX_VALUE = 5;
     
     public static void main(String[] args) {
     
         new Thread(() -> {
             //            try {
             int localValue = initValue;
             while(localValue < MAX_VALUE) {
                 if(localValue != initValue) {
                     System.out.printf("initValue update to %d\n", initValue);
                     localValue = initValue;
                 }
             }
             //            } catch (InterruptedException e) {
             //                e.printStackTrace();
             //            }
     
         }, "READ").start();
         new Thread(() -> {
             int localValue = initValue;
             try {
                 while(localValue < MAX_VALUE) {
                     initValue = ++localValue;
                     Thread.sleep(1000);
                 }
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }, "WRITE").start();
     
     ```

   - 一个新的变量只能在主内存中“诞生”，不允许在工作内存中直接使用一个未被初始化（load或assign）的变量，换句话说，就是对一个变量实施use、store操作之前，必须先执行过了assign和load操作。

   - 一个变量在同一个时刻只允许一条线程对其进行lock操作，但lock操作可以被同一条线程重复执行多次，多次执行lock后，只有执行相同次数的unlock操作，变量才会被解锁

   - 如果对一个变量执行lock操作，那将会清空工作内存中此变量的值，在执行引擎使用这个变量前，需要重新执行load或assign操作初始化变量的值

   - 如果一个变量事先没有被lock操作锁定，那就不允许对它执行unlock操作，也不允许去unlock一个被其他线程锁定住的变量。

   - 对一个变量执行unlock操作之前，必须先把此变量同步回主内存中（执行store、write操作）。
     这8种内存访问操作以及上述规则限定，再加上稍后介绍的对volatile的一些特殊规定，就已经

4. 