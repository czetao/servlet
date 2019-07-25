package czt.inter;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//合同解除接口
@WebServlet(name = "relieve")
public class relieve extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求体中的数据，通过request.getreader(),返回一个包含body数据体BufferedReader
        BufferedReader reader = request.getReader();
        String readerStr = "";// 接收用户端传来的JSON字符串（body体里的数据）
        String line;
        while ((line = reader.readLine()) != null){
            readerStr = readerStr.concat(line);
        }

        // 使用阿里的fastjson jar包处理json数据（这里是用map进行接收的，也可以定义vo层容器类接收）
        HashMap map = com.alibaba.fastjson.JSONObject.parseObject(readerStr, HashMap.class);


        //重新封装请求体中的参数
        Object type = map.get("type");
        Object srcsys = map.get("srcsys");
        Object syncts = map.get("syncts");
        Object sign = map.get("sign");
        Object data2 = map.get("data");

        com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
        json.put("type",type);
        json.put("srcsys",srcsys);
        json.put("syncts",syncts);
        json.put("sign",sign);
        json.put("data",data2);

        System.out.println(json);
        //调用接口传递 请求参数，接收返回的数据，封装返回参数




        //封装返回参数（暂时写死）
        //还差一些响应参数的逻辑判断

        //设置网页响应类型
        response.setContentType("application/json; charset=utf-8");
        //实现具体操作
        PrintWriter out = response.getWriter();
        JSONObject json2 = new JSONObject();
        json2.put("type","addcontract");
        json2.put("srcsys","NC65");
        Date date=new Date();
        //parse()返回的是一个Date类型数据，format返回的是一个StringBuffer类型的数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String d = sdf.format(date);
        json2.put("syncts",d);
        json2.put("sign","***");
        //接口调用成功，即true
        json2.put("result",true);
        json2.put("msg","***");
        // Map<String ,Object > data = new HashMap<String, Object>();
        com.alibaba.fastjson.JSONObject data = new JSONObject();
        data.put("billid","10086");
        data.put("ncbillid","NC10086");
        data.put("dresult",true);
        data.put("dmsg","**");
        json2.put("data",data);

        out.println(json2);
        out.flush();
    }

}