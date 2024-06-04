package com.lld.behavorial.momento;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCareTaker {
    List<ConfigurationMomento> history=new ArrayList<>();

    void addMomento(ConfigurationMomento momento)
    {
        history.add(momento);
    }

    ConfigurationMomento undo(){
        if(!history.isEmpty()){
            int lastIndex=history.size()-1;
            ConfigurationMomento configurationMomento = history.get(lastIndex);
            history.remove(lastIndex);
            return configurationMomento;
        }
        return null;
    }
}
