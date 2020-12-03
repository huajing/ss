package c.c.k.test;

import c.c.k.MyApplication;
import c.c.k.domain.Stock;
import c.c.k.service.StockService;
import cn.hutool.http.HttpUtil;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class }) // 指定启动类
public class Test {
    @Autowired
    private StockService stockService;

    private static String url = "http://hq.sinajs.cn/list=";
    //http://api.k780.com/?app=finance.stock_list&category=hs&appkey=55908&sign=75ee1f7439f159617a96d653520e9dc6&format=json
    public static void main(String[] args) {

    }

    @org.junit.Test
    public void testList() {
        try {
            JSONObject parse = (JSONObject)JSONValue.parse(new FileInputStream("list.txt"));
            JSONArray array = (JSONArray) ((JSONObject)parse.get("result")).get("lists");
            for (Object o : array) {
                JSONObject jsonObject = (JSONObject)o;
                String symbol = jsonObject.getAsString("symbol");
                String sname = jsonObject.getAsString("sname");
                Stock stock = new Stock();
                stock.setCode(symbol);
                stock.setName(sname);
                stockService.save(stock);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test001() {

        fetchData("sh6", 1000, 1100);
//        fetchData("sz0", 1, 100);
//        fetchData("sz3", 1, 100);
    }
    private void fetchData(String which, int start, int end){
        String s = HttpUtil.get(url + getCode(which, start, end));
        String[] split = s.split("\\n");
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            int idx1 = s1.indexOf("\"");
            String substring0 = s1.substring(idx1-1-8, idx1-1-6);
            String substring1 = s1.substring(idx1-1-6, idx1-1);
            String substring2 = s1.substring(idx1 + 1);
            if(substring2.length()>10) {
                Stock stock = new Stock();
                stock.setCode(substring1);
                stock.setName(substring2.split(",")[0]);
                stockService.save(stock);
                System.out.println(substring0 + " " + substring1 + "  " + substring2);
            }
        }
    }

    private String getCode(String which, int start, int end){
        StringBuffer sb = new StringBuffer();
        for (int i = start; i < end; i++) {
            sb.append(which + getCode(i) + ",");
        }
        return sb.toString();
    }

    private String getCode(int idx){
        if(idx<10)
            return "0000"+idx;
        if(idx<100)
            return "000"+idx;
        if(idx<1000)
            return "00"+idx;
        if(idx<10000)
            return "0"+idx;
        return idx + "";
    }
}
