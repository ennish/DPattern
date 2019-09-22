package  com.enn.adaptor;
/**
 * 笔记本
 */
class Laptop{
    private LaptopDc laptopDC;
    public void chargeByDC(){
        //charge
        laptopDC = new LaptopChargerAdaptor();
        laptopDC.chargeByDC();
    }
}
