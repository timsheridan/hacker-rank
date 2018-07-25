package io.sheridan.hackerrank.cracking;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class RunningMedian {

    public static void main(String[] args) throws Exception {
        int[] integers = { 12, 4, 5, 3, 8, 7 };

        MedianHeap heap = new MedianHeap(integers.length);

        for (int i = 0; i < integers.length; i++) {
            heap.insert(integers[i]);
            System.out.printf("%.1f\n", heap.median());
        }
        System.out.println(heap);
    }

    private static class MedianHeap {

        private final PriorityQueue<Integer> minHeap;
        private final PriorityQueue<Integer> maxHeap;

        private MedianHeap(int capacity) {
            minHeap = new PriorityQueue<>(capacity);
            maxHeap = new PriorityQueue<>(capacity, Comparator.reverseOrder());
        }

        private boolean isEmpty() {
            return minHeap.isEmpty() && maxHeap.isEmpty();
        }

        private void insert(int item) {
            if (isEmpty()) {
                minHeap.add(item);
            } else {
                if (Double.compare(item, median()) <= 0) {
                    maxHeap.add(item);
                } else {
                    minHeap.add(item);
                }
                balance();
            }
        }

        private void balance() {
            if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else {
                    maxHeap.add(minHeap.poll());
                }
            }
        }

        private double median() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            }
            return maxHeap.peek();
        }

        @Override
        public String toString() {
            return String.join("\n", minHeap.toString(), maxHeap.toString(), String.valueOf(median()));
        }
    }
}
