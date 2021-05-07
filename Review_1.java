
import java.io.*;
import java.math.*;
import java.util.*;

public class Review_1 {

    public static void main(String args[]) {

// select the complex equation 
        BigInteger x = new BigInteger("5");
        BigInteger R = new BigInteger("4");
        BigInteger y = new BigInteger("2");
        BigInteger two = new BigInteger("2");
        System.out.println("the value of x in eq:" + x);
        System.out.println("the value of R in eq:" + R);
        System.out.println("the value of y in eq:" + y);
        BigInteger eq2 = y.pow(3).subtract(y);
        BigInteger eq1 = R.multiply(eq2);
        BigInteger eq = x.pow(2).subtract(eq1);

        //BigInteger eq = x.pow(2).subtract(R.multiply(y.pow(3).subtract(y)));
        System.out.println("The test case one (i.e choosen eq is equal to)is :" + eq);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message: ");
        BigInteger m = sc.nextBigInteger();
//Append the RSA-PKC

//Key Generation
        System.out.println("RSA-PKC for appending e and phi(n)");
        System.out.println("Enter the prime number P :");

        BigInteger P = sc.nextBigInteger();
        System.out.println("Enter the prime number Q:");
        BigInteger Q = sc.nextBigInteger();
        BigInteger N = P.multiply(Q);

        BigInteger phi = (P.subtract(BigInteger.ONE)).multiply(Q.subtract(BigInteger.ONE));

// select public key e
        Scanner sci = new Scanner(System.in);
        System.out.println("Enter the public key e:");
        BigInteger e = sci.nextBigInteger();
        BigInteger check = e.gcd(phi);
        int cond = check.compareTo(BigInteger.ONE);
        if (cond == 0) {
//private key using Eucledean algorithm 
            BigInteger d = e.modInverse(phi);
            System.out.println("The public key-e OF RSA is : " + e);
            System.out.println("The private key-d of RSA is:" + d);
//from rsa we are choosing e and phi and finding alpha
            System.out.println("Append RSA-PKC");
            BigInteger alpha
                    = BigInteger.ONE.add(e.pow(2).add(two.multiply(e.multiply(x)))).mod(phi);
            System.out.println("The value of alpha is:" + alpha);
            BigInteger tc2 = alpha.subtract(e.multiply(e.add(two.multiply(x))));
            BigInteger tc1 = tc2.mod(phi);
            System.out.println("The test case 2 (i.e. alpha-e(e+2x)) is: " + tc1);

// KEY GENERATION
            System.out.println("KEY GENERATION");

//Public key has two k1 is (alpha mod phi(n),N) and k2 is ((e+2x mod phi(n)),N)
            BigInteger k1 = alpha.mod(phi);

            BigInteger k2 = (e.add(two.multiply(x))).mod(phi);

// Private key is (e,N)
            System.out.println("The public key of this crptographer - k1 is :" + k1);
            System.out.println(" The public key of this cryptographer - k2 is :" + k2);
            System.out.println("The private key of this cryptographer is :" + e);
// ENCRYPTION using public key System.out.println("ENCRYPTION");
            BigInteger ct1 = m.modPow(k1, N);
            BigInteger ct2 = m.modPow(k2, N);
            System.out.println("The ciphertext 1 is:" + ct1);
            System.out.println("The cipher text 2 is:" + ct2);
// Decryption using private key 
            System.out.println("DECRYPTION");
            BigInteger dt0 = ct2.modPow(e, N);
            BigInteger dt1 = ct1.multiply(dt0);
            BigInteger dt = dt1.mod(N);
            System.out.println("The de-cipher text( original message) is:" + dt);

        } else {

            System.out.println("choose different value of e(RSA-PKC)");

        }
    }
}
