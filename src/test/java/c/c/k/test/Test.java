package c.c.k.test;

import c.c.k.MyApplication;
import c.c.k.domain.Stock;
import c.c.k.service.StockService;
import cn.hutool.http.HttpUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class }) // 指定启动类
public class Test {
    @Autowired
    private StockService stockService;

    private static String url = "http://hq.sinajs.cn/list=";

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
                stock.setCity(which.startsWith("sh")?1:2);
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
