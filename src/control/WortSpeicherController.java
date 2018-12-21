/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

/**
 *
 * @author Niklas
 */
public class WortSpeicherController
{
    public static void init(char[] zeichen)
    {
        ArrayList<String> worte = wandleCharArrayInStringArrayList(zeichen);
        worte.sort(new Comparator<String>()
        {
            @Override
            public int compare(String s1, String s2)
            {
                return s1.compareTo(s2);
            }
        }
        );
        System.out.println(fuelleTreeMapMitArrayList(worte));
    }
    
    private static TreeMap<Integer, String> fuelleTreeMapMitArrayList(ArrayList<String> arraylist)
    {
        TreeMap<Integer, String> treemap = new TreeMap<>();
        int key = 0;
        
        for(String wort : arraylist)
        {
            treemap.put(key++, wort);
        }
        return treemap;
    }
    
    private static ArrayList<String> wandleCharArrayInStringArrayList(char[] zeichen)
    {
        StringBuilder meinStringBuilder = new StringBuilder();
        ArrayList<String> worte = new ArrayList<>();
        
        for(char element : zeichen)
        {
            if(Character.isAlphabetic(element))
            {
                meinStringBuilder.append(element);
            }
            else if(meinStringBuilder.length() > 0)
            {
                worte.add(meinStringBuilder.toString());
                meinStringBuilder.delete(0, meinStringBuilder.length());
            }
        }
        return worte;
    }
}