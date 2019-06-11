
package sieveoferatosthenes;

import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class SieveOfEratosthenes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the range n: ");
        int n = input.nextInt();
        
        sieve(n);
    }
    
    public static void sieve(int n){
        boolean[] prime = new boolean[n + 1];
        
        for(int i = 2; i * i <= n; i++){
            
            if(prime[i] == false){
                
                for(int j = i * i; j <= n; j+= i){
                    prime[j] = true;
                }
            }
        }
        
        for(int i = 2; i <= n; i++){
            if(!prime[i]){
                System.out.println(i);
            }
        }
    }
}
