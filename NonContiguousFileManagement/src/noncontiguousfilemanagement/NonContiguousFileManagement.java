
package noncontiguousfilemanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NonContiguousFileManagement {

    static Scanner input = new Scanner(System.in);
    static int empty;
    static int full = 0;
    static String[] blocks;
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Enter number of blocks:");
        int numberOfBlocks = input.nextInt();
        System.out.println("Enter number of files: ");
        int numberOfFiles = input.nextInt();
        empty = numberOfBlocks;
        blocks = new String[numberOfBlocks];
        for(int i = 0; i < numberOfBlocks; i++){
            blocks[i] = "empty";
        }
        NonContiguousAllocation(numberOfBlocks, numberOfFiles);
        
        for (String i : map.keySet()) {
            System.out.print("key " + i + ", value ");
            for(int j = 0; j < map.get(i).size(); j++){
                System.out.print(map.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        
        System.out.println("Enter number of searches: ");
        int searches = input.nextInt();
        input.nextLine();
        for(int i = 0; i <  searches; i++){
            System.out.println("Enter file name: ");
            String filename = input.nextLine();
            Search(filename, numberOfBlocks);
        }
        
    }
    
    public static void NonContiguousAllocation(int numberOfblocks, int numberOfFiles){
        for(int i = 0; i <  numberOfFiles; i++){
            input.nextLine();
            System.out.println("Enter filename: ");
            String name = input.nextLine();
            System.out.println("Enter blockSize: ");
            int blockSize = input.nextInt();
            
            int tempSize = blockSize;
            
            if(blockSize > empty){
                System.out.println("File " + name + " cannot be allocated");
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                if(full == 0){
                    int random =  (int )(Math.random() * 4 + 1);
                    for(int j = 0; j < numberOfblocks && blockSize > 0; j += random){
                        blocks[j] = name;
                        full++;
                        empty--;
                        blockSize--;
                        random = (int )(Math.random() * 4 + 1);
                        list.add(j);
                    }
                    if(blockSize > 0){
                        for(int j = 0; j < numberOfblocks; j++){
                            if(blocks[j].equals("empty")){
                                blocks[j] = name;
                                full++;
                                blockSize--;
                                list.add(j);
                            }
                        }
                    }
                    map.put(name, list);
                }else{
                    for(int j = 0; j < numberOfblocks && blockSize > 0; j++){
                        if(blocks[j].equals("empty")){
                            blocks[j] = name;
                            full++;
                            empty--;
                            blockSize--;
                            list.add(j);
                        }
                    }
                    map.put(name, list);
                }
            }
        }
    }
    
    public static void Search(String fileName, int numberOfBlocks){
        if(map.get(fileName) == null){
            System.out.println("File " + fileName + " not found");
        }else{
            System.out.println("File found: ");
            for(int i = 0; i < numberOfBlocks; i++){
                if(blocks[i].equals(fileName)){
                    System.out.print(i + " ");
                }
            }
            System.out.println("");
        }
    }
    
}
