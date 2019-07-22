package ca.jrvs.apps.grep;
import java.io.File;
import java.io.IOException;
import java.util.List;


public interface JavaGrep {

    void process() throws IOException;



    List<File> listFiles(String rootDir); // listFiles is a function



    List<String> readLines(File inputFile) throws IOException;



    Boolean containsPattern(String line);




    void writeToFile(List<String> lines) throws IOException;

    String getDirectorypath();

    void setDirectorypath(String rootPath);


    String getRegex();

    void setRegex(String regex);

    String getOutputfile();

    void setOutputfile(String outFile);


}
