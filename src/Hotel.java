import java.util.ArrayList;
import java.util.Scanner;

public class Hotel{
    Scanner input = new Scanner(System.in);
    private int totalRoomCount;
    private String hotelName;
    private int burger = 10;
    private int dessert = 15;
    private int fruits = 5;

    //Odalar için arraylist
    private ArrayList<Rooms> rooms;

    //Fatura ve servis ücretleri
    private int bill = 0;
    private final int FullService = 100;
    private final int HalfService = 80;
    private final int OnlyRoom = 60;

    //Oda tipleri
    private int r1 = 0;
    private int r2 = 0;
    private int r3 = 0;
    private int r4 = 0;
    private int r5 = 0;

    //Constructor
    public Hotel(String hotelName,int totalRoomCount){
        this.hotelName=hotelName;
        this.totalRoomCount=totalRoomCount;
    }

    //MÜŞTERİ GİRİŞİ
    public void CustomerEnterence() {

        System.out.println("Which type of room you would like to stay");
        System.out.println("1 to Normal Bed Room For 1");
        System.out.println("2 to Normal  Bed Room For 2");
        System.out.println("3 to Economic  Bed Room For 2");
        System.out.println("4 to Economic Bed Room For 4");
        System.out.println("5 to King Suite For 2");
        int s = input.nextInt();
        switch (s) {
            case 1:
                AddCustomer(1, rooms.get(r1));
                r1--;
                break;
            case 2:
                AddCustomer(2,rooms.get(r2));
                r2--;
                break;
            case 3:
                AddCustomer(2,rooms.get(r3));
                r3--;
                break;
            case 4:
                AddCustomer(4,rooms.get(r4));
                r4--;
                break;
            case 5:
                AddCustomer(2,rooms.get(r5));
                r5--;
                break;
            default:
                System.out.println("Choice is must be between 1-5!");
        }
    }

    //MÜŞTERİ EKLE (Fonksiyona kaç kişilik oda oldugunun sayısı ve oda gönderiliyor.)
    public void AddCustomer(int num, Rooms r){

        //Kaç adet oda arkadaşı olacagını aşagıda seçiyor.Şimdilik sayıyı 0 olarak atadım.
        int roomMateCount = 0;

        //Müşteri arraylisti oluştu
        ArrayList<Customer> list = new ArrayList<>();
        Customer c1; //Müşteri sınıfının c1 nesnesi

        char x = 'Y';
        while(x == 'Y'){
            System.out.println((roomMateCount+1) + ".person:");
            System.out.print("Name:");
            String name = input.nextLine();
            System.out.print("Surname:");
            String surname = input.nextLine();
            System.out.print("Age:");
            int age = input.nextInt();
            System.out.print("Job:");
            String job = input.nextLine();

            //Alınan bilgilerle yeni müşteri nesnesi oluşturuldu.
            c1 = new Customer(name,surname,age,job);

            //Servis tipleri seçiliyor. Ona göre faturaya eklenecek.
            System.out.print("Which service you prefer?:");
            System.out.println("1-Full service [100$]\n2-Half service [80$]\n3-Just room [60$]");
            int service = input.nextInt();

            //Seçilen faturaya göre fiyatlar
            while(true){
                if(service==1){
                    bill+=FullService;
                    break;
                }
                else if(service == 2){
                    bill+=HalfService;
                    break;
                }
                else if(service==3){
                    bill+=OnlyRoom;
                    break;
                }
                else{
                    System.out.println("Choice must be between 1-3");
                }
            }

            r.setBill(bill);

            //C1 Müşteri nesnesi listeye eklendi.
            list.add(c1);

            //Oda arkadaşı sayısı 1 arttı.
            roomMateCount++;

            System.out.print("Add more person? (Y/N):");
            String m = input.next();
            x = m.charAt(0);
            //Yukarıda Y/N sorusuna aldıgım cevabın ilk harfini aldım ve büyük harfe dönüştürdüm.
            x = Character.toUpperCase(x);

            //Oda arkadaşı sayısı fonksiyonda gönderilen sayıya eşit olursa x değişkeni 'N'ye çevriliyor.
            if(roomMateCount == num){
                x = 'N';
            }
        }

        ArrayList<Customer> roomMates = new ArrayList<>(list.size());

        r.setCustomers(roomMates);
        r.setS(Rooms.Status.nonavailable);
    }

    //Odaya Sipariş sistemi
    public void Order(){
        System.out.print("Please enter your room number:");
        String num = input.next();
        int choice;
        for(Rooms room: rooms){
            if(num.equals(room.getRoomNumber())){
                boolean e = true;
                while(e){
                    System.out.println("1-Burger[10$]\n2-Dessert[15$]\n3-Fruits[5$]\n4-Exit");
                    choice = input.nextInt();

                    switch (choice){
                        case 1:
                            bill+=burger;
                            break;
                        case 2:
                            bill+=dessert;
                            break;
                        case 3:
                            bill+=fruits;
                            break;
                        case 4:
                            room.setBill(bill);
                            e = false;
                            break;
                        default:
                            System.out.println("Choice must be between 1-4!");
                    }
                }
            }
        }
    }

    public void DisplayRooms() {

        for (Rooms room : rooms) {
            room.displayCustomers();
        }

    }

    public void DisplayCustomers() {
        for (Rooms room : rooms) {
            room.displayCustomers();
        }

    }



}