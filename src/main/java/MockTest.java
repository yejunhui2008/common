
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MockTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
//		String targetURL = "https://automation.uyun.cn/boltdog/api/v2/job/query?apikey=a3b8f85a-1b8b-4ecd-9462-aa649a78d5bc&isSelfConfirm=true&pageSize=10&currentPage=";
		String targetURL = "https://automation.uyun.cn/boltdog/api/v2/job/query?apikey=a3b8f85a-1b8b-4ecd-9462-aa649a78d5bc&status=1&pageSize=10&currentPage=";
//		String targetURL = "https://automation.uyun.cn/boltdog/api/v2/job/exec-abort?apikey=f67807bf508241e18cc7df22fe7efab2&jobId=c726ddbdd8b4468881b3d7803679e4af";
//		String input = "{\"workflow\": {\"id\": \"78e8940708644ae29accfb2b22241135\"},\"paramContent\": [{\"name\": \"param1\",\"description\": \"参数2\",	\"type\": \"number\",	\"value\": \"123\"}]}";
		String input = "";
//		String input = "{\"workflow\": {\"id\": \"6f3e5c65353645f18c91453a29c2edc5\"},\"paramContent\": []}";
//		String targetURL = "http://192.168.100.254:7000/boltdog/api/v2/job/execute";
//		boolean isLoop = false;
//
//		int thread = 1;
//		int count = 10000;
//		System.out.println("startTime:" + new Date());
//		while (true) {
//			for (int i = 0; i < thread; i++) {
//				executorService.execute(new ExecuteThread(count, targetURL, input));
//			}
//			if (!isLoop) {
//				break;
//			} else {
//				try {
//					Thread.sleep(5 * 60 * 1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
