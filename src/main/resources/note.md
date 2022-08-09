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

#### 111. 二叉树的最小深度

递归 (如果一个节点的一个叶子节点为 null，最小深度为 0)

#### 104. 二叉树的最大深度

递归

#### 28. KMP 实现 indexOf



#### 46. 全排列

回溯 TODO

#### 78. 求子集



#### 88. 合并有序数组

从**尾部**开始遍历修改

```
[1, 3, 5, 0, 0, 0]
[2, 4, 6]
```



#### 101. 判断是否为对称二叉树

- 递归
- 迭代：使用队列 或 栈，只需要将对称的节点**挨着成对**放进去



#### 461. 汉明距离

异或：x ^ y

获取一个数据中 1 的数量

```java
int ans = 0;
while (i > 0) {
    // 通过 & 1 判断数字的最后一位
    ans += (i & 1);
    i = i >> 1;
}

// 或者
Integer.bitCount(i);
```



#### 739. 每日温度

找到下一个大于该值的数字与当前的距离

单调栈 (存储下标，不能存储值)



#### 95. 生成二叉树

每个数字依次作为根节点

```java
// 依次作为根节点
for (int i = start; i <= end; i++) {
    // 获取所有的左子树
    List<TreeNode> leftTrees = generateTrees(start, i - 1);
    // 获取所有的右子树
    List<TreeNode> rightTrees = generateTrees(i + 1, end);
    for (TreeNode left : leftTrees) {
        for (TreeNode right : rightTrees) {
            // 创建根节点，左右节点依次赋值
            TreeNode root = new TreeNode(i);
            root.left = left;
            root.right = right;
            ans.add(root);
        }
    }
}
```



#### 704. 二分查找

数组有序，无重复



#### 34. 有序数组中查找元素出现开始和结尾位置

```java
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (nums[mid] > target) {
        high = mid - 1;
    } else if (nums[mid] < target) {
        low = mid + 1;
    } else {
        ans = mid;
        // 如果寻找左边界，可能左边还有相同的值
        if (isLeft) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
}
```



#### 11. 盛最多水的容器

使用双指针，每次移动较小的一边

<img src="./img/盛最多水的容器.jpg" alt="盛最多水的容器" style="zoom:50%;" />





#### 121. 股票卖出时机 (交易一次)

只能买一次，第 i 天的最大收益为 max(前一天的收益，[0, i]天中后面的最大值减最小值)

$profit[i] = max(profit[i - 1], price[i] - minPrice)$



#### 122. 股票卖出时机 (交易多次)

可以交易多次，每次只能持有一支股票

- 第 i 天交易完成后手里没有股票的收益 (前一天没买，当天卖了)

- 第 i 天交易完成后手里还有股票 (当天买的，前天买的)
- 最后的结果是 `profit[0][len]`

$$
profit[0][i] = max(profit[0][i - 1], profit[1][i - 1] + prices[i]) \\
profit[1][i] = max(profit[0][i - 1] - prices[i], profit[1][i - 1]) \\
$$

|      | 7    | 1                | 5                | 3              | 6              | 4             |
| ---- | ---- | ---------------- | ---------------- | -------------- | -------------- | ------------- |
| 无   | 0    | max(0, -6) = 0   | max(0, 4) = 4    | max(4, 2) = 4  | max(4, 7) = 7  | max(7, 5) = 5 |
| 有   | -7   | max(-1, -7) = -1 | max(-1, -5) = -1 | max(-1, 1) = 1 | max(1, -2) = 1 | max(1, 3) = 3 |





#### 633. 判断一个数字是否可以拆分成两个数的平方和

先开方，然后双指针判断



#### 9. 是否是回文数字

- 转成字符串

- 反转数字的后一半  (原始数字 < 反转的数字 说明到一半了)

- 比较数字的第一位 和 最后一位

  第一位 ：需要先计算数字的位数 (通过 1234 得到 1000)，然后相除

  最后一位： x % 10



#### 169. 统计数组中出现次数最多的数字

- Map：遍历统计次数，遍历求次数最大值

- 分治：如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数

  分别计算左右两侧的众数，如果相同就找到了；如果不相同，统计两个数在数组中出现的次数，出现次数多的是众数



#### 1175. 质数排列

从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。

- 先计算质数个数
- 质数个数的全排列 * 非质数个数的全排列

```java
// 判断数字是否为质数
public boolean isPrime(int n) {
    if (n == 1) {
        return false;
    }
    for (int i = 2; i * i <= n; i++) {
        // 根据余数判断能否整除
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}
```



#### 100. 判断两个二叉树是否相同

- 如果两个节点都为 null，相同
- 如果只有一个节点为 null，不相同
- 两个节点都不为 null，判断值是否相等
  - 如果值相等，递归判断两个子节点
  - 否则不相同





#### 53. 最大子数组和

如果前边累加后还不如自己本身大，那就把前边的都扔掉，从自己本身重新开始累加。

