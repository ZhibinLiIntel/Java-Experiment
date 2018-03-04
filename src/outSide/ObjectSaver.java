package outSide;

import java.io.*;
import java.util.Date;

public class ObjectSaver {
    public static void main(String[] args) throws Exception {
        /*���е�  D:\\objectFile.obj ��ʾ������л�������ļ�*/

        
        //���л�����
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\objectFile.obj"));
        Customer customer = new Customer("������", 24);    
        out.writeObject("���!");    //д������ֵ����
        out.writeObject(new Date());    //д������Date����
        out.writeObject(customer);    //д��customer����
        out.close();

        
        //�����л�����
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\objectFile.obj"));
        System.out.println("obj1 " + (String) in.readObject());    //��ȡ����ֵ����
        System.out.println("obj2 " + (Date) in.readObject());    //��ȡ����Date����
        Customer obj3 = (Customer) in.readObject();    //��ȡcustomer����
        System.out.println("obj3 " + obj3);
        in.close();
    }
}

class Customer implements Serializable {
    private String name;
    private int age;
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}