import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.Random;

public class Review_3_c2 {

    public static void main(String[] args) throws Exception {
        //read input data
        StringBuilder sb = new StringBuilder();
        String strLine = "";
        String str_data = "";
        BufferedReader br = new BufferedReader(new FileReader("100_mb_file(cipher text2).txt"));
        while (strLine != null) {
            if (strLine == null) {
                break;
            }
            str_data += strLine;
            
            strLine = br.readLine();
        }
        br.close();
        Random rand = new Random();
        int bit = 5;
        BigInteger D = new BigInteger(str_data);
        System.out.println("D : " + D);
        BigInteger C = new BigInteger(bit, rand);
        System.out.println("C : " + C);
        BigInteger K = new BigInteger(bit, rand);
        System.out.println("K : " + K);
        BigInteger R = D.subtract(C);
        //Encryption
        BigInteger E1 = C.xor(K);
        System.out.println("E1 : " + E1);
        //store E1 in file clouda
        String e1 = E1.toString();
        File my = new File("100_mb_file(cloud a ct2).txt");
        my.createNewFile();
        System.out.println("Successfully created the file.");
        FileWriter myw = new FileWriter("100_mb_file(cloud a ct2).txt");
        myw.write(e1);
        myw.close();
        System.out.println("Successfully wrote to the file.");
        BigInteger E2 = R.xor(K);
        //store E2 in file cloudb
        String e2 = E2.toString();
        System.out.println("E2 : " + E2);
        File my1 = new File("100_mb_file(cloud b ct2).txt");
        my.createNewFile();
        System.out.println("Successfully created the file.");
        FileWriter myw1 = new FileWriter("100_mb_file(cloud b ct2).txt");
        myw1.write(e2);
        myw1.close();
        System.out.println("Successfully wrote to the file.");
        //Decryption
        System.out.println("Decryption :");
        //read E1 from file clouda
        String strLine1 = "";
        String str_data1 = "";
        BufferedReader br1 = new BufferedReader(new FileReader("100_mb_file(cloud a ct2).txt"));
        while (strLine1 != null) {
            if (strLine1 == null) {
                break;
            }
            str_data1 += strLine1;
            strLine1 = br1.readLine();
        }
        br1.close();
        System.out.println("Successfully read from the file.");
        BigInteger E11 = new BigInteger(str_data1);
        System.out.println("E1 read from the file : " + E11);
        BigInteger D1 = E11.xor(K);
        //read E2 from file cloudb]
        String strLine2 = "";
        String str_data2 = "";
        BufferedReader br2 = new BufferedReader(new FileReader("100_mb_file(cloud b ct2).txt"));
        while (strLine2 != null) {
            if (strLine2 == null) {
                break;
            }
            str_data2 += strLine2;
            strLine2 = br2.readLine();
        }
        br2.close();
        System.out.println("Successfully read from the file.");
        BigInteger E21 = new BigInteger(str_data2);
        System.out.println("E2 read from the file : " + E21);
        BigInteger D2 = E21.xor(K);
        BigInteger M = D1.add(D2);
        System.out.println("Decipher Text : " + M);
        if (D.equals(M)) {
            System.out.println("original and decrypted message are equal");
            String m = M.toString();
            File my3 = new File("100_mb_file_ic(decipher text-2).txt");
            my.createNewFile();
            System.out.println("Successfully created the file.");
            FileWriter myw3 = new FileWriter("100_mb_file_ic(decipher text-2).txt");
            myw3.write(m);
            myw3.close();
            
            System.out.println("Successfully wrote to the file.");
        } else {
            System.out.println("original and decrypted message are not equal");
        }
    }
}