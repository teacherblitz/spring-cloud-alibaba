import org.springframework.web.client.RestTemplate;

/**
 * @author teacherblitz
 * @version v1.0
 * @description Sentinel限流测试
 * @date 2019/10/31 22:24
 */
public class SentinelTest {

    public static void main(String[] args) throws InterruptedException {
        // 关联限流
        RestTemplate restTemplate = new RestTemplate();
        for (int i=0;i<1000;i++){
            String str = restTemplate.getForObject("http://localhost:7000/actuator/sentinel", String.class);
            Thread.sleep(500);
        }
    }
}
