package kata6.main;

import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;
import kata6.model.Mail;
import kata6.model.Histogram;
import java.io.IOException;
import java.util.List;

public class Kata6 {
    private List<Mail> mailList;
    HistogramBuilder<Mail> builder;
    Histogram<String> domains;
    Histogram<Character> letters;
    
    
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
        builder = new HistogramBuilder<>(mailList);
    }
            
    private void process(){
        domains = builder.build(new Attribute<Mail, String>(){
            @Override
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
        });
        
        letters = builder.build(new Attribute<Mail, Character>(){
            @Override
            public Character get(Mail item){
                return item.getMail().charAt(0);
            }
        });
    } 
            
    private void output(){
        HistogramDisplay histoDisplay1 = new HistogramDisplay(domains, "Dominios");
        histoDisplay1.execute();
        HistogramDisplay histoDisplay2 = new HistogramDisplay(letters, "Primer caracter");
        histoDisplay2.execute();        
    }
            
    
    
}
