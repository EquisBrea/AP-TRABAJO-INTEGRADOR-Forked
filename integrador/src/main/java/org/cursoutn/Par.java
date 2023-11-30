package org.cursoutn;

public class Par<T,U> {
        private final T first;
        private final U second;

        public Par(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
}
