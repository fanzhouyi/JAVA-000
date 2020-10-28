import okhttp3.*;

import java.io.IOException;

/**
 * @author Fzy
 * @version 1.0
 * @description 使用 HttpClient 或 OkHttp 访问 http://localhost:8801
 * @date 2020/10/27 22:51
 */
public class OKHttpTest {
    public static void main(String[] args) {
        OKHttpTest.getRequest();
    }


    /**
     * use OkHttpClient request
     */
    public static void getRequest() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url("http://localhost:8801").method("GET",null).build();
        /**创建一个call对象，参数是Request请求对象*/
        Call call = okHttpClient.newCall(request);
        /**异步，回调*/
        call.enqueue(new Callback() {
            //请求失败执行的方法
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("response:"+e.getMessage());
            }
            //请求成功执行的方法
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                System.out.println("response:"+data);
            }
        });





    }

}
