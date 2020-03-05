package challenge;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVReaderOpen {



        String csvFile = "/src/main/resources/data.csv";
        List<Jogador> jogadores = new ArrayList<>();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                jogadores.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jogadores;




}
