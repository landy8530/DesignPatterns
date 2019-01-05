package org.landy.chain.responsibility.demo3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Landy on 2019/1/5.
 */
public class ChainDemo {

    public static void main(String[] args) {
        DefaultExecutorChain chain = new DefaultExecutorChain();
        chain.addExecutor(new Executor() {
            @Override
            public void run(ExecutorChain c) {
                System.out.println("Hello World");
                c.run();
            }
        }).addExecutor(new Executor() {
            @Override
            public void run(ExecutorChain chain) {
                System.out.println("Hello Landy");
                chain.run();
            }
        });

        chain.run();
    }

    public static class DefaultExecutorChain implements ExecutorChain {

        private final List<Executor> executorList = new LinkedList<>();

        private int index = 0;

        public ExecutorChain addExecutor(Executor executor) {
            executorList.add(executor);
            return this;
        }

        @Override
        public void run() {
            if(index == executorList.size()) return ;
            int pos = index;
            Executor executor = executorList.get(pos);

            System.out.println("执行第"+ pos + "个Executor");

            index++;

            executor.run(this);

        }
    }

    public interface Executor {
        void run(ExecutorChain chain);
    }

    public interface ExecutorChain {
        ExecutorChain addExecutor(Executor executor);
        void run();
    }
}
