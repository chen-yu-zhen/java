package protect01;

import java.util.Scanner;

public class customerView {
    public static void main(String[] args) {
        customerList func = new customerList(100);
        Scanner scan = new Scanner(System.in);
        Customer cyz = new Customer("cyz",21,"123456789","21244214");
        Customer lh = new Customer("lh",20,"987654321","124214");
        func.add(cyz);func.add(lh);
        while (true) {
            System.out.println("------------用户管理系统------------");
            System.out.println("           1.添 加 用 户            ");
            System.out.println("           2.删 除 用 户            ");
            System.out.println("           3.修 改 用 户            ");
            System.out.println("           4.用 户 列 表            ");
            System.out.println("           5.退       出            ");
            System.out.println("------------------------------------");
            int num = CMUtility.readMenuSelection();
            switch (num) {
                case '1': {
                    System.out.print("请输入用户名称:");
                    String name = scan.next();
                    System.out.print("请输入年龄:");
                    int age = scan.nextInt();
                    System.out.print("请输入电话:");
                    String phone = scan.next();
                    System.out.print("请输入邮箱:");
                    String email = scan.next();
                    Customer cust = new Customer(name, age, phone, email);
                    func.add(cust);
                    break;
                }
                case '2': {
                    System.out.print("请输入用户编号:");
                    int index = scan.nextInt();
                    func.delete(index);
                }
                break;
                case '3': {
                    System.out.print("请输入用户编号:");
                    int index = scan.nextInt();
                    func.replace(index);
                }
                break;
                case '4': {
                    System.out.println("------------用户列表-------------");
                    System.out.println("         1.显示全部用户           ");
                    System.out.println("         2.显 示 用 户            ");
                    System.out.println("         3.退       出            ");
                    System.out.println("---------------------------------");
                    int selete = CMUtility.readMenuSelection2();
                    switch (selete) {
                        case '1': {
                            func.showPublic();
                        }
                        break;
                        case '2': {
                            System.out.print("请输入用户编号:");
                            int index = scan.nextInt();
                            func.showPrivate(index);
                        }
                        break;
                        case '3': {
                            System.out.print("确定要退出吗(Y/N):");
                            char chose = CMUtility.readConfirmSelection();
                            if (chose == 'Y') {
                                return;
                            }
                        }
                        break;
                    }
                }
                break;
                case '5': {
                    System.out.print("确定要退出吗(Y/N):");
                    char chose = CMUtility.readConfirmSelection();
                    if (chose == 'Y') {
                        return;
                    }
                    break;
                }
            }
        }
    }
}
