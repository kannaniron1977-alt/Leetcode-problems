class RecentCounter {
    private Deque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        // Remove all pings that are outside the window [t - 3000, t]
        while (queue.peekFirst() < t - 3000) {
            queue.pollFirst();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
