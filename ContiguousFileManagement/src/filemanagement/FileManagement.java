/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagement;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class FileManagement {
    
    static Scanner input = new Scanner(System.in);
    static HashMap<String, File> map = new HashMap<>();
    static String[] blocks;
    static int empty;
    static int full = 0;
    public static void main(String[] args) {
        System.out.println("Number of Blocks: ");
        int numberOfBlocks = input.nextInt();
        System.out.println("Number Of files: ");
        int numberOfFiles = input.nextInt();
        blocks = new String[numberOfBlocks];
        empty = numberOfBlocks;
        contiguousAllocation(numberOfBlocks, numberOfFiles);
        for (String i : map.keySet()) {
            System.out.println("key " + i + ", value " + map.get(i));
        }
        System.out.println("number of Searches: ");
        int searches = input.nextInt();
        input.nextLine();
        for(int i = 0; i < searches; i++){
            System.out.println("Enter filename to search:");
            String fileName = input.nextLine();
            Search(fileName);
        }
    }
    
    public static void contiguousAllocation(int numberOfBlocks, int numberOfFiles){
        for(int i = 0; i < numberOfFiles; i++){
            input.nextLine();
            System.out.println("Enter FileName: ");
            String name = input.nextLine();
            System.out.println("Enter block size: ");
            int blockSize = input.nextInt();
            
            if(blockSize > empty){
                System.out.println("File " +  name + " cannot be allocated");
            }else{
                File file = new File();
                file.start = full;
                
                int temp = full;
                for(int j = full; j < blockSize + temp; j++){
                    blocks[j] = name;
                    full++;
                }
                file.end = full;
                empty -= blockSize;
                full++;
                map.put(name, file);
            }
        }
        
    }
    public static void Search(String fileName){
        File file = map.get(fileName);
        if(file != null){
            System.out.println("File found at: ");
            for(int i = file.start; i <= file.end; i++){
                System.out.print(i + " ");
            }
            System.out.println("");
        }else{
            System.out.println("File not found");
        }
    }
    
}

class File{
    int start;
    int end;

    public File(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public File() {
    }

    @Override
    public String toString() {
        return "File{" + "start=" + start + ", end=" + end + '}';
    }
    
}
