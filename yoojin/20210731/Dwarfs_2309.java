package com.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
2309
 */

public class Dwarfs_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = -100;
        ArrayList<Integer> dwarfs= new ArrayList<>();
        for(int i=0; i<9; i++){
            int d =Integer.parseInt(br.readLine());
            dwarfs.add(d);
            sum +=d;
        }
        Collections.sort(dwarfs);

        for(int d : dwarfs){
            if(dwarfs.contains(sum-d) && dwarfs.indexOf(d)!=dwarfs.lastIndexOf(sum-d)){
                dwarfs.remove(dwarfs.indexOf(d));
                dwarfs.remove(dwarfs.indexOf(sum-d));
                break;
            }
        }

        for(int d: dwarfs){
            bw.write(Integer.toString(d)+'\n');
        }

        bw.flush();
        bw.close();

    }
}