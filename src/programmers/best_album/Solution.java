package programmers.best_album;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
 
/* https://tosuccess.tistory.com/40 ���� */

public class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();        //�帣�� ���Ƚ���� ���ϱ� ���� hashmap���
        for(int i = 0; i < genres.length; i++) {                             //hashmap�� �帣�� �÷��� Ƚ�� ����
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<Integer> answers = new ArrayList<Integer>();                //���߿� int[]������ �ٲ㼭 ������ arrayList
        ArrayList<String> al = new ArrayList<String>(hm.keySet());            //Value�� ������������ �����ϱ� ���� ����
        Collections.sort(al, (o1,o2)->(hm.get(o2).compareTo(hm.get(o1))));    //ArrayList�� hm Value �������� ������ ����
        
        for(int i = 0; i < al.size(); i++) {                                //��, ���� ���� ���๮
            String TempGenres = al.get(i);
            int firstIdx = 0;
            int secondIdx = 0;
            int max = 0;
            for(int j = 0; j < genres.length; j++) {    //ù��° �� ���ϱ�
                if(TempGenres.equals(genres[j])) {        //���� ������ ������ �帣�� genres�迭�� ���� ������
                    if(plays[j]> max) {                    //max�� ���ؼ� �ִ� ����
                        max = plays[j];
                        firstIdx = j;
                    }
                }
            }
            
            max = -1;                                     //�帣�� �ϳ��� �� �����Ƿ� -1
            for(int j = 0; j < genres.length; j++) {    //�ι�° �� ���ϱ�
                if(TempGenres.equals(genres[j])) {
                    if(j != firstIdx && plays[j] > max) {
                        max = plays[j];
                        secondIdx = j;
                    }
                }
            }
            answers.add(firstIdx);            //���� ū �� �߰�
            if(max != -1) {
            answers.add(secondIdx);            //���� ū �� �߰�
            }
        }
        
        return answers.stream().mapToInt(Integer::intValue).toArray();
        
    }
    
    public static void main(String[] args) {
    	String[] genres = { "classic", "pop", "classic", "classic", "pop"};
    	int[] plays = {500, 600, 150, 800, 2500};
    	int[] answers = solution(genres, plays);
    	
    	for(int i = 0; i < answers.length; i++) {
    		System.out.print(answers[i] + " ");
    	}

	}
}
