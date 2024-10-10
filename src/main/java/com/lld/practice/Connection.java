package com.lld.practice;

public class Connection {

    private static Connection obj;

    private Connection(){

    }

    public static Connection getConnectionObj()
    {
        if(obj==null){
        synchronized (Connection.class){
        if(obj==null)
        {
            obj=new Connection();
        }
        }
        }
        return obj;
    }
}
