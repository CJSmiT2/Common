package ua.org.smit.common.filesystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class TxtFile extends FileCms {

    static Logger log = Logger.getLogger(TxtFile.class);

    public TxtFile(String path) {
        super(new File(path));
    }

    public TxtFile(FileCms file) {
        super(file);
    }

    public String readFirstValue() {
        for (String value : readByLines()) {
            if (value != null && !value.isEmpty()) {
                return value;
            }
        }
        throw new RuntimeException("Cant read value! File path: " + this.getAbsolutePath());
    }

    public int readFirstInteger() {
        try {
            List<String> lines = readByLines();
            if (lines.isEmpty()) {
                log.debug("File '{}' is empty! return = '0'" + super.getPath());
                return 0;
            }
            return Integer.valueOf(lines.get(0));
        } catch (IndexOutOfBoundsException ex) {
            throw new RuntimeException("Txt file is empty! " + super.getAbsolutePath());
        }
    }

    public long readFirstLong() {
        try {
            List<String> lines = readByLines();
            if (lines.isEmpty()) {
                log.debug("File '{}' is empty! return = '0'" + super.getPath());
                return 0;
            }
            return Long.valueOf(lines.get(0));
        } catch (IndexOutOfBoundsException ex) {
            throw new RuntimeException("Txt file is empty! " + super.getAbsolutePath());
        }
    }

    public List<String> readByLines() {
        List<String> lines = new ArrayList<>();
        try ( FileInputStream fstream = new FileInputStream(this);  InputStreamReader is = new InputStreamReader(fstream);  BufferedReader br = new BufferedReader(is)) {

            String strLine;
            while ((strLine = br.readLine()) != null) {
                lines.add(strLine);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Cant read text from file! file='" + this + "'");
        }
        return lines;
    }

    public List<Integer> readIntegers() {
        List<Integer> items = new ArrayList<>();
        for (String text : readByLines()) {
            items.add(Integer.valueOf(text));
        }
        return items;
    }

    public void add(int value) {
        addToFile(String.valueOf(value));
    }

    public void add(long value) {
        addToFile(String.valueOf(value));
    }

    public void addToFile(String text) {
        try {
            FileWriter writer = new FileWriter(this, true);
            writer.append(text);
            writer.append('\n');
            writer.flush();
            writer.close();
            log.debug("Success added text = '{}' to file = '{}'" + text + " " + this);
        } catch (IOException ex) {
            throw new RuntimeException("Cant add text to file! Text = '" + text + "', file='" + this + "'");
        }
    }

    public void addAll(List<Integer> integers) {
        try {
            FileWriter writer = new FileWriter(this, true);

            for (Integer number : integers) {
                writer.append(String.valueOf(number));
                writer.append('\n');
            }

            writer.flush();
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException("Cant add to file! Text = '" + integers + "', file='" + this + "'");
        }
    }

    public void addAll2(List<String> values) {
        try {
            FileWriter writer = new FileWriter(this, true);

            for (String value : values) {
                writer.append(value);
                writer.append('\n');
            }

            writer.flush();
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException("Cant add to file! Text = '" + values + "', file='" + this + "'");
        }
    }

    public void rewriteAll(List<String> textInLines) {
        if (!textInLines.isEmpty()) {
            File temporaryFile = writeTextInTmpFile(textInLines);
            removeFile();

            boolean result = temporaryFile.renameTo(this);
            if (result) {
                temporaryFile.delete();
            }

        } else {
            makeEmpty();
        }
    }

    public void reWrite(int value) {
        removeFile();
        add(value);
    }

    public void reWrite(long value) {
        removeFile();
        add(value);
    }

    public void reWrite(String value) {
        removeFile();
        addToFile(value);
    }

    public void makeEmpty() {
        removeFile();
        makeEmptyIfNotExist();
    }

    private File writeTextInTmpFile(List<String> textInLines) {
        String temporaryFileName = "interim-" + System.currentTimeMillis();

        File interimFile = new File(this.getParentFile() + File.separator + temporaryFileName);
        if (interimFile.exists()) {
            throw new RuntimeException("Interim file already exist! But it should be not exist! " + interimFile.getAbsolutePath());
        }

        addAll2(textInLines);

        return interimFile;
    }

    public void removeFile() {
        if (this.exists()) {
            this.delete();
        }
    }

    public void makeEmptyIfNotExist() {
        if (!exists()) {
            try {
                this.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException("Cant create empty file! " + this);
            }
        }
    }

    public boolean isEmpty() {
        return readByLines().isEmpty();
    }

    public String readAllTextSolid() {
        StringBuilder sb = new StringBuilder();
        for (String line : readByLines()){
            sb.append(line);
        }
        return sb.toString();
    }

}
