package biletRezervasyon;

import java.util.Scanner;

public class BiletRezervasyon {
    /*
    Project: mesafeye ve şartlara göre otobüs bileti fiyatı hesaplayan uygulama
    Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
    koltuk no  bilgilerini alın.
    Mesafe başına ücret 1 Lira / km olarak alın.(Gidiş-Dönüş için *2)
    Tekli Koltuk ücreti:Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 daha fazladır(1.2 Lira).
    İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;

    Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
    Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

            1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
            2-Yaş indirimi:
    Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
    Kişi 13-24 yaşları arasında ise son bilet fiyatı üzerinden %10 indirim uygulanır.
    Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.


            */

    public static void main(String[] args) {
        //1-bilet rezervasyonu için otobüs objesi olusturalım
        Bus bus=new Bus("34 ASD 78");//"1","2"....
        //4-bilet objesi olusturalım
        Bilet bilet =new Bilet();
        start(bus,bilet);

    }
    public static void start(Bus bus,Bilet bilet){
        Scanner scan=new Scanner(System.in);
        int select;
        do {
            //6-kullanıcıdan bilgileri alalım
            System.out.println("bilet rezervasyon sistemine hosgeldınız...");
            System.out.println("lütfen gidilecek mesafe bilgisini km olarak giriniz: ");
            double distance =scan.nextDouble();
            System.out.println("lütfen yolculuk tipini seciniz: ");
            System.out.println("1.tek yön");
            System.out.println("2.gidis-dönüş");
            int type=scan.nextInt();
            System.out.println("lütfen yasınızı giriniz: ");
            int age=scan.nextInt();
            System.out.println("lütfen koltuk no seciniz: ");
            System.out.println("tekli koltuk ucreti %20 daha fazladır..");
            System.out.println(bus.seats);
            int seat=scan.nextInt();
            //7-seçilen koltuk no yu listeden kaldıralım.
            bus.seats.remove(String.valueOf(seat));//"3"->"1","2","4"
            //8-kullanıcıdan alınan degerler gecerli mi?
            boolean check=type==1 || type ==2;
            if(distance>0 && age>0 && check){
                // 9-bilet fiyatını hesaplayalım
                bilet.distance=distance;
                bilet.typeNo=type;
                bilet.seatNo=seat;
                //getTotal ile bilet price ı set edelım
                bilet.price=getTotal(bilet,age);
                //bileti yazdıralım
                System.out.println("--------------------------------------");
                bilet.printBilet(bus);

            }else{
                System.out.println("hatalı giriş yaptınız!");
            }
            System.out.println("yeni işlem için herhangı bır sayı gırın cıkıs ıcın 0 gırınız: ");
            select=scan.nextInt();


        }while(select!=0);
        System.out.println();
    }
    private static double getTotal(Bilet bilet,int age) {
        double dist = bilet.distance;
        int type = bilet.typeNo;
        int seat = bilet.seatNo;
        double total = 0;
        switch (type) {
            case 1:
                if (seat % 3 == 0) {
                    total = dist * 1.2;
                } else {
                    total = dist * 1;
                }
                System.out.println("tutar: " + total);
                break;
            case 2:
                if (seat % 3 == 0) {
                    total = dist * 2.4;
                } else {
                    total = dist * 2;
                }
                System.out.println("tutar: " + total);
                total = total * 0.8;
                System.out.println("çift yön ve indirimli tutar: " + total);
                break;
        }
        if (age < 12) {
            total = total * 0.5;
            System.out.println("yas ındırımlı tutar: " + total);
        } else if (age > 13 && age > 24) {
            total = total * 0.9;
            System.out.println("yas indirimli tutar: " + total);

        } else if (age > 65) {
            total = total * 0.7;
            System.out.println("yas indirimli tutar: " + total);
        }
        return total;
    }
}
