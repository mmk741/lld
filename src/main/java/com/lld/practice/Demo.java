package com.lld.practice;

public class Demo {
    private static Demo demo;
   private Demo(){

    }

    public  static Demo getInstance(){

       if(demo==null){
       synchronized (Demo.class){
           if(demo==null)
           {
               demo=new Demo();
           }
       }
       }

      return demo;
    }

}
