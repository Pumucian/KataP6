package kata6.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import kata6.model.Mail;

import java.io.FileNotFoundException;
import java.io.IOException;
public class MailListReader {
    public static List<Mail> read (String fileName) throws FileNotFoundException, IOException{
        List<Mail> mailList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String mail;
        while ((mail = reader.readLine()) != null){
            if (mail.indexOf('@') == -1) continue;
            mailList.add(new Mail(mail));
        }
        reader.close();
        return mailList;
    }
}
