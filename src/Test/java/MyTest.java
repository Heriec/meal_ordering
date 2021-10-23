import com.he.pojo.Admin;
import com.he.pojo.Menus;
import com.he.pojo.Orders;
import com.he.service.AdminService;
import com.he.service.MenusService;
import com.he.service.OrdersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = context.getBean("adminService", AdminService.class);
        Admin sa = adminService.queryByName("sa");
        System.out.println(sa);
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = context.getBean("adminService", AdminService.class);
        List<Admin> admins = adminService.queryAllByLimit(1, 10);
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenusService menusService = context.getBean("menusService", MenusService.class);
        List<Menus> menus = menusService.queryAllMenus();
        for (Menus menu : menus) {
            System.out.println(menu);
        }
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenusService menusService = context.getBean("menusService", MenusService.class);
        menusService.insertMenus(new Menus(30, "zz", "炒菜", "1w", "12", 21, 21, 21, 21, null));
    }

    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenusService menusService = context.getBean("menusService", MenusService.class);
        menusService.updateMenus(new Menus(29, "zz", "川菜", "1w", "12", 21, 21, 21, 21, null));
    }

    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersService ordersService = context.getBean("ordersService", OrdersService.class);

    }
}