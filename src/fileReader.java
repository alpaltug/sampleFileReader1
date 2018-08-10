import java.io.*;
import java.util.*;

public class fileReader {

    public String pathname = "adult.medium.train.csv";  //the directory of the target file

    private BufferedReader input;

    private String line;

    public ArrayList<String> data = new ArrayList<>();  //the data of the file in the target directory


    public void openFile(String pathname) {     //open file in the target directory
        try {
            input = new BufferedReader(new FileReader(new File(pathname)));
            System.out.println("File opened successfully!");    //file is successfully obtained

        } catch (FileNotFoundException e) {
            System.out.println("File not found");   //file is not in the target directory
        } catch (NullPointerException e) {
            System.out.println("The file is empty");    //the targeted file is empty
        }
    }


    public void readFile() {    //writes the input on the ArrayList data
        try {
            while ((line = input.readLine()) != null) {     //reads the file line by line
                data.add(line);
            }
            input.close();  //closes the input file

        } catch (NullPointerException e) {
            System.out.println("The file is empty2");   //there is no values assigned to the ArrayList data
        } catch (IOException e) {
            System.out.println("IOException");  //IO Operation failed
        }
    }

    public ArrayList<String> returnFile() {     //returns the ArrayList data
        return (data);
    }

    public void duplicateFile(ArrayList<String> dataD) {
        dataD = this.data;
    }

    public void checkFile() {   //checks that the ArrayList data is not empty
        try {
            if (data.isEmpty()) {
                System.out.println("Data is empty");
            } else {
                System.out.println("We have the data!");
            }
        } catch (NullPointerException e) {
            System.out.println("Data is empty");
        }

    }

    public void sFile() {   //splits the ArrayList data according to the comas
        String data1 = data.toString();
        data.addAll(Arrays.asList(data1.split(",")));
    }

    public void splitFile() throws IOException {
        String dataT;
        for (int x = 0; x < data.size(); x++) {
            dataT = (data.get(x));
            data.addAll(Arrays.asList(dataT.split(",")));

            //System.out.println(data.get(x));


        }

    }

    public HashMap bagWords() throws IOException {  //assigns each value inside the ArrayList data to a hmap with indexes
        StringBuilder s = new StringBuilder();
        int c;
        String words[];
        FileInputStream fin = new FileInputStream(new File(pathname));  //gets the input from the target directory
        /* Read Input file */
        try {
            fin = new FileInputStream(new File(pathname));
        } catch (FileNotFoundException fex) {
            fex.printStackTrace();  //No file in the target directory
        }
        /* Reads individual characters till End of file is encountered */
        while ((c = fin.read()) != -1) {
            s.append((char) c);     //appends the words inside the data StringBuilder s
        }
        /* Creates array of words without \n and splits based on spaces*/
        words = s.toString().replaceAll("\n", " ").split(",");  //splits according to comas and replaces new lines with a space
        /* Creates a map */
            HashMap<String, Integer> hmap = new HashMap<>();    //hmap
        /* Trims words and adds to map */
        for (int i = 0; i < words.length; i++) {    //repeats till all the words inside the file are reached
            if((words[i].isEmpty()==false)&&(hmap.containsKey(words[i])==false)){
                hmap.put(words[i], i);  //appends an index to the value if there are no duplicates
            }
            else continue;

            /* Reverse sort map */
            int commaCorrection = 0;
            /* Print formatted output */
            for (String key : hmap.keySet()) {
                if (commaCorrection == 0) {
                    //System.out.print(key);
                    commaCorrection = 1;
                }
                //else
                //System.out.print(","+key);
            }
            fin.close();    //closes the input



        }return hmap;   //hmap


    }

}





