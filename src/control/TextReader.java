/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Niklas
 */
public class TextReader
{
    public static char[] einlesen()
    {
        BufferedReader bufferedreader = null;
        
        try
        {
            bufferedreader = new BufferedReader(new FileReader(Konstanten.TEXTQUELLE));
            return wandleTextInCharArrayUm(bufferedreader);
        } catch(IOException e)
        {
            return null;
        }
        finally
        {
            close(bufferedreader);
        }
    }
    
    private static void close(BufferedReader reader)
    {
        try
        {
            reader.close();
        } catch(IOException e)
        {
            
        }
    }

    private static char[] wandleTextInCharArrayUm(BufferedReader reader) throws IOException
    {
        int gelesenesZeichen = reader.read();
        ArrayList<Character> zeichenArray = new ArrayList<>();
        
        while(gelesenesZeichen != -1)
        {
            zeichenArray.add((char) gelesenesZeichen);
            gelesenesZeichen = reader.read();
        }  
        return wandleArrayListInCharArrayUm(zeichenArray);
    }
    
    private static char[] wandleArrayListInCharArrayUm(ArrayList<Character> charList)
    {
        char[] charArray = new char[charList.size()];
        int index = 0;
        
        for(char zeichen : charList)
        {
            charArray[index++] = zeichen;
        }
        return charArray;
    }
}