$ans[i] = max(ans[i - 1] + nums[i], nums[i])$



#### 1200. 最小绝对差

先排序，然后遍历，判断相邻两个数的差

- 大于之前的最小值，不处理
- 等于之前的最小值，将当前的两个数加入结果集
- 小于之前的最小值，清空之前存储的结果，将当前值作为新的最小值



#### 112. 二叉树路径和

判断是否存在一条路径的节点和等于指定值

- 如果当前节点是叶子节点，判断节点值和目标值是否相等
- 如果不是叶子节点，递归判断左子树 和 右子树



#### 268. 有序数组中缺失的数字

和同一个数字异或 `^` 两次还是原来的数字



#### 605. 种花问题

需要额外判断尾部 [..., 1, 0, 0] 的情况，是可以再放一个的

数组长度为 1，也需要额外考虑



#### 20. 有效括号

判断括号是否匹配，使用栈



#### 67. 二进制求和

遍历两个二进制字符串求和

- 当前位：$(first + second + carry) \% 2$
- 进位: $(first + second + carry) / 2$



#### 872. 判断两棵二叉树从左到右的叶子节点值是否相同

后序遍历



#### 434. 单词个数

"Hello, my name is John"

出现一个空格，并且前面一个不是空格，说明是一个单词；最后也给单词需要额外判断 (如果最后一个字符不是空格会少计算一个)



#### 650. 通过复制粘贴完成字符串

完成 n 个 A 复制

先找到 n 的最大公因数( 18 的话找到 9)

- 如果是质数，只能一个一个粘贴
- 9 到 18 需要复制 (18 / 9 = 2) 次，然后计算得到 9 需要几次 (递归)



#### 11. 盛水最多的容器

左右两侧哪个小移动哪个





#### 452. 射气球

将坐标按照右端点排序，从最小的右端点射箭



#### 141. 环形链表

慢指针移动 1 个节点，快指针移动 2 个节点，判断是否相遇



#### 160. 相交链表

两个指针分别遍历，走到结尾后走另一个链表

- 如果不相交，最后都为 null
- 如果相交，会同时走到相交的节点上



#### 844. 比较退格字符

每发现一个需要退格的标志，出栈一个字符，最后比较两个栈的剩余字符是否相同

双指针：从尾部开始遍历，及时判断当前字符是否需要删除



#### 1252. 统计改变奇数次的位置个数

用两个数组统计每(`row[]`)行 和 每列(`col[]`)修改了多少次，加起来看 `table[i][j] `被修改了多少次



#### 108. 根据升序数组生成平衡的二叉排序树

每次都选择数组中间的那个数作为根节点，递归生成左右子树



#### 637. 二叉树的层次遍历

使用队列完成



#### 110. 判断二叉树是否平衡

先拿到左右子树的深度，然后递归判断子树是不是平衡的



#### 205. 同构字符串

使用 map，遍历字符串的同时判断之前是否出现过

- 出现过：判断和之前的映射关系是否一样
- 没出现：放进去



#### 326. 判断是否为 3 的幂

迭代，每次除 3

```java
while (n != 0 && n % 3 == 0) {
    n /= 3;
}
return n == 1;
```



#### 645. 求数组中重复 和 缺少的数字

```
// 输入数组：[1, 2, 2, 4]
// 原数组 : [1, 2, 3, 4, 5]

// tot = [1, 2, 3, 4, 5] 所有值求和
// sum = [1, 2, 2, 4]    求和
// set = [1, 2, 4]       去重求和
// 重复：sum - set
// 缺少：tot - set
```



#### 674. 最长递增序列的长度

遍历，判断后一个是不是大于前一个；最后还要比较一下

```java
int count = 1;
int max = 1;
for (int r = 1; r < nums.length; r++) {
    if (nums[r] > nums[r - 1]) {
        count++;
    } else {
        max = Math.max(max, count);
        count = 1;
    }
}
// 最后还要比较一下，如果是 [1, 2, 3, 4]，count 一直没有更新
return Math.max(count, max);
```



#### ⭐279. 将整数拆分成平方数的和

动态规划

```java
int[] ans = new int[n + 1];
ans[0] = 0;
ans[1] = 1;
for (int i = 2; i <= n; i++) {
    // 最多需要 n 个 1
    ans[i] = i;
    for (int j = 1; j * j <= i; j++) {
        ans[i] = Math.min(ans[i], ans[i - j * j] + 1);
    }
}
return ans[n];
```



#### 202. 二叉树的层次遍历

队列



#### ⭐744. 在排序数组中查找大于指定值的最小值

二分法，找到小于指定值的最大值

```java
int left = 0, right = letters.length - 1;
int mid = 0;
while (left <= right) {
    mid = left + (right - left) / 2;
    if (letters[mid] <= target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
return letters[left];
```



#### 300. 最长递增子序列 (子序列可以不连续)

动态规划



