function reverse(head) {
    if (head === null) return head;
    
    let curr = head;
    
    while(true) {
        let next = curr.next;
        curr.next = curr.prev;
        curr.prev = next;
        if (curr.prev === null) break;
        curr = curr.prev;
    }
    
    return curr;
}
