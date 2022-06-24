#### 198. 打家劫舍

动态规划

```
nums.length == 1, nums[0]
nums.length == 2, max(nums[0], nums[1])
nums.length > 2, result[i] = max(result[i - 1], result[i - 2] + nums[i])
```

#### 203. 删除指定链表元素

可以创建一个 `dummyNode `作为头节点用 `dummyNode.next` 来返回结果

#### 206. 反转链表

- 迭代，三个指针 `pre, curr, next`

  ```java
  while (curr != null) {
      next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
  }
  ```

- 递归

  ```java
  ListNode result = reverseList(head.next);
  head.next.next = head;
  head.next = null;
  return result;
  ```

#### 665. 能否改变一个元素使数组非递减

需要考虑两种情况

```
从 1 开始遍历整个数组
	1 需要特殊考虑

	if (当前值 < 前一个) {
		// 判断怎么修改
		if (当前值 >= 前两个) {
			nums[i - 1] = nums[i]; // 把前面那一个变小 [0, 4, 2, 3] -> [0, 2, 2, 3]
		} else {
			nums[i] = nums[i - 1]; // 把当前值变大 [0, 4, -1, 5] -> [0, 4, 4, 5]
		}
	}
```

#### 144. 先序遍历二叉树 （递归 -> 栈）

<img src="./img/二叉树.png" alt="二叉树" style="zoom:50%;" />

遍历结果：

```
先序：  1  2  4  5  3  6  7
中序：  4  2  5  1  6  3  7
后序：  4  5  2  6  7  3  1
层次：  1  2  3  4  5  6  7
```

- **先序 **(中左右)

    - 递归

      ```java
      public List<Integer> preorderTraversal(TreeNode root, List<Integer> result) {
          if (root == null) {
              return result;
          }
          result.add(root.val);
          // 这里不用判断 root.left == null，因为进入方法后会先进行判断的
          preorderTraversal(root.left, result);
          preorderTraversal(root.right, result);
          return result;
      }
      ```

    - 迭代：栈，依次入栈 (中，右，左；因为左节点需要先遍历所以后放进去)

      ```java
      while (!stack.empty()) {
          TreeNode pop = stack.pop();
          result.add(pop.val);
          // 左节点要先出栈，所以后放入
          if (pop.right != null) {
              stack.push(pop.right);
          }
          if (pop.left != null) {
              stack.push(pop.left);
          }
      }
      ```

#### 94. 中序遍历二叉树

左中右：需要先一直向左到叶子节点

```java
while (root != null || !stack.empty()) {
    while (root != null) {
        stack.push(root);
        root = root.left;
    }
    TreeNode pop = stack.pop();
    result.add(pop.val);
    root = pop.right;
}
```

#### 145. 后序遍历二叉树

```java
while (root != null || !stack.empty()) {
    // 左节点到底
    while (root != null) {
        stack.push(root);
        root = root.left;
    }
    root = stack.pop();
    // 如果右边没有节点 或 已经遍历过了
    if (root.right == null || root.right == pre) {
        result.add(root.val);
        pre = root;
        root = null;
    } else {
        // 放入右节点
        stack.push(root);
        root = root.right;
    }
}
```

#### 70. 爬楼梯

每次可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到 n 楼楼顶

```
ans[i] = ans[i - 1] + ans[i - 2];
```



#### 345. 交换元音字母

由于字符串不可变，不能直接交换，所以使用 `s.toCharArray` 转换成数组

使用两个指针，找到元音字母后进行交换



#### 1115. 多线程交替打印指定次数的字符串

- 两个信号量：一个打印完成后释放另一个线程的信号量
- ReentrantLock + Condition + 标志：需要先获取锁，一个线程标志为真时输出，否则等待，输出完成后修改标志；另一个线程相反
- CycleBarrier + 标志：可重用的，两个线程通过标志按顺序输出，两个线程都输出后栅栏恢复开始新一次输出



#### 226. 反转二叉树

#### 617. 合并二叉树

#### 111. 二叉树最小深度

#### 28. KMP 实现 indexOf



#### 46. 全排列

回溯







