何为索引堆：索引堆是对堆进行了优化。
在堆中，构建堆、插入、删除过程都需要大量的交换操作。在之前的实现中，进行交换操作是直接交换datas数组中两个数组。
而索引堆交换的是这两个元素的索引，而不是直接交换元素。

既保持data的原始特性，【读取O(1)】想要得到i位置的元素，直接datas[i]就可以了,。也保持堆的特性，使用索引堆。

使用索引堆
使用索引堆后，初始化两个数组应该是这样的：
datas:[1,15,20,34,7]
indexes:[1,2,3,4,5]
这个时候，我们就交换indexes数组里面的索引2和5，而不操作datas数组。交换后两个数组是这个样子：
datas:[1,15,20,34,7]
indexes:[1,5,3,4,2]
这个时候，想要得到i位置的元素，就需要datas[indexes[i]]来获取。--，我们现在能够获得类似于这样的数据：arr排序后，第2大的数datas[indexes[1]]。


我想知道原来arr数组中第i个位置，排好序后在哪个位置。应该怎样做？
一个数组reverses，作为反向索引。反向索引存放的数据通俗来讲就是这样：
reverses[i]==j
indexes[j]==i
进而推导出：
reverses[indexes[i]]=i;
indexes[reverses[i]]=i;

indexes[i]=x 表示的是：排名第i的元素在data数组中的索引为x,,,data[x]=data[indexes[i]]
reverses[x]=i 表示的是；data数组中的索引为x的元素，排名为i,,,data[x]排名是第i。

reverses[x]代表data数组中的索引 x 在indexes数组的位置。
indexes[i]=x 代表索引x的元素在堆中的位置是i。


