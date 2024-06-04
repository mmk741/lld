package com.lld.behavorial.momento;

public class ConfigurationOrignator {
    int height;
    int width;

    public ConfigurationOrignator(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    ConfigurationMomento createMomento(){
        return new ConfigurationMomento(this.height,this.width);
    }

    void restoreMomento(ConfigurationMomento configurationMomento)
    {
        this.height=configurationMomento.height;
        this.width=configurationMomento.width;
    }
}
