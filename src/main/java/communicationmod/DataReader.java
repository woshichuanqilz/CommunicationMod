package communicationmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import quickRestart.*;

public class DataReader implements Runnable{

    private final BlockingQueue<String> queue;
    private final InputStream stream;
    private static final Logger logger = LogManager.getLogger(DataReader.class.getName());
    private boolean verbose;

    public DataReader (BlockingQueue<String> queue, InputStream stream, boolean verbose) {
        this.queue = queue;
        this.stream = stream;
        this.verbose = verbose;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            StringBuilder inputBuffer = new StringBuilder();
            try {
                while (true) {
                    int nextChar = this.stream.read();
                    if (nextChar == -1) {
                        continue;
                    } else if (nextChar == 0 || nextChar == '\n') {
                        break;
                    }
                    inputBuffer.append((char) nextChar);
                }
                if (inputBuffer.length() > 0) {
                    if (verbose) {
                        logger.info("Received message: " + inputBuffer.toString());
                    }
                    String cmd = inputBuffer.toString();
                    queue.put(cmd);
                    if(cmd.equals("restart_battle")){
                        QuickRestart.setRestart();
                    }
//                    try {
//                        FileWriter myWriter = new FileWriter("commands.txt", true);
//                        myWriter.write("AddToReadQueueCmdl: " + cmd + "\n");
//                        myWriter.close();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
                }
            } catch(IOException e){
                logger.error("Message could not be received from child process. Shutting down reading thread.");
                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                logger.info("Communications reading thread interrupted.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
