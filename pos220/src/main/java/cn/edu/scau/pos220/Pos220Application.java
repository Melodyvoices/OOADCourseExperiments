package cn.edu.scau.pos220;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class Pos220Application {
    public static void main(String[] args) {
        //启动Swing界面 OOAD课程使用
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
        SpringApplication.run(Pos220Application.class, args);
    }

}