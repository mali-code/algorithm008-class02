学习笔记

本周学习了数组，链表，栈，队列

数组

查询O(1)

插入删除O(N)

链表

插入O(1)

查询O(N)

做题方法总结：

本周的题目中很多种题目都用到了 双指针的方法 这个方式要好好体会下多写多练练，对于链表类型的题目我还是做的不够好。要多注意这一块 ，个人觉得是递归思想的多多练习

队列分析

队列的底层也是使用了一个数组作为存储数据

priorityQueue 插入的时候会进行一个比较 出队列的时候直接拿走最后一个然后再进行一个比较 不知道对不对,这块看起来比较费劲 后期慢慢补回来

deque

```
Deque<String> deque = new LinkedList<String>();
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        System.out.println(deque);
        deque.addLast("6");
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
        while (deque.size()>0){
            String s = deque.removeLast();
            System.out.println(s);
        }
```











