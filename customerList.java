package protect01;

public class customerList {
    private Customer[] customers;
    private int total;
    public customerList(int numberOfCustoemr){
        customers=new Customer[numberOfCustoemr];
    }
    public boolean add(Customer customer) {
        if (total>customers.length) {
            return false;
        } else {
            customers[total] = new Customer();
            customers[total] = customer;
            total++;
            return true;
        }
    }
    public boolean replace(int index){
        System.out.println("用户("+customers[index-1].getName()+"):");
        System.out.print("姓名:");
        String name = CMUtility.readString(10,customers[index-1].getName());
        System.out.print("年龄:");
        int age = CMUtility.readInt(customers[index-1].getAge());
        System.out.print("电话:");
        String phone = CMUtility.readString(15,customers[index-1].getPhone());
        System.out.print("邮箱:");
        String email = CMUtility.readString(100,customers[index-1].getEmail());
        customers[index-1].setName(name);
        customers[index-1].setAge(age);
        customers[index-1].setPhone(phone);
        customers[index-1].setEmail(email);
        return true;
    }
    public boolean delete(int index){
        System.out.println("用户("+customers[index-1].getName()+")");
        System.out.print("确定要删除此用户吗？");
        char chose = CMUtility.readConfirmSelection();
        if (chose == 'Y') {
           for(int i=index-1;i<total-1;i++){
               customers[i]=customers[i+1];
           }
            customers[total-1]=null;
            total--;
        }
        return true;
    }
    public Customer showPublic(){
        for(int i=0;i<total;i++){
            System.out.println("编号:"+(i+1)+"姓名:"+customers[i].getName()+"\t年龄"+customers[i].getAge()
            +"\t电话:"+customers[i].getPhone()+"\t邮箱:"+customers[i].getEmail());
        }
        return null;
    }
    public Customer showPrivate(int index){
        System.out.println("编号:"+(index)+"姓名:"+customers[index-1].getName()+"\t年龄"+customers[index-1].getAge()
                +"\t电话:"+customers[index-1].getPhone()+"\t邮箱:"+customers[index-1].getEmail());
        return null;
    }
}
