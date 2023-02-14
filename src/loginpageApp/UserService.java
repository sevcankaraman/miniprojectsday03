package loginpageApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//5- User objesiyle ilgili işlemler
public class UserService {
    //6- kullanıcı bilgilerini tutmak için list olusturalım

    List<User>userList=new ArrayList<>();

   //7-tüm methodlarda kullanıcıdan bilgi almak icin scanner objesı olustur
    Scanner inp=new Scanner(System.in);

    //8-username veya email ile kayıtlı userı getırme

    private User getUser(String usernameOrEmail){
        for (User user:userList){
            if (user.getUsername().equals(usernameOrEmail)){
                return user;
            } else if (user.getEmail().equals(usernameOrEmail)) {
                return user;
            }
        }
        return null;
    }
    //9-email validation =gecerlilik
    private static boolean validateEmail(String email){
        boolean isValid;
        boolean isExistsSpace=email.contains(" ");
        boolean isContainsAt=email.contains("@");
        if(isExistsSpace){
            System.out.println("Email boşluk içeremez!");
            isValid=false;
        }else if(!isContainsAt){
            System.out.println("Email @ sembolünü içermelidir.");
            isValid=false;
        }else{//asd@gmail@@com->[asd,gmail,com,]
            String firstPart=email.split("@")[0];//asd@mail.com->["asd","mail.com"]
            String secondPart=email.split("@")[1];//gmail.com

            boolean valid= firstPart.replaceAll("[a-zA-Z0-9_.-]","").isEmpty();
            boolean checkStart=valid && firstPart.length()>0;

            boolean checkEnd=secondPart.equals("gmail.com") ||
                    secondPart.equals("hotmail.com") ||
                    secondPart.equals("yahoo.com");
            if(!checkStart) {
                System.out.println("Mailin kullanıcı adı bölümü en az bir karakter içermelidir ve " +
                        "sadece küçük-büyük harf,rakam veya -._ içerebilir.");
            }
            if (!checkEnd){
                System.out.println("email gmail.com, hotmail.com veya yahoo.com ile bitmelidir!");
            }
            isValid=checkStart && checkEnd;
        }
        if(!isValid){
            System.out.println("Tekrar deneyiniz.");
        }
        return isValid;
    }
// 10-password validation
    private  static boolean validatePassword(String password){
        boolean isValid;
        boolean isExistsSpace=password.contains(" ");
        boolean isLengthGtSix=password.length()>=6;
        boolean isExistsUpperLetter=password.replaceAll("[^A-Z]","").length()>0;
        boolean isExistsLowerLetter=password.replaceAll("[^a-z]","").length()>0;
        boolean isExistsDigit=password.replaceAll("[\\D]","").length()>0;
        boolean isExistsSymbol=password.replaceAll("[\\P{Punct}]","").length()>0;

        if (isExistsSpace){
            System.out.println("şifre boşluk ıceremez");

        }else if (!isLengthGtSix){
            System.out.println("şifre en az 6 karakter içermelidir");

        } else if (isExistsUpperLetter) {
            System.out.println("şifre en az bir tane buyuk harf içermelidir");

        } else if (isExistsLowerLetter) {
            System.out.println("şifre en az bir tane kucukharf içermelidir");

        } else if (isExistsDigit) {
            System.out.println("şifre en az bir tane rakam içermelidir");

        } else if (isExistsSymbol) {
            System.out.println("şifre en az bir tane sembol içermelidir");

        }
        isValid=isExistsSpace && isExistsUpperLetter && isExistsLowerLetter && isExistsDigit && isExistsSymbol && isLengthGtSix;
        if (!isValid){
            System.out.println("gecersiz giriş");
        }

        return isValid;


    }

    public void register(){
        System.out.println("Ad-Soyad: ");
        String name=inp.nextLine();
//10-username unique/eşsiz olmalı
        String username=getUserName();
    }

    //10-a-kullanıcıdan userName alma
    private String getUserName(){
        String username;
        boolean existsUsername;
        do {
            System.out.println("Kullanıcı adı giriniz:");
            username=inp.next();
            existsUsername=getUser(username)!=null;
            if (existsUsername){
                System.out.println("bu username kullanılmıs, farklı bir username deneyınız.");
            }

        }while (existsUsername);
        return username;
    }

}
