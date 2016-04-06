package tema9;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProvocandoError {

    public ProvocandoError(File aFile) {
        try {
            if(aFile==null)
            throw new Exception("No me puedes mandar un null");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
