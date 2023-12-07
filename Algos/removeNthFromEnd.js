/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
    let nAhead = head
    let current = head
    let previous = null
    for (let i = 0; i < n; i++) {
        nAhead = nAhead.next
    }
    while (nAhead != null) {
        nAhead = nAhead.next
        previous = current
        current = current.next
    }
    if (!previous) {
        head = current.next
        return head
    }
    previous.next = current.next
    current.next = null
    return head
};