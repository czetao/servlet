package czt.inter;



import czt.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;


@WebServlet(name = "addInter")
public class addInter extends HttpServlet {

    private User buildUserDO(){
        User user = new User();
        user.setName("张三");
        user.setPassword("123");
        user.setAge("11");


        return user;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置网页响应类型
        System.out.println(1);
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        //阿里巴巴这个包有问题
       // String userJson = JSON.toJSONString(buildUserDO());

        //OutputStream out = response.getOutputStream();
        //out.write(userJson.getBytes("UTF-8"));
        PrintWriter out = response.getWriter();
        String str ="{\"姓名\":\"HaHa先生\",\"年龄\":\"18岁啦\"}";
        out.println(str);
        out.flush();
        System.out.println(2);

    }

}
