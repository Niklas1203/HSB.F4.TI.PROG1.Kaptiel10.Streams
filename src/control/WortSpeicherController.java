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
    
    private static TreeMap<String, Integer> fuelleTreeMapMitArrayList(ArrayList<String> arraylist)
    {
        TreeMap<String, Integer> treemap = new TreeMap<>();
        String wort = arraylist.get(0);
        int anzahl = 1;
        
        for(int i = 0; i < arraylist.size() - 1; i++)
        {
            if(arraylist.get(i + 1).equals(wort))
            {
                anzahl++;
                wort = arraylist.get(i + 1);
            }
            else
            {
                System.out.println(wort);
                System.out.println(anzahl);
                treemap.put(wort, anzahl);
                anzahl = 1;
                wort = arraylist.get(i + 1);
            }
        }
        treemap.put(wort, anzahl);
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
        if(meinStringBuilder.length() > 0)
        {
            worte.add(meinStringBuilder.toString());
        }
        return worte;
    }
}