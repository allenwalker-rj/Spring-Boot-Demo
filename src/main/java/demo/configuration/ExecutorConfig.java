package demo.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 * @author allen
 * @date 2019/6/12 15:07
 **/
@Configuration
@EnableAsync
@Slf4j
public class ExecutorConfig {

    @Bean
    public Executor asyncServiceExecutor() {

        LOGGER.info("start asyncServiceExecutor");

        ThreadPoolTaskExecutor executor;
        executor = new VisiableThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(5);
        //设置最大线程数
        executor.setMaxPoolSize(5);
        //设置队列大小
        executor.setQueueCapacity(10000);
        //设置线程池中线程的名称前缀
        executor.setThreadNamePrefix("async-service-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

    @Slf4j
    private static class VisiableThreadPoolTaskExecutor extends ThreadPoolTaskExecutor{

        private void showThreadPoolInfo(String prefix){
            ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();

            if (null == threadPoolExecutor){
                return;
            }
            LOGGER.info("{}, {},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                    this.getThreadNamePrefix(),
                    prefix,
                    //任务总数
                    threadPoolExecutor.getTaskCount(),
                    //已完成任务数
                    threadPoolExecutor.getCompletedTaskCount(),
                    //活跃线程数
                    threadPoolExecutor.getActiveCount(),
                    //队列大小
                    threadPoolExecutor.getQueue().size());
        }

        @Override
        public void execute(Runnable task){
            showThreadPoolInfo("1. do execute");
            super.execute(task);
        }

        @Override
        public void execute(Runnable task, long startTimeout) {
            showThreadPoolInfo("2. do execute");
            super.execute(task, startTimeout);
        }

        @Override
        public Future<?> submit(Runnable task) {
            showThreadPoolInfo("1. do submit");
            return super.submit(task);
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            showThreadPoolInfo("2. do submit");
            return super.submit(task);
        }

        @Override
        public ListenableFuture<?> submitListenable(Runnable task) {
            showThreadPoolInfo("1. do submitListenable");
            return super.submitListenable(task);
        }

        @Override
        public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
            showThreadPoolInfo("2. do submitListenable");
            return super.submitListenable(task);
        }

    }
}
