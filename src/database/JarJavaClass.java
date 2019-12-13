package database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * @author Marko Kosmajac, Phonkrit Van de Velde, Brent Van Eyken
 */

public class JarJavaClass {

    private excel.ExcelPlugin excelPlugin = new ExcelPlugin();

    public ArrayList<ArrayList<String>> load(File file){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        try {
            result = excelPlugin.read(file);
        } catch (BiffException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(File file, ArrayList<ArrayList<String>> list){
        try {
            excelPlugin.write(file,list);
        } catch (BiffException | IOException | WriteException e) {
            e.printStackTrace();
        }
    }
}
