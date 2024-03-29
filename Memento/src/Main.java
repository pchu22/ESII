import com.es2.memento.BackupService;
import com.es2.memento.ExistingStudentException;
import com.es2.memento.NotExistingSnapshotException;
import com.es2.memento.Server;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ExistingStudentException, NotExistingSnapshotException {
        Server s = new Server();
        BackupService backup = new BackupService(s);
        backup.takeSnapshot();
        s.addStudent("Maria José");
        backup.takeSnapshot();
        s.addStudent("Manuel António");
        System.out.println(s.getStudentNames().size());

        backup.restoreSnapshot(1);
        System.out.println(s.getStudentNames().size());
    }
}