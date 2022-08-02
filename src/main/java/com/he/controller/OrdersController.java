package com.he.controller;


/*import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;*/
import com.he.config.AlipayConfig;
import com.he.pojo.Menus;
import com.he.pojo.Orders;
import com.he.pojo.Users;
import com.he.service.MenusService;
import com.he.service.OrdersService;
import com.he.service.UsersService;
import com.he.util.AlipayUtil;
import com.he.util.Constants;
import com.he.util.Pages;
import com.he.util.ShoppingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    @Qualifier("ordersService")
    private OrdersService ordersService;

    @Autowired
    @Qualifier("menusService")
    private MenusService menusService;

    @Autowired
    @Qualifier("usersService")
    private UsersService usersService;
//    @Autowired
//    @Qualifier("usersService")
//    private UsersService usersService;

    @RequestMapping("ordergetall")
    public String ordergetall(HttpServletRequest request) {
        request.getSession().removeAttribute("url");
        Pages pages = null;
        //总记录数
        int totalCount = 0;
        //当前页面页码数
        String currentPage = "1";
        //获取上一页还是下一页标识
        String s = "";
        //数据库操作页面
        String offset = "0";
        //前端页面总数
        Integer totalPages = null;
        //如果不为空则获取currentpage
        if (request.getParameter("currentPage") != null) {
            currentPage = request.getParameter("currentPage");
            totalCount = ordersService.pageCount();
            totalPages = totalCount / Constants.PAGE_SIZE;
            if (totalCount % Constants.PAGE_SIZE != 0) {
                totalPages++;
            }
            if (Integer.parseInt(currentPage) <= 0) {
                currentPage = "1";
            }
            if (Integer.parseInt(currentPage) > totalPages) {
                currentPage = "" + totalPages;
            }


            //设置offset
            if (request.getParameter("s") != null) {
                s = request.getParameter("s");
                if (s.equals("up")) {
                    offset = "" + ((Integer.parseInt(currentPage) - 1) * Constants.PAGE_SIZE);
                } else if (s.equals("down")) {
                    offset = "" + ((Integer.parseInt(currentPage) - 1) * Constants.PAGE_SIZE);
                    System.out.println(currentPage);
                } else if (s.equals("first")) {
                    offset = "0";
                } else if (s.equals("last")) {
                    offset = "" + (totalCount - (totalCount % Constants.PAGE_SIZE));
                } else {
                    System.out.println("错误");
                }
            } else {
                System.out.println("没设置offset");
            }
            pages = new Pages(currentPage, totalPages);
            request.setAttribute("pages", pages);
        } else {
            totalCount = ordersService.pageCount();
            totalPages = totalCount / Constants.PAGE_SIZE;
            if (ordersService.pageCount() % Constants.PAGE_SIZE != 0) {
                totalPages++;
            }
            pages = new Pages("1", totalPages);

            request.setAttribute("pages", pages);
        }

        //判断操作数据库页面是否突破限制
        if (Integer.parseInt(offset) <= 0) {
            offset = "0";
        }
        else if (Integer.parseInt(offset) > totalCount) {
            offset = "" + (totalCount - (totalCount % Constants.PAGE_SIZE));
            System.out.println(offset);
        }
        else if (Integer.parseInt(offset) == totalCount) {
            offset = "" + (totalCount - (totalCount % Constants.PAGE_SIZE) - Constants.PAGE_SIZE);
        }
        List<Orders> list = ordersService.pageListQueryAllByLimit(Integer.parseInt(offset), Constants.PAGE_SIZE);
        request.setAttribute("list", list);
        for (Orders orders : list) {
            System.out.println(orders);
        }
        System.out.println("offset=" + offset);
        System.out.println("currentPage=" + currentPage);

        return "/admin/order";
    }

    ///确认订单 确认则将deliverys设置为一否则删除
    @RequestMapping("OrderComfirm")
    public String OrderComfirm(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String reqtype = request.getParameter("reqtype");
        if (reqtype.equals("delivery")) {
            ordersService.updateOrdersDelivery(id);
        } else if (reqtype.equals("del")) {
            ordersService.deleteOrders(id);
        } else {
            System.out.println("错误");
        }
        System.out.println(request.getSession().getAttribute("url"));
        if (request.getSession().getAttribute("url")!=null&&request.getSession().getAttribute("url").toString().equals("http://localhost:8080/orders/pageListByDelivery")) {
            request.getSession().removeAttribute("url");
            return "redirect:/orders/pageListByDelivery";
        }
        else
            return "redirect:/orders/ordergetall";
    }

    @RequestMapping("order_search")
    public String order_searchs(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        List<Orders> list = null;
        Integer id = null;
        String menuname = null;
        String day1 = null;
        if (request.getParameter("userid") != null && (!request.getParameter("userid").equals(""))) {
            id = Integer.parseInt(request.getParameter("userid"));
            list = ordersService.pageListByID(id);
        } else if (request.getParameter("menuname") != null && (!request.getParameter("menuname").equals(""))) {
            menuname = request.getParameter("menuname");
            list = ordersService.pageListByMenus(menuname);
        } else if (request.getParameter("date") != null && (!request.getParameter("date").equals(""))) {
            day1 = request.getParameter("date");
            Integer a = Integer.parseInt(day1.substring(9, 10));//天
            String aa = "" + (a + 1);
            StringBuilder day = new StringBuilder(day1);
            day.replace(9, 10, aa);
            String day2 = day.toString();
            list = ordersService.pageListByDate(day1, day2);
        } else {
            System.out.println("未提交");
        }
        request.getSession().setAttribute("ordersearch", list);
        return "/admin/order_search";
    }

    @RequestMapping("pageListByDelivery")
    public String pageListByDelivery(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        request.getSession().setAttribute("url",url);
        System.out.println(request.getSession().getAttribute("url"));
        request.removeAttribute("pages");
        Pages pages = null;
        //总记录数
        int totalCount = 0;
        //当前页面页码数
        String currentPage = "1";
        //获取上一页还是下一页标识
        String s = "";
        //数据库操作页面
        String offset = "0";
        //前端页面总数
        Integer totalPages = null;
        //如果不为空则获取currentpage
        if (request.getParameter("currentPage") != null) {
            currentPage = request.getParameter("currentPage");
            totalCount = ordersService.pageCountDelivery();
            totalPages = totalCount / Constants.PAGE_SIZE;
            if (totalCount % Constants.PAGE_SIZE != 0) {
                totalPages++;
            }
            if (Integer.parseInt(currentPage) <= 0) {
                currentPage = "1";
            }
            if (Integer.parseInt(currentPage) > totalPages) {
                currentPage = "" + totalPages;
            }


            //设置offset
            if (request.getParameter("s") != null) {
                s = request.getParameter("s");
                if (s.equals("up")) {
                    offset = "" + ((Integer.parseInt(currentPage) - 1) * Constants.PAGE_SIZE);
                } else if (s.equals("down")) {
                    offset = "" + ((Integer.parseInt(currentPage) - 1) * Constants.PAGE_SIZE);
                    System.out.println(currentPage);
                } else if (s.equals("first")) {
                    offset = "0";
                } else if (s.equals("last")) {
                    offset = "" + (totalCount - (totalCount % Constants.PAGE_SIZE));
                } else {
                    System.out.println("错误");
                }
            } else {
                System.out.println("没设置offset");
            }
            pages = new Pages(currentPage, totalPages);
            request.setAttribute("pages", pages);
        } else {
            totalCount = ordersService.pageCountDelivery();
            totalPages = totalCount / Constants.PAGE_SIZE;
            if (ordersService.pageCount() % Constants.PAGE_SIZE != 0) {
                totalPages++;
            }
            pages = new Pages("1", totalPages);

            request.setAttribute("pages", pages);
        }

        //判断操作数据库页面是否突破限制
        if (Integer.parseInt(offset) <= 0) {
            offset = "0";
        }
        else if (Integer.parseInt(offset) > totalCount) {
            offset = "" + (totalCount - (totalCount % Constants.PAGE_SIZE));
            System.out.println(offset);
        }
        else if (Integer.parseInt(offset) == totalCount) {
            offset = "" + (totalCount - (totalCount % Constants.PAGE_SIZE) - Constants.PAGE_SIZE);
        }
        List<Orders> list = ordersService.pageListByDelivery(Integer.parseInt(offset), Constants.PAGE_SIZE);
        request.setAttribute("list", list);
        for (Orders orders : list) {
            System.out.println(orders);
        }
        System.out.println("offset=" + offset);
        System.out.println("currentPage=" + currentPage);
        return "/admin/orderByDelivery";
    }

    //跳转到statistic页面
    @RequestMapping("order_statistic")
    public String order_statistic(HttpServletRequest request) throws UnsupportedEncodingException {
        List<Orders> list = null;
        request.setCharacterEncoding("utf-8");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String day1 = formatter.format(date);
        Integer a = Integer.parseInt(day1.substring(9, 10));
        String aa = "" + (a + 1);
        StringBuilder day = new StringBuilder(day1);
        day.replace(9, 10, aa);
        String day2 = day.toString();
        list = ordersService.pageListByDate(day1, day2);
        request.getSession().setAttribute("orderstatistic", list);
        return "/admin/order_statistic";
    }


    //个人订单
    @RequestMapping("queryOrdersById")
    public String queryOrdersById(HttpSession session, HttpServletRequest request) {
        Users user = (Users) session.getAttribute(Constants.USER_SESSION);
        System.out.println(user);
        List<Orders> orders = ordersService.pageListByID(user.getId());
        request.setAttribute("ordersearch", orders);
        return "/qiantai/order";
    }

    @RequestMapping("queryOrdersById/{delivery}")
    public String queryOrdersByIdAndDelivery(@PathVariable int delivery, HttpSession session, HttpServletRequest request) {
        System.out.println(delivery);
        Users user = (Users) session.getAttribute(Constants.USER_SESSION);
        List<Orders> orders = ordersService.queryOrdersByIdAndDelivery(user.getId(),delivery);
        System.out.println(orders);
        request.setAttribute("ordersearch", orders);
        return "/qiantai/order";
    }

    //放入购物车
    @RequestMapping("order_addshoppingcar/{menuId}")
    public String order_addshoppingcar(@PathVariable("menuId") Integer menuId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("menuId"+menuId);
        Integer sum = (Integer) session.getAttribute("sum");
        if (sum == null) {
            sum = 1;
            session.setAttribute("sum", sum);
        }
        Menus menus = menusService.queryById(menuId);
        String name = menus.getName();
        float price1 = menus.getPrice1();
        List<ShoppingCar> shoppingCars = new ArrayList<>();
        if (session.getAttribute("shoppingcar") != null) {
            shoppingCars = (List<ShoppingCar>) session.getAttribute("shoppingcar");
            for (ShoppingCar shoppingCar : shoppingCars) {
                if (name.equals(shoppingCar.getName())){
                    sum =shoppingCar.getSums()+1;
                    shoppingCars.remove(shoppingCar);
                    break;
                }
            }
            shoppingCars.add(new ShoppingCar(menuId,name,price1,sum));
            session.setAttribute("shoppingcar",shoppingCars);
        }else{
            shoppingCars.add(new ShoppingCar(menuId,name,price1,sum));
            session.setAttribute("shoppingcar",shoppingCars);
        }

        return "redirect:/menus/qiantai/allMenus";
    }

    //提交或取消订单
    @RequestMapping("order_addShoppingCartoOrder")
    public String order_addShoppingCartoOrder(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<ShoppingCar> shoppingcars = (List<ShoppingCar>) session.getAttribute("shoppingcar");
        if (session.getAttribute(Constants.USER_SESSION)!=null){
            Users user = (Users) session.getAttribute(Constants.USER_SESSION);
            Integer userid = user.getId();
            String name = user.getName();
            Integer delivery = 0;
            String remove = request.getParameter("remove");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            String day = formatter.format(date);
            Integer id = null;
            if (shoppingcars !=null){
                for (ShoppingCar shoppingcar : shoppingcars) {
                    Integer sums = shoppingcar.getSums();
                    Integer menuid = shoppingcar.getId();
                    Orders order = new Orders(userid, menuid, sums, day, delivery);
                    int i = ordersService.insertOrders(order);
                }
//                //商户订单号，商户网站订单系统中唯一订单号，必填
//                String orderId = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//                //付款金额，必填
//                String money = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
//                //订单名称，必填
//                String name = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
//                //商品描述，可空
//                String info = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");

                try {
//                    String result = AlipayUtil.pay(response, 1, 1, 1, 22222);
//                    request.setAttribute("result", result);
//                    System.out.println(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                session.removeAttribute("shoppingcar");
            }

            if(remove!=null) {
                if (remove.equals("1")) {
                    session.removeAttribute("shoppingcar");
                }
            }
        }else{
            return "redirect:../public/qiantai/login.jsp";
        }
        return "redirect:/menus/qiantai/allMenus";
    }


    //购物车单个取消
    @RequestMapping("order_shoppingcardel")
    public String order_shoppingcardel(HttpServletRequest request){
        HttpSession session=request.getSession();
        List<ShoppingCar> shoppingCarts=(List<ShoppingCar>)session.getAttribute("shoppingcar");
        Integer id=Integer.parseInt(request.getParameter("del"));
        Integer i=0;
        for (ShoppingCar shoppingCar:shoppingCarts) {
            if(i.equals(id)){
                shoppingCarts.remove(shoppingCar);
                break;
            }
            i++;
        }
        return "redirect:/menus/qiantai/allMenus";
    }
 /*   @RequestMapping("alipaySum")
    public Object alipayIumpSum(Model model, String payables, String subject, String body, HttpServletResponse response)
            throws Exception {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
                AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = sdf.format(new Date());
        // 付款金额，必填
        String total_amount = payables.replace(",", "");
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
                + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        // 请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        // System.out.println(result);
        AlipayConfig.logResult(result);// 记录支付日志
        response.setContentType("text/html; charset=gbk");
        PrintWriter out = response.getWriter();
        out.print(result);
        return "qiantai/hello";
    }*/
}
