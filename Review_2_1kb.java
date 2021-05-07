
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.Random;

public class Review_2_1kb {

    public static void main(String args[]) throws IOException {
        long startTime1 = System.currentTimeMillis();
        long total1 = 0;
        for (int i1 = 0; i1 < 10000000; i1++) {
            total1 += i1;
        }
        File file = new File("one_kb_file.txt");
        file.createNewFile();
        System.out.println("File created");
        String ip = "12";
        FileWriter myWriter = new FileWriter("one_kb_file.txt");
        myWriter.write(ip);
        myWriter.close();
         String str_data = "";
        String strLine = "";
        BufferedReader br = new BufferedReader(new FileReader("one_kb_file.txt"));
        while (strLine != null) {
            if (strLine == null) {
                break;
            }
            str_data += strLine;
            strLine = br.readLine();
        }
        br.close();
         RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.setLength(1024);
        raf.close();
        System.out.println("Successfully wrote to the file.");

        BigInteger x = new BigInteger("5");

        BigInteger R = new BigInteger("4");
        BigInteger y = new BigInteger("2");

        BigInteger two = new BigInteger("2");

        BigInteger eq2 = y.pow(3).subtract(y);
        BigInteger eq1 = R.multiply(eq2);
        BigInteger eq = x.pow(2).subtract(eq1);
        // BigInteger eq = x.pow(2).subtract(R.multiply(y.pow(3).subtract(y))); 
        System.out.println("The test case one (i.e choosen eq is equal to)is :" + eq);
        //Append the RSA-PKC
       

        BigInteger m = new BigInteger(str_data);

        //System.out.println("Enter the message: " + m);
        //Key Generation
        int bits = 5;
        BigInteger P = new BigInteger("7");

        BigInteger Q = new BigInteger("13");

        BigInteger N = P.multiply(Q);
        BigInteger phi = (P.subtract(BigInteger.ONE)).multiply(Q.subtract(BigInteger.ONE));

        // select public key e
        //Scanner sci = new Scanner(System.in);
        // System.out.println("Enter the public key e:");
        //  BigInteger e = BigInteger.probablePrime(bits,rand);
        BigInteger e = new BigInteger("11");
        BigInteger check = e.gcd(phi);
        int cond = check.compareTo(BigInteger.ONE);

        if (cond == 0) {
            //private key using Eucledean algorithm
            BigInteger d = e.modInverse(phi);

            System.out.println("The public key-e  OF RSA is " + e);
            System.out.println("The private key-d  of RSA is" + d);

            //from rsa we are choosing e and phi and finding alpha
            BigInteger alpha = BigInteger.ONE.add(e.pow(2).add(two.multiply(e.multiply(x)))).mod(phi);

            System.out.println("The value of alpha is:" + alpha);
            BigInteger tc2 = alpha.subtract(e.multiply(e.add(two.multiply(x))));
            BigInteger tc1 = tc2.mod(phi);
            System.out.println("The test case 2 (i.e. alpha-e(e+2x)) is: " + tc1);

            // KEY GENERATION 
            //Public key has two k1 is (alpha mod phi(n),N) and k2 is ((e+2x mod phi(n)),N)
            BigInteger k1 = alpha.mod(phi);
            BigInteger k2 = (e.add(two.multiply(x))).mod(phi);
            // Private key is (e,N)
            System.out.println("The public key of this crptographer - k1 is " + k1);
            System.out.println(" The public key of this cryptographer - k2 is" + k2);
            System.out.println("The private key of this  cryptographer is" + e);

            // ENCRYPTION using public key 
            long startTime2 = System.currentTimeMillis();
            long total2 = 0;
            for (int i2 = 0; i2 < 10000000; i2++) {
                total2 += i2;
            }
            BigInteger ct1 = m.modPow(k1, N);
            BigInteger ct2 = m.modPow(k2, N);
            String cipher1 = ct1.toString();
            File file1 = new File("one_kb_file(cipher text1).txt");
            file1.createNewFile();
            FileWriter myWriter1 = new FileWriter("one_kb_file(cipher text1).txt");
            myWriter1.write(cipher1);
            myWriter1.close();
            String cipher2 = ct2.toString();
            File file2 = new File("one_kb_file(cipher text2).txt");
            file2.createNewFile();
            FileWriter myWriter2 = new FileWriter("one_kb_file(cipher text2).txt");
            myWriter2.write(cipher2);
            myWriter2.close();

            System.out.println("The ciphertext 1 is:" + ct1);
            System.out.println("The cipher text 2 is:" + ct2);
            long stopTime2 = System.currentTimeMillis();
            long elapsedTime2 = stopTime2 - startTime2;
            System.out.print("Encryption time : ");
            System.out.println(elapsedTime2);
            // Decryption using private key  
            //DT= ct*ct^e mod N
            //Extracting the cipher text from file
            long startTime3 = System.currentTimeMillis();
            long total3 = 0;
            for (int i3 = 0; i3 < 10000000; i3++) {
                total3 += i3;
            }
            String strLine2 = "";
            String str_data2 = "";
            BufferedReader br2 = new BufferedReader(new FileReader("one_kb_file(cipher text1).txt"));
            while (strLine2 != null) {
                if (strLine2 == null) {
                    break;
                }
                str_data2 += strLine2;
                strLine2 = br2.readLine();
            }
            br2.close();
            String strLine3 = "";
            String str_data3 = "";
            BufferedReader br3 = new BufferedReader(new FileReader("one_kb_file(cipher text2).txt"));
            while (strLine3 != null) {
                if (strLine3 == null) {
                    break;
                }
                str_data3 += strLine3;
                strLine3 = br3.readLine();
            }
            br3.close();
            BigInteger cipher1_file = new BigInteger(str_data2);
            BigInteger cipher2_file = new BigInteger(str_data3);
            BigInteger dt0 = cipher2_file.modPow(e, N);
            BigInteger dt1 = cipher1_file.multiply(dt0);
            BigInteger dt = dt1.mod(N);
            File decyppt11= new File("Outputkb.txt");
            decyppt11.createNewFile();
             FileWriter myWritero = new FileWriter("Outputkb.txt");
             String out= dt.toString();
        myWritero.write(out);
        myWritero.close();
            RandomAccessFile raf1;
            raf1 = new RandomAccessFile(decyppt11, "rw");
        raf1.setLength(1024);
        raf1.close();
            

            System.out.println("The de-cipher text( original message) is:" + dt);
            long stopTime3 = System.currentTimeMillis();
            long elapsedTime3 = stopTime3 - startTime3;
            System.out.print("Decryption time : ");
            System.out.println(elapsedTime3);
        } else {
            System.out.println("choose different value of e(RSA-PKC)");
        }
    }
}
