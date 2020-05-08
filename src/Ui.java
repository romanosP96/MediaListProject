import java.util.Scanner;

public class Ui {

    public Choice menu(){
        Choice returnChoice;
        System.out.println("1.Add media to your List \n2.Remove a media from your List " +
                "\n3.Display your List \n4.Save your List \n5.Load you List \n6.Clear your List \n7.Search \n0.Exit");

        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
            switch(choice){
                case 1: return Choice.ADD;
                case 2: return Choice.REMOVE;
                case 3: return Choice.DISPLAY;
                case 4: return Choice.SAVE;
                case 5: return Choice.LOAD;
                case 6: return Choice.CLEAR;
                case 7: return Choice.SEARCH;
                case 0: return Choice.EXIT;
                default:return Choice.ERROR;
            }
        }
        catch(Exception e){
            return Choice.ERROR;
        }
    }

    public Media createMedia()  {
        String id;
        String filename;
        String filetype;
        Float duration;
        String description;
        String creator;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the Media");
        id  = scanner.next();

        System.out.println("Enter the Filename");
        filename = scanner.next();
        System.out.println("Please Enter a valid number");
        System.out.println("Press (1) for Audio File and (2) for Video File");
        filetype = scanner.next();
        Boolean loop = true;
        while (loop) {

            if (filetype.equals("1")) {
                filetype = "mp3";
                loop = false;
            }
            else if (filetype.equals("2")){
                filetype = "mp4";
                loop = false;
            }else {
                System.out.println("Please Enter a valid number");
                System.out.println("Press (1) for Audio File and (2) for Video File");
                filetype = scanner.next();
            }
        }

        System.out.println("Enter the duration of the Media (e.x. 2.3 minutes)");
        duration = scanner.nextFloat();

//        while (true) {
//
//            if (duration % 1 == 0) {
//                    continue;
//            }
//            else {
//                break;
//            }
//        }
        System.out.println("Write a Description");
        description = scanner.next();
        System.out.println("Enter the creator ");
        creator = scanner.next();

        Media media = new Media(id, filename, filetype,duration,description,creator);
        return media;

    }


    public void manageList(MediaList mediaList){
        Choice choice;
        do {
            choice =  menu();

            switch (choice) {
                case ADD:
                    Media product =  createMedia();
                    mediaList.addMediaFile(product);
                    break;
                case REMOVE:
                    System.out.println("Give an index to remove");
                    Scanner scanner = new Scanner(System.in);
                    int index= scanner.nextInt();
                    mediaList.removeItemFromList(index);
                    break;
                case DISPLAY:
                    mediaList.displayList();
                    break;
                case CLEAR:
                    mediaList.clearList();
                    break;
                case SEARCH:
                    mediaList.searchMedia();
                    break;
                case SAVE:
                    mediaList.saveListInFile("myList.txt");
                    break;
                case LOAD:
                    mediaList.loadListFromFile("myList.txt");
                    break;
                case ERROR:
                    System.out.println("You gave erroneous input");
                    break;
                case EXIT:
                    break;

            }
        }while(choice!=Choice.EXIT);

    }
}
