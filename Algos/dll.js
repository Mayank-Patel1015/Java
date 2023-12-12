class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

/**
 * A class to represent a doubly linked list and contain all of it's methods.
 * A doubly linked list is a singly linked list that can be traversed in both
 * directions.
 */
class DoublyLinkedList {
  /**
   * Executed when the new keyword is used to construct a new DoublyLInkedList
   * instance that inherits these methods and properties.
   */
  constructor() {
    this.head = null;
    this.tail = null;
  }

  /**
   * Creates a new node and adds it at the back of this list.
   * - Time: O(?).
   * - Space: O(?).
   * @param {any} data The data for the new node.
   * @returns {DoublyLinkedList} This list.
   */
  insertAtBack(data) {
    const newNode = new Node(data);
    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
      return this;
    }
    newNode.prev = this.tail;
    this.tail.next = newNode;
    this.tail = newNode;
    return this;
  }

  /**
   * Find targetVal in DLL and return node
   * if targetVal is not found return null
   */
  findTarget(targetVal) {
    let runner = this.head;
    while (runner) {
      if (runner.data === targetVal) {
        return runner;
      }
      runner = runner.next;
    }
    return null;
  }

  /**
   * Inserts a new node with the given newVal after the node that has the
   * given targetVal as it's data.
   * - Time: O(?).
   * - Space: O(?).
   * @param {any} targetVal The node data to find.
   * @param {any} newVal Data for the new node.
   * @returns {boolean} Indicates if the new node was added.
   */
  insertAfter(targetVal, newVal) {
    let targetNode = this.findTarget(targetVal);
    if (targetNode === null) {
      return false;
    }
    let newNode = new Node(newVal);
    if (targetNode === this.tail) {
      this.insertAtBack(newNode.data);
      return true;
    }
    // 1 -> 3
    //   <-

    // 1 -> 2 -> 3
    //   <-   <-
    let nextNode = targetNode.next;
    targetNode.next = newNode;
    newNode.previous = targetNode;
    newNode.next = nextNode;
    nextNode.prev = newNode;
    return true;
  }

  /**
   * Inserts a new node with the given newVal before the node that has the
   * given targetVal as it's data.
   * - Time: O(?).
   * - Space: O(?).
   * @param {any} targetVal The node data to find.
   * @param {any} newVal Data for the new node.
   * @returns {boolean} Indicates if the new node was added.
   */
  insertBefore(targetVal, newVal) {
    let targetNode = this.findTarget(targetVal);
    let newNode = new Node(newVal);
    if (!targetNode) {
      return false;
    }
    if (targetNode === this.head) {
      newNode.next = this.head;
      this.head.prev = newNode;
      this.head = newNode;
    } else {
      targetNode.prev.next = newNode;
      newNode.next = targetNode;
      newNode.prev = targetNode.prev;
      targetNode.prev = newNode;
    }

    // 1 -> 2 -> 4 -> 5
    //   <-   <-   <-

    // 1 -> 2 -> 3 -> 4 -> 5
    //   <-   <-   <-   <-

    return true;
  }

  /**
   * Determines if this list is empty.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {boolean} Indicates if this list is empty.
   */
  isEmpty() {
    return this.head === null;
  }

  /**
   * Converts this list to an array of the node's data.
   * - Time: O(n) linear, n = list length.
   * - Space: O(n) linear, array grows as list length increases.
   * @returns {Array<any>} All the data of the nodes.
   */
  toArray() {
    const vals = [];
    let runner = this.head;

    while (runner) {
      vals.push(runner.data);
      runner = runner.next;
    }
    return vals;
  }

  /**
   * Adds all the given items to the back of this list.
   * @param {Array<any>} items Items to be added to the back of this list.
   * @returns {DoublyLinkedList} This list.
   */
  insertAtBackMany(items = []) {
    items.forEach((item) => this.insertAtBack(item));
    return this;
  }
}

const emptyList = new DoublyLinkedList();

/**************** Uncomment these test lists after insertAtBack is created. ****************/
const singleNodeList = new DoublyLinkedList().insertAtBack(1);
const biNodeList = new DoublyLinkedList().insertAtBack(1).insertAtBack(2);
const firstThreeList = new DoublyLinkedList().insertAtBackMany([1, 2, 3]);
const secondThreeList = new DoublyLinkedList().insertAtBackMany([4, 5, 6]);
const unorderedList = new DoublyLinkedList().insertAtBackMany([
  -5, -10, 4, -3, 6, 1, -7, -2,
]);

console.log(unorderedList.toArray());
console.log(unorderedList.insertAfter(4, 3));
console.log(unorderedList.toArray());
console.log(unorderedList.insertAfter(-2, 3));
console.log(unorderedList.toArray());
console.log(unorderedList.insertAfter(-5, 3));
console.log(unorderedList.toArray());
console.log(unorderedList.insertAfter(-24, 3));
console.log(unorderedList.toArray());
// empty case
console.log(emptyList.insertAfter(-24, 3));
console.log(emptyList.toArray());

console.log("*****************************");
console.log(secondThreeList.toArray());
console.log(secondThreeList.insertBefore(5, -1));
console.log(secondThreeList.toArray());
console.log(secondThreeList.insertBefore(4, -1));
console.log(secondThreeList.toArray());
console.log(secondThreeList.insertBefore(6, -1));
console.log(secondThreeList.toArray());
console.log(secondThreeList.insertBefore(-24, -1));
// empty case
console.log(emptyList.insertBefore(-24, -1));
console.log(emptyList.toArray());