#### 130.

#### 63.

#### 180. 连续出现三次的记录

```sql
select * from logs l1, logs l2, logs l3
where l1.id = l2.id - 1 and l2.id = l3.id - 1
and l1.num == l2.num and l2.num == l3.num

select * from logs
where (id + 1, num) in (select * from logs)
and (id + 1, num) int (select * from logs)
```



#### 557. 反转字符串中的单词

#### 83. 移除链表中的重复节点

#### ⭐ 671. 第二小节点

<img src="./img/671.jpg" alt="img" style="zoom:50%;" />

```java
// 最小的是根节点，要找的是比根节点大的
private int getMin(TreeNode root, int val) {
    if (root == null) {
        return -1;
    }
    // 如果当前节点的值大于 val，这个节点就不用继续遍历了
    if (root.val > val) {
        return root.val;
    }
    int left = getMin(root.left, val);
    int right = getMin(root.right, val);
    // 如果两个子树，都有小于 val 的节点，选小的那个
    if (left != -1 && right != -1) {
        return Math.min(left, right);
    } else {
        // 如果只有一个子树有小于 val 的节点
        return Math.max(left, right);
    }
}
```



#### 66. 对数组中的数组加一

从尾部遍历，如果是 9，改成0，再判断前一位；如果不是 9，直接加 1 就行

```java
public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
        digits[i] = (digits[i] + 1) % 10;
        if (digits[1] != 0) {
            return digits;
        }
    }
    // 如果没有返回说明全是 9
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
}
```



#### 814. 二叉树剪枝

递归：去除子节点全为 0 的子树

```java
public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    if (root.left == null && root.right == null && root.val == 0) {
        return null;
    }
    return root;
}
```



#### ⭐ 191. 求数字的二进制表示中 1 的个数

- 算术右移 >> ：舍弃最低位，高位用符号位填补；

- 逻辑右移 >>> ：舍弃最低位，高位用 0 填补。

  那么对于负数来说，其二进制最高位是 1，如果使用算术右移，那么高位填补的仍然是 1

```java
public int hammingWeight(int n) {
    int ans = 0;
    while (n != 0) {
        int i = n % 2;
        if (i != 0) {
            ans += 1;
        }
        // 逻辑右移
        n >>>= 1;
    }
    return ans;
}
```

`n & (n - 1)`相当于将 n 的二进制的最后一个 1 变成 0

6 & 5 = 5

110 & 100 = 100

```java
public int hammingWeight(int n) {
    int ret = 0;
    while (n != 0) {
        // 不断让 n 的最后一个 1 变成 0
        n &= n - 1;
        // 改了几次，就有几个 1
        ret++;
    }
    return ret;
}
```



#### 283. 将数组中的 0 向后移

双指针，left 指向 0 的位置，right 指向不为 0 的位置

```java
public void moveZeroes(int[] nums) {
    int left = 0, right = 0;
    // left 到 right 之间全是 0
    while (right < nums.length) {
        if (nums[right] != 0) {
            swap(nums, left, right);
            left++;
        }
        right++;
    }
}
```



#### 415. 字符串相加

`char -> int    s.charAt(i) - '0'`



#### ⭐ 441. 求满足 $ (1 + n) * n / 2 < val$  最大的 n

二分法，边界



#### 693. 判断数字是否01相间

```java
// 5  101 ^ 010 = 111 得到全为 1 的数
int tmp = n ^ (n >> 1);
// 0111 & 1000 = 0
return (tmp & (tmp + 1)) == 0;
```



#### l22. 倒数第 n 个节点

用两个指针，第一个提前向下走 n 个节点，当第一个到末尾的时候，第二个指针正好指向倒数第 n 个节点



#### ⭐ l26. 判断一个树是不是另一个的子树  (包含)

递归

- b 是 a 的根节点的子树
- b 是 a 的左子节点的子树
- b 是 a 的右子节点的子树

判断是不是子树

- 根节点相等
- 两个子节点完全相同

```java
public boolean isSubStructure(TreeNode A, TreeNode B) {
    return isSame(A, B)
            || isSubStructure(A.left, B.left)
            || isSubStructure(A.right, B.right);
}
/**
 * 判断 b 是不是 a 的子树
 */
public boolean isSame(TreeNode a, TreeNode b) {
    if (b == null) {
        return true;
    }
    if (a == null) {
        return false;
    }
    if (a.val == b.val) {
        return isSame(a.left, b.left)
                && isSame(a.right, b.right);
    }
    return false;
}
```



#### ⭐ l29. 顺时针打印矩阵



#### ⭐ 22. 排列括号

回溯



#### ⭐ 55. 跳跃

数组中的每个元素代表你在该位置可以跳跃的最大长度，判断能否到达最后一个下标

维护**当前能到达的最远距离**



#### 56. 合并区间

先按照区间第一个值排序，然后判断是直接加入 还是 更新区间第二个值











































