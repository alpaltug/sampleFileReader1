import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class fileWriter extends fileReader{

    public String pathname1 = "adult.medium.train.csv1";    //name of the file which will be created to input the data as a hmap

    fileReader fr = new fileReader();
    private HashMap <String, Integer> hmap;     //assigned to the hmap

    @Override
    public HashMap bagWords() throws IOException {
        hmap = this.bagWords();
        return hmap;
    }

    public void fileWriter(HashMap hmap) throws IOException{
        this.hmap = hmap;
        RandomAccessFile stream = new RandomAccessFile(pathname1, "rw");    //file writing with RandomAccessFile
        FileChannel channel = stream.getChannel();
        String data = hmap.toString();
        byte[] strBytes = data.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);

        stream.close();
        channel.close();



    }
}
