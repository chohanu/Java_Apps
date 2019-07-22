package ca.jrvs.apps.grep;
import java.io.*;
import java.util.List;
import java.util.ArrayList;


public class JavaGrepImp implements JavaGrep {

    private String regex;
    private String outputfile;
    private String directorypath;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getOutputfile() {
        return outputfile;
    }

    public void setOutputfile(String outputfile) {
        this.outputfile = outputfile;
    }

    public String getDirectorypath() {
        return directorypath;
    }

    public void setDirectorypath(String directorypath) {
        this.directorypath = directorypath;
    }


    public static void main(String[] args) {


        JavaGrepImp javagrep = new JavaGrepImp();
        javagrep.setRegex(args[0]);
        javagrep.setDirectorypath(args[1]);
        javagrep.setOutputfile(args[2]);

        try {
            javagrep.process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void process() throws IOException {

        List<File> files = listFiles(this.getDirectorypath());


        List<String> matchedLines = new ArrayList<>();
        List<String> lineFromFiles;


        for (File file : files) {
            lineFromFiles = readLines(file);

            for (String line : lineFromFiles) {
                if (containsPattern(line)) {
                    matchedLines.add(line);
                }
            }


        }
        writeToFile(matchedLines);
    }


    @Override
    public List<File> listFiles(String rootDir) {

        File directory = new File(rootDir);
        List<File> file = new ArrayList<>();

        for (File f : directory.listFiles()) {
            if (f.isDirectory()) {
                file.addAll(listFiles(f.getPath()));
            } else {
                file.add(f);
            }

        }
        return file;


    }


    @Override
    public List<String> readLines(File inputFile) throws IOException {

        List<String> lines = new ArrayList<>();


        BufferedReader breader = new BufferedReader(new FileReader(inputFile));
        try {
            String line;
            while ((line = breader.readLine()) != null) {
                lines.add(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return lines;

    }



    @Override
    public Boolean containsPattern(String line) {
        return line.matches(this.getRegex());

    }


    @Override
    public void writeToFile(List<String> lines) throws IOException {


        FileOutputStream fs = new FileOutputStream(this.getOutputfile());
        OutputStreamWriter oswriter = new OutputStreamWriter(fs);
        BufferedWriter bwriter = new BufferedWriter(oswriter);
        for (String line : lines) {
            bwriter.write(line);
            bwriter.newLine();
        }
        bwriter.close();




    }


} // end of class