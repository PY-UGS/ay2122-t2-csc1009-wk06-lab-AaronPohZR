package CSC1009.wk06_lab;

import java.util.*;

public class Week06 {

    public void wk06_question1(){
        int[] values = { 5, 3, 1, 11, 9, 7};
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int value : values) linkedList = addAndSort(linkedList, value);
        
        System.out.print("LinkList values: ");
        for (int i=0; i < linkedList.size(); i ++){
            System.out.print(linkedList.get(i)+" ");
        }
        System.out.print("\n");
        
    }

    public void wk06_question2(){
        int[] values = { 5, 3, 1, 11, 9, 7};
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int value : values) linkedList = addAndSort(linkedList, value);

        System.out.print("LinkList values from: ");
        for (int i=0; i < linkedList.size(); i ++){
            System.out.print(linkedList.get(i)+" ");
        }
        System.out.print("to ");
        linkedList = swapValues(linkedList, 1, 5);
        for (int i=0; i < linkedList.size(); i ++){
            System.out.print(linkedList.get(i)+" ");
        }
        System.out.print("\n");

    }

    public void wk06_question3(){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i =0;i <500; i++){
            linkedList.add(numGenerator(1000, 9999));
        }
        
        int numGenerated = numGenerator(1000, 9999);
        System.out.print("Linklist number ");

        int value = findValue(linkedList, numGenerated);
        if (value > -1 ){
            System.out.println(numGenerated + " is found.");
        }
        else{
            System.out.println(numGenerated + " is not found.");
        }
    }

    public void wk06_question4(){
        int[] values = { 5, 3, 1, 11, 9, 7};
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        
        for (int i=0; i<values.length; i++) linkedHashMap = addAndSort(linkedHashMap, values[i]);

        System.out.print("LinkedHashMap values: ");
        for (int i=0; i < linkedHashMap.size(); i ++){
            System.out.print(linkedHashMap.get(i)+" ");
        }
        System.out.print("\n");
    }

    public void wk06_question5(){
        int[] values = { 5, 3, 1, 11, 9, 7};
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();

        for (int i=0; i<values.length; i++) linkedHashMap = addAndSort(linkedHashMap, values[i]);

        System.out.print("LinkHashMap values from: ");
        for (int i=0; i < linkedHashMap.size(); i ++){
            System.out.print(linkedHashMap.get(i)+" ");
        }
        System.out.print("to ");
        linkedHashMap = swapValues(linkedHashMap, 1, 5);
        for (int i=0; i < linkedHashMap.size(); i ++){
            System.out.print(linkedHashMap.get(i)+" ");
        }
        System.out.print("\n");

    }

    public void wk06_question6(){
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        for (int i =0;i <500; i++){
            linkedHashMap.put(i, numGenerator(1000, 9999));
        }
        
        int numGenerated = numGenerator(1000, 9999);
        System.out.print("LinkedHashMap number ");

        int value = findValue(linkedHashMap, numGenerated);
        if (value > -1 ){
            System.out.println(numGenerated + " is found.");
        }
        else{
            System.out.println(numGenerated + " is not found.");
        }
    }

    //
    //Question 1
    public LinkedList<Integer> addAndSort(LinkedList<Integer> list, int value) {
        list.add(value);
        Collections.sort(list);
        return list;
    }
    //Question 4
    public LinkedHashMap<Integer, Integer> addAndSort(LinkedHashMap<Integer, Integer> list, int value) {
        list.put(list.size(), value);

        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for(int i=1; i<list.size();i++){
                if(list.get(i)<list.get(i-1)){
                    list = swapValues(list, i, i-1);
                    sorted = false;
                }
            }
        }
        
        return list;
    }
    //Question 2
    public LinkedList<Integer> swapValues(LinkedList<Integer> list, int indexOne, int indexTwo) {
        Collections.swap(list, indexOne, indexTwo);
        return list;
    }
    //Question 5
    public LinkedHashMap<Integer, Integer> swapValues(LinkedHashMap<Integer, Integer> list, int indexOne, int indexTwo) {
        int temp = list.get(indexOne);
        list.put(indexOne, list.get(indexTwo));
        list.put(indexTwo, temp);
        return list;
    }
    //Question 3
    public int findValue(LinkedList<Integer> list, int searchVal){
        return list.indexOf(searchVal);
    }
    //Question 6
    private int findValue(LinkedHashMap<Integer, Integer> linkedHashMap, int searchVal) {
        for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()){
            if (entry.getValue() == searchVal){
                return entry.getKey();
            }
        }
        return -1;
    }
    //Question 3 & 6 Number generator
    public int numGenerator(int min, int max) {
        int num = (int)(Math.random()*(max-min+1)+min);
        return num;
    }
}
