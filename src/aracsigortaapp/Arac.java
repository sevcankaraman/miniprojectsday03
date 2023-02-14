package aracsigortaapp;

import java.util.Scanner;

public class Arac {
    //tipi , primi

    public String type; // field/ feature/ ozellık
    public int prim;

    public void countPrim(int term) {
        switch (this.type) {
            case "otomobil":
                this.prim=term==1 ? 2000 : 2500;
                break;
            case "kamyon":
                this.prim=term==1 ? 3000 : 3500;
                break;
            case "motosiklet":
                this.prim=term==1 ? 1500 : 1750;
                break;
            case "otobüs":
                countPrimBus(term);
                break;
            default:
                System.out.println("hatalı gırıs!!!");
                this.prim=0;
                break;

        }

    }
    private void countPrimBus(int term){
        Scanner input=new Scanner(System.in);
        System.out.println("otobüs tipini giriniz: ");
        System.out.println("1.18-30 koltuk");
        System.out.println("2.30 koltuk veya üstü");
        int busType=input.nextInt();
        switch (busType){
            case 1:
                this.prim=term==1 ? 4000 : 5000;
                break;
            case 2:
                this.prim=term==1 ? 5000 : 5500;
                break;
            default:
                System.out.println("hatalı gırıs");
                this.prim=0;
                break;
        }

    }
}