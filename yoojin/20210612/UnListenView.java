package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UnListenView {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i ,lcnt,vcnt;
        String name;

        HashSet<String> hashSet = new HashSet<String>();
        ArrayList<String> resultlist = new ArrayList<String>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        lcnt = Integer.parseInt(st.nextToken());
        vcnt = Integer.parseInt(st.nextToken());

        for(i = 0; i<lcnt+vcnt; i++) {
            name = br.readLine();
            if (hashSet.contains(name)) resultlist.add(name);
            else hashSet.add(name);
        }
        Collections.sort(resultlist);
        System.out.println(resultlist.size());
        for(String n : resultlist) System.out.println(n);
    }
}
