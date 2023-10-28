package edu.jlu.MyProperties;

import java.util.ResourceBundle;

public class TestProperties {
    public static void main(String[] args) {
        First();
    }

    public static void First() {

        // 资源绑定器是放在类的路径下,必须以properties结尾,填写相对于类路径下的文件名
        ResourceBundle bundle = ResourceBundle.getBundle("TestProperties");
        System.out.println(bundle.getString("className"));
    }
}
