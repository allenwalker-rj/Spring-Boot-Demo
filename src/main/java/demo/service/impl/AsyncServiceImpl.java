package demo.service.impl;

import demo.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author allen
 * @date 2019/6/12 15:01
 **/
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    /**
     * 该注释，表明了 executeAsync方法进入的线程池是由 asyncServiceExecutor 创建的
     */
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        LOGGER.info("start executeAsync");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("end executeAsync");
    }
}
