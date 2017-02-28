
import java.util.ArrayList;
import java.util.List;

public class ExecuteThread implements Runnable {
//	private String targetURL;
//	private String input;
//	private int count;
//
//	public ExecuteThread(int count, String targetURL, String input) {
//		this.count = count;
//		this.targetURL = targetURL;
//		this.input = input;
//	}
//
	@Override
	public void run() {
//		for (int i = 0; i < count; i++) {
//			try {
////				String data = HttpsRestUtil.connectGet(targetURL + (i + 1)).toString();
////				List<String> jobIdList = getJobIdList(data);
////				for (String jobId : jobIdList) {
////					String result = HttpsRestUtil.connectPost(
////							"https://automation.uyun.cn/boltdog/api/v2/job/exec-abort?apikey=a3b8f85a-1b8b-4ecd-9462-aa649a78d5bc&jobId="
////									+ jobId,
////							input).toString();
////					System.out.println("time：" + new Date() + ",jobId=" + jobId + "," + result);
////				}
////								String result = RestUtil.doPost(targetURL, input).toString();
////								System.out.println("time：" + new Date() + "," + result);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
//
//	private List<String> getJobIdList(String json) {
//		List<String> jobIdList = new ArrayList<>();
//		JSONObject jsonObj = JSONObject.parseObject(json);
//		JSONObject messageObj = JSONObject.parseObject((String) jsonObj.get("message"));
//		JSONArray jsonArray = messageObj.getJSONArray("data");
//		for (int i = 0; i < jsonArray.size(); i++) {
//			JSONObject jobJson = jsonArray.getJSONObject(i);
////			if (jobJson.getIntValue("status") == JobConstants.JOB_STATUS_WAITACKS) {
//				JSONObject workflowJson = jobJson.getJSONObject("workflow");
////				if ("9e53c0c7a5ee4fb78fc2df41bc2ede4e".equals(workflowJson.getString("id"))) {
//					jobIdList.add(jobJson.getString("id"));
////				}
////			}
//		}
//		return jobIdList;
//	}
}
