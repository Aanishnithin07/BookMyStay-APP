import java.util.*;


/**
 * =====================================================
 * MAIN CLASS - BookMyStayApp
 * =====================================================
 * Combines:
 * UC1 - Application Startup
 * UC2 - Room Domain Model
 * UC3 - Centralized Inventory
 * UC4 - Room Search
 * UC5 - Booking Request Queue
 * UC6 - Reservation Confirmation & Room Allocation
 * UC7 - Add-On Service Selection
 * UC8 - Booking History & Reporting
 *
 * @author  AANISH NITHIN A
 * @version 8.0
 */


/*-------------------------------------------------------
ABSTRACT CLASS : Room
-------------------------------------------------------*/
abstract class Room {


    private final String roomType;
    private final int beds;
    private final int size;
    private final double price;


    public Room(String roomType, int beds, int size, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
 * BookMyStayAPP.java
 * UC1: Application startup and welcome message.
 * UC2: Room modeling with abstract classes, inheritance, and static availability.
 * UC3: Centralized inventory management using HashMap.
 * UC4: Room search & availability check (read-only access).
 * UC5: Booking request intake using Queue (FIFO).
 * UC6: Reservation confirmation & room allocation with uniqueness enforcement.
 * UC7: Add-On Service Selection
 *
 * @author Aanish
 * @version 6.1
 * @version 5.1
 * @version 4.1
 *
 * @author Aanish
 * @version 7.1
 * @version 3.1
 */

import java.util.*;
// UC2: Abstract Room
abstract class Room {

    private final String roomType;
    private final int beds;
    private final double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }


    public String getRoomType() {
        return roomType;
    }


    public void displayRoomDetails() {
        System.out.println("Room Type    : " + roomType);
        System.out.println("Beds         : " + beds);
        System.out.println("Room Size    : " + size + " sq.ft");
        System.out.println("Price/Night  : ₹" + price);
    }
}


/*-------------------------------------------------------
ROOM TYPES
-------------------------------------------------------*/
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 200, 2000);
    }
}


class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 350, 3500);
    }
}


class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 600, 7000);
    }
}


/*-------------------------------------------------------
ROOM INVENTORY
-------------------------------------------------------*/
class RoomInventory {


    private final Map<String, Integer> inventory;


    public RoomInventory() {


        inventory = new HashMap<>();


        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }


    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }


    public void decrementRoom(String roomType) {


        int count = inventory.get(roomType);


        if (count > 0) {
            inventory.put(roomType, count - 1);
        }
    }


    public void displayInventory() {


        System.out.println("------------- CURRENT ROOM INVENTORY -------------");


        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Available : " + entry.getValue());
    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    public abstract void displayRoom();
}

// Single Room
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 1500);
    }

    public void displayRoom() {
        System.out.println("Single Room | Beds:1 | Price: ₹1500");
    }
}

// Double Room
class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 2500);
    }

    public void displayRoom() {
        System.out.println("Double Room | Beds:2 | Price: ₹2500");
    }
}

// Suite Room
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 5000);
    }

    public void displayRoom() {
        System.out.println("Suite Room | Beds:3 | Price: ₹5000");
    }
}

/// UC3: Room Inventory
class RoomInventory {

    private final Map<String,Integer> inventory = new HashMap<>();

    public void addRoom(String type,int count){
        inventory.put(type,count);
    }

    public int getAvailability(String type){
        return inventory.getOrDefault(type,0);
    }

    public void update(String type,int value){
        inventory.put(type,value);
    }

    public void display(){
        System.out.println("\nRoom Inventory");
        for(String key: inventory.keySet()){
            System.out.println(key+" -> "+inventory.get(key));
        }
    }
}

/// UC4: Search Service
class SearchService {

    private final RoomInventory inventory;

    public SearchService(RoomInventory inventory){
        this.inventory=inventory;
    }

    public void search(Room[] rooms){
        System.out.println("\nAvailable Rooms");

        for(Room r:rooms){

            int count=inventory.getAvailability(r.getRoomType());

            if(count>0){
                r.displayRoom();
                System.out.println("Available: "+count+"\n");
            }
        }


        System.out.println("--------------------------------------------------");
    }
}


/*-------------------------------------------------------
RESERVATION CLASS
-------------------------------------------------------*/
class Reservation {


    private final String guestName;
    private final String roomType;

/// UC5: Reservation
class Reservation {

    private final String guest;
    private final String roomType;

    public Reservation(String guest,String roomType){
        this.guest=guest;
        this.roomType=roomType;
    }


    public String getGuestName() {
        return guestName;
    }


    public String getRoomType() {
    public String getGuest(){
        return guest;
    }

    public String getRoomType(){
        return roomType;
    }
}


/*-------------------------------------------------------
BOOKING HISTORY (UC8)
-------------------------------------------------------*/
class BookingHistory {


    private final List<Reservation> history = new ArrayList<>();


    public void addReservation(Reservation r) {
        history.add(r);
    }


