package leetcode

import leetcode.list.ListNode

/*
 21. 合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。



示例 1：


输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]


提示：

两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列

 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val preHead = ListNode(-1)
    var prev = preHead
    var l1 = l1
    var l2 = l2
    while (null != l1 && null != l2) {
        if (l1.`val` < l2.`val`) {
            prev.next = l1
            l1 = l1.next
        } else {
            prev.next = l2
            l2 = l2.next
        }
        prev = prev.next!!
    }
    prev.next = if (null == l1) l2 else l1
    return preHead.next
}