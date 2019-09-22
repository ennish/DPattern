package com.enn.adaptor;

/**
 *  笔记本电源适配器，笔记本需要的是低压稳定直流电
 *  我们需要一个适配器（ChargerAdaptor）将插座
 *  的交流电转化为我们想要的直流电
 */
class LaptopChargerAdaptor implements LaptopDc {
    private  SocketAC socket;

    public LaptopChargerAdaptor(){
        socket = new  SocketAC();
    }

    @Override
    public Object chargeByDC(){

        Object object = socket.power();
        System.out.println("power in:"+(String) object);
        //整流***
        object = new String("DC");
        System.out.println("power out:"+(String)object);
        return object;
    }
}