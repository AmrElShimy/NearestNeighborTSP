import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Helper {
    //helper method to load the file from the project directory
    public static City[] loadFile(){
        int index = 0;
        City[] cities = new City[4663];
        BufferedReader reader;
        String file = "";
        try {
            reader = new BufferedReader(new FileReader("")); // your file name
            String line = reader.readLine();
            while (line != null) {
                file = file + line + "\n";
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] city = line.split(" ");
            City newCity = new City();
            newCity.x = Float.parseFloat(city[1]);
            newCity.y = Float.parseFloat(city[2]);
            cities[index] = newCity;
            index++;
        }
        scanner.close();
        return cities;
    }

    public static float distance(City first, City second){
        return (float) Math.sqrt((second.y - first.y) * (second.y - first.y) + (second.x - first.x) * (second.x - first.x));
    }

    public static float[] nearestNeighbor(City[] cities, City current){
        current.isVisited = true;
        float[] result = new float[2];
        result[1] = 1000000000;
        for(int i = 0; i < cities.length; i++){
            if(!cities[i].isVisited && distance(current, cities[i]) < result[1] && distance(current, cities[i]) != 0){
                result[0] = i;
                result[1] = distance(current, cities[i]);
                continue;
            }
            else
                continue;
        }
        return result;
    }
}
