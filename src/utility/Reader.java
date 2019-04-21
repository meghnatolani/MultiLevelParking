package utility;

import service.MultiLevelParkingService;
import service.MultiLevelParkingServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**@author Meghna Tolani
 * Reader : Utility class which asks for number of leves of parking and reads input from input.txt
 * */

public class Reader {

    MultiLevelParkingService multiLevelParkingService = new MultiLevelParkingServiceImpl();

    public void readInput(){

        Scanner sc=new Scanner(System.in);

        System.out.println("Number of levels of Parking ");

        int level = sc.nextInt();

        File file=new File("input.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

               multiLevelParkingService.processParking(line, level);
            }

        } catch (Exception e){

            e.printStackTrace();
        }
    }
}