    public List<Reservation> getHistory() {
        return Collections.unmodifiableList(history);
    }
}


/*-------------------------------------------------------
BOOKING REPORT SERVICE
-------------------------------------------------------*/
class BookingReportService {


    public void generateReport(List<Reservation> reservations) {


        System.out.println("\n=========== BOOKING HISTORY REPORT ===========");


        Map<String,Integer> summary = new HashMap<>();


        for(Reservation r : reservations){


            System.out.println("Guest : " + r.getGuestName() +
                    " | Room : " + r.getRoomType());


            summary.put(
                    r.getRoomType(),
                    summary.getOrDefault(r.getRoomType(),0)+1
            );
        }


        System.out.println("\n--------- BOOKING SUMMARY ---------");


        for(Map.Entry<String,Integer> entry : summary.entrySet()){
            System.out.println(entry.getKey()+" Booked : "+entry.getValue());
        }


        System.out.println("-----------------------------------");
    }
}


/*-------------------------------------------------------
BOOKING REQUEST QUEUE
-------------------------------------------------------*/
class BookingRequestQueue {


    private final Queue<Reservation> queue;


    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }


    public void addRequest(Reservation reservation) {
        queue.add(reservation);
    }


    public Reservation getNextRequest() {
        return queue.poll();
/// Booking Queue
class BookingQueue{

    Queue<Reservation> queue=new LinkedList<>();

    public void add(Reservation r){
        queue.add(r);
        System.out.println("Request Added: "+r.getGuest());
    }

    public Queue<Reservation> getQueue(){
        return queue;
    }
}

/// UC6: Booking Service
class BookingService{

    private final RoomInventory inventory;

    Map<String,String> confirmedReservations=new HashMap<>();

    public BookingService(RoomInventory inventory){
        this.inventory=inventory;
    }

    public void process(BookingQueue bookingQueue){

        Queue<Reservation> q=bookingQueue.getQueue();

        while(!q.isEmpty()){

            Reservation r=q.poll();

            int available=inventory.getAvailability(r.getRoomType());

            if(available>0){

                String reservationId="RES-"+UUID.randomUUID().toString().substring(0,5);

                confirmedReservations.put(reservationId,r.getGuest());

                inventory.update(r.getRoomType(),available-1);

                System.out.println("CONFIRMED: "+r.getGuest()+" | "+reservationId);
            }

            else{

                System.out.println("FAILED: "+r.getGuest()+" | No Rooms");
            }
        }
    }

    public Set<String> getReservationIds(){
        return confirmedReservations.keySet();
    }
}


    public boolean isEmpty() {
        return queue.isEmpty();
    }
}


/*-------------------------------------------------------
ROOM ALLOCATION SERVICE
-------------------------------------------------------*/
class RoomAllocationService {


    private final Map<String, Set<String>> allocatedRooms;
    private final Set<String> usedRoomIds;


    public RoomAllocationService() {


        allocatedRooms = new HashMap<>();
        usedRoomIds = new HashSet<>();


        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.put("Double Room", new HashSet<>());
        allocatedRooms.put("Suite Room", new HashSet<>());
    }


    public void processBookings(
            BookingRequestQueue queue,
            RoomInventory inventory,
            BookingHistory history) {


        System.out.println("=================================================");
        System.out.println("        PROCESSING BOOKING REQUESTS (FIFO)       ");
        System.out.println("=================================================");


        while (!queue.isEmpty()) {


            Reservation request = queue.getNextRequest();


            String roomType = request.getRoomType();
            String guest = request.getGuestName();


            if (inventory.getAvailability(roomType) > 0) {


                String roomId = generateRoomId(roomType);


                allocatedRooms.get(roomType).add(roomId);
                usedRoomIds.add(roomId);


                inventory.decrementRoom(roomType);


                System.out.println("Reservation Confirmed");
                System.out.println("Guest  : " + guest);
                System.out.println("Room   : " + roomType);
                System.out.println("RoomID : " + roomId);
                System.out.println("---------------------------------------");


                /* UC8 - Store booking in history */
                history.addReservation(request);


            } else {


                System.out.println("Reservation Failed (No Rooms Available)");
                System.out.println("Guest : " + guest);
                System.out.println("---------------------------------------");
/// UC7: Add-on Service
class Service{

    String name;
    double price;

    public Service(String name,double price){
        this.name=name;
        this.price=price;
    }
}

/// Add-on Manager
class AddOnManager{

    Map<String,List<Service>> map=new HashMap<>();

    public void addService(String reservationId,Service s){

        map.putIfAbsent(reservationId,new ArrayList<>());

        map.get(reservationId).add(s);

        System.out.println("Added "+s.name+" to "+reservationId);
    }

    public void showServices(String reservationId){

        System.out.println("\nServices for "+reservationId);

        double total=0;

        if(map.containsKey(reservationId)){

            for(Service s:map.get(reservationId)){

                System.out.println(s.name+" ₹"+s.price);

                total+=s.price;
            }
        }


    private String generateRoomId(String roomType) {


        String prefix = roomType.replace(" ", "").substring(0,2).toUpperCase();
        String roomId;


        do {
            roomId = prefix + (int)(Math.random() * 1000);
        }
        while (usedRoomIds.contains(roomId));


        return roomId;
    }
}


/*-------------------------------------------------------
ADD ON SERVICE (UC7)
-------------------------------------------------------*/
record AddOnService(String serviceName, double cost) {


}


/*-------------------------------------------------------
ADD ON SERVICE MANAGER
-------------------------------------------------------*/
class AddOnServiceManager{


    private final Map<String,List<AddOnService>> services=new HashMap<>();


    public void addService(String reservationId,AddOnService service){


        services
                .computeIfAbsent(reservationId,k->new ArrayList<>())
                .add(service);
    }


    public void displayServices(String reservationId){


        List<AddOnService> list=services.get(reservationId);


        if(list==null){
            System.out.println("No Add-On Services Selected");
            return;
        }


        double total=0;


        System.out.println("\nAdd-On Services for "+reservationId);


        for(AddOnService s:list){


            System.out.println(s.serviceName()+" : ₹"+s.cost());
            total+=s.cost();
        }


        System.out.println("Total Add-On Cost : ₹"+total);
    }
}


/*-------------------------------------------------------
MAIN APPLICATION
-------------------------------------------------------*/
public class BookMyStayApp {


    public static void main(String[] args) {


        System.out.println("=================================================");
        System.out.println("                BOOK MY STAY APP                 ");
        System.out.println("=================================================");
        System.out.println("                 Version : 8.0                   ");
        System.out.println("    Status  : Application Started Successfully   ");
        System.out.println();
        System.out.println("=================================================");


        System.out.println("Extra Cost: ₹"+total);
    }
}

/// Main Application
public class BookMyStayAPP{

    public static void main(String[] args){

        System.out.println("=======================================");
        System.out.println("   Welcome to Book My Stay App!");
        System.out.println("   Hotel Booking Management System V7.1");
        System.out.println("=======================================n");

        // UC2 Rooms
        Room single=new SingleRoom();
        Room dbl=new DoubleRoom();
        Room suite=new SuiteRoom();

        Room[] rooms={single,dbl,suite};

        // UC3 Inventory
        RoomInventory inventory=new RoomInventory();

        inventory.addRoom("Single Room",2);
        inventory.addRoom("Double Room",1);
        inventory.addRoom("Suite Room",0);

        inventory.display();

        // UC4 Search
        SearchService search=new SearchService(inventory);

        search.search(rooms);

        // UC5 Booking Queue
        BookingQueue queue=new BookingQueue();

        queue.add(new Reservation("Alice","Single Room"));
        queue.add(new Reservation("Bob","Double Room"));
        queue.add(new Reservation("Charlie","Suite Room"));

        // UC6 Booking Process
        BookingService booking=new BookingService(inventory);

        booking.process(queue);

        // UC7 Add-On Services
        AddOnManager manager=new AddOnManager();

        Service breakfast=new Service("Breakfast",500);
        Service spa=new Service("Spa",2000);

        for(String id: booking.getReservationIds()){

            manager.addService(id,breakfast);

            manager.addService(id,spa);

            manager.showServices(id);
        }

        inventory.display();
        System.out.println("   Hotel Booking Management System v6.1");
        System.out.println("   Hotel Booking Management System v5.1");
        System.out.println("   Hotel Booking Management System v4.1");
        System.out.println("   Hotel Booking Management System v3.1");
        System.out.println("=======================================\n");

        // UC2: Initialize room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();
        Room[] rooms = { single, doubleRoom, suite };

        // UC3: Centralized Inventory
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingHistory history = new BookingHistory();


        queue.addRequest(new Reservation("Ajay", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Double Room"));
        queue.addRequest(new Reservation("Priya", "Suite Room"));
        queue.addRequest(new Reservation("Arun", "Single Room"));


        RoomAllocationService allocationService = new RoomAllocationService();


        allocationService.processBookings(queue, inventory, history);


        System.out.println();
        // Final inventory state
        // Search again after update
        searchService.searchAvailableRooms(rooms);
        single.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suite.displayRoomDetails();

        // UC3: Centralized Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType(single.getRoomType(), 5);
        inventory.addRoomType(doubleRoom.getRoomType(), 3);
        inventory.addRoomType(suite.getRoomType(), 2);

        // Display inventory
        inventory.displayInventory();

        // Example update
        inventory.updateAvailability("Single Room", 4);
        System.out.println("\nAfter booking one Single Room:");
        inventory.displayInventory();


        /* UC7 Add On Services */


        AddOnServiceManager serviceManager = new AddOnServiceManager();


        serviceManager.addService("RES101",new AddOnService("Breakfast",500));
        serviceManager.addService("RES101",new AddOnService("Airport Pickup",1200));
        serviceManager.addService("RES101",new AddOnService("Spa",2000));


        serviceManager.displayServices("RES101");


        /* UC8 Booking Report */


        BookingReportService reportService = new BookingReportService();


        reportService.generateReport(history.getHistory());
    }
}

