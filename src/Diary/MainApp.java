package Diary;

import java.util.Scanner;

import static java.lang.System.exit;

public class MainApp {
    private static Diary diary ;
    private static final Diaries diaries = new Diaries();
    public static void main(String[] args) {
        mainMenu();
    }
    public static void print(String message){
        System.out.println(message);
    }

    public static String input(String prompt){
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }




    public static void mainMenu(){
        print("""
                Welcome to Mo's Diary App
                1 -> Create New Diary
                2 -> Delete Diary
                3 -> Create New Entry
                4 -> Delete Entry
                5 -> Update An Entry
                6 -> Find Diary
                7 -> Unlock Diary
                8 -> Lock Diary
                9 -> Exit
                
                
                """);
        String input = input("");
        switch (input.charAt(0)){
            case '1':
                createDiary();
                mainMenu();
                break;

            case '2':
                deleteDiary();
                break;

            case '3':
                createEntry();
                break;

            case '4':
                deleteEntry();
                break;

            case '5':
                updateEntry();
                break;

            case '6':
                findDiary();
                break;

            case '7':
                unlockDiary();
                break;

            case '8':
                lockDiary();
                break;

            case '9':
                exit(0);
                print("Thank you! We hope to see you again!!");
                break;

            default:
                print("Enter valid input");
                mainMenu();
        }



    }

    private static String setUsername(){
        return input("Please enter username: ");
    }

    private static String password(){
        return input("Please enter password");
    }

    private static void nullContingency(){
        print("Diary hasn't been created, create diary first");
        createDiary();

    }

    public static void createDiary() {
        String username = setUsername();
        String password = password();
        diaries.add(username,password);
        diary = diaries.findByUsername(username);

    }

    public static void deleteDiary() {

        try{
            diaries.delete(setUsername(),password());
            print("*****Diary Deleted Successfully*****");
        }catch (Exception message){
            print(message.getMessage());
        }finally {
            mainMenu();
        }
    }



    public static void createEntry() {
        if (diary == null)nullContingency();
        String title = input("Enter Title of Entry: ");
        String body =  input("Enter Body of Entry: ");
        try {
            if (diary.isLocked()) {
                diary.unlockDiary(password());
            }
            diary.createEntry(title,body);
            print("*****Entry Successfully Added*****");
            print("***************************");
            print(title);
            print(body);
            print("***************************");

        }catch (Exception message){
            print(message.getMessage());
        }finally {
            mainMenu();
        }
    }

    public static void deleteEntry() {
        if (diary == null)nullContingency();
        String entryId = input("Enter the id of the entry you'd like to delete: ");
        try {
            if (diary.isLocked()) {
                diary.unlockDiary(password());
            }
            diary.deleteEntry(Integer.parseInt(entryId));
            print("Entry successfully deleted ");

        }catch (Exception message){
            print(message.getMessage());
        }finally {
            mainMenu();
        }

    }

    public static void updateEntry() {
        if (diary == null)nullContingency();

        try {
            String entryId = input("Enter the id of the entry you'd like to update: ");
            String title = input("Enter new title: ");
            String body = input("Enter body of the entry: ");
            if (diary.isLocked()){
                diary.unlockDiary(password());
            }
            diary.updateEntry(Integer.parseInt(entryId),title,body);
            print("***************************");
            print("Entry successfully updated ");
            print("***************************");
            print(entryId);
            print(title);
            print(body);
            print("***************************");
        }catch (Exception message){
            print(message.getMessage());
        }finally {
            mainMenu();
        }

    }

    public static void findDiary() {
        try {
            diary = diaries.findByUsername(setUsername());
            print("Found the Diary! you may proceed to use now ");

        }catch (Exception message){
            print(message.getMessage());
        }finally {
            mainMenu();
            print("\n");
        }

    }

    public static void unlockDiary() {
        if (diary == null)nullContingency();
        try {
            diary.unlockDiary(password());
            print("Diary is unlocked you may now proceed to use!");
        }catch (Exception message){
            print(message.getMessage());
        }finally {
            mainMenu();
        }

    }

    public static void lockDiary() {
        if (diary == null)nullContingency();
        try {
            diary.lockDiary();
            print("Diary is locked!");
        }catch (Exception message){
            print(message.getMessage());
        }finally {
            mainMenu();
        }

    }
}
