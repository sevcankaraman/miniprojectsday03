package biletRezervasyon;

public class Bilet {
    //mesafe,yolculuk tipi,fiyat,koltuk no
    public double distance;
    public int typeNo;
    public double price;
    public int seatNo;

    //5-bileti yazdıralım

    public void printBilet(Bus bus){

        System.out.println("toplam tutar: "+ this.price);
        System.out.println("-------------Bilet Detayı-------------");
        System.out.println("Otobüs plaka     :"+bus.numberPlate);
        System.out.println("mesafe           :"+this.distance);
        System.out.println("yolculuk tıpi    :"+ (this.typeNo==1 ? "tek yön" : "gidiş dönüş"));
        System.out.println("koltuk no        :"+this.seatNo);
        System.out.println("keyifli yolculuklar dileriz...");
    }
}
