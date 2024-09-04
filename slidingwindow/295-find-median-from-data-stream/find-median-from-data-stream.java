class MedianFinder {
    PriorityQueue<Integer> rightHeap ;
    PriorityQueue<Integer> leftHeap ;
    

    public MedianFinder() {
        rightHeap = new PriorityQueue<>();
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(leftHeap.size()==0 || leftHeap.peek()>num)
        leftHeap.offer(num);
        else
        rightHeap.offer(num);
        if(leftHeap.size()>rightHeap.size()+1)
        rightHeap.offer(leftHeap.poll());
        if(leftHeap.size()+1<rightHeap.size())
        leftHeap.offer(rightHeap.poll());
    }
    
    public double findMedian() {
        if(leftHeap.size()>rightHeap.size()){
            return (double)leftHeap.peek();
        }
        else if(leftHeap.size()<rightHeap.size()){
            return (double)rightHeap.peek();
        }
        
        else{
            return ((double)leftHeap.peek()+(double)rightHeap.peek())/2.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */