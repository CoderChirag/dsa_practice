class MedianFinder {
    PriorityQueue<Integer> max_heap;
    PriorityQueue<Integer> min_heap;
    
    public MedianFinder() {
        max_heap = new PriorityQueue<>(Collections.reverseOrder());
        min_heap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max_heap.isEmpty() || max_heap.peek() >= num) max_heap.offer(num);
        else min_heap.offer(num);
        
        if(max_heap.size() - min_heap.size() > 1) min_heap.offer(max_heap.poll());
        else if(min_heap.size() - max_heap.size() > 1) max_heap.offer(min_heap.poll());
    }
    
    public double findMedian() {
        if(max_heap.size() == min_heap.size()){
            return (max_heap.peek()+min_heap.peek())/2.0;
        }else if(max_heap.size() > min_heap.size()) return max_heap.peek();
        else return min_heap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */