
package bitwisesieve;

import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class BitwiseSieve {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the range n: ");
        int n = 99999999;//input.nextInt();
        
        sieve(n);
        optimizedSieve(n);
    }
    
    public static int check(int index, int position){
        int bit =  (index & (1 << position));
        return bit;
    }
    
    public static int set(int index, int position){
        return index | (1 << position);
    }
    
    public static void sieve(int n){
        int[] status = new int[n / 32 + 1];
        
        for(int i = 3; i * i <= n; i += 2){
            
            if(check(status[i / 32], i % 32) == 0){
                
                for(int j = i * i; j <= n; j += 2 * i){
                    status[j / 32] = set(status[j / 32], j % 32);
                }
            }
        }
        
        System.out.println("primes: ");
        System.out.println("2");
        
        for(int i = 3; i <= n; i += 2){
            if(check(status[i / 32], i % 32) == 0){
                System.out.println(i);
            }
        }
    }
    
    public static void optimizedSieve(int n){
        int[] status = new int[n / 32 + 1];
        
        for(int i = 3; i * i <= n; i += 2){
            
            if(check(status[i >> 5], i & 31) == 0){
                
                for(int j = i * i; j <= n; j += i << 1){
                    status[j >> 5] = set(status[j >> 5], j & 31);
                }
            }
        }
        
        System.out.println("primes: ");
        System.out.println("2");
        
        for(int i = 3; i <= n; i += 2){
            if(check(status[i >> 5], i & 31) == 0){
                System.out.println(i);
            }
        }
    }
}
