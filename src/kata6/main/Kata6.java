package kata6.main;

import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;
import kata6.model.Mail;
import kata6.model.Histogram;
import java.io.IOException;
import java.util.List;

public class Kata6 {
    private List<Mail> mailList;
    private Histogram<String> histogram;
    
    
    public static void main(String[] args) throws IOException {
        Kata6 a = new Kata6();
        a.execute();
    }

    private void execute() throws IOException{
        input();
        process();
        output();
    }
            
    private void input() throws IOException{
        String filename = "C:\\Users\\Entrar\\Desktop\\Kata6\\emailsfile.txt";
        mailList = MailListReader.read(filename);        
    }
            
    private void process(){
        histogram = MailHistogramBuilder.build(mailList);
    } 
            
    private void output(){
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();        
    }
            
    
    
}
