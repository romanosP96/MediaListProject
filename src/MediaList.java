import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MediaList {
    private ArrayList<Media> medias = new ArrayList<>();

    public void addMediaFile(Media media){
        medias.add(media);
        System.out.println("The media has been added\n");
    }

    public void displayList(){
        medias.forEach(System.out::println);
    }

    public void clearList () {
        medias.clear();
        System.out.println("The list is now clear\n");
    }

    public void removeItemFromList(int index){
        if (index>=0 && index < medias.size()){
            medias.remove(index);
            System.out.println("The item has been \n");
        }
    }

    public void saveListInFile(String filename){
        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for (Media p : medias) {
                printWriter.println(p.getId() + ", " +p.getFilename() + ", " + p.getFilename() + ", " + p.getDuaration() + ", " + p.getDescription() + ", " + p.getCreator());
                System.out.println("A List of media files has been created\n");
            }
            printWriter.close();
        } catch (FileNotFoundException e){
            System.out.println("The file cannot be saved");
        }
    }

    public void loadListFromFile(String filename){
        medias.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",");
                Media product = new Media(
                        words[0],
                        words[1],
                        words[2],
                        Float.parseFloat(words[3]) ,
                        words[4],
                        words[5]);
                medias.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchMedia() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        List<Media> mediaList = medias.stream().filter(media -> media.getId().equals(input)).collect(Collectors.toList());
               if (mediaList.size() != 0){
                   mediaList.forEach(System.out::println);
               }else{
                   System.out.println("File not found!");
               }
//
//        medias.stream().forEach(media -> {
//            if (media.getId().equals(input)){
//                System.out.println("Name File: " + media.getFilename() );
//            } else {
//                System.out.println("File not found!");
//            }
//        });

    }

}
