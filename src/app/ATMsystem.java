package app;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMsystem {
    public static void main(String[] args) {
//      定义集合容器，存储账户进行业务操作
        ArrayList<Account> acounts = new ArrayList<Account>();
        while (true) {
//          ATM首页
          Scanner sc = new Scanner(System.in);
            System.out.println("===========ATM系统============");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出系统");
            System.out.println("请选择操作：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    //                登录系统操作
                    login(acounts, sc);
                    break;
                case 2:
                    //                注册系统操作
                    regist(acounts, sc);
                    break;
                case 3:
                    //                退出系统
                    System.out.println("感谢使用，欢迎下次使用");
                    System.exit(0);
                default:
                    System.out.println("您输入的命令有误，请重新输入");
            }
        }


    }

    /**
     * 登录功能
     *
     * @param acounts 账户对象集合
     * @param sc      扫描器
     */
    private static void login(ArrayList<Account> acounts, Scanner sc) {
        System.out.println("=============登录=============");
//      判断系统中是否有账户，若不存在登录功能无法开启
        if (acounts.size() == 0) {
            System.out.println("本系统未创建任何账户,请先注册后重试");
            return;
        }
//      正常登录
        while (true) {
            System.out.println("请输入登录卡号：");
            String carid = sc.next();
//          判断卡号是否存在，调用getacountcarid
            Account acc = getacountcarid(carid, acounts);
            if (acc != null) {
                //          卡号存在
                while (true) {
                    System.out.println("请输入密码：");
                    String PW = sc.next();
                    if (PW.equals(acc.getUserPW())) {
                        System.out.println("登录成功" + acc.getUsername() + "您好,欢迎使用本系统");
                        showlogin(acounts, sc, carid);
                    } else {
                        int a= 5;
                        System.out.println("密码错误请重新输入,剩余尝试次数：" + a);
                        a--;
                    }
                }
            } else {
                System.out.println("账号不存在，请检查后重试");
            }
        }
    }

    private static void showlogin(ArrayList<Account> acounts, Scanner sc, String carid) {
        System.out.println("=============用户操作=============");
        while (true) {
//          功能页面
            System.out.println("1.查询");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转帐");
            System.out.println("5.密码修改");
            System.out.println("6.返回首页");
            System.out.println("请选择操作：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    //                查询余额操作
                    howmoney(acounts, sc, carid);
                    break;
                case 2:
                    //                进行存款操作
                    setmoney(acounts, sc, carid);
                    break;
                case 3:
                    //                进行取款操作
                    getmoney(acounts, sc, carid);
                    break;
                case 4:
                    //                进行转账操作
                    transafe(acounts, sc, carid);
                    break;
                case 5:
                    //                修改密码操作
                    rname(acounts, sc, carid);
                    break;
                case 6:
                    //                退出系统
                    System.out.println("已退出账号，欢迎下次使用");
                    break;
                default:
                    System.out.println("您输入的命令有误，请重新输入");
            }
        }
    }

    /**
     * 查询操作界面
     *
     * @param acounts
     * @param sc
     * @param carid
     */
    private static void howmoney(ArrayList<Account> acounts, Scanner sc, String carid) {
        while (true) {
            System.out.println("=============查询操作=============");
            Account acc = getacountcarid(carid, acounts);
            System.out.println("用户名:" + acc.getUsername());
            System.out.println("卡号:" + acc.getCarid());
            System.out.println("余额:" + acc.getMoney());
            System.out.println("每日取款限额:" + acc.getQutomoney());
            System.out.println("1.返回上层");
            System.out.println("请输入操作:");
            int a = sc.nextInt();
            if (a == 1) {
                return;
            } else {
                System.out.println("输入有误重新输入");
            }
        }
    }

    /**
     * 存款操作界面
     *
     * @param acounts
     * @param sc
     * @param carid
     */
    private static void setmoney(ArrayList<Account> acounts, Scanner sc, String carid) {
        while (true) {
            System.out.println("=============存款操作=============");
            Account acc = getacountcarid(carid, acounts);
            System.out.println("用户名:" + acc.getUsername());
            System.out.println("卡号:" + acc.getCarid());
            System.out.println("余额:" + acc.getMoney());
            System.out.println("1.返回上层");
            System.out.println("请输入操作（回车存款）:");
            double a = sc.nextDouble();
            if (a == 1) {
                return;
            } else {
                System.out.println("本次存款:" + a + "请检查存款金额再次输入以确认:");
                double b = sc.nextDouble();
                if (a == b) {
                    acc.setMoney(acc.getMoney() + a);
                    System.out.println("存款成功，请仔细检查钞票数额,您的余额为:" + acc.getMoney());
                } else {
                    System.out.println("两次金额输入有误，请重新输入");
                }

            }
        }
    }

    /**
     * 取款操作界面
     *
     * @param acounts
     * @param sc
     * @param carid
     */
    private static void getmoney(ArrayList<Account> acounts, Scanner sc, String carid) {
        while (true) {
            System.out.println("=============取款操作=============");
            Account acc = getacountcarid(carid, acounts);
            System.out.println("用户名:" + acc.getUsername());
            System.out.println("卡号:" + acc.getCarid());
            System.out.println("余额:" + acc.getMoney());
            System.out.println("每日取款限额:" + acc.getQutomoney());
            System.out.println("1.返回上层");
            System.out.println("请输入操作（回车取款）:");
            double a = sc.nextDouble();
            if (a == 1) {
                return;
            } else {
                if (a <= acc.getQutomoney()) {
                    System.out.println("本次取款:" + a + "请检查取款金额再次输入以确认:");
                    double b = sc.nextDouble();
                    if (a == b) {
                        acc.setMoney(acc.getMoney() - a);
                        System.out.println("取款成功，请仔细检查钞票数额,您的余额为:" + acc.getMoney());
                    } else {
                        System.out.println("两次金额输入有误，请重新输入");
                    }
                } else {
                    System.out.println("输入有误，超出取款限额，请重新输入");
                }
            }
        }
    }

    /**
     * 转账操作界面
     *
     * @param acounts
     * @param sc
     * @param carid
     */
    private static void transafe(ArrayList<Account> acounts, Scanner sc, String carid) {
        System.out.println("=============转账操作=============");
        Account acc = getacountcarid(carid, acounts);
        System.out.println("用户名:" + acc.getUsername());
        System.out.println("卡号:" + acc.getCarid());
        System.out.println("余额:" + acc.getMoney());
        System.out.println("每日取款限额:" + acc.getQutomoney());
        System.out.println("1.返回上层");
        System.out.println("请输入操作（任意数字转账）:");
        double v = sc.nextDouble();
        if (v == 1) {
            return;
        } else {
            while (true) {
                System.out.println("请输入转账账户卡号:");
                String orderid = sc.next();
                Account order = getacountcarid(orderid, acounts);
                if (getacountcarid(orderid, acounts) == null) {
                    System.out.println("该用户未在本系统注册/卡号输入错误,暂无法转账,请检查后重试");

                } else {
                    System.out.println("请补全转账对象:");
                    String Sname = order.getUsername().substring(1);
                    System.out.println("*"+Sname);
                    String send = sc.next();
                    String okname = order.getUsername().substring(0, 1);
                    if (okname.equals(send)) {
                        System.out.println("请输入转账金额:");
                        double a = sc.nextInt();
                        if (a <= acc.getQutomoney()) {
                            if (a <= acc.getMoney()) {
                                System.out.println("本次转账:" + a + "请检查转账金额再次输入以确认:");
                                double b = sc.nextDouble();
                                if (a == b) {
                                    acc.setMoney(acc.getMoney() - a);
                                    order.setMoney(order.getMoney() + a);
                                    System.out.println("转账成功,您的余额为:" + acc.getMoney());
                                    break;
                                } else {
                                    System.out.println("两次金额输入有误，请重新输入");
                                }
                            } else {
                                System.out.println("余额不足,请检查后重试");
                            }
                            }
                             else {
                            System.out.println("输入有误，超出取款限额，请重新输入");
                        }
                    }
            }


            }
        }


    }

    /**
     * 修改密码界面
     *
     * @param acounts
     * @param sc
     * @param carid
     */
    private static void rname(ArrayList<Account> acounts, Scanner sc, String carid) {
        while (true) {
            System.out.println("=============密码修改=============");
            Account acc = getacountcarid(carid, acounts);
            System.out.println("用户名:" + acc.getUsername());
            System.out.println("卡号:" + acc.getCarid());
            System.out.println("1.返回上层");
            System.out.println("请输入操作（回车密码修改）:");
            double a = sc.nextDouble();
            if (a == 1) {
                return;
            } else {
                System.out.println("请输入原密码:");
                String CPW = sc.next();
                String rawPW = acc.getUserPW();
                if (CPW.equals(acc.getUserPW())) {
                    while (true) {
                        System.out.println("请输入新密码:");
                        String newPW = sc.next();
                        System.out.println("请再次输入新密码:");
                        String newokPW = sc.next();
                        if (newokPW.equals(newPW)) {
                            System.out.println("修改成功,请牢记密码");
                            acc.setUserPW(newokPW);
                            break;
                        } else {
                            System.out.println("两次密码输入不一致,请重新输入");
                        }
                    }
                } else {
                    System.out.println("密码错误,请检查后重试");
                }
            }
        }
    }


    /**
     * 注册功能实现方法
     *
     * @param acounts 接受账户信息。
     */
    private static void regist(ArrayList<Account> acounts, Scanner sc) {
        System.out.println("=============注册=============");
        Account account = new Account();
        System.out.println("请输入用户名：");
        String userName = sc.next();
        account.setUsername(userName);
        while (true) {
            System.out.println("请输入密码：");
            String userPW = sc.next();
            System.out.println("请再次确认密码：");
            String CuserPW = sc.next();
            if (CuserPW.equals(userPW)) {
                account.setUserPW(userPW);
                break;//验证成功，结束死循环
            } else {
                System.out.println("两次密码输入不一致，请重新输入");
            }
        }
        System.out.println("请设置账户每日限额(注意一经设置不可更改）：");
        double overmoney = sc.nextDouble();
        account.setQutomoney(overmoney);
//      随机生成8位卡号
        String carid = getRodomCarid(acounts);
        account.setCarid(carid);
//      录入信息
        acounts.add(account);
        System.out.println("注册成功," + userName + "先生/女士，你好！您的卡号为：" + carid);
    }

    /**
     * 为不同用户生成随机卡号
     *
     * @return
     */
    private static String getRodomCarid(ArrayList<Account> accounts) {
        Random r = new Random();
        while (true) {
            String carid = "";
            for (int i = 0; i < 8; i++) {
                carid += r.nextInt(10);
            }
            //判断新卡号是否与已注册用户冲突
            Account acc = getacountcarid(carid, accounts);
            if (acc == null) {
//          查无此人可以使用卡号
                return carid;
            }
        }

    }

    /**
     * 根据卡号查询对象
     *
     * @param carid    卡号
     * @param accounts 账户集合
     * @return 账户对象 null
     */
    private static Account getacountcarid(String carid, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCarid().equals(carid)) {
                return acc;
            }
        }
        return null;
    }
}
