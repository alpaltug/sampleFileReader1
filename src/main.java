import java.io.*;

/*** A program that converts a file in the target directory to an hmap of raw numbers.
 * It then creates a new file in the directory and prints the hmap into the new file.
 * Alp Altug 2018 Tazi.io internship project
 */


public class main {

    public static String pathname = "adult.medium.train.csv";   //the target directory in which the input will be taken

    public static void main(String[] args) throws IOException {

        fileReader fr = new fileReader();   //the class that gets the input

        fileWriter fw = new fileWriter();   //the class that writes the input to the target file



        fr.openFile(pathname);  //opens the file through import
        fr.readFile();  //reads the file through the import and puts it inside an array list
        fr.checkFile();   //checks if the data is stored inside the array list


        //fr.splitFile();   //splits the file according to commas
        fr.sFile(); //separates data into lines
        fr.bagWords();  //separates data into an hmap in which every recurring word is assigned to an integer value
        //System.out.println(fr.bagWords());    //prints the hmap with the mapped indexes just to check that everything is on track
        fw.fileWriter(fr.bagWords());   //inputs the hmap for the method to append the data to a newly created file in the directory

    }
}
